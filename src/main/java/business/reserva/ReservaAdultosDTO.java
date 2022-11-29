package business.reserva;

/**
 * A class that implements the booking for adults
 * @author Alfonso De la Torre
 * */

public class ReservaAdultosDTO extends Reserva{
	
	/**
	 * The adults number
	 */
	private Integer nAdults;
	
	/**
	 * Constructor which refers to the class that inherits
	 */
	public ReservaAdultosDTO() {
		super();
	}
	
	public void setNAdult(Integer numAdults) {
			this.nAdults=numAdults;
	}
	
	public Integer getNAdult() {
		return this.nAdults;
	}
	
	public String toString() {
		return (super.toString()+ "con numero de adultos: "+this.getNAdult());
	}
	
}
