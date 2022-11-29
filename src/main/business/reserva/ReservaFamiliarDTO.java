package business.reserva;

/**
 * A class that implements the booking for families
 * @author Alfonso De la Torre
 * */

public class ReservaFamiliarDTO extends Reserva {
/* Attributes */
	
	/**
	 * The number of children
	 */
	private Integer nChilds;
	
	/**
	 * The number of adults
	 */
	private Integer nAdults;
	
	
	public void setNChild(Integer numChilds) {
			this.nChilds=numChilds;
	}
	
	public Integer getNChild() {
		return this.nChilds;
	}
	
	/**
	 * 
	 * The number of adults due to the fact of the familiar booking must be also bigger than 0 due to look for the childs.
	 */
	public void setNAdult(Integer numAdults) {
		this.nAdults=numAdults;
	}
	
	public Integer getNAdult() {
		return this.nAdults;
	}
	
	/**
	 * Constructor which refers to the class that inherits
	 */
	public ReservaFamiliarDTO() {
		super();
	}
	
	public String toString() {
		return (super.toString()+ "con numero de childs= "+this.getNChild()+" y numero de adultos: "+this.getNAdult());
	}
	
}
