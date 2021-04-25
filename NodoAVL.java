/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author Nestor
 */
public class NodoAVL<E>{
    E info;
    int equilibrio;
    NodoAVL izq;
    NodoAVL der;
    
    public NodoAVL(E elemento) {
        info = elemento;
        equilibrio = 0;
        izq = null;
        der = null;
    }
    
    public E getInfo(){
        return info;
    }
    
    public NodoAVL getIzquierdo(){
        return izq;
    }
    
    public NodoAVL getDerecho(){
        return der;
    }
    
    public void setInfo(E nuevo){
        info = nuevo;
    }
    
    public void setIzquierdo(NodoAVL r){
        izq = r;
    }
    
    public void setDerecho(NodoAVL r){
        der = r;
    }
    
    public int getEquilibrio(){
        return equilibrio;
    }
    
    /*
    public void calcularFE(){
        equilibrio = Altura(der,0) - Altura(izq,0);
    }
    
    private int Altura(NodoAVL r, int contador){
        if(r == null){
            return 0;
        }else{
            if(r.getIzquierdo() != null && r.getDerecho() != null){
                return Math.max(Altura(r.getIzquierdo(), contador), Altura(r.getDerecho(), contador)) + 1;
            }else{
                if(r.getIzquierdo() == null && r.getDerecho() != null){
                    return Altura(r.getDerecho(), contador) + 1;
                }else{
                    if(r.getIzquierdo() != null && r.getDerecho() == null){
                        return Altura(r.getIzquierdo(), contador) + 1;
                    }else{
                        if(r.getIzquierdo() == null && r.getDerecho() == null){
                            return 1;
                        }
                    }
                }
            }
        }
        return contador;
    }*/
}
