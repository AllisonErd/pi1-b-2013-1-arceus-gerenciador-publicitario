package br.com.luguia.arceus.model;


public class Requisicao {

	private int idProjeto;
	private String nomeProjet;
	private String definicaoProjeto;
	private String custoEquipamento;
	private int prioridadeProjeto;
	private String dataPedido;
	private String tempoEntrega;
	private String tipoExecucao;
	private int porcentagemConclusao;
	private int idPessoa;
	private Financeiro custos;
	
	public Financeiro getCustos() {
		return custos;
	}
	public void setCustos(Financeiro custos) {
		this.custos = custos;
	}
	public int getIdProjeto() {
		return idProjeto;
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
	public String getCustoEquipamento() {
		return custoEquipamento;
	}
	public void setCustoEquipamento(String custoEquipamento) {
		this.custoEquipamento = custoEquipamento;
	}
	public int getPrioridadeProjeto() {
		return prioridadeProjeto;
	}
	public void setPrioridadeProjeto(int prioridadeProjeto) {
		this.prioridadeProjeto = prioridadeProjeto;
	}
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String dataPedido) {
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
	public int getPorcentagemConclusao(){
		return porcentagemConclusao;
	}
	
	public void setPorcentagemConclusao(int porcentagemConclusao){
		this.porcentagemConclusao = porcentagemConclusao;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
}
