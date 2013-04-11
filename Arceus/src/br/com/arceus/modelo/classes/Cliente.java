
public class Cliente extends Pessoa {

	private String dataCadastro;
	private String tempoFreguesia;

	private Cliente(String dataCadastro, String tempoFreguesia) {

		this.dataCadastro = dataCadastro;
		this.tempoFreguesia = tempoFreguesia;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getTempoFreguesia() {
		return tempoFreguesia;
	}

	public void setTempoFreguesia(String tempoFreguesia) {
		this.tempoFreguesia = tempoFreguesia;
	}

}
