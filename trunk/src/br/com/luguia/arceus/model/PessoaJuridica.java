package br.com.luguia.arceus.model;

public class PessoaJuridica extends Pessoa {
	
	
	private String cnpj;
		
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String toString() {
		return  "CNPJ: "+this.cnpj+"\n"+super.toString();

	}
	
}
