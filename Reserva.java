import java.io.Serializable;

/**
 * @author Carlos Estrada Garcia
 * Creacion de los atributos de la superclase Reserva
 * Se realiza un implements Serializable para grabar la clase en un fichero .dat
 */
public class Reserva  implements Serializable{
	private String codigo;
	private String origen;
	private String destino;
	private int pasajeros;
	public Reserva() {
		super();
	}
	
	/**
	 * 
	 * @param codigo
	 * @param origen
	 * @param destino
	 * @param pasajeros
	 */
	public Reserva(String codigo, String origen, String destino, int pasajeros) {
		super();
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.pasajeros = pasajeros;
	}
	
	//Generacion de Getters y Setters de cada atributo
	
	/**
	 * 
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getOrigen() {
		return origen;
	}
	
	/**
	 * 
	 * @param origen
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDestino() {
		return destino;
	}
	
	/**
	 * 
	 * @param destino
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPasajeros() {
		return pasajeros;
	}
	
	/**
	 * 
	 * @param pasajeros
	 */
	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	/**
	 * Metodo para visualizar los datos de los atributos
	 */
	
	@Override
	public String toString() {
		return "[codigo=" + codigo + ", origen=" + origen + ", destino=" + destino + ", pasajeros=" + pasajeros;
	}
	
	
}	

