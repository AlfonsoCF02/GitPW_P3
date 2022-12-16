package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import data.common.connection;
import properties.QuerysProperties;
import business.reserva.BonoDTO;
import business.usuario.UsuarioDTO;


/**
 * A class that implements the bonus data access via DAO 
 * @author Alfonso Cabezas
 * */

public class BonoDAO {

	/**
	 * A method that allows to create new bonus
	 * Bonus will be saved in the DB
	 * @param b
	 * @throws SQLException
	 */
	public Integer altaBono(BonoDTO b){
		QuerysProperties a=new QuerysProperties();

		int status = 0;
		
		try {
			
			connection dbConnection = new connection();
			Connection connection = dbConnection.getConnection();

			PreparedStatement ps = connection.prepareStatement(a.getInsertBono());
			ps.setString(1,b.getEmail());
			ps.setString(2,b.getTipo());
			ps.setInt(3,b.getRestantes());
			ps.setString(4,null);
			ps.setString(5,null);
		
			status = ps.executeUpdate();
			dbConnection.closeConnection();
			return 0;
		} catch (SQLException e) {
			System.out.println("Error, no existe ningun usuario con email " + b.getEmail());
			System.out.println("Introduzca un usuario valido\n");
			return -1;
			
		}		
	}
	
	
	/**
	 * A method that checks if a bonus exists.
	 * @param nbono
	 * @throws SQLException
	 */
public Boolean comprobarBonoExistente(int nbono) {
		
	try {
		
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();

		Connection connection = dbConnection.getConnection();

		String query = a.getSelectBonoById() + nbono; 
		
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		
		if(rs.next()==true) {
			return true;
		}

		if (stmt != null){ 
			stmt.close(); 
		}
		
		dbConnection.closeConnection();

		return false;
		
	} catch (SQLException e) {
		return false;
	}
	
}

	/**
	 * A method that checks if a bonus belong to a user
	 * @param nbono, user
	 * @throws SQLException
	 */
public Boolean comprobarBonoyUser(int nbono, String user) {
	
	try {
		
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();

		Connection connection = dbConnection.getConnection();
		String usuario="'"+user+"'";
		String bono="'"+nbono+"'";
		
		String query = a.getSelectBonoById() + bono + a.getSelectBonoSecondPart() + usuario; 
		
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		
		if(rs.next()==true) {
			return true;
		}

		if (stmt != null){ 
			stmt.close(); 
		}
		
		dbConnection.closeConnection();
		return false;
		
	} catch (SQLException e) {
		return false;
	}
	
}


/**
 * A method that allows to delete a bonus
 * @param b
 * @throws SQLException
 */
public Integer eliminarBono(BonoDTO b){
	QuerysProperties a=new QuerysProperties();

	if(comprobarBonoExistente(b.getnBono()) == false) {
		return -1;

	}
	
	try{
		
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		
		PreparedStatement ps=connection.prepareStatement(a.getDeleteBono());
		
		ps.setInt(1,b.getnBono());
		
		ps.executeUpdate();
		
		return 0;
		
	}catch(Exception e){
		return -2;
		
	}
	
}


/**
 * A method that subtracts one use from the bonus each time it is used
 * @param b
 * @throws SQLException
 */

public Integer restarUsoBono(BonoDTO b) throws ParseException{
	QuerysProperties a=new QuerysProperties();

	
	if(comprobarBonoExistente(b.getnBono()) == false) {
		return -1;
	}
	
	int restantes = -1;
	
	try {
		
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		
		String query = a.getSelectRestantesBono() + b.getnBono();
		
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		
		while (rs.next()) {

			restantes = rs.getInt("restantes");

		}
		
		if (stmt != null){ 
			stmt.close(); 
		}
		
		restantes--; 
		
	
		if(restantes == 0) {
			
			eliminarBono(b);
			dbConnection.closeConnection();
			
			return -2;
		}
		else {
			
			
			if(comprobarNUsos(b)<5) {
				PreparedStatement ps = connection.prepareStatement(a.getUpdateRestantesBono() + b.getnBono());
				ps.setInt(1, restantes);
			
				ps.executeUpdate();
				
				dbConnection.closeConnection();
			}else {
				SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
				LocalDate fechaSys2 = LocalDate.now();
		        Date date =  format3.parse(fechaSys2.toString());
			    java.sql.Date date1 = new java.sql.Date(date.getTime());

			    Date fechactplus = format3.parse(fechaSys2.toString());
			    java.sql.Date date2 = new java.sql.Date(fechactplus.getTime());
			    date2.setYear(date2.getYear()+1);
				PreparedStatement ps = connection.prepareStatement(a.getUpdateRestantesBonoDos() + b.getnBono());
				ps.setInt(1, restantes);
				ps.setDate(2,(java.sql.Date) date1);
				ps.setDate(3, date2);
				ps.executeUpdate();
				
				dbConnection.closeConnection();
			}
			
			
			return 0;
			
		}
	
	} catch (SQLException e) {
		System.out.println(e);
		return -1;
		
	}
}

/**
 * A method that checks the number of uses of the bonus
 * @param b
 * @throws SQLException
 */

public Integer comprobarNUsos(BonoDTO b) throws SQLException {
	connection dbConnection = new connection();
	QuerysProperties a=new QuerysProperties();

	Connection connection = dbConnection.getConnection();

	String query = a.getSelectBonoById() + b.getnBono(); 
	int usos=0;
	Statement stmt = connection.createStatement();
	ResultSet rs = (ResultSet) stmt.executeQuery(query);
	
	if(rs.next()==true) {
		usos = rs.getInt("nbono");
	}

	if (stmt != null){ 
		stmt.close(); 
	}
	
	dbConnection.closeConnection();
	return usos;
}


/**
 * A method that allows to list the bonus
 * @throws SQLException
 */

public ArrayList<String> listarBonos(String mail,String type){
	QuerysProperties a=new QuerysProperties();
	ArrayList<String> b=new ArrayList<String>();
	try {
		
		String info = "";
		
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		
		String query = a.getselectFromBonosEmail()+"'"+mail+"'"+a.getselectFromBonosEmailTwo()+"'"+type+"'";
		
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		
		while (rs.next()) {
			int nbono = rs.getInt("nbono");
			String email = rs.getString("email");
			String tipo = rs.getString("tipo");
			int restantes = rs.getInt("restantes");
			java.sql.Date pr = rs.getDate("primres");
			java.sql.Date cad = rs.getDate("caducidad");

			info = ("IDBono: " + nbono + " " + "EmailPropietario: " + email + " " + "Tipo: " + tipo +
						" " + "UsosRestantes: " + restantes + " " + " PrimeraReserva: " + pr +
						" Caducidad: " + cad + "\n");
			b.add(info);
		}
		
		if (stmt != null){ 
			stmt.close(); 
		}
		
		dbConnection.closeConnection();
		
		return b;
	
	} catch (SQLException e) {
		System.out.println(e);
		
	}
	return b;

}	

/**
 * A method that allows to know the type of bonus
 * @throws SQLException
 */
public String getTipoBono(int nbono){
	QuerysProperties a=new QuerysProperties();

	try {
		
		String info = "";
		
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		
		String query = a.getSelectAllBonos();
		
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		
		while (rs.next()) {
			int nbono_get = rs.getInt("nbono");
			String tipo = rs.getString("tipo");

			if(nbono == nbono_get) {
				return tipo;
			}
		}
		
		if (stmt != null){ 
			stmt.close(); 
		}
		
		dbConnection.closeConnection();
		
		return info;
	
	} catch (SQLException e) {
		System.out.println(e);
		return "";
		
	}

}

}