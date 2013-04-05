package br.com.arceus.modelo.entidades;

public class Pessoa {
	
	private int cod;
	private String login;
	private String senha;
	private String Nome;
	private String dataNascimento;
	private String razaoSocial;
	private String rg;
	private String pf_cnpj;
	private Endereço endereço;
	private Contatos contato;
	private String setor;
	private String cargo;
	
	
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getPf_cnpj() {
		return pf_cnpj;
	}
	public void setPf_cnpj(String pf_cnpj) {
		this.pf_cnpj = pf_cnpj;
	}
	public Endereço getEndereço() {
		return endereço;
	}
	public void setEndereço(Endereço endereço) {
		this.endereço = endereço;
	}
	public Contatos getContato() {
		return contato;
	}
	public void setContato(Contatos contato) {
		this.contato = contato;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
