package display.javabean;

import java.io.Serializable;
import java.util.Date;

import business.usuario.typeof;

public class CustomerBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private typeof privilegios;
	private String mail;
	private String email="";
	private String nombre="";
	private String apellidos="";
	private Date fechN;
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nom) {
		nombre=nom;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public void setApellidos(String ap) {
		apellidos=ap;
	}
	
	public Date getfechN() {
		return this.fechN;
	}
	
	public void setfechN(Date fech) {
		fechN=fech;
	}
	
	public typeof getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(typeof p) {
		this.privilegios = p;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return mail;
	}

	public void setLogin(String email) {
		this.mail = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	
	
}
