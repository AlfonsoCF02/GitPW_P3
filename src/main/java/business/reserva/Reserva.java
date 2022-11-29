package business.reserva;

import java.util.Date;


/**
 * A class that implements the track booking
 * @author Alfonso De la Torre
 * */


public abstract class Reserva {
	/* Attributes */
	
	/**
	 * The user identification
	 */
	protected String idUser;
	
	/**
	 * The booking date
	 */
	protected Date date;
	
	/**
	 * The booking hour
	 */
	protected Date hour;
	
	/**
	 * The booking duration
	 */
	protected Integer duration;
	
	/**
	 * The track identification
	 */
	protected String idTrack;
	
	/**
	 * The track price
	 */
	protected Float price;
	
	/**
	 * The track discount
	 */
	protected Float discount;
	
	
	
	/**
	 * Empty (default) constructor
	 */
	public Reserva() {
		
	}

	public void setIdUser(String id) {
		
		this.idUser=id;
	}
	
	public String getIdUser() {
		return this.idUser;
	}
	
	public void setDate(Date auxdate) {
		this.date=auxdate;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setHour(Date auxhour) {
		this.hour=auxhour;
	}
	
	public Date getHour() {
		return this.hour;
	}
	
	public void setDuration(Integer timeofduration) {
		this.duration=timeofduration;
	}
	
	public Integer getDuration() {
		return this.duration;
	}

	public void setIdTrack(String idofTrack) {
		this.idTrack=idofTrack;
	}
	
	public String getIdTrack() {
		return this.idTrack;
	}
	
	public void setPrice(Float priceoftrack) {
		this.price=priceoftrack;
	}
	
	public Float getPrice() {
		return this.price;
	}
	
	public void setDiscount(Float discountoftrack) {
		this.discount=discountoftrack;
	}
	
	public Float getDiscount() {
		return this.discount;
	}
	
	public String toString() {
		return ("El usuario "+this.getIdUser()+" ha reservado "+this.getIdTrack()+" con una duracion de "+this.getDuration()+" con fecha "+this.getDate()+" con hora "+this.getHour()+" con precio "+this.getPrice());
	}
	
}
