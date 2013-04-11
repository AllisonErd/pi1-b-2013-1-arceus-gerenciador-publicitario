public class Criação extends Setores {

	private String Definicao_Projeto;
	private String Prioridade_Projeto;

	private Criação(String Def_Pro, String Pri_Pro) {
		this.Definicao_Projeto = Def_Pro;
		this.Prioridade_Projeto = Pri_Pro;
	}

	public String getDefinicaoProjeto() {
		return Definicao_Projeto;
	}

	public void setDefinicaoProjeto(String Definicao_Projeto) {
		this.Definicao_Projeto = Definicao_Projeto;
	}

	public String getPrioridadeProjeto() {
		return Prioridade_Projeto;
	}

	public void setPrioridadeProjeto(String Prioridade_Projeto) {
		this.Prioridade_Projeto = Prioridade_Projeto;
	}

}
