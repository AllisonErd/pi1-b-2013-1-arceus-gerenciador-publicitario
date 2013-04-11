
public class ClienteJuridico extends Cliente {
	
	private String CNPJ;
	
	private ClienteJuridico(String CNPJ){
		this.CNPJ = CNPJ;
	}

	public String getCnpj(){
		return CNPJ;
	}
	
	public void setCnpj(String CNPJ){
		this.CNPJ = CNPJ;
	}
}
