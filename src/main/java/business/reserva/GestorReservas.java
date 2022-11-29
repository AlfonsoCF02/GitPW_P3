package business.reserva;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import business.pista.PistaDTO;
import data.BonoDAO;
import data.PistaDAO;
import data.ReservaAdultDAO;
import data.ReservaChildDAO;
import data.ReservaFamDAO;
import data.UserDAO;



/**
 * A class that implements system booking management
 * @author Alfonso Cabezas
 * @author Alfonso de la Torre 
 * */

public class GestorReservas {


	/**
	 * A method that allow to make an individual booking
	 * Bookings will be saved in a text file
	 * @throws SQLException 
	 * @throws MySQLSyntaxErrorException 
	 * @throws ParseException 
	 * */
	
	@SuppressWarnings("deprecation")
	public int reservaIndividual(ModalidadReservaIndividual a, String idUser,Date date, Date hour, Integer duration, String idTrack, Integer nChild,Integer nAdults) throws MySQLSyntaxErrorException, SQLException, ParseException{
		
		float price, discount = 0;
		
		UserDAO u = new UserDAO();
		if( u.comprobarUsuarioExistente(idUser) == false) {
			return -1;
		}
		
		
		PistaDAO p = new PistaDAO();
		PistaDTO p1 = new PistaDTO();
		
		p1 = p.encontrarPista(idTrack);
		
		if( !(p1.getState() == false ) ){
			return -6;
			
		}
		
		price = calcularPrecio(duration);
		if( price == -1) {
			return -2;
		}

		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date frd = format.parse(u.obtenerFechaRegistro(idUser));
		
	    java.sql.Date fecha1 = new java.sql.Date(frd.getTime());
		
	    java.sql.Date date1 = new java.sql.Date(fecha1.getTime());
	    
	    int year_minus1 = date1.getYear() + 1898; 
	    
	    java.sql.Date date2 = date1;
	    date2.setYear(year_minus1);
	    
	    if(date1.compareTo(date2)<0) {
	    	discount = 10;
	    	price = price * (90 / 100);
	    }
		
		if(nChild == 0) { 
			if(!p1.getDifficulty().toString().equals("adult")) {
				return -7;
			}
			
			if(nChild != 0) {
				return -9;
			}
			
			ReservaAdultosDTO r = a.createRAdult(idUser, date, hour, duration, idTrack, price, discount, nAdults);
			ReservaAdultDAO rd = new ReservaAdultDAO();
			
			if (rd.anadirReservaIndivAdult(r) != 0 ) {
				return -5;
			}

			
		}
		else if(nAdults == 0) { 
			if(!p1.getDifficulty().toString().equals("child")) {
				return -7;
			}
			
			if(nAdults != 0) {
				return -9;
			}
			
			ReservaInfantilDTO r = a.createRChild(idUser, date, hour, duration, idTrack, price, discount, nChild);

			ReservaChildDAO rd = new ReservaChildDAO();

			if (rd.anadirReservaIndivChild(r) != 0 ) {
				return -5;
			}
			
		}
		else { 
			if(!p1.getDifficulty().toString().equals("family")) {
				return -7;
			}
			
			ReservaFamiliarDTO r = a.createRFamiliar(idUser, date, hour, duration, idTrack, price, discount, nChild, nAdults);

			ReservaFamDAO rd = new ReservaFamDAO();
			
			if (rd.anadirReservaIndivFam(r) != 0 ) {
				return -5;
			}
			
			
		}
				
	
		return 0;
		
	}
	

