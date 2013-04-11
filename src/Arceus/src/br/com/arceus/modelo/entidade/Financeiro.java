package Arceus.src.br.com.arceus.modelo.entidade;

public class Financeiro extends Setores {

	private double custo;
	private double ganho;

	public Financeiro(String idSetor, double custo, double ganho) {
		super(idSetor);
		this.custo = custo;
		this.ganho = ganho;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public double getGanho() {
		return ganho;
	}

	public void setGanho(double ganho) {
		this.ganho = ganho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(custo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ganho);
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
		Financeiro other = (Financeiro) obj;
		if (Double.doubleToLongBits(custo) != Double
				.doubleToLongBits(other.custo))
			return false;
		if (Double.doubleToLongBits(ganho) != Double
				.doubleToLongBits(other.ganho))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Financeiro [custo=").append(custo).append(", ganho=")
				.append(ganho).append("]");
		return builder.toString();
	}

}
