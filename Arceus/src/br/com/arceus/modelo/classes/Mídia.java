public class M�dia extends Setores {

	private String Execu��o_Projeto;
	private String Meios_Execu��o;

	private M�dia(String Execu��o, String Meios) {
		this.Execu��o_Projeto = Execu��o;
		this.Meios_Execu��o = Meios;
	}

	public String getExecu��o() {
		return Execu��o_Projeto;
	}

	public void setExecu��o(String Execu��o_Projeto) {
		this.Execu��o_Projeto = Execu��o_Projeto;
	}

	public String getMeios() {
		return Meios_Execu��o;
	}

	public void setMeios(String Meios_Execu��o) {
		this.Meios_Execu��o = Meios_Execu��o;
	}

}
