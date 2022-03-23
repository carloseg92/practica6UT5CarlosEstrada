
/**
 * 
 * @author Carlos Estrada Garcia
 * Creacion de la clase Ida que hereda de la superclase Reserva y de su atributo correspondiente
 */
public class Ida extends Reserva {
	private String tarifaida;
	
	public Ida() {
		super();
		
	}
	
	/**
	 * 
	 * @param codigo
	 * @param origen
	 * @param destino
	 * @param pasajeros
	 * @param tarifaida
	 */
	public Ida(String codigo, String origen, String destino, int pasajeros, String tarifaida) {
		super(codigo, origen, destino, pasajeros);
		this.tarifaida=tarifaida;
	}
	
	public Ida(String tarifaida) {
		super();
		this.tarifaida = tarifaida;
	}
	
	//Generacion de Getters y Setters de cada atributo
	/**
	 * 
	 * @return
	 */
	public String getTarifaida() {
		return tarifaida;
	}
	
	/**
	 * 
	 * @param tarifaida
	 */
	public void setTarifaida(String tarifaida) {
		this.tarifaida = tarifaida;
	}
	
	/**
	 * Metodo que devuelve los valores de la superclase Reserva y de la clase Ida
	 */
	@Override
	public String toString() {
		return super.toString()+ ", tarifaida=" + tarifaida + "]";
	}
	
	/**
	 * Metodo para calcular el precio de la reserva que retornara dicho precio
	 * @param reserva
	 * @return
	 */
	public double calculoreserva (String reserva) {
		double importereserva = 0;
		String [] tarifa = {"PROMO", "TUR","TUR_PLUS", "FLEX", "BSS", "BSS+"};
		double [] precios = {100, 120, 150, 200, 400, 450};
		
		for (int i=0; i<precios.length; i++) {
			if (tarifa[i].equalsIgnoreCase(reserva)) {
				
			}
			importereserva = precios[i] * super.getPasajeros();
		}
		return importereserva;
		
	}
	
	
}
