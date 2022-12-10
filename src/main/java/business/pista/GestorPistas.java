package business.pista;

import java.util.ArrayList;
import java.util.Date;

import business.kart.KartDTO;
import business.kart.kartstat;
import business.usuario.GestorUsuario;
import business.usuario.UsuarioDTO;
import data.KartDAO;
import data.KartsPistasDAO;
import data.PistaDAO;
import data.UserDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * A class that implements system track management
 * @author Abraham Cordoba
 * @author Victoria Muñoz
 * */

public class GestorPistas {
	
	/**
	 * Empty (default) constructor
	 */
	public GestorPistas() {
		
	}
	
	/**
	 * A method that allow to create new tracks
	 * Changes will be saved in the DB
	 * */
	public Integer crearPista(String nombre, Boolean estado, Integer karts, diff dificultad) throws SQLException, ParseException{
		PistaDAO u=new PistaDAO();
		PistaDTO x=new PistaDTO(nombre, estado, karts, dificultad);
		Integer value=u.crearPista(x);	
		if(value==0) {
			return 0;
			
		}else {
			
			return -1;
		}
	}
	
	/**
	 * A method that shows us all tracks that are in maintenance
	 * @throws SQLException 
	 * */
	public String listarPistasMantenimiento() throws SQLException {
		String info;
		PistaDAO u=new PistaDAO();
		info=u.listarPistasMantenimiento();
		return info;
	}
		
	/**
	 * A method that confirms if it is possible to associate a kart to a specific track
	 * @throws SQLException 
	 * */
	public Integer asociarKartPista(int num, String nombre) throws FileNotFoundException, SQLException {
		KartsPistasDAO g = new KartsPistasDAO();
		KartDAO a = new KartDAO();
		PistaDAO b = new PistaDAO();
		KartDTO k=new KartDTO();
		k=a.encontrarKart(num);
		PistaDTO p = new PistaDTO();
		p=b.encontrarPista(nombre);
		int value=g.asociarKartPista(k, p);
		return value;
	}
	
	/**
	 * A method that shows the available tracks
	 * @throws SQLException 
	 * */	
	public String pistasLibres(int num, diff tipo) throws SQLException {
		String info;
		PistaDAO u = new PistaDAO();
		info=u.pistasLibres(num, tipo);
		return info;
	}
	
	public ArrayList<String> listarPistas() throws SQLException {
		ArrayList<String> pistas=new ArrayList<String>();
		PistaDAO u = new PistaDAO();
		pistas=u.listarPistas();
		return pistas;
	}
	
	public Integer modificarPistaState(String nom,String val) throws SQLException {
		PistaDAO kd = new PistaDAO();
		PistaDTO kk=new PistaDTO();
		kk.setName(null);
		if(val.equals("true")) {
			kk.setState(true);
		}else {
			kk.setState(false);
		}
		int i=kd.modificarPistaState(kk);
		return i;
	}
}
