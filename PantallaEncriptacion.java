import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PantallaEncriptacion extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	String Nombre;
	JButton btnDesencriptar = new JButton("Desencriptar");
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaEncriptacion frame = new PantallaEncriptacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PantallaEncriptacion() {
		
		btnDesencriptar.setEnabled(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(53, 62, 469, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 143, 567, 342);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblRutaDeArchivo = new JLabel("Ruta de archivo");
		lblRutaDeArchivo.setBounds(54, 37, 129, 14);
		contentPane.add(lblRutaDeArchivo);
		
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(53, 112, 244, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombreDelArchivo = new JLabel("Nombre del archivo");
		lblNombreDelArchivo.setBounds(53, 93, 119, 14);
		contentPane.add(lblNombreDelArchivo);
		
		
		
		
		JButton btnSeleccionar = new JButton("Seleciona la ruta del archivo");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fc=new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");          	
				fc.setFileFilter(filtro);           	
				int seleccion=fc.showOpenDialog(contentPane);
				if(seleccion==JFileChooser.APPROVE_OPTION){        	  
					File fichero=fc.getSelectedFile();
					textField.setText(fichero.getAbsolutePath());
					textField_1.setText(fichero.getName());
					Nombre = fichero.getName();
					try(FileReader fr=new FileReader(fichero)){
						String cadena="";
						int valor=fr.read();
						while(valor!=-1){
							cadena=cadena+(char)valor;
							valor=fr.read();
						}
						textArea.setText(cadena);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}	
				
				
				
				
			}
			
		});
		
		btnSeleccionar.setBounds(532, 61, 245, 23);
		contentPane.add(btnSeleccionar);
		
		
		
		JButton btnEncriptar = new JButton("Encriptar");
		btnEncriptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			

				ListaDoble lista = new ListaDoble();
				ListaCircular clave = new ListaCircular();
				ListaDoble Resultado = new ListaDoble();

				lista.LeerArchivo(lista,Nombre);
				System.out.println("Tu texto en ascii es :");
				lista.mostrarDADoble();
				 String  clave2 = (JOptionPane.showInputDialog("ingresa clave"));
				 String nl = System.getProperty("line.separator"); 
				   JOptionPane.showMessageDialog(null, "Encontraras la"
				     + nl + "encriptacion en "
				     + nl + "tu archivo .txt");
				for (int contador2 = 0; contador2 < clave2.length(); contador2++) {
					int Dato = (int) clave2.charAt(contador2);

					clave.insertarFinal(Dato);
				}
				System.out.println("");
				System.out.println("la clave en ascii es:");
				clave.mostrarDA2();
				Resultado.encriptar(lista, clave);
				System.out.println("");
				System.out.println(" Metodo Encriptacion ascii:");
				Resultado.mostrarDADoble();
				
				
				JFileChooser fc=new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");          	
				fc.setFileFilter(filtro);           	
				int seleccion=fc.showOpenDialog(contentPane);
				
				if(seleccion==JFileChooser.APPROVE_OPTION){        	  
					File fichero=fc.getSelectedFile();
					textField.setText(fichero.getAbsolutePath());
					textField_1.setText(fichero.getName());
					Nombre = fichero.getName();
					try(FileReader fr=new FileReader(fichero)){
						String cadena="";
						int valor=fr.read();
						while(valor!=-1){
							cadena=cadena+(char)valor;
							valor=fr.read();
						}
						textArea.setText(cadena);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}	
				
				btnDesencriptar.setEnabled(true);
				btnEncriptar.setEnabled(false);
		
			}
		});
		btnEncriptar.setBounds(116, 522, 533, 23);
		contentPane.add(btnEncriptar);
		
		
		btnDesencriptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ListaDoble lista = new ListaDoble();
				ListaCircular clave = new ListaCircular();
				ListaDoble Resultado = new ListaDoble();
				
			
			 
				lista.LeerArchivo(lista,Nombre);

				lista.mostrarDADoble();
				String cadenaClave = JOptionPane.showInputDialog("ingresa clave");
				 
				String nl = System.getProperty("line.separator"); 
				   JOptionPane.showMessageDialog(null, "!!Desencriptado exitoso!!"
				     + nl + "El resultado en"
				     + nl + "tu archivo .txt");

				for (int contador = 0; contador < cadenaClave.length(); contador++) {
					int cadena = (int) cadenaClave.charAt(contador);
					clave.insertarFinal(cadena);
				}
				
			
				clave.mostrarDA2();
				Resultado.desencriptar(lista, clave);
				Resultado.mostrarDADoble();
				
				
				
				
				
			}
		});
		btnDesencriptar.setBounds(116, 556, 533, 23);
		contentPane.add(btnDesencriptar);
	
		
		
		
	}
}
