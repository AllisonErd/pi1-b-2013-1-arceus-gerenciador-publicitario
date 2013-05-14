package br.com.luguia.arceus.model.dao.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.luguia.arceus.model.Contato;
import br.com.luguia.arceus.model.Endereco;
import br.com.luguia.arceus.model.PessoaFisica;
import br.com.luguia.arceus.model.PessoaJuridica;
import br.com.luguia.arceus.model.Telefone;
import br.com.luguia.arceus.model.dao.InterfacePessoaFisicaDAO;

public class PessoaFisicaDAO implements InterfacePessoaFisicaDAO{

	
	private List<PessoaFisica> banco;

	public PessoaFisicaDAO(){
		this.banco = new ArrayList<PessoaFisica>();
		this.populaBanco();
	}
	
	
	public void populaBanco(){
		PessoaFisica pessoaFisica = new PessoaFisica();
		
		pessoaFisica.setId(this.proximo());
		pessoaFisica.setNome("Paulo");
		pessoaFisica.setRg("893475");
		pessoaFisica.setCpf("573968340");
		
		Contato contato = new Contato();
		
		contato.setEmail("paulo@live.com");
		
		Telefone telefone = new Telefone();
		
		telefone.setTelefoneCel("94111120");
		telefone.setTelefoneFixo("37261589");
		
		contato.setTelefone(telefone);
		
		pessoaFisica.setContato(contato);
		Endereco endereco = new Endereco();
		endereco.setRua("Rua das Dores");
		endereco.setBairro("AIAI");
		endereco.setCidade("Brazilandia");
		endereco.setCep("3456787654");
		endereco.setEstado("Vivo");
		endereco.setComplemento("xxxxx x x x x xxxxx xxxxx xx xxxx xxxxx xxx xxxx xxxxxxxxxxx x x x x xxxxx xxxxx xx xxxx xxxxx xxx xxxx xxxxxx");
		
		pessoaFisica.setEndereco(endereco);
		
			this.insira(pessoaFisica);
		
			
			pessoaFisica = new PessoaFisica();
			
		pessoaFisica.setId(this.proximo());
		pessoaFisica.setNome("Fernando");
		pessoaFisica.setRg("235435");
		pessoaFisica.setCpf("234523455");
		
		//Contato contato = new Contato();
		
		contato.setEmail("fernando@live.com");
		
		//Telefone telefone = new Telefone();
		
		telefone.setTelefoneCel("4124566");
		telefone.setTelefoneFixo("12341234");
		
		contato.setTelefone(telefone);
		
		pessoaFisica.setContato(contato);
		
		//Endereco endereco = new Endereco();
		endereco.setRua("Rua das Casas");
		endereco.setBairro("uiuiui");
		endereco.setCidade("Brazilindra");
		endereco.setCep("8765454");
		endereco.setEstado("Vivo");
		endereco.setComplemento("xxxxx x x x x xxxxx xxxxx xx xxxx xxxxx xxx xxxx xxxxxxxxxxx x x x x xxxxx xxxxx xx xxxx xxxxx xxx xxxx xxxxxx");
		
		pessoaFisica.setEndereco(endereco);
		
			this.insira(pessoaFisica);
	}
	
	
	@Override
	public void insira(PessoaFisica pessoaFisica) {
		// TODO Auto-generated method stub
		this.banco.add(pessoaFisica);
	}

	@Override
	public void exclua(PessoaFisica pessoaFisica) {
		PessoaFisica pF = this.traga(pessoaFisica);
		if (pF != null)
			this.banco.remove(pessoaFisica);
		
	}

	@Override
	public void altere(PessoaFisica pessoaFisica) {
		PessoaFisica alteraPessoaFisica = this.traga(pessoaFisica);
		
		if(alteraPessoaFisica != null){
		
			
			int position = alteraPessoaFisica.getId()-1;
			this.banco.remove(position);
		this.banco.add(position, pessoaFisica);
		}
		
	}

	@Override
	public List<PessoaFisica> listeTodos() {
		ArrayList<PessoaFisica> lista = new ArrayList<PessoaFisica>(banco);
		return lista;
		
	}
	
	private int proximo() {
		int codigo = 1;
		if(banco.size() != 0){
			codigo++;
			banco.get(banco.size() - 1);
			//PessoaFisica pessoaFisica = banco.get(banco.size() - 1);
			//codigo = pessoaFisica.getId();
		}
		return codigo;
	
		
	}
	
	private PessoaFisica traga(PessoaFisica pessoaFisica) {
		Iterator<PessoaFisica> it = banco.iterator();
		while (it.hasNext()) {
			PessoaFisica pessoaFisicaBanco = it.next();
			if (pessoaFisica.getId() == pessoaFisicaBanco.getId()) {
				return pessoaFisicaBanco;
			}

		}
		return null;

	}

}
