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
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

public class TelaPrincipal extends JFrame {

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private ArrayList<Funcionario> manipulaFuncionario;
	private JButton btnAtendimento;
	private JButton btnFinanceiro;
	private JButton btnCriao;
	private JButton btnProduo;
	private JButton btnMidia;

	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/arceus1024x768.png")));
		getContentPane().setBackground(Color.WHITE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				liberaSetor();
			}
		});
		
				JToolBar toolBar = new JToolBar();
				toolBar.setRollover(true);
				toolBar.setFloatable(false);
				
						btnAtendimento = new JButton("Atendimento");
						btnAtendimento.setToolTipText("Atendimento");
						btnAtendimento.setIcon(new ImageIcon(TelaPrincipal.class
								.getResource("/images/notes_edit.png")));
						btnAtendimento.setVerticalTextPosition(JButton.BOTTOM);
						btnAtendimento.setHorizontalTextPosition(JButton.CENTER);
						toolBar.add(btnAtendimento);
						btnAtendimento.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								new TelaAtendimento().setVisible(true);
							}
						});
						btnAtendimento.setEnabled(false);
						
								btnCriao = new JButton("Cria\u00E7\u00E3o");
								btnCriao.setToolTipText("Cria\u00E7\u00E3o");
								btnCriao.setIcon(new ImageIcon(TelaPrincipal.class
										.getResource("/images/favorite.png")));
								btnCriao.setVerticalTextPosition(JButton.BOTTOM);
								btnCriao.setHorizontalTextPosition(JButton.CENTER);
								toolBar.add(btnCriao);
								btnCriao.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										new TelaCriação().setVisible(true);
									}
								});
								btnCriao.setEnabled(false);
								
										btnProduo = new JButton("Produ\u00E7\u00E3o");
										btnProduo.setToolTipText("Produ\u00E7\u00E3o");
										btnProduo.setIcon(new ImageIcon(TelaPrincipal.class
												.getResource("/images/chart.png")));
										btnProduo.setVerticalTextPosition(JButton.BOTTOM);
										btnProduo.setHorizontalTextPosition(JButton.CENTER);
										toolBar.add(btnProduo);
										btnProduo.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												new TelaProducao().setVisible(true);
											}
										});
										btnProduo.setEnabled(false);
										
												btnMidia = new JButton("Midia");
												btnMidia.setToolTipText("M\u00EDdia");
												btnMidia.setIcon(new ImageIcon(TelaPrincipal.class
														.getResource("/images/movie_track.png")));
												btnMidia.setVerticalTextPosition(JButton.BOTTOM);
												btnMidia.setHorizontalTextPosition(JButton.CENTER);
												toolBar.add(btnMidia);
												btnMidia.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														new TelaMidia().setVisible(true);
													}
												});
												btnMidia.setEnabled(false);
												
														btnFinanceiro = new JButton("Financeiro");
														btnFinanceiro.setToolTipText("Financeiro");
														btnFinanceiro.setIcon(new ImageIcon(TelaPrincipal.class
																.getResource("/images/calculator.png")));
														btnFinanceiro.setVerticalTextPosition(JButton.BOTTOM);
														btnFinanceiro.setHorizontalTextPosition(JButton.CENTER);
														toolBar.add(btnFinanceiro);
														btnFinanceiro.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																new TelaFinanceiro().setVisible(true);
															}
														});
														btnFinanceiro.setEnabled(false);
		
		JLabel lblKk = new JLabel("");
		lblKk.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Arceus718x673.jpg")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(509)
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(394)
							.addComponent(lblKk, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(356, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(lblKk, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{toolBar, btnAtendimento, btnCriao, btnProduo, btnMidia, btnFinanceiro}));
		setTitle("Arceus - Gerenciador Publicit\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
