public class Atendimento extends Setores {

	private String Cadastro;
	private String Or�amento;

	private Atendimento(String cadastro, String or�amento) {
		this.Cadastro = cadastro;
		this.Or�amento = or�amento;
	}

	public String getCadastro() {
		return Cadastro;
	}

	public void setCadastro(String Cadastro) {
		this.Cadastro = Cadastro;
	}

	public String getOr�amento() {
		return Or�amento;
	}

	public void setOr�amento(String Or�amento) {
		this.Or�amento = Or�amento;
	}

}
