
/**
 * 
 * @author Carlos Estrada Garcia
 * Creacion de la clase IdayVuelta que hereda de la superclase Reserva y de sus atributos correspondientes
 */
public class IdayVuelta extends Reserva {
	private String tarifida;
	private String tarifvuelta;
	
	public IdayVuelta() {
		super();	
	}
	
	/**
	 * @param codigo
	 * @param origen
	 * @param destino
	 * @param pasajeros
	 * @param tarifida
	 * @param tarifvuelta
	 */
	
	public IdayVuelta(String codigo, String origen, String destino, int pasajeros, String tarifida, String tarifvuelta) {
		super(codigo, origen, destino, pasajeros);
		this.tarifida=tarifida;
		this.tarifvuelta=tarifvuelta;
		
	}
	/**
	 * 
	 * @param tarifida
	 * @param tarifvuelta
	 */
	public IdayVuelta(String tarifida, String tarifvuelta) {
		super();
		this.tarifida = tarifida;
		this.tarifvuelta = tarifvuelta;
	}
	/**
	 * 
	 * @return
	 */
	public String getTarifida() {
		return tarifida;
	}
	/**
	 * 
	 * @param tarifida
	 */
	public void setTarifida(String tarifida) {
		this.tarifida = tarifida;
	}
	/**
	 * 
	 * @return
	 */
	public String getTarifvuelta() {
		return tarifvuelta;
	}
	/**
	 * 
	 * @param tarifvuelta
	 */
	public void setTarifvuelta(String tarifvuelta) {
		this.tarifvuelta = tarifvuelta;
	}
	
	/**
	 * Metodo para calcular el precio de la reserva que retornara dicho precio
	 * @param reserva 
	 * @return
	 */
	
	public double calculoreserva (String reserva) {
		double importereserva = 0;
		double importeida=0;
		double importevuelta=0;
		String [] tarifa = {"PROMO", "TUR","TUR_PLUS", "FLEX", "BSS", "BSS+"};
		double [] precios = {100, 120, 150, 200, 400, 450};
		
		for (int i=0; i<precios.length; i++) {
			if (tarifa[i].equalsIgnoreCase(reserva)) {
				importeida = precios[i] * super.getPasajeros();
			}
		}
		
		for (int i=0; i<precios.length; i++) {
			if (tarifa[i].equalsIgnoreCase(reserva)) {
				
			}
			importevuelta = precios[i] * super.getPasajeros();
		}
		 importereserva= importeida+importevuelta;
		return importereserva;
	}
	
	/**
	 * Metodo que devuelve los valores de la superclase Reserva y de la clase IdayVuelta
	 */
	@Override
	public String toString() {
		return super.toString()+ ", tarifida=" + tarifida + ", tarifvuelta=" + tarifvuelta + "]";
	}
	
	
}
