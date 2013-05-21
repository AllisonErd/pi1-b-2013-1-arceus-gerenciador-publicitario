package br.com.luguia.arceus.model.dao;

import java.util.List;

import br.com.luguia.arceus.model.Requisicao;

public interface InterfaceProjetoDAO {

	public abstract void insira(Requisicao requisicao);

	public abstract void exclua(Requisicao requisicao);

	public abstract void altere(Requisicao requisicao);

	public abstract List<Requisicao> listeTodos();
	
}
