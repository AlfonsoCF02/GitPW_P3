package data;
import java.io.FileNotFoundException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import data.common.connection;
import properties.QuerysProperties;

import java.util.Date;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import business.kart.KartDTO;
import business.pista.GestorPistas;
import business.pista.PistaDTO;
import business.pista.diff;
import business.usuario.UsuarioDTO;

public class KartsPistasDAO {

	/**
	 * A method that links a kart to a track
	 * @author Abraham Cordoba
	 * @param k
	 * @param p
	 * @return
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	
	public Integer asociarKartPista(KartDTO k, PistaDTO p) throws FileNotFoundException {
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();

	try {
		int id = k.getId();
		String nombre="'"+p.getName()+"'";
		String query = a.getSelectKartPistasFirst() + "'" +id + "'" + a.getSelectKartPistasSecond() + nombre ; 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		int count=0;
		KartDAO t = new KartDAO();
		while (rs.next()) {
			count++;
			int kart = rs.getInt("kart");
			String pista = rs.getString("pista");
			if(kart==id && pista==nombre) {
				return -1;
			}
		}
		if(count<p.getMaxkarts()&&t.comprobarKartExistente(k.getId())) {
			int status=0;
			PreparedStatement ps=connection.prepareStatement(a.getInsertKartPistas());
			ps.setInt(1, k.getId());
			ps.setString(2, p.getName());
			status = ps.executeUpdate();
			dbConnection.closeConnection();
			return 0;
		}
		else {
			return -2;
		}
	}catch(SQLException e){
		return -1;
	}catch(NullPointerException e1) {
		return -3;
	}
	}
	
}