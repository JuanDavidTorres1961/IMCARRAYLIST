import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Proceso {

	ArrayList<Double> Peso = new ArrayList<Double>();
	ArrayList<Double> Altura = new ArrayList<Double>();
	ArrayList<Double> ResultadoIMC = new ArrayList<Double>();
	ArrayList<String> Nombre = new ArrayList<String>();
	ArrayList<Integer> Documento = new ArrayList<Integer>();
	ArrayList<Integer> Telefono = new ArrayList<Integer>();
	
	double IMC;
	String estado = "",mensaje = "";
	
	public void iniciar() {
		
		String menu="MENU:\n";
		menu+="1. AGREGAR PERSONAS\n";
		menu+="2. BUSCAR RESULTADOS INDIVIDUALES\n";
		menu+="3. IMPRIMIR DATOS\n";
		menu+="4. ACTUALIZAR DATOS\n";
		menu+="5. BORRAR PERSONA\n";
		menu+="6. BORRAR TODO\n";
		menu+="7. SALIR DEL MENU\n";
		
		int opc = 0;
		do {
			opc= Integer.parseInt(JOptionPane.showInputDialog(menu));
			validacionDelmenu(opc);
		} while (opc!=7);
	}
	
	
	
	public void validacionDelmenu(int opc) {
		switch (opc) {
		case 1: 
			pedirdatos();
			break;
			
		case 2:
			if (Documento!=null) {
				Diagnostico();	
			}else {
				System.out.println("Debe primero llenar datos");
			}
			break;
		case 3:
			if (validarArreglo()) {
				Imprimirdatos();	
			}else {
				System.out.println("Debe primero llenar datos");
			}
			break;
		case 4: 
			if (validarArreglo()) {
				actualizarDatos();	
			}else {
				System.out.println("Debe primero llenar datos");
			}
			break;
		case 5: 
			if (validarArreglo()) {
				borrarPersona();	
			}else {
				System.out.println("Debe primero llenar datos");
			}
			break;
		case 6: 
			if (validarArreglo()) {
				borrarTodo();	
			}else {
				System.out.println("Debe primero llenar datos");
			}
			break;
		case 7: 
			System.out.println("saliendo del programa...");
			
			break; 
			
		default:
			System.out.println("ingrese una opcion valida");
		}
	}



	public boolean validarArreglo() {
		if (Nombre!=null) {
			return true;
		}else {
			System.out.println("Debe primero llenar datos");
			return false;
		}
	}
	
	private void Imprimirdatos() {
		System.out.println("Impresion de datos");
		for (int i = 0; i < Nombre.size(); i++) {
			System.out.println("Nombre: "+Nombre.get(i)+" Documento: "+Documento.get(i)+" Telefono: "+Telefono.get(i)+" Resultado: "+ResultadoIMC.get(i));
		}
		
	}
	
	private void Diagnostico() {
		int documentobuscar = Integer.parseInt(JOptionPane.showInputDialog("ingrese su documento"));
		int contador=0;
		
		for (int i = 0; i < Documento.size(); i++) {
			if (Documento.get(i)==documentobuscar) {
				mensaje="Señor(a) "+Nombre.get(i)+", identificado con el documento "+Documento.get(i)+"\n";
				mensaje+="con el telefono "+Telefono.get(i)+". El resultado de su IMC fue "+ResultadoIMC.get(i)+"\n";
				mensaje+="el cual dice que usted padece "+estado;
				System.out.println(mensaje);
				contador++;
			}
		}
		if (contador==0) {
			System.out.println("La persona a buscar no ha sido encontrada");
		}
	}


	private void borrarPersona() {
		System.out.println("Lista de personas ingresadas:\n");
		
		for (int i = 0; i < Nombre.size(); i++) {
			System.out.println((i+1)+" "+Nombre.get(i));
		}
		int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la persona que desea actualizar"));
		
		if (num >= 1 && num<=Nombre.size()) {
			System.out.println("La persona que va a actualizar es: "+Nombre.get(num-1));
			Documento.remove(num-1);
			Nombre.remove(num-1);
			Telefono.remove(num-1);
			Peso.remove(num-1);
			Altura.remove(num-1);
			ResultadoIMC.remove(num-1);
			
			System.out.println("La persona ha sido eliminada");
			
		}
		
	}
	

	public void actualizarDatos() {
		
		
		System.out.println("Lista de personas ingresadas");
		for (int i = 0; i < Nombre.size(); i++) {
			System.out.println((i+1)+" "+Nombre.get(i));
		}
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la persona que desea actualizar"));
		
		if (n >= 1 && n<=Nombre.size()) {
			
			System.out.println("La persona selecionada fue: "+Nombre.get(n-1));

			
			String opc ="INGRESE LA OPCION QUE DESEA ACTUALIZAR\n";
			opc +="1.DOCUMENTO\n";
			opc +="2.NOMBRE\n";
			opc +="3.TELEFONO\n";
			opc +="4.PESO\n";
			opc +="5.ALTURA";
			
			int x = Integer.parseInt(JOptionPane.showInputDialog(opc));
			
			switch (x) {
			case 1: 
				int documentoNuevo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo documento"));
				Documento.set(n-1,  documentoNuevo);
				break;
				
			case 2: 
				String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
				Nombre.set(n-1, nuevoNombre);
				break;
			case 3: 
				int nuevoTelefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo telefono"));
				Telefono.set(n-1, nuevoTelefono);
				break;
			case 4: 
				Double nuevoPeso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo peso"));
				Peso.set(n-1, nuevoPeso);
				break;
			case 5: 
				Double nuevaAltura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva altura"));
				Altura.set(n-1, nuevaAltura);
				break;
			default:
				JOptionPane.showMessageDialog(null, "ingrese un numero valido");
			}
		}
		System.out.println("Esta es  la nueva actualizacion: \n");
		
		System.out.println(Peso.get(n-1));
		System.out.println(Altura.get(n-1));
		System.out.println(Nombre.get(n-1));
		System.out.println(Documento.get(n-1));
		System.out.println(Telefono.get(n-1));
		
	}
	
	
	public void borrarTodo() {
		Documento.clear();
		Nombre.clear();
		Telefono.clear();
		Peso.clear();
		Altura.clear();
		ResultadoIMC.clear();
		System.out.println("Todos los datos han sido eliminados");
	}

	public void pedirdatos() {
		
		Documento.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de documento")));
		
		Nombre.add(JOptionPane.showInputDialog("Ingrese su nombre"));
		
		Telefono.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su telefono")));
		
		Peso.add(Double.parseDouble(JOptionPane.showInputDialog("Ingrese su peso")));
		
		Altura.add(Double.parseDouble(JOptionPane.showInputDialog("Ingrese su altura")));
		
		for (int i = 0; i <Nombre.size(); i++) {
			IMC=Peso.get(i)/(Altura.get(i)*Altura.get(i));
			
			ResultadoIMC.add(IMC);
			
			if(IMC<18) {
			estado = "Anorexia";
		}else if(IMC>=18 && IMC<20) {
			estado = "Delgadez";
		}else if(IMC>=20 && IMC<27) {
			estado = "Normalidad";
		}else if(IMC>=27 && IMC<30) {
			estado = "Obesidad grado 1";
		}else if(IMC>=30 && IMC<35) {
			estado = "Obesidad grado 2";
		}else if(IMC>=35 && IMC<40) {
			estado = "Obesidad grado 3";
		}else if(IMC>=40) {
			estado = "Obesidad morbida";
		}
			
			
		}
	}
}
