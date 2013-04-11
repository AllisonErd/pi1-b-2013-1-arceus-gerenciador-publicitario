public class Mídia extends Setores {

	private String Execução_Projeto;
	private String Meios_Execução;

	private Mídia(String Execução, String Meios) {
		this.Execução_Projeto = Execução;
		this.Meios_Execução = Meios;
	}

	public String getExecução() {
		return Execução_Projeto;
	}

	public void setExecução(String Execução_Projeto) {
		this.Execução_Projeto = Execução_Projeto;
	}

	public String getMeios() {
		return Meios_Execução;
	}

	public void setMeios(String Meios_Execução) {
		this.Meios_Execução = Meios_Execução;
	}

}