	public int reservaIndividual(ModalidadReservaBono a, int nbono, String idUser,Date date, Date hour, Integer duration, String idTrack, Integer nChild,Integer nAdults) throws MySQLSyntaxErrorException, SQLException, ParseException{
		
		float price, discount = 0;
		
		UserDAO u = new UserDAO();
		if( u.comprobarUsuarioExistente(idUser) == false) {
			return -1;
		}
		
		BonoDAO b = new BonoDAO();
		if( b.comprobarBonoExistente(nbono) == false) {
			return -2;
		}
		
		if(b.comprobarBonoyUser(nbono, idUser)==false) {
			return -3;
		}
		
		
		PistaDAO p = new PistaDAO();
		PistaDTO p1 = new PistaDTO();
		
		p1 = p.encontrarPista(idTrack);
		
		if( !(p1.getState() == false ) ){
			return -6;
		}
		
		
		price = calcularPrecio(duration);
		if( price == -1) {
			return -4;
		}

		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date frd = format.parse(u.obtenerFechaRegistro(idUser));
		
	    java.sql.Date fecha1 = new java.sql.Date(frd.getTime());
		
	    java.sql.Date date1 = new java.sql.Date(fecha1.getTime());
	    
	    int year_minus1 = date1.getYear() + 1898; 
	    
	    java.sql.Date date2 = date1;
	    date2.setYear(year_minus1);
	    
	    if(date1.compareTo(date2)<0) {
	    	discount = 10;
	    	price = price * (95 / 100);
	    }
		
		if(nChild == 0) { 
			if(!p1.getDifficulty().toString().equals("adult")) {
				return -7;
			}
			
			if(!b.getTipoBono(nbono).toString().equals("adult")) {
				return -4;
			}
			
			
			if(nChild != 0) {
				return -9;
			}
			
			ReservaAdultosDTO r = a.createRAdult(idUser, date, hour, duration, idTrack, price, discount, nAdults);
			ReservaAdultDAO rd = new ReservaAdultDAO();
			BonoDTO bonoDTO = new BonoDTO();
			bonoDTO.setnBono(nbono);
			
			if (rd.anadirReservaBonoAdult(r, bonoDTO) != 0 ) {
				return -5;
			}

			
		}
		else if(nAdults == 0) {
			if(!p1.getDifficulty().toString().equals("child")) {
				return -7;
			}
			
			if(!b.getTipoBono(nbono).toString().equals("child")) {
				return -4;
			}
			
			if(nAdults != 0) {
				return -9;
			}
			

			ReservaInfantilDTO r = a.createRChild(idUser, date, hour, duration, idTrack, price, discount, nChild);

			ReservaChildDAO rd = new ReservaChildDAO();
			
			BonoDTO bonoDTO = new BonoDTO();
			bonoDTO.setnBono(nbono);
			
			
			if (rd.anadirReservaBonoChild(r, bonoDTO) != 0 ) {
				return -5;
			}
			
			
		}
		else { 
			if(!p1.getDifficulty().toString().equals("family")) {
				return -7;
			}
			
			if(!b.getTipoBono(nbono).toString().equals("family")) {
				return -4;
			}
			
			ReservaFamiliarDTO r = a.createRFamiliar(idUser, date, hour, duration, idTrack, price, discount, nChild, nAdults);

			ReservaFamDAO rd = new ReservaFamDAO();
			
			BonoDTO bonoDTO = new BonoDTO();
			bonoDTO.setnBono(nbono);
			
			if (rd.anadirReservaBonoFam(r, bonoDTO) != 0 ) {
				return -5;
			}
			
		}
				
		BonoDAO bono = new BonoDAO();
		BonoDTO bo = new BonoDTO();
		bo.setnBono(nbono);
		bono.restarUsoBono(bo);
		
		return 0;
		
	}

	
	public int ModificarReservaIndividual(int idres, ModalidadReservaIndividual a, String idUser,Date date, Date hour, Integer duration, String idTrack, Integer nChild,Integer nAdults) throws MySQLSyntaxErrorException, SQLException, ParseException{
		
		float price, discount = 0;
		
		UserDAO u = new UserDAO();
		if( u.comprobarUsuarioExistente(idUser) == false) {
			return -1;
		}
		
		
		PistaDAO p = new PistaDAO();
		PistaDTO p1 = new PistaDTO();
		
		p1 = p.encontrarPista(idTrack);
		
		if( !(p1.getState() == false ) ){
			return -6;
			
		}
		
		price = calcularPrecio(duration);
		if( price == -1) {
			return -2;
		}

		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date frd = format.parse(u.obtenerFechaRegistro(idUser));
		
	    java.sql.Date fecha1 = new java.sql.Date(frd.getTime());
		
	    java.sql.Date date1 = new java.sql.Date(fecha1.getTime());
	    
	    int year_minus1 = date1.getYear() + 1898;
	    
	    java.sql.Date date2 = date1;
	    date2.setYear(year_minus1);
	    
	    if(date1.compareTo(date2)<0) {
	    	discount = 10;
	    	price = price * (90 / 100);
	    }
		
		if(nChild == 0) { 
			if(!p1.getDifficulty().toString().equals("adult")) {
				return -7;
			}
			
			if(nChild != 0) {
				return -9;
			}
			
			ReservaAdultosDTO r = a.createRAdult(idUser, date, hour, duration, idTrack, price, discount, nAdults);
			ReservaAdultDAO rd = new ReservaAdultDAO();
			
			
			
			if (rd.modificarReservaIndivAdult(r, idres) != 0 ) {
				return -5;
			}

			
		}
		else if(nAdults == 0) { 
			if(!p1.getDifficulty().toString().equals("child")) {
				return -7;
			}
			
			if(nAdults != 0) {
				return -9;
			}
			
			ReservaInfantilDTO r = a.createRChild(idUser, date, hour, duration, idTrack, price, discount, nChild);

			ReservaChildDAO rd = new ReservaChildDAO();

			if (rd.modificarReservaIndivChild(r, idres) != 0 ) {
				return -5;
			}
			
		}
		else { 
			if(!p1.getDifficulty().toString().equals("family")) {
				return -7;
			}
			
			ReservaFamiliarDTO r = a.createRFamiliar(idUser, date, hour, duration, idTrack, price, discount, nChild, nAdults);

			ReservaFamDAO rd = new ReservaFamDAO();
			
			if (rd.modificarReservaIndivFam(r, idres) != 0 ) {
				return -5;
			}
			
			
		}
		
		return 0;
		
	}
	
	

