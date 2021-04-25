/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Nestor
 */
public class ArbolAVL{
    NodoAVL raiz;
    
    public ArbolAVL(){
        raiz = null;
    }
    
    public ArbolAVL(NodoAVL r){
        raiz = r;
    }
    
    //Acá empiezan los métodos propios del árbol binario
    
    public void setRaiz(NodoAVL r){
        this.raiz = r;
    }
    
    public NodoAVL getRaiz(){
        return raiz;
    }
    
    public boolean esVacio(){
        return raiz == null;
    }
    
    public void preOrden(){
        preOrden(raiz);
    }
    
    private void preOrden(NodoAVL n){
        if(n != null){
            System.out.println(n.getInfo());
            preOrden(n.getIzquierdo());
            preOrden(n.getDerecho());
        }
    }
    
    public void inOrden(){
        inOrden(raiz);
    }
    
    private void inOrden(NodoAVL n){
        if(n != null){
            inOrden(n.getIzquierdo());
            System.out.println(n.getInfo());
            inOrden(n.getDerecho());
        }
    }
    
    public void postOrden(){
        postOrden(raiz);
    }
    
    private void postOrden(NodoAVL n){
        if(n != null){
            postOrden(n.getIzquierdo());
            postOrden(n.getDerecho());
            System.out.println(n.getInfo());
        }
    }
    
    public int contarHojas(NodoAVL n, int contador){
        if(n.getIzquierdo() == null && n.getDerecho() == null){
            //Si ambos hijos son nulos, entonces es una hoja
            return contador + 1;
        }else{
            //Si no, pueden haber tres casos
            if(n.getIzquierdo() != null && n.getDerecho() != null){
                //Que tenga los dos hijos
                contador = contarHojas(n.getIzquierdo(), contador);
                contador = contarHojas(n.getDerecho(), contador);
            }else{
                if(n.getIzquierdo() != null && n.getDerecho() == null){
                    //Que tenga solo el hijo izquierdo
                    contador = contarHojas(n.getIzquierdo(), contador);
                }else{
                    if(n.getDerecho() != null && n.getIzquierdo() == null){
                        //O que tenga solo el hijo derecho
                        contador = contarHojas(n.getDerecho(), contador);
                    }
                }
            }
            return contador;
        }
    }
    
    public int Altura(){
        return Altura(raiz, 0);
    }
    
    private int Altura(NodoAVL r, int contador){
        if(r == null){
            return 0;
        }else if(r.getIzquierdo() == null && r.getDerecho() == null){
                return Math.max(0,0) + 1;
            }else{
                if(r.getIzquierdo() != null && r.getDerecho() != null){
                    return Math.max(Altura(r.getIzquierdo(), contador), Altura(r.getDerecho(), contador)) + 1;
                }else{
                    if(r.getIzquierdo() == null && r.getDerecho() != null){
                        return Altura(r.getDerecho(), contador) + 1;
                    }else{
                        if(r.getIzquierdo() != null && r.getDerecho() == null){
                            return Altura(r.getIzquierdo(), contador) + 1;
                        }
                    }
                }
            }
        return contador;
    }
    
    public int Peso(){
        return Peso(raiz, 0);
    }
    
    private int Peso(NodoAVL r, int contador){
        if(r != null){
            contador = Peso(r.getIzquierdo(), contador);
            contador = Peso(r.getDerecho(), contador);
            return contador + 1;
        }else{
            return contador;
        }
    }
    
    public boolean esCompleto(){
        return Peso() == Math.pow(2, Altura()) - 1;
    }
    
    public void enAnchura(){
        enAnchura(raiz);
    }
    
    private void enAnchura(NodoAVL r){
        Queue<NodoAVL> resultado = new LinkedList<>();
        Queue<NodoAVL> visitados = new LinkedList<>();
        visitados.add(r);
        NodoAVL aux;
        while(!visitados.isEmpty()){
            aux = visitados.remove();
            if(aux.getIzquierdo() != null){
                visitados.add(aux.getIzquierdo());
            }
            
            if(aux.getDerecho() != null){
                visitados.add(aux.getDerecho());
            }
            
            resultado.add(aux);
        }
        
        while(!resultado.isEmpty()){
            System.out.println(resultado.remove().getInfo());
        }
    }
    
    public void porNivel(int nivel){
        porNivel(raiz, nivel, 1);
    }
    
    private void porNivel(NodoAVL r, int nivel, int contador){
        if(r != null){
            if(contador == nivel){
                System.out.println(r.getInfo());
            }else{
                porNivel(r.getIzquierdo(), nivel, contador + 1);
                porNivel(r.getDerecho(), nivel, contador + 1);
            }
        }
    }
    
    //Acá empiezan los métodos propios del árbol de búsqueda
    
    public NodoAVL Buscar(int info){
        if(raiz == null){
            return null;
        }else{
            return Buscar(raiz, info);
        }
    }
    
    private NodoAVL Buscar(NodoAVL r, int info){
        if(r == null){
            return null;
        }else{
            if( (int) r.getInfo() == info){
                return r;
            }else{
                if(info > (int) r.getInfo()){
                    return Buscar(r.getDerecho(), info);
                }else{
                    return Buscar(r.getIzquierdo(), info);
                }
            }
        }
    }
    
    public void buscarRango(int inicio, int fin){
        buscarRango(raiz, inicio, fin);
    }
    
