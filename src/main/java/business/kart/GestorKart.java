package business.kart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.KartDAO;
import data.common.connection;
import properties.QuerysProperties;

public class GestorKart {

	/**
	 * A method that allow to create new karts
	 * Karts will be saved in the DB
	 * @throws SQLException 
	 * */
	public Integer crearKart(Integer id, Boolean karttype, kartstat stateofkart ) throws SQLException {
		KartDAO u=new KartDAO();
		KartDTO x=new KartDTO(id, karttype, stateofkart);
		Integer value=u.altaKart(x);	
		if(value==0) {
			return 0;
			
		}else {
			
			return -1;
		}
	}
	
	public Integer modificarKartState(int id,kartstat k) throws SQLException {
		KartDAO kd = new KartDAO();
		KartDTO kk=new KartDTO();
		kk.setId(id);
		kk.setKartstatus(k);
		int i=kd.modificarKartState(kk);
		return i;
	}
	
public ArrayList<String> listarKarts() throws SQLException {
		ArrayList<String> karts = new ArrayList<String>();
		KartDAO kd=new KartDAO();
		karts=kd.listarKarts();
		return karts;
		
	}
	
	
}
