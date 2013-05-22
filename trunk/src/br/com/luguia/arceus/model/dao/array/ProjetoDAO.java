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
		bd.cadastrar(
				"INSERT into FINANCEIRO (id_projeto, orcamento, custo, desconto, ganho) VALUES(?,?,?,?,?)",
		 
		 "" + projeto.getIdProjeto() + "#&V&#" 
			+ "0" + "#&V&#" 
			
			+ "0" + "#&V&#"
			+ "0" + "#&V&#" 
			+ "0" + "");
		
	}

	@Override
	public void exclua(Requisicao requisicao) {
		bd.excluir("DELETE FROM `arceus1.1`.`financeiro` WHERE `id_projeto`= "
				+ requisicao.getIdProjeto());
		
		bd.excluir("DELETE FROM `arceus1.1`.`requisicao` WHERE `id_projeto`= "
				+ requisicao.getIdProjeto());

		
	}

	@Override
	public void altere(Requisicao requisicao, int caso) {
	switch (caso) {
	case 1:
		bd.alterar("UPDATE requisicao SET nome_projeto = '" + requisicao.getNomeProjet()
				+ "', data_pedido = '" + requisicao.getDataPedido() + "', data_entrega = '"
				+ requisicao.getTempoEntrega() + "', definicao_projeto = '"
				+ requisicao.getDefinicaoProjeto() + "' WHERE id_projeto = '"
				+ requisicao.getIdProjeto() + "'");
		break;
	case 2:
		bd.alterar("UPDATE financeiro SET ganho = '" + requisicao.getCustos().getGanho()
				+ "', orcamento = '" + requisicao.getCustos().getOrcamento() + "', custo = '"
				+ requisicao.getCustos().getCusto() + "', desconto = '"
				+ requisicao.getCustos().getDesconto() + "' WHERE id_projeto = '"
				+ requisicao.getIdProjeto() + "'");
		break;
	}
		
		
	}

	@Override
	public List<Requisicao> listeTodos() {
		
		bd.exibir("select requisicao.id_pessoa, requisicao.id_projeto, requisicao.nome_projeto, requisicao.data_pedido, requisicao.data_entrega, requisicao.definicao_projeto, requisicao.tipo_execucao, requisicao.prioridade, requisicao.custo_equipamento, requisicao.porcentagem_conclusao, financeiro.orcamento, financeiro.custo, financeiro.desconto, financeiro.ganho FROM requisicao, financeiro WHERE requisicao.id_projeto = financeiro.id_projeto",4);

		return bd.getListaRequisicao();
	}

}
