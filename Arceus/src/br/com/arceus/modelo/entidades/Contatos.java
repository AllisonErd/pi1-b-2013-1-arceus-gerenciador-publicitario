package br.com.arceus.modelo.entidades;

public class Contatos {

	private String telefone1;
	private String telefone2;

	
	private Contatos(String telefone1, String telefone2){
		
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
	}
	
	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

}
