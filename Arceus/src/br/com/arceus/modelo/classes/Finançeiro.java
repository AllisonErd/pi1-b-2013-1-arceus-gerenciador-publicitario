public class Finanšeiro extends Setores {

	private String Custo;
	private String Ganho;

	private Finanšeiro(String Custo, String Ganho) {

		this.Custo = Custo;
		this.Ganho = Ganho;
	}

	public String getCusto() {
		return Custo;
	}

	public void setCusto(String Custo) {
		this.Custo = Custo;
	}

	public String getGanho() {
		return Ganho;
	}

	public void setGanho(String Ganho) {
		this.Ganho = Ganho;
	}
}