	public int ModificarReservaIndividual(int idres, ModalidadReservaBono a, int nbono, String idUser,Date date, Date hour, Integer duration, String idTrack, Integer nChild,Integer nAdults) throws MySQLSyntaxErrorException, SQLException, ParseException{
		
		float price, discount = 0;
		
		UserDAO u = new UserDAO();
		if( u.comprobarUsuarioExistente(idUser) == false) {
			return -1;
		}
		
		BonoDAO b = new BonoDAO();
		if( b.comprobarBonoExistente(nbono) == false) {
			return -2;
		}
		
		if(b.comprobarBonoyUser(nbono, idUser)==false) {
			return -3;
		}
		
		
		PistaDAO p = new PistaDAO();
		PistaDTO p1 = new PistaDTO();
		
		p1 = p.encontrarPista(idTrack);
		
		if( !(p1.getState() == false ) ){
			return -6;
		}
		
		
		price = calcularPrecio(duration);
		if( price == -1) {
			return -4;
		}

		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date frd = format.parse(u.obtenerFechaRegistro(idUser));
		
	    java.sql.Date fecha1 = new java.sql.Date(frd.getTime());
		
	    java.sql.Date date1 = new java.sql.Date(fecha1.getTime());
	    
	    int year_minus1 = date1.getYear() + 1898; 
	    
	    java.sql.Date date2 = date1;
	    date2.setYear(year_minus1);
	    
	    if(date1.compareTo(date2)<0) {
	    	discount = 10;
	    	price = price * (95 / 100);
	    }
		
		if(nChild == 0) { 
			if(!p1.getDifficulty().toString().equals("adult")) {
				return -7;
			}
			
			if(!b.getTipoBono(nbono).toString().equals("adult")) {
				return -4;
			}
			
			if(nChild != 0) {
				return -9;
			}
			
			ReservaAdultosDTO r = a.createRAdult(idUser, date, hour, duration, idTrack, price, discount, nAdults);
			ReservaAdultDAO rd = new ReservaAdultDAO();
			BonoDTO bonoDTO = new BonoDTO();
			bonoDTO.setnBono(nbono);
			
			if (rd.modificarReservaBonoAdult(r, idres, bonoDTO) != 0 ) {
				return -5;
			}

			
		}
		else if(nAdults == 0) { 
			if(!p1.getDifficulty().toString().equals("child")) {
				return -7;
			}
			
			if(!b.getTipoBono(nbono).toString().equals("child")) {
				return -4;
			}
			
			if(nAdults != 0) {
				return -9;
			}
			
			ReservaInfantilDTO r = a.createRChild(idUser, date, hour, duration, idTrack, price, discount, nChild);

			ReservaChildDAO rd = new ReservaChildDAO();
			
			BonoDTO bonoDTO = new BonoDTO();
			bonoDTO.setnBono(nbono);
			
			
			if (rd.modificarReservaBonoChild(r, idres, bonoDTO) != 0 ) {
				return -5;
			}
			
			
		}
		else { 
			
			if(!p1.getDifficulty().toString().equals("family")) {
				return -7;
			}
			
			if(!b.getTipoBono(nbono).toString().equals("family")) {
				return -4;
			}
			
			ReservaFamiliarDTO r = a.createRFamiliar(idUser, date, hour, duration, idTrack, price, discount, nChild, nAdults);

			ReservaFamDAO rd = new ReservaFamDAO();
			
			BonoDTO bonoDTO = new BonoDTO();
			bonoDTO.setnBono(nbono);
			
			if (rd.modificarReservaBonoFam(r, idres, bonoDTO) != 0 ) {
				return -5;
			}
			
		}
				
		
		return 0;
		
	}	

	
	
	public int calcularPrecio(int duracion) {

		if ( duracion == 60 ) {
			return 20;
		}
		else if ( duracion == 90 ) {
			return 30;
		}
		else if ( duracion == 120 ) {
			return 40;
		}
		
		return -1; //Error
		
	}
	
	public String verResFuturas() throws SQLException {

		ReservaChildDAO rd = new ReservaChildDAO();
		return rd.listarReservas();

	}
	
	public String verResConcreta(Date fech,String name) throws SQLException {

		ReservaChildDAO rd = new ReservaChildDAO();
		return rd.listarReservasConcreta(fech,name);

	}
	
	public int eliminarReserva(int id) throws SQLException {

		ReservaChildDAO rd = new ReservaChildDAO();
		
		if (rd.eliminarReserva(id) != 0) {
			return -1;
		}
		
		return 0;

	}
	
	public int altaBono(String email,String tipo) {
		BonoDTO b=new BonoDTO(email,tipo,5);
		BonoDAO bdao=new BonoDAO();
		int status=bdao.altaBono(b);
		return status;
	}	
}