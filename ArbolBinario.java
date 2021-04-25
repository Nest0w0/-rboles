package arboles;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Nestor
 */
public class ArbolBinario {
    Nodo raiz;
    
    public ArbolBinario(){
        raiz = null;
    }
    
    public ArbolBinario(Nodo r){
        raiz = r;
    }
    
    public void setRaiz(Nodo r){
        this.raiz = r;
    }
    
    public Nodo getRaiz(){
        return this.raiz;
    }
    
    public boolean esVacio(){
        return raiz == null;
    }
    
    public void preOrden(){
        preOrden(raiz);
    }
    
    private void preOrden(Nodo n){
        if(n != null){
            System.out.println(n.info);
            preOrden(n.getIzquierdo());
            preOrden(n.getDerecho());
        }
    }
    
    public void inOrden(){
        inOrden(raiz);
    }
    
    private void inOrden(Nodo n){
        if(n != null){
            inOrden(n.getIzquierdo());
            System.out.println(n.info);
            inOrden(n.getDerecho());
        }
    }
    
    public void postOrden(){
        postOrden(raiz);
    }
    
    private void postOrden(Nodo n){
        if(n != null){
            postOrden(n.getIzquierdo());
            postOrden(n.getDerecho());
            System.out.println(n.info);
        }
    }
    
    public int contarHojas(Nodo n, int contador){
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
    
    private int Altura(Nodo r, int contador){
        if(r.getIzquierdo() == null && r.getDerecho() == null){
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
    
    //El método Peso solo modifica el postOrden
    public int Peso(){
        return Peso(raiz, 0);
    }
    
    private int Peso(Nodo r, int contador){
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
    
    private void enAnchura(Nodo r){
        Queue<Nodo> resultado = new LinkedList<>();
        Queue<Nodo> visitados = new LinkedList<>();
        visitados.add(r);
        Nodo aux;
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
    
    private void porNivel(Nodo r, int nivel, int contador){
        if(r != null){
            if(contador == nivel){
                System.out.println(r.getInfo());
            }else{
                porNivel(r.getIzquierdo(), nivel, contador + 1);
                porNivel(r.getDerecho(), nivel, contador + 1);
            }
        }
    }
    
    public boolean compararHijos(Nodo r){
        boolean bandera = true;
        if(r.getIzquierdo() != null && r.getDerecho() != null){
            bandera = (int) r.getInfo() > (int) r.getIzquierdo().getInfo() && (int) r.getInfo() < (int) r.getDerecho().getInfo();
        }else{
            if(r.getIzquierdo() == null && r.getDerecho() != null){
                bandera = (int) r.getInfo() < (int) r.getDerecho().getInfo();
            }else{
                if(r.getIzquierdo() != null && r.getDerecho() != null){
                    bandera = (int) r.getInfo() > (int) r.getIzquierdo().getInfo();
                }
            }
        }
        /*Cuando ninguna condición se cumple, es decir; ambos hijos son nulos
        devuelve la bandera tal cual, con valor TRUE*/
        return bandera;
    }
    
    public boolean esBusqueda(){
        return esBusqueda(raiz, true);
    }
    
    private boolean esBusqueda(Nodo r, boolean bandera){
        if(r != null){
            if(compararHijos(r)){
                bandera = esBusqueda(r.getIzquierdo(), bandera);
                bandera = esBusqueda(r.getDerecho(), bandera);
            }else{
                bandera = false;
            }
        }
        return bandera;
    }
}

