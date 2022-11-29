package business.reserva;

import java.util.Date;

import business.pista.diff;

/**
 * A class that includes the bonus parameters
 * @author Victoria Muñoz
 * @author Alfonso de la Torre 
 * @author Alfonso Cabezas
 * @author Abraham Cordoba
 * */

public class BonoDTO {
	/* Attributes */
	
	/**
	 * The bonus identification
	 */
	private Integer nbono;
	
	/**
	 * The email associated with the booking
	 */
	private String email;
	
	/**
	 * The type of bonus
	 */
	private String tipo;
	
	/**
	 * The number of remaining sessions
	 */
	private Integer nSesionesRestantes;
	
	/**
	 * The date of the first booking
	 */
	private Date primeraReserva;
	
	/**
	 * The expiration of the bonus
	 */
	private Date caducidad;
	
	public BonoDTO(String email,String tipo,Integer restantes) {
		this.nbono=null;
		this.email=email;
		this.tipo=tipo;
		this.nSesionesRestantes=restantes;
		this.primeraReserva=null;
		this.caducidad=null;
	}
	
	public BonoDTO() {
		this.nbono=null;
	}
	
	public Integer getnBono() {
		return this.nbono;
	}
	
	public void setnBono(Integer numBono) {
		this.nbono=numBono;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String type) {
		this.tipo=type;
	}
	
	public Integer getRestantes() {
		return this.nSesionesRestantes;
	}
	
	public void setRestantes(int r) {
		this.nSesionesRestantes=r;
	}
	
	public Date getPrimeraReserva() {
		return this.primeraReserva;
	}
	
	public void setPrimeraReserva(Date prim) {
		this.primeraReserva=prim;
	}
	
	public Date getCaducidad() {
		return this.caducidad;
	}
	
	public void setCaducidad(Date cad) {
		this.caducidad=cad;
	}
}
