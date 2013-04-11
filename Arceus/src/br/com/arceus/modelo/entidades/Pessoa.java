package br.com.arceus.modelo.entidades;

public class Pessoa {

	private String nome;
	private int cod;

	public Pessoa(String nome, int cod) {

		this.nome = nome;
		this.cod = cod;

	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public int getcod() {
		return cod;
	}

	public void setcod(int cod) {
		this.cod = cod;
	}

}
