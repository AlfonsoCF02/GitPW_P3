package business.reserva;

/**
 * A class that implements the booking for children
 * @author Alfonso De la Torre
 * */

public class ReservaInfantilDTO extends Reserva {


	/**
	 * The number of children
	 */
	private Integer nChild; 
	
	/**
	 * Constructor which refers to the class that inherits
	 */
	public ReservaInfantilDTO() {
		super();
	}
	
	/**
	 * 
	 * To do a booking the number of child must be bigger than 0 due to a booking must have some users
	 */
	
	public void setNChild(Integer numofchilds) {
		
			this.nChild=numofchilds;
	}
	
	public Integer getNChild() {
		return this.nChild;
	}
	
	public String toString() {
		return (super.toString()+" con numero de childs= "+this.getNChild());
	}
	
	

}
