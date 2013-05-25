package br.com.luguia.arceus.model;

public class Job {

	private int idJob;
	private int idProjeto;
	private int idFuncionario;
	private String nomeJob;
	private String caracteristicasJob;
	private int prioridadeJob;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdJob() {
		return idJob;
	}

	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getNomeJob() {
		return nomeJob;
	}

	public void setNomeJob(String nomeJob) {
		this.nomeJob = nomeJob;
	}

	public String getCaracteristicasJob() {
		return caracteristicasJob;
	}

	public void setCaracteristicasJob(String caracteristicasJob) {
		this.caracteristicasJob = caracteristicasJob;
	}

	public int getPrioridadeJob() {
		return prioridadeJob;
	}

	public void setPrioridadeJob(int prioridadeJob) {
		this.prioridadeJob = prioridadeJob;
	}

}
