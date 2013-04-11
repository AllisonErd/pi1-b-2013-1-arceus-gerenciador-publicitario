package Arceus.src.br.com.arceus.modelo.entidade;

import Arceus.src.br.com.arceus.modelo.Contato;
import Arceus.src.br.com.arceus.modelo.Endereco;

public class ClienteJuridico extends Cliente {

	private String CNPJ;

	public ClienteJuridico(int cod, String nome, Endereco endereco,
			Contato contato, String dataCadastro, String tempoFreguesia,
			String cNPJ) {
		super(cod, nome, endereco, contato, dataCadastro, tempoFreguesia);
		CNPJ = cNPJ;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((CNPJ == null) ? 0 : CNPJ.hashCode());
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
		ClienteJuridico other = (ClienteJuridico) obj;
		if (CNPJ == null) {
			if (other.CNPJ != null)
				return false;
		} else if (!CNPJ.equals(other.CNPJ))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClienteJuridico [CNPJ=").append(CNPJ).append("]");
		return builder.toString();
	}

}
