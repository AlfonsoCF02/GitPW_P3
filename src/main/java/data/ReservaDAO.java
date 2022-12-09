package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import data.common.connection;
import properties.QuerysProperties;


/**
 * A class that implements the bookings data access via DAO 
 * @author Alfonso de la Torre
 * */

public abstract class ReservaDAO {
	
	/**
	 * A method that allow to list the bookings
	 * */
	public String listarReservas() throws SQLException {
		String info="";
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();

		String query = a.getSelectAllReservas(); 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		while (rs.next()) {
			int id = rs.getInt("id");
			String email = rs.getString("email");
			int discount = rs.getInt("descuento");
			int duration = rs.getInt("duracion");
			String pista = rs.getString("pista");
			int nadults = rs.getInt("adultos");
			int nchilds = rs.getInt("ninos");
			int nbono = rs.getInt("nbono");
			int price = rs.getInt("precio");
			String type = rs.getString("tipo");
			java.sql.Date date = rs.getDate("fecha");
			info+=("Id: "+id+" "+"Email: "+email+" "+"Descuento: "+discount+" "+"Duracion: "+duration+" "+"PistaDTO: "+pista+" "+"Adultos: "+nadults+" "+"Ninos: "+nchilds+" "+
					"NumeroBono: "+nbono+" "+"Precio: "+price+" "+"Tipo: "+type+" "+"Fecha: "+date+"\n");
		}
		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		return info;
	}
		
	
	/**
	 * A method that allow to list a specific booking
	 * */
	public String listarReservasConcreta(Date fech,String name) throws SQLException {
		String info="";
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	    String stringDate= format.format(fech);  
		String query = a.getSelectConcretaUno() + "'"+stringDate+"'" + a.getSelectConcretaDos() + "'"+name+"'" ; 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		while (rs.next()) {
			int id = rs.getInt("id");
			String email = rs.getString("email");
			int discount = rs.getInt("descuento");
			int duration = rs.getInt("duracion");
			String pista = rs.getString("pista");
			int nadults = rs.getInt("adultos");
			int nchilds = rs.getInt("ninos");
			int nbono = rs.getInt("nbono");
			int price = rs.getInt("precio");
			String type = rs.getString("tipo");
			java.sql.Date date = rs.getDate("fecha");
			info+=("Id: "+id+" "+"Email: "+email+" "+"Descuento: "+discount+" "+"Duracion: "+duration+" "+"PistaDTO: "+pista+" "+"Adultos: "+nadults+" "+"Ninos: "+nchilds+" "+
					"NumeroBono: "+nbono+" "+"Precio: "+price+" "+"Tipo: "+type+" "+"Fecha: "+date+"\n");
		}
		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		return info;
	}
	
	public String obtenerNReservas(String email) throws SQLException {
		int nres=0;
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();  
		String mail="'"+email+"'";
		String query = "select * from reservas where email = "+mail ; 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		while (rs.next()) {
			nres++;
		}
		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		return String.valueOf(nres);
	}
	
	public String obtenerProxReserva(String email) throws SQLException {
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();  
		String mail="'"+email+"'";
		String query = "select * from reservas where email = "+mail ; 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		int i=0;
		String cad="";
		while (rs.next()) {
			if(i==0) {
				cad=rs.getDate("fecha").toString();
				i++;
			}			
		}
		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		return cad;
	}
	
	
	/**
	 * A method that allow to check if a booking already exists
	 * */
	public Boolean comprobarReservaExistente(int id) throws SQLException,MySQLSyntaxErrorException {
		
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();

		int flag=0;
		String query =  a.getSelectReservaById()+ id; 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		if(rs.next()==true) {
			flag=1;
			return true;
		}

		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		if(flag==0) {
			return false;
		}else {
			return true;
		}
		
	}
	
	
	/**
	 * A method that allow to delete a booking
	 * Changes will be saved in the DB
	 * */
	public Integer eliminarReserva(int nreserva) throws MySQLSyntaxErrorException, SQLException {
		int status=0;
		QuerysProperties a=new QuerysProperties();

		if(comprobarReservaExistente(nreserva)==false) {
			return -1;
		}
		try{
			connection dbConnection = new connection();
			Connection connection = dbConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement(a.getDeleteReserva());
			ps.setInt(1,nreserva);
			status=ps.executeUpdate();
			return 0;
		}catch(Exception e){
			return -2;

		}
	}
	
}
