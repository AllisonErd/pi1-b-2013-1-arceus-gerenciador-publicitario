
public class ClienteFisico extends Cliente {

	private String sexo;
	private String CPF;

	private ClienteFisico(String sexo, String CPF) {
		this.sexo = sexo;
		this.CPF = CPF;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return CPF;
	}

	public void setCpf(String CPF) {
		this.CPF = CPF;
	}
}
