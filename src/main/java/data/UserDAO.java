package data;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import data.common.connection;
import properties.QuerysProperties;

import java.util.Date;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import business.reserva.BonoDTO;
import business.reserva.ModalidadReservaIndividual;
import business.usuario.UsuarioDTO;




/**
 * A class that implements the user's data access via DAO 
 * @author Alfonso de la Torre
 * */
public class UserDAO {

	
	/**
	 * A method that allows to register a new user in the DB
	 * @param x
	 * @throws SQLException
	 */
	public Integer altaUsuario(UsuarioDTO x) throws SQLException{
		
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();
		try {
				int status=0;
				PreparedStatement ps=connection.prepareStatement(a.getInsertUser());
				ps.setString(1,x.getEmail());
				ps.setString(2,x.getName());
				ps.setString(3,x.getSurname());
				ps.setDate(4,(java.sql.Date) x.getBirth());
				ps.setDate(5,(java.sql.Date) x.getFirstBooking());
	
				status = ps.executeUpdate();
				dbConnection.closeConnection();
				return 0;
			
		}catch(Exception e){
			return -1;
			
		}
	}
	
	/**
	 * A method that gets the register date of an user
	 * @param email
	 * @throws SQLException
	 */
	
	public String obtenerFechaRegistro(String email) throws SQLException {
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();
		java.sql.Date firstB = null;
		Connection connection = dbConnection.getConnection();
		int flag=0;
		String mail="'"+email+"'";
		String query = a.getSelectUserByEmail() + mail; 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		while(rs.next()) {
			firstB = rs.getDate("primres");
		}

		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		return firstB.toString();

	}
	
	/**
	 * A method that modify a user
	 * @param x
	 * @throws SQLException
	 */
	
	public Integer modificarUsuario(UsuarioDTO x) throws SQLException {
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();

		if(comprobarUsuarioExistente(x.getEmail())==false) {
			return -1;
			
		}
		try {
			int status=0;
			PreparedStatement ps=connection.prepareStatement(a.getUpdateUser());
			ps.setString(1,x.getName());
			ps.setString(2,x.getSurname());
			ps.setDate(3,(java.sql.Date) x.getBirth());
			ps.setDate(4,(java.sql.Date) x.getFirstBooking());
			ps.setString(5,x.getEmail());

			status = ps.executeUpdate();
			dbConnection.closeConnection();
			return 0;
		}catch(Exception e) {

			return -1;
		}
	}

	
	/**
	 * A method that checks if an user exits
	 * @param email
	 * @throws SQLException
	 * @throws MySQLSyntaxErrorException
	 */
	
	public Boolean comprobarUsuarioExistente(String email) throws SQLException,MySQLSyntaxErrorException {
		
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();
		Connection connection = dbConnection.getConnection();
		int flag=0;
		String mail="'"+email+"'";
		String query = a.getSelectUserByEmail() + mail; 
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
	
	public UsuarioDTO obtenerUser(String email) throws SQLException {
		UsuarioDTO u=null;
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();
		Connection connection = dbConnection.getConnection();
		int flag=0;
		String mail="'"+email+"'";
		String query = a.getSelectUserByEmail() + mail; 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		if(rs.next()==true) {
			flag=1;
			String email1=rs.getString(1);
			String nom
			String ap=
			String
		}

		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
	}

	/**
	 * A method that removes an user
	 * @param x
	 * @throws MySQLSyntaxErrorException
	 * @throws SQLException
	 */

	public Integer eliminarUsuario(UsuarioDTO x) throws MySQLSyntaxErrorException, SQLException {
		int status=0;
		QuerysProperties a=new QuerysProperties();
		if(comprobarUsuarioExistente(x.getEmail())==false) {
			return -1;
			
		}
		try{
			connection dbConnection = new connection();
			Connection connection = dbConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement(a.getDeleteUser());
			ps.setString(1,x.getEmail());
			status=ps.executeUpdate();
			return 0;
		}catch(Exception e){
			return -2;
			
		}
		
	}
	
	/**
	 * A method that lists the user of the DB
	 * @throws SQLException
	 */
	
	public String listarUsuarios() throws SQLException {
		String info="";
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();
		Connection connection = dbConnection.getConnection();
		String query = a.getSelectAllUsers(); 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		while (rs.next()) {
			String nombre = rs.getString("nombre");
			String apellidos = rs.getString("apellidos");
			String email = rs.getString("email");
			java.sql.Date birth = rs.getDate("cumple");
			java.sql.Date firstB = rs.getDate("primres");
			info+=("Nombre: "+nombre+" "+"Apellidos: "+apellidos+" "+"Email: "+email+" "+"FechaNacimiento: "+birth+" "+"PrimeraReserva: "+firstB+"\n");
		}
		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		return info;
	}	
}

