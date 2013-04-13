package Arceus.src.br.com.arceus.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class TelaPrincipal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		getContentPane().setLayout(null);
		setTitle("Arceus - Gerenciador Publicit\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuCadastro = new JMenu("Cadastros");
		menuBar.add(menuCadastro);
		
		JMenuItem itemMenuCadastroDeClientes = new JMenuItem("Clientes");
		menuCadastro.add(itemMenuCadastroDeClientes);
		
		JMenuItem itemMenuCadastroDeFuncionários = new JMenuItem("Funcion\u00E1rios");
		menuCadastro.add(itemMenuCadastroDeFuncionários);
		
		JSeparator separator = new JSeparator();
		menuCadastro.add(separator);
		
		JMenuItem itemMenuCadastroSair = new JMenuItem("Sair...");
		menuCadastro.add(itemMenuCadastroSair);
		
		JMenu menuSetores = new JMenu("Setores");
		menuBar.add(menuSetores);
		
		JMenuItem itemMenuSetoresAtendimento = new JMenuItem("Atendimento");
		menuSetores.add(itemMenuSetoresAtendimento);
		
		JMenuItem itemMenuSetoresCriacao = new JMenuItem("Cria\u00E7\u00E3o");
		menuSetores.add(itemMenuSetoresCriacao);
		
		JMenuItem itemMenuSetoresProducao = new JMenuItem("Produ\u00E7\u00E3o");
		menuSetores.add(itemMenuSetoresProducao);
		
		JMenuItem itemMenuSetoresMidia = new JMenuItem("M\u00EDdia");
		menuSetores.add(itemMenuSetoresMidia);
		
		JMenuItem itemMenuSetoresFinanceiro = new JMenuItem("Financeiro");
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
