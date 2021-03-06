import java.util.*;
import java.math.*;

public class arbolPaises {
    Scanner sc = new Scanner(System.in);
    Random rdm = new Random();
    boolean existe=false;
    
    private NodoPais raiz = new NodoPais();
    
    public arbolPaises(){
        raiz=null;
    }
    
    public arbolPaises(NodoPais raiz){
        this.raiz=raiz;
    }
    
    public void setRaiz(NodoPais raiz){
        this.raiz=raiz;
    }
    
    public NodoPais getRaiz(){
        return raiz;
    }
    
    public boolean vacio(){
        return raiz==null;
    }
    
    // Recorrido Pre-Orden del ABB. Se usa, se va por la izquierda y luego por la derecha
    public void mostrarPreOrden(NodoPais aux){
        if(aux!=null){
            aux.mostrar();
            mostrarPreOrden(aux.getIzq());
            mostrarPreOrden(aux.getDer()); 
        }
    }
    
    // Recorrido En-Orden del ABB. Se va por la izquierda, se usa y luego por la derecha
    public void mostrarEnOrden(NodoPais aux){
        if(aux!=null){
            mostrarEnOrden(aux.getIzq());
            aux.mostrar();
            mostrarEnOrden(aux.getDer()); 
        }
    }
    
    // Recorrido Post-Orden del ABB. Se va por la izquierda, luego por la derecha y se usa
    public void mostrarPostOrden(NodoPais aux){
        if(aux!=null){
            mostrarPostOrden(aux.getIzq());
            mostrarPostOrden(aux.getDer()); 
            aux.mostrar();
        }
    }
    // Metodo que inserta el nodo nuevo recibido por parametro, en el ABB (en su posicion respectiva)
    public void Insertar(NodoPais aux, NodoPais nuevo)
    {
        if (vacio())
            raiz = nuevo;
	else if (nuevo.getPosicion()<aux.getPosicion())
	{
            if (aux.getIzq()== null)
		aux.setIzq(nuevo);
            else
                Insertar(aux.getIzq(), nuevo);   
        }
	else if (nuevo.getPosicion()>aux.getPosicion())
	{
            if (aux.getDer()== null)
		aux.setDer(nuevo);  
            else
		Insertar(aux.getDer(), nuevo);
        }
        else{
            System.out.println("Posicion repetida, ingrese otro numero: ");
            nuevo.setPosicion(sc.nextInt());
        }
    }
    // Metodo que pone en nulo, el hijo izquierdo de aux (subarbol izquierdo)
    public void suprimeHijoIzquierdo(NodoPais aux){
        if(aux!=null){
            aux.setIzq(null);
        }
    }
    // Metodo que pone en nulo, el hijo derecho de aux (subarbol derecho)
    public void suprimeHijoDerecho(NodoPais aux){
        if(aux!=null){
            aux.setDer(null);
        }
    }
    
    // Metodo que retorna la cantidad de nodos presentes en el arbol
    public int contarNodos(NodoPais aux){
        if(aux==null)
            return 0;
        else
            return 1 + contarNodos(aux.getIzq())+contarNodos(aux.getDer());   
    }
    
    public void CompararPos (NodoPais aux, int num){
        
        if(aux!=null){
            CompararPos(aux.getIzq(), num);
            if(num!=aux.getPosicion()){
                existe=true;
            }
            CompararPos(aux.getDer(), num); 
        }
    }
    
    public void NuevoPais() throws Exception{
        existe=false;
        NodoPais aux = new NodoPais();
        NodoPais ra = raiz;
        System.out.println("Indique el numero del pais: ");
        if(raiz==null)
            aux.setPosicion(100);
        else{
            int num;
            num=sc.nextInt();             
            aux.setPosicion(num);
        }
        System.out.println("Indique el nombre del pais");
        aux.setNombrePais(sc.next());
        Insertar(ra , aux);
    }
    
    
}
