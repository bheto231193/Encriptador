import java.io.File;
import java.io.FileReader;

public class ListaCircular {
	

	private NodoCircular actual;
	
	public ListaCircular(){
		
		actual=null;
	}

    public NodoCircular getActual() {
        return actual;
    }

    public void setActual(NodoCircular actual) {
        this.actual = actual;
    }
	
	
	public void insertar(int elem){
		
		NodoCircular nuevo= new NodoCircular (elem);
		nuevo.setSiguiente(nuevo);
		
		if(actual==null){
			actual=nuevo;
		}else{
			nuevo.setSiguiente(actual.getSiguiente());
			actual.setSiguiente(nuevo);
		}	

	}
        
    public void InsertarInicio (int d){
      
       NodoCircular nuevo =new NodoCircular(d);
         if(actual==null){
         actual=nuevo;
         nuevo.setSiguiente(nuevo);
       }else{
         NodoCircular aux=actual;
         while(aux.getSiguiente()!=actual){
                   aux=aux.getSiguiente();
         }
         aux.setSiguiente(nuevo);
         nuevo.setSiguiente(actual);
        
       }
            }
	
	
	public void recorrer(){
		
		if(actual!=null){
                        System.out.print(actual.getDato());
			NodoCircular aux=actual.getSiguiente();
                       

			do{
				
				System.out.print(aux.getDato());
			
				aux=aux.getSiguiente();
			}while(aux!=actual);
		
		}
	}
	public void insertarFinal(int elemento) {

        NodoCircular nuevo = new NodoCircular(elemento);
        nuevo.setSiguiente(nuevo);

        if (actual == null) {
            actual = nuevo;

        } else {
            NodoCircular aux = actual.getSiguiente();
            while (aux.getSiguiente() != actual) {
                aux = aux.getSiguiente();

            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }

	}
        
    public int MostrarElemento()throws ListaVaciaException{
		
		if(actual==null)
		throw new ListaVaciaException();
		int salida=actual.getDato();
		actual=actual.getSiguiente();
		
		return salida;
		
	}       
    @SuppressWarnings("resource")

                
    public void mostrarDA2 ()
    {
        if (actual!=null) {
            NodoCircular aux=actual;
            do {
                System.out.printf("-->["+aux.getDato()+"]<--");
                aux = aux.getSiguiente();                
            } while (aux!=actual);
        }    
    }  
        
}
