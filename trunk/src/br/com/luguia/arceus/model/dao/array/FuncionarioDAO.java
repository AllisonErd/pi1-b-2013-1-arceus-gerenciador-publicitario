package br.com.luguia.arceus.model.dao.array;

import java.util.List;

import br.com.luguia.arceus.control.MySqlController;
import br.com.luguia.arceus.model.Funcionario;
import br.com.luguia.arceus.model.dao.InterfaceFuncionarioDAO;

public class FuncionarioDAO implements InterfaceFuncionarioDAO {

	MySqlController bd = new MySqlController();

	public FuncionarioDAO() {

		bd.parametrosConexao();
	}

	@Override
	public void insira(Funcionario funcionario) {

		bd.cadastrar(
				"INSERT into FUNCIONARIO (ID_FUNC, NOME, LOGIN, SENHA, TIPO) VALUES(?,?,?,?,?)",
				"" + funcionario.getId() + "#&V&#" + funcionario.getNome() + "#&V&#"
						+ funcionario.getLogin() + "#&V&#" + funcionario.getSenha()
						+ "#&V&#" + funcionario.getTipo() + "");

	}

	@Override
	public void exclua(Funcionario funcionario) {

		bd.excluir("DELETE FROM `arceus1.1`.`funcionario` WHERE `id_func`= "
				+ funcionario.getId());

	}

	@Override
	public void altere(Funcionario funcionario) {

		bd.alterar("UPDATE funcionario SET NOME = '" + funcionario.getNome()
				+ "', LOGIN = '" + funcionario.getLogin() + "', SENHA = '"
				+ funcionario.getSenha() + "', TIPO = '"
				+ funcionario.getTipo() + "' WHERE ID_FUNC = '"
				+ funcionario.getId() + "'");

	}

	@Override
	public List<Funcionario> listeTodos() {

		bd.exibir("select * from funcionario",1);

		return bd.getListaFuncionario();

	}

}
