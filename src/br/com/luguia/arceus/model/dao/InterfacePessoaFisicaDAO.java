package br.com.luguia.arceus.model.dao;

import java.util.List;

import br.com.luguia.arceus.model.PessoaFisica;

public interface InterfacePessoaFisicaDAO {

	public abstract void insira(PessoaFisica pessoaFisica);

	public abstract void exclua(PessoaFisica pessoaFisica);

	public abstract void altere(PessoaFisica pessoaFisica);

	public abstract List<PessoaFisica> listeTodos();
	
}
