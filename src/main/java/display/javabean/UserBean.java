package display.javabean;

import java.io.Serializable;

import business.usuario.typeof;

public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String emailUsuario,password;
	private typeof privilegios;
	
	public typeof getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(typeof p) {
		this.privilegios = p;
	}
	
	public String getLogin() {
		return emailUsuario;
	}

	public void setLogin(String email) {
		this.emailUsuario = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	
	
}
