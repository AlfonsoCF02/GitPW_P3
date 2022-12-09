package data;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;

import business.kart.KartDTO;
import business.kart.kartstat;
import business.pista.PistaDTO;
import business.pista.diff;
import data.common.connection;
import properties.QuerysProperties;

public class PistaDAO {

	/**
 	 * @author Abraham Cordoba
	 * A method that creates a new track
	 * @param x
	 * @return
	 */
	
	public Integer crearPista(PistaDTO x) {
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();
		Connection connection = dbConnection.getConnection();
		try {
			int status=0;
			PreparedStatement ps=connection.prepareStatement(a.getInsertPista());
			ps.setString(1,x.getName());
			ps.setString(2,x.getState().toString());
			ps.setInt(3,x.getMaxkarts());
			ps.setString(4,x.getDifficulty().toString());

			status = ps.executeUpdate();
			dbConnection.closeConnection();
			return 0;
			
		}catch(Exception e) {
			return -1;
			
		}
		
	}
	
	/**
	 * A method that checks if a track exists
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	
	public Boolean comprobarPistaExistente(String nombre) throws SQLException {
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();

		Connection connection = dbConnection.getConnection();
		int flag=0;
		String name="'"+nombre+"'";
		String query = a.getSelectPistaByName() + name;
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		if(rs.next()==true) {
			flag=1;
			return true;
		}
		if(stmt != null) {
			stmt.close();
		}
		dbConnection.closeConnection();
		if(flag==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * A method that lists the maintenance tracks
	 * @return
	 * @throws SQLException
	 */
	
	public String listarPistasMantenimiento() throws SQLException {
		String info="";
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();

		Connection connection = dbConnection.getConnection();
		String query = a.getSelectPistasFalse(); 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		while (rs.next()) {
			String nombre = rs.getString("nombre");
			Boolean disponible = rs.getBoolean("disponible");
			Integer karts = rs.getInt("maxcarts");
			String dificultad = rs.getString("dificultad").toString();
			String disponibilidad;
			if(disponible==true) {
				disponibilidad="Disponible";
			}
			else {
				disponibilidad="Mantenimiento";
			}
			info+=("Nombre: "+nombre+", "+"Estado: "+disponibilidad+", "+"Karts Maximos: "+karts+", "+"Dificultad: "+dificultad+"\n");
		}
		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		return info;
		
	}
	
	/**
	 * A method that lists the available tracks
	 * @param num
	 * @param tipo
	 * @return
	 * @throws SQLException
	 */
	
	public String pistasLibres(int num, diff tipo) throws SQLException {
		String info="";
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();

		Connection connection = dbConnection.getConnection();
		String type="'"+tipo+"'";
		String query = a.getSelectPistaFirst() + "'" +num + "'" + a.getSelectPistaSecond() + type.toString();
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		while (rs.next()) {
			String nombre = rs.getString("nombre");
			Boolean disponible = rs.getBoolean("disponible");
			Integer karts = rs.getInt("maxcarts");
			String dificultad = rs.getString("dificultad").toString();
			String disponibilidad;
			if(disponible==true) {
				disponibilidad="Disponible";
			}
			else {
				disponibilidad="Mantenimiento";
			}
			info+=("Nombre: "+nombre+", "+"Estado: "+disponibilidad+", "+"Karts Maximos: "+karts+", "+"Dificultad: "+dificultad+"\n");
		}
		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		return info;
		
	}
	
	/**
	 * A method that find and return a track in the DB
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	
	public PistaDTO encontrarPista(String nombre) throws SQLException {
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		
		String name = "'"+nombre+"'";
		QuerysProperties a=new QuerysProperties();
		String query = a.getSelectPistaByName() + name; 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		
		PistaDTO p = new PistaDTO();
		
		while (rs.next()) {
			p.setName(rs.getString("nombre"));
			p.setState(rs.getBoolean("disponible"));
			p.setMaxkarts(rs.getInt("maxcarts"));
			
			if(rs.getString("disponible").equals("disponible")) {
				p.setState(true);
			}
			else {
				p.setState(false);
			}
			
			if(rs.getString("dificultad").equals("family")) {
				p.setDifficulty(diff.family);
			}
			else if(rs.getString("dificultad").equals("adult")) {
				p.setDifficulty(diff.adult);			}
			else if(rs.getString("dificultad").equals("child")) {
				p.setDifficulty(diff.child);
				}
		}
		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		
		return p;
	}
	
	public ArrayList<String>listarPistas() throws SQLException {
		String info="";
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();
		ArrayList<String> pistas=new ArrayList<String>();
		Connection connection = dbConnection.getConnection();
		String query ="select * from pistas";
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		while (rs.next()) {
			String nombre = rs.getString("nombre");
			Boolean disponible = rs.getBoolean("disponible");
			Integer karts = rs.getInt("maxcarts");
			String dificultad = rs.getString("dificultad").toString();			
			info=("Nombre: "+nombre+", "+"Estado: "+disponible+", "+"Karts Maximos: "+karts+", "+"Dificultad: "+dificultad+"\n");
			pistas.add(info);
		}
		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		return pistas;
		
	}
}

