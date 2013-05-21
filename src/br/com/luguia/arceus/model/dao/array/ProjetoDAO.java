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
	public void insira(Requisicao projeto, int id_pessoa) {

		bd.cadastrar(
				"INSERT into REQUISICAO (ID_PESSOA, ID_PROJETO, NOME_PROJETO, DATA_PEDIDO, DATA_ENTREGA, DEFINICAO_PROJETO, TIPO_EXECUCAO, PRIORIDADE, CUSTO_EQUIPAMENTO, PORCENTAGEM_CONCLUSAO) VALUES(?,?,?,?,?,?,?,?,?,?)",
					 
					 "" + id_pessoa + "#&V&#" 
						+ projeto.getIdProjeto() + "#&V&#"
						+ projeto.getNomeProjet() + "#&V&#" 
						+ projeto.getDataPedido() + "#&V&#" 
						
						+ projeto.getTempoEntrega() + "#&V&#"
						+ projeto.getDefinicaoProjeto() + "#&V&#" 
						+ projeto.getTipoExecucao() + "#&V&#"
						+ projeto.getPrioridadeProjeto() + "#&V&#"
						+ projeto.getCustoEquipamento() + "#&V&#" 
						
						+ projeto.getPorcentagemConclusao() + "");
		
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
		
		bd.exibir("select * from requisicao",4);

		return bd.getListaRequisicao();
	}

}
