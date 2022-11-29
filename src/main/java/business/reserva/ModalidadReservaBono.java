package business.reserva;

import java.util.Date;

/**
 * A class that implements a modality of a booking reservation through bonus for our three specific bookings
 * @author Alfonso De la Torre
 * */


public class ModalidadReservaBono extends ReservaCreator{
	/* Attributes */
	/**
	 * The Bonus identification
	 */
	private Integer idBonus;
	/**
	 * The number of bonus
	 */
	private Integer numberBonus;
	
	
	/**
	 * Empty (default) constructor
	 */
	public ModalidadReservaBono(){
		
	}
	
	
	public void setIdBonus(Integer num) {
		this.idBonus=num;
	}
	
	public Integer getIdBonus() {
		return this.idBonus;
	}
	
	public void setNumberBonus(Integer num) {
		this.numberBonus=num;
	}
	
	public Integer getNumberBonus() {
		return this.numberBonus;
	}
	
	
	/**
	 * Parameterized constructor
	 * @param IdUser The user id
	 * @param IdTrack The track id
	 * @param Date The date chosen by the user
	 * @param Duration The booking duration in minutes
	 * @param Price The booking price in euros
	 * @param NChild The number of children
	 */
	
	public ReservaInfantilDTO createRChild(String idUser,Date date,Date hour,Integer duration,String idTrack,float price, float discount,Integer nChild) {
		ReservaInfantilDTO r1=new ReservaInfantilDTO();
		r1.setIdUser(idUser);
		r1.setDate(date);
		r1.setHour(hour);
		r1.setDuration(duration);
		r1.setIdTrack(idTrack);
		r1.setPrice(price);
		r1.setDiscount(discount);
		r1.setNChild(nChild);
		return r1;
		
	}
	

	public ReservaFamiliarDTO createRFamiliar(String idUser,Date date,Date hour,Integer duration,String idTrack,float price, float discount,Integer nChild,Integer nAdults) {
		ReservaFamiliarDTO r1=new ReservaFamiliarDTO();
		r1.setIdUser(idUser);
		r1.setDate(date);
		r1.setHour(hour);
		r1.setDuration(duration);
		r1.setIdTrack(idTrack);
		r1.setPrice(price);
		r1.setDiscount(discount);
		r1.setNChild(nChild);
		r1.setNAdult(nAdults);
		return r1;
	}

	public ReservaAdultosDTO createRAdult(String idUser,Date date,Date hour,Integer duration,String idTrack,float price, float discount,Integer nAdults) {
		ReservaAdultosDTO r1=new ReservaAdultosDTO();
		r1.setIdUser(idUser);
		r1.setDate(date);
		r1.setHour(hour);
		r1.setDuration(duration);
		r1.setIdTrack(idTrack);
		r1.setPrice(price);
		r1.setDiscount(discount);
		r1.setNAdult(nAdults);
		return r1;
	}
}
