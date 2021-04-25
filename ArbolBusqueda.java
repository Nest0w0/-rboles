/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.LinkedList;

/**
 *
 * @author Nestor
 */
public class ArbolBusqueda extends ArbolBinario{
    
    public ArbolBusqueda(){
        raiz = null;
    }
    
    public ArbolBusqueda(Nodo r){
        raiz = r;
    }
    
    public Nodo Buscar(int info){
        if(raiz == null){
            return null;
        }else{
            return Buscar(raiz, info);
        }
    }
    
    private Nodo Buscar(Nodo r, int info){
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
    
    private void buscarRango(Nodo n, int inicio, int fin){
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
    
    private LinkedList buscarRango(Nodo n, int inicio, int fin, LinkedList lista){
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
    
    public Nodo Insertar(int info){
        return Insertar(raiz, info);
    }
    
    private Nodo Insertar(Nodo r, int info){
        if(r == null){
            return new Nodo(info);
        }else{
            if(info > (int) r.getInfo()){
                r.setDerecho(Insertar(r.getDerecho(), info));
            }else{
                Nodo nuevo = Insertar(r.getIzquierdo(), info);
                r.setIzquierdo(nuevo);
            }
            return r;
        }
    }
    
    public Nodo Reemplazar(Nodo r){
        Nodo a,p;
        p = r;
        a = p.getIzquierdo();
        while(a.getDerecho() != null){
            p = a;
            a = p.getDerecho();
        }
        Nodo aux = new Nodo(r.getInfo());
        r.setInfo(a.getInfo());
        a.setInfo(aux.getInfo());
        if(p == r){
            p.setIzquierdo(a.getIzquierdo());
        }else{
            p.setDerecho(a.getDerecho());
        }
        return a;
    }

    public Nodo Eliminar(int info){
        return Eliminar(raiz, info);
    }
    
    private Nodo Eliminar(Nodo r, int info){
        if(r == null){
            return null;
        }else{
            if(info > (int) r.getInfo()){
                r.setDerecho(Eliminar(r.getDerecho(), info));
            }else{
                if(info < (int) r.getInfo()){
                    r.setIzquierdo(Eliminar(r.getIzquierdo(), info));
                }else{
                    Nodo aux;
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
            return r;
        }
    }
}
