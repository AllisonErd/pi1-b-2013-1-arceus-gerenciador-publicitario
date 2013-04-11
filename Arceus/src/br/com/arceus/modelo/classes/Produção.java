public class Produção extends Setores {

	private String Preço_Equipamento;

	private Produção(String Preço_Equipamento) {
		this.Preço_Equipamento = Preço_Equipamento;
	}

	public String getPreço() {
		return Preço_Equipamento;
	}

	public void setPreço(String Preço_Equipamento) {
		this.Preço_Equipamento = Preço_Equipamento;
	}

}
