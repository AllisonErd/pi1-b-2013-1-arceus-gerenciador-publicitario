package Arceus.src.br.com.arceus.modelo.entidade;

import Arceus.src.br.com.arceus.modelo.Contato;
import Arceus.src.br.com.arceus.modelo.Endereco;

public class Funcionario extends Pessoa {

	private String sexo, senha, tempoCasa, dataAdmicao;
	private double salario;

	public Funcionario(int cod, String nome, Endereco endereco,
			Contato contato, String sexo, String senha, String tempoCasa,
			String dataAdmicao, double salario) {
		super(cod, nome, endereco, contato);
		this.sexo = sexo;
		this.senha = senha;
		this.tempoCasa = tempoCasa;
		this.dataAdmicao = dataAdmicao;
		this.salario = salario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTempoCasa() {
		return tempoCasa;
	}

	public void setTempoCasa(String tempoCasa) {
		this.tempoCasa = tempoCasa;
	}

	public String getDataAdmicao() {
		return dataAdmicao;
	}

	public void setDataAdmicao(String dataAdmicao) {
		this.dataAdmicao = dataAdmicao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((dataAdmicao == null) ? 0 : dataAdmicao.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result
				+ ((tempoCasa == null) ? 0 : tempoCasa.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (dataAdmicao == null) {
			if (other.dataAdmicao != null)
				return false;
		} else if (!dataAdmicao.equals(other.dataAdmicao))
			return false;
		if (Double.doubleToLongBits(salario) != Double
				.doubleToLongBits(other.salario))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (tempoCasa == null) {
			if (other.tempoCasa != null)
				return false;
		} else if (!tempoCasa.equals(other.tempoCasa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [sexo=").append(sexo).append(", senha=")
				.append(senha).append(", tempoCasa=").append(tempoCasa)
				.append(", dataAdmicao=").append(dataAdmicao)
				.append(", salario=").append(salario).append("]");
		return builder.toString();
	}

}
