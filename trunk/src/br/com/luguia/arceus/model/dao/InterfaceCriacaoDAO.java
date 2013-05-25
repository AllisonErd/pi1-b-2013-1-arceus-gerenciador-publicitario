package br.com.luguia.arceus.model.dao;

import java.util.List;

import br.com.luguia.arceus.model.Job;

public interface InterfaceCriacaoDAO {

	public abstract void insira(Job trabalho);
	public abstract void exclua(Job trabalho);
	public abstract void altera(Job trabalho);
	public abstract List<Job> listeTodos();
	
	
}
