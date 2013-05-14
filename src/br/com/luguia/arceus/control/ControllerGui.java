package br.com.luguia.arceus.control;

import br.com.luguia.arceus.view.gui.inicializacao.EscolhaBanco;

public class ControllerGui  implements InterfaceController{

	//private Principal tela;
	private EscolhaBanco escolhaBanco;

	public ControllerGui() {
		
		escolhaBanco = new EscolhaBanco();
		//tela = new Principal();

	}

	public void inicializar() {
	//	tela.welcome();

		escolhaBanco.setVisible(true);
		
		
		
		
		
		//if (tela.menu() == 1)
			//testarFuncionarioDAO();
		
	}
	
	
	
	

//public void testarFuncionarioDAO() {
		//Factory.criarBanco(Banco.ARRAY);
		//InterfaceFuncionarioDAO iFuncionarioDAO = Factory.getBanco();
		//tela.exibirTodos(iFuncionarioDAO.listeTodos());
		
	//}

}
