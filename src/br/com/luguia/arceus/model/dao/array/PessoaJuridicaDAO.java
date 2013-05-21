package br.com.luguia.arceus.model.dao.array;

import java.util.List;

import br.com.luguia.arceus.control.MySqlController;
import br.com.luguia.arceus.model.PessoaJuridica;
import br.com.luguia.arceus.model.dao.InterfacePessoaJuridicaDAO;

public class PessoaJuridicaDAO implements InterfacePessoaJuridicaDAO {

	MySqlController bd = new MySqlController();

	public PessoaJuridicaDAO() {
		bd.parametrosConexao();
	}

	

	@Override
	public void insira(PessoaJuridica pessoaJuridica) {
		bd.cadastrar("INSERT into PESSOA (ID_PESSOA, NOME) VALUES(?,?)", ""
				+ pessoaJuridica.getId() + "#&V&#" + pessoaJuridica.getNome() + "");

		bd.cadastrar(
				"INSERT into PESSOA_JURIDICA (ID_PESSOA, CNPJ) VALUES(?,?)",
				"" + pessoaJuridica.getId() + "#&V&#" + pessoaJuridica.getCnpj()+ "");

		bd.cadastrar(
				"INSERT into ENDERECO (ID_PESSOA, RUA, BAIRRO, CEP, CIDADE, ESTADO, COMPLEMENTO) VALUES(?,?,?,?,?,?,?)",
				"" + pessoaJuridica.getId() + "#&V&#"
						+ pessoaJuridica.getEndereco().getRua() + "#&V&#"
						+ pessoaJuridica.getEndereco().getBairro() + "#&V&#"
						+ pessoaJuridica.getEndereco().getCep() + "#&V&#"
						+ pessoaJuridica.getEndereco().getCidade() + "#&V&#"
						+ pessoaJuridica.getEndereco().getEstado() + "#&V&#"
						+ pessoaJuridica.getEndereco().getComplemento() + "");

		bd.cadastrar("INSERT into CONTATO (ID_PESSOA, E_MAIL) VALUES(?,?)",
				"" + pessoaJuridica.getId() + "#&V&#"
						+ pessoaJuridica.getContato().getEmail() + "");

		bd.cadastrar(
				"INSERT into TELEFONES (ID_PESSOA, TELEFONE_FIXO, TELEFONE_CELL) VALUES(?,?,?)",
				""
						+ pessoaJuridica.getId()
						+ "#&V&#"
						+ pessoaJuridica.getContato().getTelefone()
								.getTelefoneFixo() + "#&V&#"
						+ pessoaJuridica.getContato().getTelefone()
						.getTelefoneCel() + "");

	}

	@Override
	public void exclua(PessoaJuridica pessoaJuridica) {
	

		bd.excluir("DELETE FROM `arceus1.1`.`pessoa_juridica` WHERE `id_pessoa`= "
				+ pessoaJuridica.getId());

		bd.excluir("DELETE FROM `arceus1.1`.`telefones` WHERE `id_pessoa`= "
				+ pessoaJuridica.getId());

		bd.excluir("DELETE FROM `arceus1.1`.`endereco` WHERE `id_pessoa`= "
				+ pessoaJuridica.getId());

		bd.excluir("DELETE FROM `arceus1.1`.`contato` WHERE `id_pessoa`= "
				+ pessoaJuridica.getId());

		bd.excluir("DELETE FROM `arceus1.1`.`pessoa` WHERE `id_pessoa`= "
				+ pessoaJuridica.getId());
	}

	@Override
	public void altere(PessoaJuridica pessoaJuridica) {
		bd.alterar("UPDATE pessoa SET nome = '" + pessoaJuridica.getNome()
				+ "' WHERE id_pessoa = '" + pessoaJuridica.getId() + "'");

		bd.alterar("UPDATE pessoa_fisica SET CNPJ = '" + pessoaJuridica.getCnpj()
				+ "' WHERE id_pessoa = '" + pessoaJuridica.getId() + "'");

		bd.alterar("UPDATE endereco SET RUA = '"
				+ pessoaJuridica.getEndereco().getRua() + "', BAIRRO = '"
				+ pessoaJuridica.getEndereco().getBairro()+ "', CEP = '"
				+ pessoaJuridica.getEndereco().getCep() + "', CIDADE = '"
				+ pessoaJuridica.getEndereco().getCidade() + "', ESTADO = '"
				+ pessoaJuridica.getEndereco().getEstado() + "', COMPLEMENTO = '"
				+ pessoaJuridica.getEndereco().getComplemento() + "' WHERE id_pessoa = '"
				+ pessoaJuridica.getId() + "'");

		bd.alterar("UPDATE contato SET E_MAIL = '"
				+ pessoaJuridica.getContato().getEmail()
				+ "' WHERE id_pessoa = '" + pessoaJuridica.getId() + "'");

		bd.alterar("UPDATE telefones SET telefone_fixo = '"
				+ pessoaJuridica.getContato().getTelefone().getTelefoneFixo()
				+ "', telefone_cell = '"
				+ pessoaJuridica.getContato().getTelefone().getTelefoneCel()
				+ "' WHERE id_pessoa = '" + pessoaJuridica.getId() + "'");

	}

	@Override
	public List<PessoaJuridica> listeTodos() {
		bd.exibir("select pessoa_juridica.id_pessoa, pessoa.nome, pessoa_juridica.cnpj, endereco.rua, endereco.cep, endereco.bairro, endereco.cidade, endereco.estado, endereco.complemento, contato.e_mail, telefones.telefone_cell, telefones.telefone_fixo FROM pessoa_juridica, pessoa, contato, endereco, telefones WHERE	pessoa_juridica.id_pessoa = pessoa.id_pessoa AND pessoa_juridica.id_pessoa = contato.id_pessoa AND pessoa_juridica.id_pessoa = endereco.id_pessoa AND pessoa_juridica.id_pessoa = telefones.id_pessoa", 3);

		
		return bd.getListaPessoaJuridica();
	}

	

}
