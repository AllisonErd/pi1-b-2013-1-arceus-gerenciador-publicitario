package br.com.luguia.arceus.model.dao.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.luguia.arceus.model.Contato;
import br.com.luguia.arceus.model.Endereco;
import br.com.luguia.arceus.model.PessoaJuridica;
import br.com.luguia.arceus.model.Telefone;
import br.com.luguia.arceus.model.dao.InterfacePessoaJuridicaDAO;

public class PessoaJuridicaDAO implements InterfacePessoaJuridicaDAO {

	private List<PessoaJuridica> banco;

	public PessoaJuridicaDAO() {
		this.banco = new ArrayList<PessoaJuridica>();
		this.populaBanco();
	}

	public void populaBanco() {
		PessoaJuridica pessoaJuridica = new PessoaJuridica();

		pessoaJuridica.setId(this.proximo());
		pessoaJuridica.setNome("Firma 1");
		pessoaJuridica.setCnpj("768549303984756");

		Contato contato = new Contato();

		contato.setEmail("firma1@live.com");

		Telefone telefone = new Telefone();

		telefone.setTelefoneCel("34567567");
		telefone.setTelefoneFixo("35678945");

		contato.setTelefone(telefone);

		pessoaJuridica.setContato(contato);

		Endereco endereco = new Endereco();

		endereco.setRua("Rua da Firma1");
		endereco.setBairro("blasc");
		endereco.setCidade("Brass");
		endereco.setCep("345456");
		endereco.setEstado("Vivo");
		endereco.setComplemento("xxxxx x x x x xxxxx xxxxx xx xxxx xxxxx xxx xxxx xxxxxxxxxxx x x x x xxxxx xxxxx xx xxxx xxxxx xxx xxxx xxxxxx");

		pessoaJuridica.setEndereco(endereco);

		this.insira(pessoaJuridica);
		
		pessoaJuridica = new PessoaJuridica();

		pessoaJuridica.setId(this.proximo());
		pessoaJuridica.setNome("Firma 2");
		pessoaJuridica.setCnpj("456787654");

		contato = new Contato();

		contato.setEmail("firma2@live.com");

		telefone = new Telefone();

		telefone.setTelefoneCel("6578765");
		telefone.setTelefoneFixo("787654345");

		contato.setTelefone(telefone);

		pessoaJuridica.setContato(contato);

		endereco = new Endereco();

		endereco.setRua("Rua da Firma2");
		endereco.setBairro("blasc2");
		endereco.setCidade("Brass2");
		endereco.setCep("34545622");
		endereco.setEstado("Vivo2");
		endereco.setComplemento("2xxxxx x x x x xxxxx xxxxx xx xxxx xxxxx xxx xxxx xxxxxxxxxxx x x x x xxxxx xxxxx xx xxxx xxxxx xxx xxxx xxxxxx");

		pessoaJuridica.setEndereco(endereco);

		this.insira(pessoaJuridica);

	}

	@Override
	public void insira(PessoaJuridica pessoaJuridica) {
		// TODO Auto-generated method stub
		this.banco.add(pessoaJuridica);
	}

	@Override
	public void exclua(PessoaJuridica pessoaJuridica) {
		PessoaJuridica pJ = this.traga(pessoaJuridica);
		if (pJ != null)
			this.banco.remove(pessoaJuridica);

	}

	@Override
	public void altere(PessoaJuridica pessoaJuridica) {
		PessoaJuridica alteraPessoaJuridica = this.traga(pessoaJuridica);
		
		if(alteraPessoaJuridica != null){
		
			
			int position = alteraPessoaJuridica.getId()-1;
			this.banco.remove(position);
		this.banco.add(position, pessoaJuridica);
		}

	}

	@Override
	public List<PessoaJuridica> listeTodos() {
		ArrayList<PessoaJuridica> lista = new ArrayList<PessoaJuridica>(banco);
		return lista;
	}

	private int proximo() {
		int codigo = 1;
		if (banco.size() != 0) {
			
			codigo++;
			banco.get(banco.size() - 1);
			
			//Funcionario funcionario = banco.get(banco.size() - 1);
			//codigo = funcionario.getId();
		}
		return codigo;
		
		
		
		
	//	int codigo = 1;
		//if (banco.size() != 0) {
			//codigo++;
			//banco.get(banco.size() - 1);
		//}
		//return codigo;
	}

	private PessoaJuridica traga(PessoaJuridica pessoaJuridica) {
		Iterator<PessoaJuridica> it = banco.iterator();
		while (it.hasNext()) {
			PessoaJuridica pessoaJuridicaBanco = it.next();
			if (pessoaJuridica.getId() == pessoaJuridicaBanco.getId()) {
				return pessoaJuridicaBanco;
			}

		}
		return null;

	}

}
