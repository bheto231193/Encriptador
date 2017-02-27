import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ListaDoble {

	private NodoDoble inicio;

	public ListaDoble() {

		inicio = null;

	}


	public NodoDoble Inicio() {
		return inicio;
	}

	public void Inicio(NodoDoble inicio) {
		this.inicio = inicio;
	}

	public void insertarFinal(int elemento) {

		NodoDoble nuevo = new NodoDoble(elemento);

		if (inicio == null) {

			inicio = nuevo;

		} else {
			NodoDoble aux = inicio;
			while (aux.getSiguiente() != null) {

				aux = aux.getSiguiente();
			}

			aux.setSiguiente(nuevo);
			nuevo.setAnterior(aux);
		}

	}

	public void insertarInicio(int elemento) {

		NodoDoble nuevo = new NodoDoble(elemento);

		if (inicio == null) {

			inicio = nuevo;
		} else {

			nuevo.setSiguiente(inicio);
			inicio.setAnterior(nuevo);
			inicio = nuevo;

		}
	}

	public void mostrarDADoble() {

		NodoDoble aux = inicio;
		NodoDoble ant = null;

		while (aux != null) {

			System.out.print("-->["+aux.getDato()+"]<--");

			ant = aux;
			aux = aux.getSiguiente();

		}
	

	}

	public void encriptar(ListaDoble lista1, ListaCircular lista2) {

		try {

			ListaDoble ascii = new ListaDoble();
			NodoDoble aux1 = lista1.Inicio();
			NodoCircular aux2 = lista2.getActual();

			while (aux1 != null) {

				int resultado = aux1.getDato() + aux2.getDato();

				if (resultado > 255) {
					resultado = (resultado - 255);
				} else {
					ascii.insertarFinal(resultado);
				}

				aux1 = aux1.getSiguiente();
				aux2 = aux2.getSiguiente();
			}

			this.Inicio(ascii.Inicio());
			ingresarDato(ascii);

		} catch (Exception ex) {

		}

	}

	public ListaDoble desencriptar(ListaDoble lista, ListaCircular clave) {
		ListaDoble lista1 = new ListaDoble();

		NodoDoble aux1 = lista.Inicio();
		NodoCircular aux2 = clave.getActual();
		int resultado = 0;
		char caracter;
		while (aux1 != null) {
			resultado = (aux1.getDato() - aux2.getDato());
			if (resultado < 0) {

				resultado = (resultado + 256);

				caracter = (char) resultado;
			} else {

				caracter = (char) resultado;

			}
			lista1.insertarFinal(resultado);
			aux1 = aux1.getSiguiente();
			aux2 = aux2.getSiguiente();
		}
		ingresarDato(lista1);
		return lista1;
		
	}
	
	public ListaDoble LeerArchivo (ListaDoble lista, String nombre) {

		
		String nombreArchivo = (nombre);
		
		try {
			@SuppressWarnings("resource")
			FileInputStream file = new FileInputStream(nombre);
			int variable;
			while ((variable = file.read()) != -1) {
				
				lista.insertarFinal(variable);
			}
			
		} catch (Exception e) {

		}
		return lista;
	}

	public boolean ingresarDato(ListaDoble lista) {
		NodoDoble aux = lista.Inicio();
		String nombre = ("ascii.txt");
		try {
			FileOutputStream ou = new FileOutputStream(nombre);
			while (aux != null) {
				int r = aux.getDato();
				ou.write(r);
				aux = aux.getSiguiente();

			}
		} catch (Exception e) {

		}
		return true;

	}

}