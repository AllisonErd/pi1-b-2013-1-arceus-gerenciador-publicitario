package Arceus.src.br.com.arceus.modelo.entidade;

import Arceus.src.br.com.arceus.modelo.atributo.Contato;
import Arceus.src.br.com.arceus.modelo.atributo.Endereco;
import Arceus.src.br.com.arceus.modelo.atributo.SexoType;

public class ClienteFisico extends Cliente {

	private String cpf;
	private SexoType sexo;

	public ClienteFisico(int cod, String nome, Endereco endereco,
			Contato contato, String dataCadastro, String tempoFreguesia,
			String cpf, SexoType sexo) {
		super(cod, nome, endereco, contato, dataCadastro, tempoFreguesia);
		this.cpf = cpf;
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public SexoType getSexo() {
		return sexo;
	}

	public void setSexo(SexoType sexo) {
		this.sexo = sexo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		ClienteFisico other = (ClienteFisico) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClienteFisico [cpf=").append(cpf).append(", sexo=")
				.append(sexo).append("]");
		return builder.toString();
	}

}
