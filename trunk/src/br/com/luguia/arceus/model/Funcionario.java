package br.com.luguia.arceus.model;

public class Funcionario {

	private int id;
	private String login;
	private String senha;
	private String tipo;
	private String nome;
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return  "ID: "+this.id+"\n"+
				"Nome: "+this.nome + "\n" +
				"Login: " + this.login + "\n" + 
				"Tipo: " + this.tipo + "\n"+
				"Senha: " + this.senha + "\n";

	}
}