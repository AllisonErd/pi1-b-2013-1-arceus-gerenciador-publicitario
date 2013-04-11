package Arceus.src.br.com.arceus.modelo.entidade;

public class Producao extends Setores {

	private double precoEquipamento;

	public Producao(String idSetor, double precoEquipamento) {
		super(idSetor);
		this.precoEquipamento = precoEquipamento;
	}

	public double getPrecoEquipamento() {
		return precoEquipamento;
	}

	public void setPrecoEquipamento(double precoEquipamento) {
		this.precoEquipamento = precoEquipamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(precoEquipamento);
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
		Producao other = (Producao) obj;
		if (Double.doubleToLongBits(precoEquipamento) != Double
				.doubleToLongBits(other.precoEquipamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producao [precoEquipamento=").append(precoEquipamento)
				.append("]");
		return builder.toString();
	}

}