    private void buscarRango(NodoAVL n, int inicio, int fin){
        if(n != null){
            if((int) n.getInfo() < inicio){
                buscarRango(n.getDerecho(), inicio, fin);
            }else if((int) n.getInfo() > fin){
                buscarRango(n.getIzquierdo(), inicio, fin);
            }else{
                buscarRango(n.getIzquierdo(), inicio, fin);
                System.out.println(n.getInfo());
                buscarRango(n.getDerecho(), inicio, fin);
            }
        }
    }
    
    public LinkedList buscarRangoLista(int inicio, int fin){
        LinkedList lista = new LinkedList();
        return buscarRango(raiz, inicio, fin, lista);
    }
    
    private LinkedList buscarRango(NodoAVL n, int inicio, int fin, LinkedList lista){
        if(n != null){
            if((int) n.getInfo() < inicio){
                buscarRango(n.getDerecho(), inicio, fin, lista);
            }else if((int) n.getInfo() > fin){
                buscarRango(n.getIzquierdo(), inicio, fin, lista);
            }else{
                buscarRango(n.getIzquierdo(), inicio, fin, lista);
                lista.add(n.getInfo());
                buscarRango(n.getDerecho(), inicio, fin, lista);
            }
        }
        return lista;
    }
    
    public NodoAVL Insertar(int info){
        if(esVacio()){
            raiz = Insertar(raiz, info);
            return raiz;
        }else{
            raiz = Insertar(raiz, info);
            return raiz;
        }
    }
    
    private NodoAVL Insertar(NodoAVL r, int info){
        if(r == null){
            return new NodoAVL(info);
        }else{
            NodoAVL nuevo;
            if(info > (int) r.getInfo()){
                nuevo = Insertar(r.getDerecho(), info);
                r.setDerecho(nuevo);
            }else{
                nuevo = Insertar(r.getIzquierdo(), info);
                r.setIzquierdo(nuevo);
            }
            r = Equilibrar(r);
            return r;
        }
    }
    
    public NodoAVL Reemplazar(NodoAVL r){
        NodoAVL a,p;
        p = r;
        a = p.getIzquierdo();
        while(a.getDerecho() != null){
            p = a;
            a = p.getDerecho();
        }
        NodoAVL aux = new NodoAVL(r.getInfo());
        r.setInfo(a.getInfo());
        a.setInfo(aux.getInfo());
        if(p == r){
            p.setIzquierdo(a.getIzquierdo());
        }else{
            p.setDerecho(a.getDerecho());
        }
        return a;
    }
    
    public NodoAVL Eliminar(int info){
        raiz = Eliminar(raiz, info);
        return raiz;
    }
    
    private NodoAVL Eliminar(NodoAVL r, int info){
        if(r == null){
            return null;
        }else{
            if(info > (int) r.getInfo()){
                r.setDerecho(Eliminar(r.getDerecho(), info));
            }else{
                if(info < (int) r.getInfo()){
                    r.setIzquierdo(Eliminar(r.getIzquierdo(), info));
                }else{
                    NodoAVL aux;
                    aux = r;
                    if(r.getIzquierdo() == null){
                        r = aux.getDerecho();
                    }else{
                        if(r.getDerecho() == null){
                            r = aux.getIzquierdo();
                        }else{
                            Reemplazar(aux);
                        }
                    }
                }
            }
            
            if(r != null){
                r = Equilibrar(r);
            }
            return r;
        }
    }
    
    //Acá empiezan los métodos propios del arbol AVL

    public void FE(NodoAVL n){
        if(n != null){
            n.equilibrio = Altura(n.getDerecho(), 0) - Altura(n.getIzquierdo(), 0);
        }
    }
    
    public void mostrarEquilibrio(){
        mostrarEquilibrio(raiz);
    }
    
    public void mostrarEquilibrio(NodoAVL n){
        if(n != null){
            mostrarEquilibrio(n.getIzquierdo());
            mostrarEquilibrio(n.getDerecho());
            System.out.println(n.getEquilibrio());
        }
    }
    
    public NodoAVL RotacionDerecha(NodoAVL n){
        NodoAVL i = n.getIzquierdo();
        NodoAVL d = n.getIzquierdo().getDerecho();
        i.setDerecho(n);
        n.setIzquierdo(d);
        return i;
    }
    
    public NodoAVL RotacionIzquierda(NodoAVL n){
        NodoAVL d = n.getDerecho();
        NodoAVL i = n.getDerecho().getIzquierdo();
        d.setIzquierdo(n);
        n.setDerecho(i);
        return d;
    }
    
    public NodoAVL Equilibrar(NodoAVL n){
        FE(n);
        int balance = n.getEquilibrio();
        
        if(balance > 1){
            if(Altura(n.getDerecho().getDerecho(), 0) > Altura(n.getDerecho().getIzquierdo(), 0)){
                n = RotacionIzquierda(n);
            }else{
                n.setDerecho(RotacionDerecha(n.getDerecho()));
                n = RotacionIzquierda(n);
            }
        } else if(balance < -1){
            if(Altura(n.getIzquierdo().getIzquierdo(), 0) > Altura(n.getIzquierdo().getDerecho(), 0)){
                n = RotacionDerecha(n);
            }else{
                n.setIzquierdo(RotacionIzquierda(n.getIzquierdo()));
                n = RotacionDerecha(n);
            }
        }
        return n;
    }
}
