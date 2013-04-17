package Arceus.src.br.com.arceus.modelo.entidade;

public class Atendimento extends Setores {

	private String cadastro;
	private double orcamento;

	public Atendimento(String idSetor, String cadastro, double orcamento) {
		super(idSetor);
		this.cadastro = cadastro;
		this.orcamento = orcamento;
	}

	public String getCadastro() {
		return cadastro;
	}

	public void setCadastro(String cadastro) {
		this.cadastro = cadastro;
	}

	public double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((cadastro == null) ? 0 : cadastro.hashCode());
		long temp;
		temp = Double.doubleToLongBits(orcamento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Atendimento other = (Atendimento) obj;
		if (cadastro == null) {
			if (other.cadastro != null)
				return false;
		} else if (!cadastro.equals(other.cadastro))
			return false;
		if (Double.doubleToLongBits(orcamento) != Double
				.doubleToLongBits(other.orcamento))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Atendimento [cadastro=").append(cadastro)
				.append(", orcamento=").append(orcamento).append("]");
		return builder.toString();
	}

}
