package data;
import java.sql.*;

import business.kart.KartDTO;
import business.kart.kartstat;
import data.common.connection;
import properties.QuerysProperties;

/**
 * A class that implements the kart data access via DAO 
 * @author Victoria Muñoz
 * */



public class KartDAO {
	
	/**
	 * A method that allows to create new karts
	 * Karts will be saved in the DB
	 * @param x
	 * @return
	 * @throws SQLException
	 */
	
	public Integer altaKart(KartDTO x) {
		
		int status = 0;
		QuerysProperties a=new QuerysProperties();

		try {
			
			connection dbConnection = new connection();
			Connection connection = dbConnection.getConnection();
			PreparedStatement ps;
			
			ps = connection.prepareStatement(a.getInsertKart());
			ps.setString(1,x.getKarttype().toString());
			ps.setString(2,x.getKartstatus().toString());
			
			status = ps.executeUpdate();
			dbConnection.closeConnection();
			
			return 0;
			
			
		} catch (SQLException e) {
			System.out.println(e);
			return -1;
			
		}
		
	}
	
	/**
	 * A method that checks if a kart exists.
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Boolean comprobarKartExistente(Integer id) throws SQLException{
		
		connection dbConnection = new connection();
		QuerysProperties a=new QuerysProperties();

		Connection connection = dbConnection.getConnection();
		String query = a.getSelectKartById() + id; 
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
	}
	
	/**
	 * A method that changes the items of a kart
	 * @param x
	 * @return
	 * @throws SQLException
	 */
	
	public Integer modificarKart(KartDTO x) throws SQLException {
		
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();

		if(comprobarKartExistente(x.getId())==false) {
			return -1;
		}
		
		int status = 0;
			
		try {
			PreparedStatement ps=connection.prepareStatement(a.getUpdateKart());
			ps.setBoolean(1,x.getKarttype());
			ps.setString(2,x.getKartstatus().toString());
			ps.setInt(3, x.getId());
			status = ps.executeUpdate();
			dbConnection.closeConnection();
			return 0;
			
		}catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	
	/**
	 * A method that removes a kart
	 * @param x
	 * @return
	 * @throws SQLException
	 */

	public Integer eliminarKart(KartDTO x) throws SQLException{
	
		if(comprobarKartExistente(x.getId()) == false) {
			return -1;
			
		}
		QuerysProperties a=new QuerysProperties();

	try{
		
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		
		PreparedStatement ps=connection.prepareStatement(a.getDeleteKart());
		
		ps.setInt(1,x.getId());
		
		ps.executeUpdate();
		
		return 0;
		
	}catch(Exception e){
		return -2;
		
	}
	
}

	/**
	 * A method that lists the karts
	 * @return
	 * @throws SQLException
	 */

	public String listarKarts() throws SQLException {
		
		String info="";
		
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();

		String query = a.getSelectAllKarts(); 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		
		while (rs.next()) {
			
			Integer id = rs.getInt("id");
			Boolean tipo = rs.getBoolean("tipo");
			String estado = rs.getString("estado");
			info+=("Id: "+id+" "+"Tipo: "+tipo+" "+"Estado: "+estado+"\n");
		}
		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		return info;
		
	}
	
	/**
	 * A method that find a kart in the DB
	 * @param num
	 * @return 
	 * @throws SQLException
	 */
	
	public KartDTO encontrarKart(int num) throws SQLException {
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();

		String query = a.getSelectKartById() + num; 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		
		KartDTO k = new KartDTO();
		
		while (rs.next()) {
			k.setId(rs.getInt("id"));
			k.setKarttype(rs.getBoolean("tipo"));
			if(rs.getString("estado")=="reservado") {
				k.setKartstatus(kartstat.reservado);
			}
			else if(rs.getString("estado")=="mantenimiento") {
				k.setKartstatus(kartstat.mantenimiento);
			}
			else if(rs.getString("estado")=="disponible") {
				k.setKartstatus(kartstat.disponible);
			}
		}
		if (stmt != null){ 
			stmt.close(); 
		}
		dbConnection.closeConnection();
		
		return k;
	}
	
}