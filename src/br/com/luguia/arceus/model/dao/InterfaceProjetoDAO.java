package br.com.luguia.arceus.model.dao;

import java.util.List;

import br.com.luguia.arceus.model.Requisicao;

public interface InterfaceProjetoDAO {

	public abstract void insira(Requisicao requisicao, int id_pessoa);

	public abstract void exclua(Requisicao requisicao);

	public abstract void altere(Requisicao requisicao, int caso);

	public abstract List<Requisicao> listeTodos();
	
}
