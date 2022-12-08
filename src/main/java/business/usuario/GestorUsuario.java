package business.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import business.pista.PistaDTO;
import data.UserDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * A class that implements system user management
 * @author Alfonso De la Torre
 * */

public class GestorUsuario {
	
	/**
	 * Empty (default) constructor
	 */
	public GestorUsuario() {
		
	}
	
	
	/**
	 * A method that allows to register new users
	 * Changes will be saved in the DB
	 * @throws SQLException 
	 * @throws ParseException 
	 * */
	//Manager receives a user and passes the partitioned info to the DAO
	
	public Integer altaUsuario(String nom,String surname,String email,Date birth,Date firstB,typeof tipo,String pass) throws SQLException, ParseException {
		UserDAO u=new UserDAO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    java.sql.Date date1 = new java.sql.Date(birth.getTime());
		UsuarioDTO x=new UsuarioDTO(nom,surname,date1,email,pass,tipo);
	    java.sql.Date date2 = new java.sql.Date(firstB.getTime());
		x.setFirstBooking(date2);
		Integer value=u.altaUsuario(x);	
		if(value==0) {
			return 0;
			
		}else {
			
			return -1;
		}
	}
	
	/**
	 * A method that allows to discharge an user
	 * Changes will be saved in the DB
	 * @throws SQLException 
	 * @throws ParseException 
	 * */

	public Integer bajaUsuario(String nom,String surname,String email,Date birth,Date firstB,typeof tipo,String pass) throws SQLException, ParseException {
		UserDAO u=new UserDAO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    java.sql.Date date1 = new java.sql.Date(birth.getTime());
		UsuarioDTO x=new UsuarioDTO(nom,surname,date1,email,pass,tipo);
	    java.sql.Date date2 = new java.sql.Date(firstB.getTime());
		x.setFirstBooking(date2);
		Integer value=u.eliminarUsuario(x);	
		if(value==0) {
			return 0;
			
		}else if(value==-1) {
			
			return -1;
		}else {
			return -2;
			
		}
	}
	
	
	/**
	 * A method that allow to modify specific data users
	 * Changes will be saved in the DB
	 * @throws SQLException 
	 * @throws ParseException 
	 * */
	
	public Integer modificarUsuario(String nom,String surname,String email,Date birth,Date firstB,typeof tipo,String pass) throws SQLException, ParseException {
		UserDAO u=new UserDAO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    java.sql.Date date1 = new java.sql.Date(birth.getTime());
		UsuarioDTO x=new UsuarioDTO(nom,surname,date1,email,pass,tipo);
	    java.sql.Date date2 = new java.sql.Date(firstB.getTime());
		x.setFirstBooking(date2);
		Integer value=u.modificarUsuario(x);	
		if(value==0) {
			return 0;
			
		}else {
			
			return -1;
		}
	}
	
	/**
	 * A method that shows us all users that are registered in the system
	 * @throws SQLException 
	 * */
	public ArrayList<ArrayList<String>> listarUsuarios() throws SQLException{
		String info;
		UserDAO u=new UserDAO();
		ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
		users=u.listarUsuarios();
		return users;
	}

	public Boolean comprobarUsuarioExistente(String email) throws MySQLSyntaxErrorException, SQLException {
		UserDAO u=new UserDAO();
		if(u.comprobarUsuarioExistente(email)==false){
			return false;
		}else {
			return true;
		}
	}
}
