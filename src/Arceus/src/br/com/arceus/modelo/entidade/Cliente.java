package Arceus.src.br.com.arceus.modelo.entidade;

import Arceus.src.br.com.arceus.modelo.Contato;
import Arceus.src.br.com.arceus.modelo.Endereco;

public class Cliente extends Pessoa {

	private String dataCadastro;
	private String tempoFreguesia;

	public Cliente(int cod, String nome, Endereco endereco, Contato contato,
			String dataCadastro, String tempoFreguesia) {
		super(cod, nome, endereco, contato);
		this.dataCadastro = dataCadastro;
		this.tempoFreguesia = tempoFreguesia;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getTempoFreguesia() {
		return tempoFreguesia;
	}

	public void setTempoFreguesia(String tempoFreguesia) {
		this.tempoFreguesia = tempoFreguesia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result
				+ ((tempoFreguesia == null) ? 0 : tempoFreguesia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (tempoFreguesia == null) {
			if (other.tempoFreguesia != null)
				return false;
		} else if (!tempoFreguesia.equals(other.tempoFreguesia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [dataCadastro=").append(dataCadastro)
				.append(", tempoFreguesia=").append(tempoFreguesia).append("]");
		return builder.toString();
	}

}
