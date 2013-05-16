package br.com.luguia.arceus.model.dao.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.luguia.arceus.control.MySqlController;
import br.com.luguia.arceus.model.Funcionario;
import br.com.luguia.arceus.model.dao.InterfaceFuncionarioDAO;

public class FuncionarioDAO implements InterfaceFuncionarioDAO {
	
	boolean conect;
	
	MySqlController bd = new MySqlController();
	
	private List<Funcionario> banco;

	
	public FuncionarioDAO() {
		this.banco = new ArrayList<Funcionario>();
		this.popularBanco();

	}

	// estamos populando a lista com essas caracteristicas
	public void popularBanco() {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(this.proximo());
		funcionario.setLogin("Henrique");
		funcionario.setNome("Henrique Araujo");
		funcionario.setSenha("1234");
		funcionario.setTipo("Atendimento");
		
		this.banco.add(funcionario);
		
		funcionario = new Funcionario();
		funcionario.setId(this.proximo());
		funcionario.setLogin("Kleo");
		funcionario.setNome("Kleo Marinho");
		funcionario.setSenha("4321");
		funcionario.setTipo("Financeiro");
		
		this.banco.add(funcionario);

	}

	
	
	
	@Override
	public void insira(Funcionario funcionario) {
		// TODO Verificar o ultimo codigo a acrecentar!
		if(conect == false){
		this.banco.add(funcionario);
		}else if(conect == true){
		
		bd.cadastrar("INSERT into FUNCIONARIO (SENHA, NOME, TIPO, LOGIN, ID) VALUES(?,?,?,?,?)", "" + funcionario.getSenha()+"#"
				+ funcionario.getNome() + "#"
				+ funcionario.getTipo() + "#"
				+ funcionario.getLogin() + "#"
				+ funcionario.getId() + "");
		
	}

	}

	@Override
	public void exclua(Funcionario funcionario) {
		
		
		Funcionario f = this.traga(funcionario);
		
		if (f != null){
		
				this.banco.remove(funcionario);
				
				if(conect == true){
				bd.excluir("DELETE FROM `arceus1.1`.`funcionario` WHERE `id`= "+funcionario.getId());
				System.out.println("entrou3");
				}
			
		}
		
	}

	@Override
	public void altere(Funcionario funcionario) {
		
		Funcionario alteraFuncionario = this.traga(funcionario);
		
		if(alteraFuncionario != null){
		
			
			int position = alteraFuncionario.getId()-1;
			this.banco.remove(position);
		this.banco.add(position, funcionario);
		}
	}

	@Override
	public List<Funcionario> listeTodos() {
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>(banco);
		return lista;
	}

	//***********mecher aque!! 
	private int proximo() {
		int codigo = 1;
		if (banco.size() != 0) {
			
			codigo++;
			banco.get(banco.size() - 1);
			
			//Funcionario funcionario = banco.get(banco.size() - 1);
			//codigo = funcionario.getId();
		}
		return codigo;
	}

	
	private Funcionario traga(Funcionario funcionario) {
		Iterator<Funcionario> it = banco.iterator();
		while (it.hasNext()) {
			Funcionario funcionarioBanco = it.next();
			if (funcionario.getId() == funcionarioBanco.getId()) {
				return funcionarioBanco;
			}

		}
		return null;

	}
	
	public void bancoConectado(boolean conect){
		this.conect = conect;
	}
	
	
	
}