package business.reserva;

import java.util.Date;

public class ModalidadReservaIndividual extends ReservaCreator {

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
