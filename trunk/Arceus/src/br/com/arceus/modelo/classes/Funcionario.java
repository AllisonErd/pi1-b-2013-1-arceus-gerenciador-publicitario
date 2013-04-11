package br.com.arceus.modelo.classes;
import br.com.arceus.modelo.entidades.Pessoa;


public class Funcionario extends Pessoa {

	
	private String sexo, senha, tempoCasa;
	private double salario;
	
	private Funcionario(String sexo, String senha, String tempoCasa, double salario){
		
		this.sexo = sexo;
		this.senha = senha;
		this.tempoCasa = tempoCasa;
		this.salario = salario;
		
	}
	
	public String getSexo(){
		return sexo;
	}
	
	public void setSexo(String sexo){
		this.sexo = sexo;
	}
	
	public String getSenha(){
		return senha;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
	
	public String getTempoCasa(){
		return tempoCasa;
	}
	
	public void setTempoCasa(String tempoCasa){
		this.tempoCasa = tempoCasa;
	}
	
	public getSalario(){
		return salario;
	}
	
	public void setSalario(double salario){
		this.salario = salario;
	}
		
		
	}
	


