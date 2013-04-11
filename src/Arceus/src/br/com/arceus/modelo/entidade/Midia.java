package Arceus.src.br.com.arceus.modelo.entidade;

public class Midia extends Setores {

	private String execucaoProjeto;
	private String meiosExecucao;

	public Midia(String idSetor, String execucaoProjeto, String meiosExecucao) {
		super(idSetor);
		this.execucaoProjeto = execucaoProjeto;
		this.meiosExecucao = meiosExecucao;
	}

	public String getExecucaoProjeto() {
		return execucaoProjeto;
	}

	public void setExecucaoProjeto(String execucaoProjeto) {
		this.execucaoProjeto = execucaoProjeto;
	}

	public String getMeiosExecucao() {
		return meiosExecucao;
	}

	public void setMeiosExecucao(String meiosExecucao) {
		this.meiosExecucao = meiosExecucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((execucaoProjeto == null) ? 0 : execucaoProjeto.hashCode());
		result = prime * result
				+ ((meiosExecucao == null) ? 0 : meiosExecucao.hashCode());
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
		Midia other = (Midia) obj;
		if (execucaoProjeto == null) {
			if (other.execucaoProjeto != null)
				return false;
		} else if (!execucaoProjeto.equals(other.execucaoProjeto))
			return false;
		if (meiosExecucao == null) {
			if (other.meiosExecucao != null)
				return false;
		} else if (!meiosExecucao.equals(other.meiosExecucao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Midia [execucaoProjeto=").append(execucaoProjeto)
				.append(", meiosExecucao=").append(meiosExecucao).append("]");
		return builder.toString();
	}

}
