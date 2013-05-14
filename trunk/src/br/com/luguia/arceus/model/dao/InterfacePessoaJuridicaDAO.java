package br.com.luguia.arceus.model.dao;

import java.util.List;

import br.com.luguia.arceus.model.PessoaJuridica;

public interface InterfacePessoaJuridicaDAO {

	public abstract void insira(PessoaJuridica pessoaJuridica);

	public abstract void exclua(PessoaJuridica pessoaJuridica);

	public abstract void altere(PessoaJuridica pessoaJuridica);

	public abstract List<PessoaJuridica> listeTodos();
	
	
}
