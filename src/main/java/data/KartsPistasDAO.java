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
	
	public Integer asociarKartPista(KartDTO k, PistaDTO p) throws FileNotFoundException, SQLException {
		connection dbConnection = new connection();
		Connection connection = dbConnection.getConnection();
		QuerysProperties a=new QuerysProperties();
		try {
		KartDAO kd=new KartDAO();
		PistaDAO pd=new PistaDAO();
		int id = k.getId();
		String nombre="'"+p.getName()+"'";
		if(!kd.comprobarKartExistente(id)) {
			return -3;
		}
		if(!pd.comprobarPistaExistente(p.getName())) {
			return -3;
		}
		String query = a.getselectKartOne() +nombre; 
		Statement stmt = connection.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery(query);
		int count=0;
		KartDAO t = new KartDAO();
		while (rs.next()) {
			count++;
		}
		String tipo = null;
		String dif=null;
		query = a.getselectKartTwo() +"'"+id+"'"; 
	    rs = (ResultSet) stmt.executeQuery(query);
	    while (rs.next()) {
			String val=rs.getString("pista");
			tipo=rs.getString("tipo");
			if (val!=null) {
				return -1;
			}
		}
	    query = a.getSelectPistaByName() +"'"+p.getName()+"'"; 
	    rs = (ResultSet) stmt.executeQuery(query);
	    while (rs.next()) {
	    	dif=rs.getString("dificultad");
	    }
	    if(dif.equals("child")) {
	    	if(tipo.equals("true")) {
	    		return -5;
	    	}
	    }else if(dif.equals("adult")) {
	    	if(tipo.equals("false")) {
	    		return -5;
	    	}
	    }
		if(count<p.getMaxkarts()&&t.comprobarKartExistente(k.getId())) {
			int status=0;
			PreparedStatement ps=connection.prepareStatement(a.getupdateKartPista());
			ps.setString(1, p.getName());
			ps.setInt(2, k.getId());
			status = ps.executeUpdate();
			dbConnection.closeConnection();
			return 0;
		}
		else {
			return -2;
		}
		}catch(NullPointerException e) {
			return -3;
		}
	
	}
	
}