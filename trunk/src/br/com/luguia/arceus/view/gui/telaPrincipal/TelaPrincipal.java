package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 240);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		setTitle("Arceus - Gerenciador Publicit\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuCadastro = new JMenu("Cadastros");
		menuBar.add(menuCadastro);

		JMenuItem itemMenuCadastroDeClientes = new JMenuItem("Clientes");
		itemMenuCadastroDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new TelaCadastroCliente().setVisible(true);
				
			}
		});
		menuCadastro.add(itemMenuCadastroDeClientes);

		JMenuItem itemMenuCadastroDeFuncionários = new JMenuItem(
				"Funcion\u00E1rios");
		itemMenuCadastroDeFuncionários.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroFuncionario().setVisible(true);
			}
		});
		menuCadastro.add(itemMenuCadastroDeFuncionários);

		JSeparator separator = new JSeparator();
		menuCadastro.add(separator);

		JMenuItem itemMenuCadastroSair = new JMenuItem("Sair...");
		itemMenuCadastroSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);// matando o programa!
			}
		});
		menuCadastro.add(itemMenuCadastroSair);

		JMenu menuSetores = new JMenu("Setores");
		menuBar.add(menuSetores);

		JMenuItem itemMenuSetoresAtendimento = new JMenuItem("Atendimento");
		itemMenuSetoresAtendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAtendimento().setVisible(true);

			}
		});
		menuSetores.add(itemMenuSetoresAtendimento);

		JMenuItem itemMenuSetoresCriacao = new JMenuItem("Cria\u00E7\u00E3o");
		itemMenuSetoresCriacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCriação().setVisible(true);
			}
		});
		menuSetores.add(itemMenuSetoresCriacao);

		JMenuItem itemMenuSetoresProducao = new JMenuItem("Produ\u00E7\u00E3o");
		itemMenuSetoresProducao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaProducao().setVisible(true);
			}
		});
		menuSetores.add(itemMenuSetoresProducao);

		JMenuItem itemMenuSetoresMidia = new JMenuItem("M\u00EDdia");
		itemMenuSetoresMidia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaMidia().setVisible(true);
			}
		});
		menuSetores.add(itemMenuSetoresMidia);

		JMenuItem itemMenuSetoresFinanceiro = new JMenuItem("Financeiro");
		itemMenuSetoresFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaFinanceiro().setVisible(true);
			}
		});
		menuSetores.add(itemMenuSetoresFinanceiro);

		JMenu menuConsulta = new JMenu("Consultas");
		menuBar.add(menuConsulta);

		JMenuItem itemMenuSolicitacao = new JMenuItem("Solicita\u00E7\u00E3o");
		menuConsulta.add(itemMenuSolicitacao);

		JMenu menuOpcoes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(menuOpcoes);

		JMenuItem itemSuporteMenuOpcoes = new JMenuItem("Suporte");
		menuOpcoes.add(itemSuporteMenuOpcoes);

		JMenuItem itemAjudaMenuOpcoes = new JMenuItem("Ajuda");
		menuOpcoes.add(itemAjudaMenuOpcoes);

		JSeparator separator_1 = new JSeparator();
		menuOpcoes.add(separator_1);

		JMenuItem itemSobreMenuOpcoes = new JMenuItem("Sobre");
		menuOpcoes.add(itemSobreMenuOpcoes);
	}
}
