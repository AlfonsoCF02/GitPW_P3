package display.javabean;

import java.io.Serializable;

import business.usuario.typeof;

public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String email= "";
	private String password="";
	private typeof privilegios;
	
	public typeof getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(typeof p) {
		this.privilegios = p;
	}
	
	public String getLogin() {
		return email;
	}

	public void setLogin(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	
	
}
