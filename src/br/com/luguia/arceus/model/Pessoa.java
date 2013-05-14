package br.com.luguia.arceus.model;

public class Pessoa {

	private int id;
	private String nome;
	private Endereco endereco;
	private Contato contato;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public String toString() {
		return  "ID: "+this.id+"\n"+
				"Nome: "+this.nome + "\n" +
				"Endereço: " + this.endereco + "\n" + 
				"Contato: " + this.contato + "\n";

	}
}
