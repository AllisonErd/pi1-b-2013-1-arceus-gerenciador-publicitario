package br.com.luguia.arceus.model.dao.array;

import java.util.List;

import br.com.luguia.arceus.control.MySqlController;
import br.com.luguia.arceus.model.PessoaFisica;
import br.com.luguia.arceus.model.dao.InterfacePessoaFisicaDAO;

public class PessoaFisicaDAO implements InterfacePessoaFisicaDAO {

	MySqlController bd = new MySqlController();

	public PessoaFisicaDAO() {
		bd.parametrosConexao();
	}

	@Override
	public void insira(PessoaFisica pessoaFisica) {
		bd.cadastrar("INSERT into PESSOA (ID_PESSOA, NOME) VALUES(?,?)", ""
				+ pessoaFisica.getId() + "#&V&#" + pessoaFisica.getNome() + "");

		bd.cadastrar(
				"INSERT into PESSOA_FISICA (ID_PESSOA, RG, CPF) VALUES(?,?,?)",
				"" + pessoaFisica.getId() + "#&V&#" + pessoaFisica.getRg()
						+ "#&V&#" + pessoaFisica.getCpf() + "");

		bd.cadastrar(
				"INSERT into ENDERECO (ID_PESSOA, RUA, BAIRRO, CEP, CIDADE, ESTADO, COMPLEMENTO) VALUES(?,?,?,?,?,?,?)",
				"" + pessoaFisica.getId() + "#&V&#"
						+ pessoaFisica.getEndereco().getRua() + "#&V&#"
						+ pessoaFisica.getEndereco().getBairro() + "#&V&#"
						+ pessoaFisica.getEndereco().getCep() + "#&V&#"
						+ pessoaFisica.getEndereco().getCidade() + "#&V&#"
						+ pessoaFisica.getEndereco().getEstado() + "#&V&#"
						+ pessoaFisica.getEndereco().getComplemento() + "");

		bd.cadastrar("INSERT into CONTATO (ID_PESSOA, E_MAIL) VALUES(?,?)",
				"" + pessoaFisica.getId() + "#&V&#"
						+ pessoaFisica.getContato().getEmail() + "");

		bd.cadastrar(
				"INSERT into TELEFONES (ID_PESSOA, TELEFONE_FIXO, TELEFONE_CELL) VALUES(?,?,?)",
				""
						+ pessoaFisica.getId()
						+ "#&V&#"
						+ pessoaFisica.getContato().getTelefone()
								.getTelefoneFixo() + "#&V&#"
						+ pessoaFisica.getContato().getTelefone()
						.getTelefoneCel() + "");

	}

	@Override
	public void exclua(PessoaFisica pessoaFisica) {

		

		bd.excluir("DELETE FROM `arceus1.1`.`pessoa_fisica` WHERE `id_pessoa`= "
				+ pessoaFisica.getId());

		bd.excluir("DELETE FROM `arceus1.1`.`telefones` WHERE `id_pessoa`= "
				+ pessoaFisica.getId());

		bd.excluir("DELETE FROM `arceus1.1`.`endereco` WHERE `id_pessoa`= "
				+ pessoaFisica.getId());

		bd.excluir("DELETE FROM `arceus1.1`.`contato` WHERE `id_pessoa`= "
				+ pessoaFisica.getId());

		bd.excluir("DELETE FROM `arceus1.1`.`pessoa` WHERE `id_pessoa`= "
				+ pessoaFisica.getId());
	}

	@Override
	public void altere(PessoaFisica pessoaFisica) {
		bd.alterar("UPDATE pessoa SET nome = '" + pessoaFisica.getNome()
				+ "' WHERE id_pessoa = '" + pessoaFisica.getId() + "'");

		bd.alterar("UPDATE pessoa_fisica SET RG = '" + pessoaFisica.getRg()
				+ "', CPF = '" + pessoaFisica.getCpf()
				+ "' WHERE id_pessoa = '" + pessoaFisica.getId() + "'");

		bd.alterar("UPDATE endereco SET RUA = '"
				+ pessoaFisica.getEndereco().getRua() + "', BAIRRO = '"
				+ pessoaFisica.getEndereco().getBairro()+ "', CEP = '"
				+ pessoaFisica.getEndereco().getCep() + "', CIDADE = '"
				+ pessoaFisica.getEndereco().getCidade() + "', ESTADO = '"
				+ pessoaFisica.getEndereco().getEstado() + "', COMPLEMENTO = '"
				+ pessoaFisica.getEndereco().getComplemento() + "' WHERE id_pessoa = '"
				+ pessoaFisica.getId() + "'");

		bd.alterar("UPDATE contato SET E_MAIL = '"
				+ pessoaFisica.getContato().getEmail()
				+ "' WHERE id_pessoa = '" + pessoaFisica.getId() + "'");

		bd.alterar("UPDATE telefones SET telefone_fixo = '"
				+ pessoaFisica.getContato().getTelefone().getTelefoneFixo()
				+ "', telefone_cell = '"
				+ pessoaFisica.getContato().getTelefone().getTelefoneCel()
				+ "' WHERE id_pessoa = '" + pessoaFisica.getId() + "'");

	}

	@Override
	public List<PessoaFisica> listeTodos() {
		bd.exibir("select pessoa_fisica.id_pessoa, pessoa.nome, pessoa_fisica.rg, pessoa_fisica.cpf, endereco.rua, endereco.cep, endereco.bairro, endereco.cidade, endereco.estado, endereco.complemento, contato.e_mail, telefones.telefone_cell, telefones.telefone_fixo FROM pessoa_fisica, pessoa, contato, endereco, telefones WHERE pessoa_fisica.id_pessoa = pessoa.id_pessoa AND pessoa_fisica.id_pessoa = contato.id_pessoa AND pessoa_fisica.id_pessoa = endereco.id_pessoa AND pessoa_fisica.id_pessoa = telefones.id_pessoa", 2);

		return bd.getListaPessoaFisica();

	}

}
