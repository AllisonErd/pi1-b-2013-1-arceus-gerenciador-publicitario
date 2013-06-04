package br.com.luguia.arceus.model.dao;

import java.util.List;

import br.com.luguia.arceus.model.Funcionario;

public interface InterfaceFuncionarioDAO {

	public abstract void insira(Funcionario funcionario);

	public abstract void exclua(Funcionario funcionario);

	public abstract void altere(Funcionario funcionario);

	public abstract List<Funcionario> listeTodos();
	
	
}

