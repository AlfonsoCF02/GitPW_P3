
package business.reserva;

import java.util.Date;

/**
 * A class that implements the creation for our three specific bookings
 * @author Alfonso De la Torre
 * */

public abstract class ReservaCreator {
	
	public abstract ReservaInfantilDTO createRChild(String idUser,Date date,Date hour,Integer duration,String idTrack,float price, float discount,Integer nChild);
	
	public abstract ReservaFamiliarDTO createRFamiliar(String idUser,Date date,Date hour,Integer duration,String idTrack,float price, float discount,Integer nChild,Integer nAdults);
	
	public abstract ReservaAdultosDTO createRAdult(String idUser,Date date,Date hour,Integer duration,String idTrack,float price, float discount,Integer nAdults);
	
}
