public class Atendimento extends Setores {

	private String Cadastro;
	private String Orçamento;

	private Atendimento(String cadastro, String orçamento) {
		this.Cadastro = cadastro;
		this.Orçamento = orçamento;
	}

	public String getCadastro() {
		return Cadastro;
	}

	public void setCadastro(String Cadastro) {
		this.Cadastro = Cadastro;
	}

	public String getOrçamento() {
		return Orçamento;
	}

	public void setOrçamento(String Orçamento) {
		this.Orçamento = Orçamento;
	}

}
