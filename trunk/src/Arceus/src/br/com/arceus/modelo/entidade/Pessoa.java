package Arceus.src.br.com.arceus.modelo.entidade;

import Arceus.src.br.com.arceus.modelo.Contato;
import Arceus.src.br.com.arceus.modelo.Endereco;

public class Pessoa {

	private int cod;
	private String nome;
	private Endereco endereco;
	private Contato contato;

	public Pessoa(int cod, String nome, Endereco endereco, Contato contato) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
	}

	public Pessoa(int cod, String nome) {
		super();
		this.cod = cod;
		this.nome = nome;
	}

	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cod != other.cod)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [cod=").append(cod).append(", nome=")
				.append(nome).append(", endereco=").append(endereco)
				.append(", contato=").append(contato).append("]");
		return builder.toString();
	}

}
