package display.javabean;

import java.io.Serializable;

public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String email = "";
	private String password="";
	
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
