package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import br.com.luguia.arceus.model.Funcionario;
import br.com.luguia.arceus.model.dao.array.FuncionarioDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaPrincipal extends JFrame {

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private ArrayList<Funcionario> manipulaFuncionario;
	private JButton btnAtendimento;
	private JButton btnFinanceiro;
	private JButton btnCriao;
	private JButton btnProduo;
	private JButton btnMidia;

	public TelaPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				liberaSetor();
			}
		});
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 240);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnAtendimento = new JButton("Atendimento");
		btnAtendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAtendimento().setVisible(true);
			}
		});
		btnAtendimento.setEnabled(false);
		btnAtendimento.setBounds(0, 0, 93, 23);
		panel_1.add(btnAtendimento);

		btnFinanceiro = new JButton("Financeiro");
		btnFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaFinanceiro().setVisible(true);
			}
		});
		btnFinanceiro.setEnabled(false);
		btnFinanceiro.setBounds(103, 0, 93, 23);
		panel_1.add(btnFinanceiro);

		btnCriao = new JButton("Cria\u00E7\u00E3o");
		btnCriao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCriação().setVisible(true);
			}
		});
		btnCriao.setEnabled(false);
		btnCriao.setBounds(206, 0, 93, 23);
		panel_1.add(btnCriao);

		btnProduo = new JButton("Produ\u00E7\u00E3o");
		btnProduo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaProducao().setVisible(true);
			}
		});
		btnProduo.setEnabled(false);
		btnProduo.setBounds(309, 0, 93, 23);
		panel_1.add(btnProduo);

		btnMidia = new JButton("Midia");
		btnMidia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaMidia().setVisible(true);
			}
		});
		btnMidia.setEnabled(false);
		btnMidia.setBounds(157, 34, 93, 23);
		panel_1.add(btnMidia);
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

	public void liberaSetor() {
		String setor = "";
		try {

			InputStream is = new FileInputStream("ReferenciaFuncionario.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String idFuncionario = br.readLine();

			manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO
					.listeTodos();

			for (int i = 0; i < manipulaFuncionario.size(); i++) {
				if (manipulaFuncionario.get(i).getId() == Integer
						.parseInt(idFuncionario)) {
					setor = manipulaFuncionario.get(i).getTipo();

					if (setor.equalsIgnoreCase("ATENDIMENTO")) {
						btnAtendimento.setEnabled(true);
					} else if (setor.equalsIgnoreCase("CRIACAO")) {
						btnCriao.setEnabled(true);
					} else if (setor.equalsIgnoreCase("FINANCEIRO")) {
						btnFinanceiro.setEnabled(true);
					} else if (setor.equalsIgnoreCase("MIDIA")) {
						btnMidia.setEnabled(true);
					} else if (setor.equalsIgnoreCase("PRODUCAO")) {
						btnProduo.setEnabled(true);
					} else if (setor.equalsIgnoreCase("admin")) {
						btnProduo.setEnabled(true);
						btnMidia.setEnabled(true);
						btnFinanceiro.setEnabled(true);
						btnAtendimento.setEnabled(true);
						btnCriao.setEnabled(true);
					}

				}

			}

			br.close();
		} catch (Exception e2) {

			e2.printStackTrace();
		}
	}
}
