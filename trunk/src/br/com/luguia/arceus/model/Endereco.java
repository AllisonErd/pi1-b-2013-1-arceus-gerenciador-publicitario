package br.com.luguia.arceus.model;

public class Endereco {
	private String rua;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	private String complemento;
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String toString() {
		return  "Rua: "+this.rua+"\n"+
				"Cep: "+this.cep+"\n"+
				"Bairro: "+this.bairro+"\n"+
				"Cidade: "+this.cidade+"\n"+
				"Estado: "+this.estado+"\n"+
				"Complemento: "+this.complemento+"\n";

	}

	
}
