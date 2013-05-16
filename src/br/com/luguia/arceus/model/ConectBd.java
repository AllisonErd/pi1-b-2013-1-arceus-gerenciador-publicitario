package br.com.luguia.arceus.model;

import javax.swing.JOptionPane;

public class ConectBd {

	String host = "jdbc:mysql://localhost:3306/arceus1.1";
	String user = "root";
	String pass = "1234";
	public String getHost() {
		return host;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPass() {
		return pass;
	}
	
	public boolean validaConexao(String host, String user, String pass){
		if(host.equalsIgnoreCase(this.host)&&user.equalsIgnoreCase(this.user)&&pass.equalsIgnoreCase(pass)){
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "Os dados de conexão estao errados!!");
			return false;
		}
	}
	
	
}
