package br.com.luguia.arceus.model.dao.array;

import java.util.List;

import br.com.luguia.arceus.control.MySqlController;
import br.com.luguia.arceus.model.Job;
import br.com.luguia.arceus.model.dao.InterfaceCriacaoDAO;

public class CriacaoDAO implements InterfaceCriacaoDAO {

	MySqlController bd = new MySqlController();

	public CriacaoDAO() {

		bd.parametrosConexao();
	}

	@Override
	public void insira(Job trabalho) {
		bd.cadastrar(
				"INSERT into JOB (id_job, id_projeto, id_func, nome_job, caracteristicas_job, prioridade_job, status_job) VALUES(?,?,?,?,?,?,?)",
				"" + trabalho.getIdJob() + "#&V&#" + trabalho.getIdProjeto()
						+ "#&V&#" + trabalho.getIdFuncionario() + "#&V&#"
						+ trabalho.getNomeJob() + "#&V&#"
						+ trabalho.getCaracteristicasJob() + "#&V&#"
						+ trabalho.getPrioridadeJob() + "#&V&#"
						+ trabalho.getStatus() + "");

	}

	@Override
	public void altera(Job trabalho) {

		bd.alterar("UPDATE job SET STATUS_JOB = '" + trabalho.getStatus()
				+ "' WHERE ID_JOB = '" + trabalho.getIdJob() + "'");

	}

	@Override
	public List<Job> listeTodos() {
		bd.exibir("select * from JOB", 5);

		return bd.getListaJob();
	}

	@Override
	public void exclua(Job trabalho) {
		bd.excluir("DELETE FROM `arceus1.1`.`job` WHERE `id_projeto`= "
				+ trabalho.getIdProjeto());
		
	}

}
