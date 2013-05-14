package br.com.luguia.arceus.model;

public class Telefone {
	
	private String telefoneFixo;
	private String telefoneCel;
	
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelefoneCel() {
		return telefoneCel;
	}
	public void setTelefoneCel(String telefoneCel) {
		this.telefoneCel = telefoneCel;
	}
	
	public String toString() {
		return  "TeleFoneFixo: "+this.telefoneFixo+"\n"+
				"TelefoNeCel: "+this.telefoneCel+"\n";

	}
}
