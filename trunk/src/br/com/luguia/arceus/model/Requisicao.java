package br.com.luguia.arceus.model;

import javax.xml.crypto.Data;

public class Requisicao {

	private int idProjeto;
	private String nomeProjet;
	private String definicaoProjeto;
	private double custoEquipamento;
	private String prioridadeProjeto;
	private Data dataPedido;
	private String tempoEntrega;
	private String tipoExecucao;
	
	
	public int getIdProjeto() {
		return idProjeto++;
	}
	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}
	public String getNomeProjet() {
		return nomeProjet;
	}
	public void setNomeProjet(String nomeProjet) {
		this.nomeProjet = nomeProjet;
	}
	public String getDefinicaoProjeto() {
		return definicaoProjeto;
	}
	public void setDefinicaoProjeto(String definicaoProjeto) {
		this.definicaoProjeto = definicaoProjeto;
	}
	public double getCustoEquipamento() {
		return custoEquipamento;
	}
	public void setCustoEquipamento(double custoEquipamento) {
		this.custoEquipamento = custoEquipamento;
	}
	public String getPrioridadeProjeto() {
		return prioridadeProjeto;
	}
	public void setPrioridadeProjeto(String prioridadeProjeto) {
		this.prioridadeProjeto = prioridadeProjeto;
	}
	public Data getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Data dataPedido) {
		this.dataPedido = dataPedido;
	}
	public String getTempoEntrega() {
		return tempoEntrega;
	}
	public void setTempoEntrega(String dataEntrega) {
		this.tempoEntrega = dataEntrega;
	}
	public String getTipoExecucao() {
		return tipoExecucao;
	}
	public void setTipoExecucao(String tipoExecucao) {
		this.tipoExecucao = tipoExecucao;
	}
	
	
}
