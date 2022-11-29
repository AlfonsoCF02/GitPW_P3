package business.kart;

import business.pista.PistaDTO;
import business.pista.diff;

/**
 * A class that implements a kart
 * @author Victoria Muñoz
 * @author Abraham Córdoba
 * */

public class KartDTO {
/* Attributes */
	/**
	 * The kart identification
	 */
	private Integer id;
	/**
	 * The type of kart
	 */
	private Boolean karttype;
	/**
	 * The kart status	
	 */
	private kartstat kartstatus;
	
	
	/**
	 * Empty (default) constructor
	 */
	public KartDTO() {
		
	}
	
	/**
	 * Parameterized constructor
	 * @param id The id of the kart
	 * @param karttype The type of kart
	 * @param stateofkart The state of a kart
	 * */
	
	public KartDTO(Integer id, Boolean karttype,kartstat stateofkart ) {
		this.id = id;
		this.karttype = karttype;
		this.kartstatus = stateofkart;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getKarttype() {
		return karttype;
	}

	public void setKarttype(Boolean karttype) {
		this.karttype = karttype;
	}

	public kartstat getKartstatus() {
		return this.kartstatus;
	}

	public void setKartstatus(kartstat kartstatus) {
		this.kartstatus = kartstatus;
	}

	@Override
	public String toString() {
		return "Kart [id=" + id + ", karttype=" + karttype + ", kartstatus=" + kartstatus + "]";
	}
}