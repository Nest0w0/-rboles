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
public class Nodo<E> {
    E info;
    Nodo izq;
    Nodo der;
    //int equi;
    
    public Nodo(E elemento){
        info = elemento;
        izq = null;
        der = null;
    }
    
    public E getInfo(){
        return this.info;
    }
    
    public Nodo getIzquierdo(){
        return this.izq;
    }
    
    public Nodo getDerecho(){
        return this.der;
    }
    /*
    public int getEquilibrio(){
        return this.equi;
    }*/
    
    public void setInfo(E nuevo){
        info = nuevo;
    }
    
    public void setIzquierdo(Nodo a){
        izq = a;
    }
    
    public void setDerecho(Nodo b){
        der = b;
    }
    /*
    public void setEquilibrio(int e){
        equi = e;
    }*/
}
