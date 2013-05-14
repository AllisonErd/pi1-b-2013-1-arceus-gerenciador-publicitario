package br.com.luguia.arceus.model.dao;

import br.com.luguia.arceus.model.dao.array.FuncionarioDAO;
import br.com.luguia.arceus.model.dao.array.PessoaFisicaDAO;
import br.com.luguia.arceus.model.dao.array.PessoaJuridicaDAO;


public class Factory {
	
	private static InterfaceFuncionarioDAO iFuncionarioDAO;
	private static InterfacePessoaFisicaDAO iPessoaFisicaDAO;
	private static InterfacePessoaJuridicaDAO iPessoaJuridicaDAO;
	
	public static void criarBanco(Banco banco) {
		if (banco == Banco.ARRAY) {
			iFuncionarioDAO = new FuncionarioDAO();
			iPessoaFisicaDAO = new PessoaFisicaDAO();
			iPessoaJuridicaDAO = new PessoaJuridicaDAO();
		}
	}
	
	public static InterfaceFuncionarioDAO getBancoF() {
		return iFuncionarioDAO;
	}
	
	public static InterfacePessoaFisicaDAO getBancoPF(){
		return iPessoaFisicaDAO;
	}
	
	public static InterfacePessoaJuridicaDAO getBancoPJ(){
		return iPessoaJuridicaDAO;
	}
	
	
	
}
