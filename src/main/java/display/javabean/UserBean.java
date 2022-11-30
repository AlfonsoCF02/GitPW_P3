package display.javabean;

import java.io.Serializable;

import business.usuario.typeof;

public class UserBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private typeof privilegios;
	private String mail;
	private String email="";
	
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
