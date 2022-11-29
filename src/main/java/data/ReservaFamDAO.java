package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import business.kart.KartDTO;
import business.pista.PistaDTO;
import business.reserva.BonoDTO;
import business.reserva.ModalidadReservaIndividual;
import business.reserva.Reserva;
import business.reserva.ReservaFamiliarDTO;
import business.usuario.GestorUsuario;
import business.usuario.UsuarioDTO;
import data.common.connection;
import properties.QuerysProperties;


/**
 * A class that implements the family type booking, extending ReservaDAO
 * @author Alfonso de la Torre
 * */


public class ReservaFamDAO extends ReservaDAO {
	
	/**
	 * A method that allow to make an individual family booking
	 * Changes will be saved in the DB
	 * */
	public Integer anadirReservaIndivFam(ReservaFamiliarDTO r){
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();
		Connection connection = dbConnection.getConnection();
		try {
				int status=0;
				PreparedStatement ps=connection.prepareStatement(a.getInsertReserva());
				ps.setString(1,r.getIdUser());
				ps.setFloat(2, r.getDiscount());
				ps.setLong(3,r.getDuration());
				ps.setString(4,r.getIdTrack());
				ps.setInt(5,r.getNAdult());
				ps.setInt(6,r.getNChild());
				ps.setString(7,null);
				ps.setFloat(8,r.getPrice());
				ps.setString(9, r.getClass().toString());
				ps.setDate(10,(java.sql.Date) r.getHour());
	
				status = ps.executeUpdate();
				dbConnection.closeConnection();
				return 0;
			
		}catch(MySQLIntegrityConstraintViolationException e){
			
			return -2;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return -1;
			// TODO Auto-generated catch block
		}
	}
	
	
	/**
	 * A method that allow to include a booking to a family bonus
	 * Changes will be saved in the DB
	 * */
	public Integer anadirReservaBonoFam(ReservaFamiliarDTO r,BonoDTO x) {
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();
		Connection connection = dbConnection.getConnection();
		try {
				int status=0;
				PreparedStatement ps=connection.prepareStatement(a.getInsertReserva());
				ps.setString(1,r.getIdUser());
				ps.setFloat(2, r.getDiscount());
				ps.setLong(3,r.getDuration());
				ps.setString(4,r.getIdTrack());
				ps.setInt(5,r.getNAdult());
				ps.setInt(6,r.getNChild());
				ps.setInt(7,x.getnBono());
				ps.setFloat(8,r.getPrice());
				ps.setString(9, r.getClass().toString());
				ps.setDate(10,(java.sql.Date) r.getHour());
				status = ps.executeUpdate();
				dbConnection.closeConnection();
				BonoDAO b=new BonoDAO();
				b.restarUsoBono(x);
				return 0;
			
		}catch(MySQLIntegrityConstraintViolationException e1) {
			return -2;
			
		}catch(Exception e){
			System.out.println(e);
			return -1;
			
		}	
	}
	
	
	
	/**
	* A method that allow to modify an individual family booking
	* Changes will be saved in the DB
	* */	
	public Integer modificarReservaIndivFam(ReservaFamiliarDTO r,int id) throws SQLException {
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();
		if(super.comprobarReservaExistente(id)==false) {
			return -1;
			
		}
		try {
			int status=0;
			PreparedStatement ps=connection.prepareStatement(a.getUpdateReserva());
			ps.setString(1,r.getIdUser());
			ps.setFloat(2, r.getDiscount());
			ps.setLong(3,r.getDuration());
			ps.setString(4,r.getIdTrack());
			ps.setInt(5,r.getNAdult());
			ps.setInt(6,r.getNChild());
			ps.setString(7, null);
			ps.setFloat(8,r.getPrice());
			ps.setString(9, r.getClass().toString());
			ps.setDate(10,(java.sql.Date) r.getHour());
			ps.setInt(11, id);
			status = ps.executeUpdate();
			dbConnection.closeConnection();
			return 0;
		}catch(MySQLIntegrityConstraintViolationException e1) {
			return -2;
			
		}catch(Exception e) {
			return -1;
			
		}
	}
	
	
	/**
	* A method that allow to modify a booking included in a family bonus
	* Changes will be saved in the DB
	* */	
	public Integer modificarReservaBonoFam(ReservaFamiliarDTO r,int id,BonoDTO x) throws MySQLSyntaxErrorException, SQLException {
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();
		if(super.comprobarReservaExistente(id)==false) {
			return -1;
			
		}
		try {
			int status=0;
			PreparedStatement ps=connection.prepareStatement(a.getUpdateReserva());
			ps.setString(1,r.getIdUser());
			ps.setFloat(2, r.getDiscount());
			ps.setLong(3,r.getDuration());
			ps.setString(4,r.getIdTrack());
			ps.setInt(5,r.getNAdult());
			ps.setInt(6,r.getNChild());
			ps.setInt(7,x.getnBono());
			ps.setFloat(8,r.getPrice());
			ps.setString(9, r.getClass().toString());
			ps.setDate(10,(java.sql.Date) r.getHour());
			ps.setInt(11, id);
			status = ps.executeUpdate();
			dbConnection.closeConnection();
			return 0;
		}catch(MySQLIntegrityConstraintViolationException e1) {
			return -2;
			
		}catch(Exception e) {
			System.out.println(e);
			return -1;
			
		}
	}	
}
