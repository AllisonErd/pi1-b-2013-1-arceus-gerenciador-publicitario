package br.com.luguia.arceus.model.dao.array;

import java.util.List;

import br.com.luguia.arceus.control.MySqlController;
import br.com.luguia.arceus.model.Requisicao;
import br.com.luguia.arceus.model.dao.InterfaceProjetoDAO;

public class ProjetoDAO implements InterfaceProjetoDAO{

	MySqlController bd = new MySqlController();
	
	public ProjetoDAO() {

		bd.parametrosConexao();
	}
	
	@Override
	public void insira(Requisicao requisicao) {

		
		
	}

	@Override
	public void exclua(Requisicao requisicao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altere(Requisicao requisicao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Requisicao> listeTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
