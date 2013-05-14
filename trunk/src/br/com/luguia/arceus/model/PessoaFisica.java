package br.com.luguia.arceus.model;

public class PessoaFisica extends Pessoa{

	private String rg;
	private String cpf;
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String toString() {
		return  "CPF: " + this.cpf + "\n" +
				"RG: " + this.rg + "\n";
	}
}
