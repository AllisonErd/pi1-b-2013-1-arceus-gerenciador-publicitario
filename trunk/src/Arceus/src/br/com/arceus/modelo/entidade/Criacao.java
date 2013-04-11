package Arceus.src.br.com.arceus.modelo.entidade;

public class Criacao extends Setores {

	private String definicaoProjeto;
	private int prioridadeProjeto;

	public Criacao(String idSetor, String definicaoProjeto,
			int prioridadeProjeto) {
		super(idSetor);
		this.definicaoProjeto = definicaoProjeto;
		this.prioridadeProjeto = prioridadeProjeto;
	}

	public String getDefinicaoProjeto() {
		return definicaoProjeto;
	}

	public void setDefinicaoProjeto(String definicaoProjeto) {
		this.definicaoProjeto = definicaoProjeto;
	}

	public int getPrioridadeProjeto() {
		return prioridadeProjeto;
	}

	public void setPrioridadeProjeto(int prioridadeProjeto) {
		this.prioridadeProjeto = prioridadeProjeto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((definicaoProjeto == null) ? 0 : definicaoProjeto.hashCode());
		result = prime * result + prioridadeProjeto;
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
		Criacao other = (Criacao) obj;
		if (definicaoProjeto == null) {
			if (other.definicaoProjeto != null)
				return false;
		} else if (!definicaoProjeto.equals(other.definicaoProjeto))
			return false;
		if (prioridadeProjeto != other.prioridadeProjeto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Criacao [definicaoProjeto=").append(definicaoProjeto)
				.append(", prioridadeProjeto=").append(prioridadeProjeto)
				.append("]");
		return builder.toString();
	}

}
