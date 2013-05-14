package br.com.luguia.arceus.model;
// Sera apagado tb, pois esse log informa que o usuario master é um usuario porem tem um login diferenciado
public class Master extends Funcionario{
	private String log;
	
	public String getLog() {
		return log;
	}
	
	public void setLog(String log) {
		this.log += log + "\n"; 
	}
}
