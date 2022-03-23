import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
/**
 * 
 * @author Carlos Estrada Garcia
 * Creacion de la clase ejecutable
 *
 */
public class AppReserva {
	/**
	 * Metodo que contiene un menu con diferentes opciones a elegir
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		int op;
		//Definicion de un ArrayList
		ArrayList<Reserva> reser = new ArrayList<Reserva>();
		//Para ejecutar siempre el metodo rellenar se situara antes del bucle do...while
		rellenar(reser);
		//Creacion de un menu con un bucle do..while y un switch
		do {
			  System.out.println("1-Grabar");
			  System.out.println("2-Visualizar");
			  System.out.println("3-Cancelar");
			  System.out.println("4-Salir");
		      System.out.println("Elige una operacion");
				op=teclado.nextInt();
				
				switch(op) {
				
				case 1:
					grabar(reser);
					break; 
					
				case 2:
					visualizar(reser);
					break;
					
				case 3:
					cancelar (reser);
					break;
				
				case 4:
					System.out.println("FIN OPERACIONES");
					break;
				}
				
			}while (op!=4);

	}
	/**
	 * Metodo para crear reservas de ida y de ida y vuelta
	 * @param reser
	 */
  public static void rellenar (ArrayList<Reserva> reser) {
		
		reser.add(new Ida ("1A", "ASTURIAS", "MADRID", 50, "PROMO"));
		reser.add(new Ida ("2B", "MADRID", "BARCELONA", 55, "TUR"));
		reser.add(new IdayVuelta ("3C", "VALENCIA", "ASTURIAS", 60, "TUR_PLUS", "BSS"));
		reser.add(new IdayVuelta ("4D", "ASTURIAS", "SEVILLA", 80, "BSS+", "FLEX"));
		reser.add(new IdayVuelta ("5E", "VALENCIA", "ASTURIAS", 60, "BSS", "TUR"));
		
	}
  /**
   * Metodo para grabar la superclase Reserva
   * @param reser
   */
  public static void grabar (ArrayList<Reserva> reser) {
		try {
			ObjectOutputStream profesal = new ObjectOutputStream (new FileOutputStream ("Reservas.dat"));
			profesal.writeObject(reser);
			profesal.close();
			System.out.println("Reservas bien grabadas");
			} catch (FileNotFoundException er) {
				
			    System.out.println("Error: El fichero no existe. ");
			    
			 } catch (IOException ioe) {
				 
		    System.out.println("Error: Fallo en la escritura en el fichero. ");
		 } 
		    System.out.println();
		
	}
  /**
   * Metodo para visualizar todas las reservas del metodo rellenar y el precio de cada una
   * @param reser
   */
  public static void visualizar (ArrayList<Reserva> reser) {
		Scanner teclado = new Scanner (System.in);
		//Para redondear a dos decimales se usa la instruccion DecimalFormal ("#.00")
		DecimalFormat df = new DecimalFormat ("#.00");
		double importereserva;
		String reserva="", tmpStr1="";
			//Se recorre todo el ArrayList Reserva con un bucle for
			for (Reserva res: reser) {
				//instaceof se usa para diferenciar la clase Ida de la clase IdayVuelta
				//Si la reserva es de ida
				if (res instanceof Ida) {
					tmpStr1 = "Ida";
					importereserva=((Ida) res).calculoreserva(reserva);
					System.out.println("Reserva :"+tmpStr1+" Datos: "+res.toString()+ " Importe " +df.format(importereserva)+"€");
				}
				
				//Si la reserva es de ida y vuelta
				else {
					tmpStr1 = "Ida y Vuelta";
					importereserva=((IdayVuelta) res).calculoreserva(reserva);
					System.out.println("Reserva :"+tmpStr1+ " Datos: "+res.toString()+" Importe "+df.format(importereserva)+"€");
			}
			System.out.println();
		}
		System.out.println();
	}
  /**
   * Metodo booleano para buscar en el ArrayListuna reserva por su codigo
   * Si el codigo de la reserva esta en el ArrayList devolvera true
   * Si el codigo de la reserva no esta en el ArrayList devolvera false
   * @param reser
   * @param codigo
   * @return
   */
  public static boolean buscarcodigo (ArrayList<Reserva> reser, String codigo) {
		for (Reserva rese: reser) {
			if (rese.getCodigo().equalsIgnoreCase(codigo)) {
				return true;
		}
	}
	return false;
}
  
  /**
   * Metodo para cancelar una reserva y calculo del 20% del precio de la reserva a pagar por su cancelacion 
   * @param reser
   */
    public static void cancelar (ArrayList<Reserva> reser) {
    	Scanner teclado = new Scanner (System.in);
    	DecimalFormat df = new DecimalFormat ("#.00");
		boolean cod=false;
		String codigo;
		double importereserva = 0, penalizacion;
		String tmpStr1, reserva=" ";
		int pos;
		//Introducir codigo de la reserva
		System.out.println("Introducir codigo de la reserva a cancelar");
		codigo=teclado.nextLine();
		cod=buscarcodigo(reser, codigo);
		//El bucle se ejecutara siempre que el codigo de la reserva no este en el ArrayList
		while(cod==false) {
			System.out.println("La referencia de la reserva no existe");
			System.out.println("Introduzca otra referencia que exista");
			codigo=teclado.nextLine();
			cod=buscarcodigo(reser, codigo);
		}
		
		/**
		 * Se recorre el ArrayList con un iterator 
		 */
		Iterator <Reserva> it = reser.iterator();
		while (it.hasNext()) {
			Reserva res = it.next();
			//Si el codigo de la reserva esta en el ArrayList se realizara la cancelacion de la reserva
			if (res.getCodigo().equalsIgnoreCase(codigo)) {
				//Si la reserva es de ida
				if (res instanceof Ida) {
					importereserva=((Ida) res).calculoreserva(reserva);
					tmpStr1 = "Ida";
					//Calculo del 20% del precio de la reserva que se debe abonar
					penalizacion=importereserva*20/100;
					//Visualizacion del codigo de la reserva y del precio por su cancelacion
					System.out.println("Codigo reserva " +res.getCodigo()+ " - Penalizacion "+penalizacion+"€");
					it.remove();
					System.out.println("La reserva se borrara");
				}
				//Si la reserva es de ida y vuelta
				else {
					tmpStr1 = "Ida y Vuelta";
					importereserva=((IdayVuelta) res).calculoreserva(reserva);
					//Calculo del 20% del precio de la reserva que se debe abonar
					penalizacion=importereserva*20/100;
					//Visualizacion del codigo de la reserva y del precio por su cancelacion
					System.out.println("Codigo reserva " +res.getCodigo()+ " - Penalizacion "+penalizacion+"€");
					it.remove();
					System.out.println("La reserva se borrara");
				}
			
			}
		}
		System.out.println();

	}

}
