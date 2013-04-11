package Arceus.src.br.com.arceus.modelo.entidade;

public class Projeto {

	private int idProjeto;
	private String nomeProjeto;

	public Projeto(int idProjeto, String nomeProjeto) {
		super();
		this.idProjeto = idProjeto;
		this.nomeProjeto = nomeProjeto;
	}

	public int getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProjeto;
		result = prime * result
				+ ((nomeProjeto == null) ? 0 : nomeProjeto.hashCode());
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
		Projeto other = (Projeto) obj;
		if (idProjeto != other.idProjeto)
			return false;
		if (nomeProjeto == null) {
			if (other.nomeProjeto != null)
				return false;
		} else if (!nomeProjeto.equals(other.nomeProjeto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Projeto [idProjeto=").append(idProjeto)
				.append(", nomeProjeto=").append(nomeProjeto).append("]");
		return builder.toString();
	}

}
