package br.com.luguia.arceus.model;

public class Contato {

	private String email;
	private Telefone telefone;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public String toString() {
		return  "Email: "+this.email+"\n"+telefone.toString()+"\n";

	}
	
}
