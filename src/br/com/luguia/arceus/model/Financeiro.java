package br.com.luguia.arceus.model;

public class Financeiro {

	private int idFinanceiro;
	private double orcamento;
	private double custo ;
	private double desconto;
	private double ganho;
	
	
	public int getIdFinanceiro() {
		return idFinanceiro++;
	}
	public void setIdFinanceiro(int idFinanceiro) {
		this.idFinanceiro = idFinanceiro;
	}
	public double getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public double getGanho() {
		return ganho;
	}
	public void setGanho(double ganho) {
		this.ganho = ganho;
	}
	
}
