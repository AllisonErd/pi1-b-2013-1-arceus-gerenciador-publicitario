package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.luguia.arceus.model.Job;
import br.com.luguia.arceus.model.PessoaFisica;
import br.com.luguia.arceus.model.PessoaJuridica;
import br.com.luguia.arceus.model.Requisicao;
import br.com.luguia.arceus.model.dao.array.CriacaoDAO;
import br.com.luguia.arceus.model.dao.array.PessoaFisicaDAO;
import br.com.luguia.arceus.model.dao.array.PessoaJuridicaDAO;
import br.com.luguia.arceus.model.dao.array.ProjetoDAO;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;

public class TelaAtendimento extends JFrame {

	private JPanel contentPane;
	private JTextField campoCodigoProjeto;
	private JTextField campoNomeProjeto;
	private JFormattedTextField campoDataEntrega;
	private JFormattedTextField campoDataEmissao;
	private JFormattedTextField campoCpfCnpj;
	private JTextArea campoDescricaoProjeto;

	private PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
	private ArrayList<PessoaJuridica> manipulaPessoaJuridica;

	private PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
	private ArrayList<PessoaFisica> manipulaPessoaFisicas;

	private boolean fisico = true;

	private JTextArea campoCaracteristicas;
	private JTable table;

	private ProjetoDAO projetoDao = new ProjetoDAO();
	private ArrayList<Requisicao> manipulaProjeto;
	private Requisicao projeto;

	private CriacaoDAO jobDao = new CriacaoDAO();
	private ArrayList<Job> manipulaTrabalho;
	private Job trabalho;

	private int idPessoa = 0;
	private int chaveDeControle = 0;

	private MaskFormatter mascaraCNPJ;  
	private MaskFormatter mascaraCPF;  
	

	public TelaAtendimento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaAtendimento.class
						.getResource("/Images24x24/notes_edit.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				posicaoCorreta();

			}
		});
		setTitle("Setor de Atendimento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(970, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1194, 56);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(" A t e n d i m e n t o");
		lblNewLabel.setIcon(new ImageIcon(TelaAtendimento.class
				.getResource("/images/notes_edit.png")));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 384, 56);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "C l i e n t e",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 122, 413, 303);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		campoCaracteristicas = new JTextArea();
		campoCaracteristicas.setBounds(10, 23, 374, 269);
		panel_1.add(campoCaracteristicas);
		campoCaracteristicas.setBackground(UIManager
				.getColor("CheckBox.background"));
		campoCaracteristicas.setEditable(false);

		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(384, 23, 17, 267);
		panel_1.add(scrollBar_2);

		JButton btnNovo = new JButton("Pesquisar Cliente");
		btnNovo.setIcon(new ImageIcon(TelaAtendimento.class
				.getResource("/Images16x16/search.png")));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				String cpfCnpj = campoCpfCnpj.getText().toString().trim();

				if (fisico == true) {
					manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO
							.listeTodos();

					for (int i = 0; i < manipulaPessoaFisicas.size(); i++) {

						if (manipulaPessoaFisicas.get(i).getCpf()
								.equalsIgnoreCase(cpfCnpj)) {

							idPessoa = manipulaPessoaFisicas.get(i).getId();
							tabelaSincronizada(idPessoa);
							campoCaracteristicas.setText(""
									+ manipulaPessoaFisicas.get(i).getId()
									+ "\n"
									+ manipulaPessoaFisicas.get(i).getNome()
									+ "\n"
									+ manipulaPessoaFisicas.get(i).getRg()
									+ "\n"
									+ manipulaPessoaFisicas.get(i).getCpf()
									+ "\n\n"
									+ manipulaPessoaFisicas.get(i).getContato()
											.getEmail()
									+ "\n"
									+ manipulaPessoaFisicas.get(i).getContato()
											.getTelefone().getTelefoneFixo()
									+ "\n"
									+ manipulaPessoaFisicas.get(i).getContato()
											.getTelefone().getTelefoneCel()
									+ "\n\n"
									+ manipulaPessoaFisicas.get(i)
											.getEndereco().getRua()
									+ "\n"
									+ manipulaPessoaFisicas.get(i)
											.getEndereco().getBairro()
									+ "\n"
									+ manipulaPessoaFisicas.get(i)
											.getEndereco().getCep()
									+ "\n"
									+ manipulaPessoaFisicas.get(i)
											.getEndereco().getCidade()
									+ "\n"
									+ manipulaPessoaFisicas.get(i)
											.getEndereco().getEstado()
									+ "\n"
									+ manipulaPessoaFisicas.get(i)
											.getEndereco().getComplemento());

						}

					}

				} else if (fisico == false) {
					manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO
							.listeTodos();

					for (int i = 0; i < manipulaPessoaJuridica.size(); i++) {
						if (manipulaPessoaJuridica.get(i).getCnpj()
								.equalsIgnoreCase(cpfCnpj)) {

							idPessoa = manipulaPessoaJuridica.get(i).getId();
							tabelaSincronizada(idPessoa);
							campoCaracteristicas.setText(""
									+ manipulaPessoaJuridica.get(i).getId()
									+ "\n"
									+ manipulaPessoaJuridica.get(i).getNome()
									+ "\n"
									+ manipulaPessoaJuridica.get(i).getCnpj()
									+ "\n\n"
									+ manipulaPessoaJuridica.get(i)
											.getContato().getEmail()
									+ "\n"
									+ manipulaPessoaJuridica.get(i)
											.getContato().getTelefone()
											.getTelefoneFixo()
									+ "\n"
									+ manipulaPessoaJuridica.get(i)
											.getContato().getTelefone()
											.getTelefoneCel()
									+ "\n\n"
									+ manipulaPessoaJuridica.get(i)
											.getEndereco().getRua()
									+ "\n"
									+ manipulaPessoaJuridica.get(i)
											.getEndereco().getBairro()
									+ "\n"
									+ manipulaPessoaJuridica.get(i)
											.getEndereco().getCep()
									+ "\n"
									+ manipulaPessoaJuridica.get(i)
											.getEndereco().getCidade()
									+ "\n"
									+ manipulaPessoaJuridica.get(i)
											.getEndereco().getEstado()
									+ "\n"
									+ manipulaPessoaJuridica.get(i)
											.getEndereco().getComplemento());
						}

					}

				}

			}
		});

		btnNovo.setBounds(255, 59, 168, 31);
		contentPane.add(btnNovo);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(433, 78, 18, 393);
		contentPane.add(separator);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "P r o j e t o",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(441, 95, 513, 330);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNomeDoProjeto = new JLabel("Nome do Projeto");
		lblNomeDoProjeto.setBounds(20, 29, 106, 14);
		panel_3.add(lblNomeDoProjeto);

		campoNomeProjeto = new JTextField();
		campoNomeProjeto.setBounds(141, 26, 362, 28);
		panel_3.add(campoNomeProjeto);
		campoNomeProjeto.setColumns(10);

		JLabel lblTermino = new JLabel("Entrega do Projeto");
		lblTermino.setBounds(301, 61, 106, 14);
		panel_3.add(lblTermino);

		try {
			campoDataEntrega = new JFormattedTextField(new MaskFormatter("##/##/####"));
			campoDataEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		} catch (ParseException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		campoDataEntrega.setBounds(417, 58, 86, 28);
		panel_3.add(campoDataEntrega);
		campoDataEntrega.setColumns(10);

		JLabel lblDataDaEmisso = new JLabel("Data da Emiss\u00E3o");
		lblDataDaEmisso.setBounds(20, 61, 106, 14);
		panel_3.add(lblDataDaEmisso);

		try {
			campoDataEmissao = new JFormattedTextField(new MaskFormatter("##/##/####"));
			campoDataEmissao.setHorizontalAlignment(SwingConstants.CENTER);
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		campoDataEmissao.setBounds(141, 58, 86, 28);
		panel_3.add(campoDataEmissao);
		campoDataEmissao.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 88, 498, 113);
		panel_3.add(panel_6);
		panel_6.setBorder(new TitledBorder(null,
				"Informa\u00E7\u00F5es de Produ\u00E7\u00E3o",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setLayout(null);
		campoDescricaoProjeto = new JTextArea();
		campoDescricaoProjeto.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(campoDescricaoProjeto);  
		scroll.setBounds(10, 24, 478, 80);
		panel_6.add(scroll);
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 212, 498, 107);
		panel_3.add(panel_5);
		panel_5.setBorder(new TitledBorder(null,
				"Projetos relacionados ao cliente pesquisado",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "New column", "New column", "New column",
						"New column" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.setBounds(10, 24, 458, 72);
		panel_5.add(table);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(471, 24, 17, 72);
		panel_5.add(scrollBar);

		JLabel lblNewLabel_1 = new JLabel("Codigo do Projeto :");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(738, 67, 163, 23);
		contentPane.add(lblNewLabel_1);

		campoCodigoProjeto = new JTextField();
		campoCodigoProjeto.setEnabled(false);
		campoCodigoProjeto.setFont(new Font("Dialog", Font.BOLD, 16));
		campoCodigoProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		campoCodigoProjeto.setEditable(false);
		campoCodigoProjeto.setBounds(904, 62, 50, 31);
		contentPane.add(campoCodigoProjeto);
		campoCodigoProjeto.setColumns(10);

		
		try {
			campoCpfCnpj = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		campoCpfCnpj.setFont(new Font("Dialog", Font.BOLD, 14));
		campoCpfCnpj.setHorizontalAlignment(SwingConstants.CENTER);
		campoCpfCnpj.setColumns(10);
		campoCpfCnpj.setBounds(76, 59, 168, 30);
		contentPane.add(campoCpfCnpj);

		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpfcnpj.setBounds(0, 70, 72, 14);
		contentPane.add(lblCpfcnpj);

		JRadioButton rdbtnFisico = new JRadioButton("Fisico", true);
		rdbtnFisico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fisico = true;
				boolean cnpj = false;
				mudarMascara(cnpj );

			}
		});
		rdbtnFisico.setBounds(10, 97, 72, 17);
		contentPane.add(rdbtnFisico);

		JRadioButton rdbtnJuridico = new JRadioButton("Juridico");
		rdbtnJuridico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fisico = false;
				boolean cnpj = true;
				mudarMascara(cnpj );
			
			}
		});
		rdbtnJuridico.setBounds(83, 97, 78, 17);
		contentPane.add(rdbtnJuridico);

		ButtonGroup gp = new ButtonGroup();
		gp.add(rdbtnFisico);
		gp.add(rdbtnJuridico);
		

		try  
	    {  
	        mascaraCNPJ = new MaskFormatter("###.###.###/####-##");  
	        mascaraCPF = new MaskFormatter("###.###.###-##");  
	    }catch(Exception e){e.printStackTrace();}  
		
		

		JButton novoCliente = new JButton("Cadastrar");
		novoCliente.setIcon(new ImageIcon(TelaAtendimento.class
				.getResource("/Images16x16/accept.png")));
		novoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroCliente().setVisible(true);
			}
		});
		novoCliente.setBounds(300, 428, 123, 31);
		contentPane.add(novoCliente);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setIcon(new ImageIcon(TelaAtendimento.class
				.getResource("/Images16x16/database_remove.png")));
		btnExcluir.setBounds(853, 427, 101, 33);
		contentPane.add(btnExcluir);

		JButton botaoOrcamento = new JButton("Or\u00E7amento");
		botaoOrcamento.setToolTipText("Solicita Or\u00E7amento");
		botaoOrcamento.setIcon(new ImageIcon(TelaAtendimento.class
				.getResource("/Images16x16/calculator.png")));
		botaoOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				projeto = new Requisicao();

				if (campoNomeProjeto.getText().toString().equalsIgnoreCase("")
						|| campoDataEntrega.getText().equalsIgnoreCase("")
						|| campoDataEmissao.getText().toString()
								.equalsIgnoreCase("")
						|| campoDescricaoProjeto.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"Preencha todos os campos! ");

				} else {
					projeto.setIdProjeto(Integer.parseInt(campoCodigoProjeto
							.getText().toString().trim()));
					projeto.setNomeProjet(campoNomeProjeto.getText().toString()
							.trim());
					projeto.setDataPedido(campoDataEmissao.getText().toString()
							.trim());
					projeto.setTempoEntrega(campoDataEntrega.getText()
							.toString().trim());
					projeto.setDefinicaoProjeto(campoDescricaoProjeto.getText()
							.toString().trim());

					projeto.setCustoEquipamento("");
					projeto.setPorcentagemConclusao(0);
					// projeto.setPrioridadeProjeto(0);
					projeto.setTipoExecucao("");

					if (chaveDeControle == 0) {
						if (idPessoa != 0) {
							projetoDao.insira(projeto, idPessoa);
						} else {
							JOptionPane
									.showMessageDialog(null,
											"Pesquisar o cliente que deseja solicitar um projeto!");
						}
					} else {
						projetoDao.altere(projeto, 1);

						chaveDeControle = 0;

					}
				}

				posicaoCorreta();
				tabelaSincronizada(idPessoa);
				limpaTela();
			}
		});
		botaoOrcamento.setBounds(644, 427, 109, 33);
		contentPane.add(botaoOrcamento);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setIcon(new ImageIcon(TelaAtendimento.class
				.getResource("/Images16x16/back.png")));
		botaoVoltar.setBounds(10, 428, 117, 31);
		contentPane.add(botaoVoltar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setIcon(new ImageIcon(TelaAtendimento.class
				.getResource("/Images16x16/page_edit.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					chaveDeControle = 1;
					String codigo, nome;

					codigo = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 0);
					nome = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 1);

					manipulaProjeto = (ArrayList<Requisicao>) projetoDao
							.listeTodos();
					for (int i = 0; i < manipulaProjeto.size(); i++) {
						if (manipulaProjeto.get(i).getNomeProjet()
								.equalsIgnoreCase(nome.toString().trim())
								&& manipulaProjeto.get(i).getIdProjeto() == Integer
										.parseInt(codigo)) {

							campoCodigoProjeto.setText(""
									+ manipulaProjeto.get(i).getIdProjeto());
							campoNomeProjeto.setText(""
									+ manipulaProjeto.get(i).getNomeProjet());
							campoDataEmissao.setText(""
									+ manipulaProjeto.get(i).getDataPedido());
							campoDataEntrega.setText(""
									+ manipulaProjeto.get(i).getTempoEntrega());
							campoDescricaoProjeto.setText(""
									+ manipulaProjeto.get(i)
											.getDefinicaoProjeto());
						}
					}
					// limpaTabela();

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Ningu�m foi selecionado !");
				}

			}
		});
		btnAlterar.setBounds(755, 427, 96, 33);
		contentPane.add(btnAlterar);

		JButton btnCriao = new JButton("Cria\u00E7\u00E3o");
		btnCriao.setToolTipText("Envia Cria\u00E7\u00E3o");
		btnCriao.setIcon(new ImageIcon(TelaAtendimento.class
				.getResource("/Images16x16/favorite.png")));
		btnCriao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String codigo, nome;

					codigo = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 0);
					nome = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 1);

					manipulaProjeto = (ArrayList<Requisicao>) projetoDao
							.listeTodos();
					for (int i = 0; i < manipulaProjeto.size(); i++) {
						if (manipulaProjeto.get(i).getNomeProjet()
								.equalsIgnoreCase(nome.toString().trim())
								&& manipulaProjeto.get(i).getIdProjeto() == Integer
										.parseInt(codigo)
								&& manipulaProjeto.get(i)
										.getPorcentagemConclusao() == 15) {

							projeto = new Requisicao();
							projeto.setPorcentagemConclusao(20);
							projeto.setIdProjeto(manipulaProjeto.get(i)
									.getIdProjeto());

							projetoDao.altere(projeto, 3);
						}
					}

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum projeto foi selecionad");
				} finally {
					tabelaSincronizada(idPessoa);
				}

			}
		});
		btnCriao.setBounds(539, 427, 103, 33);
		contentPane.add(btnCriao);

		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setIcon(new ImageIcon(TelaAtendimento.class
				.getResource("/Images16x16/image.png")));
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String codigo, nome;

					codigo = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 0);
					nome = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 1);

					manipulaProjeto = (ArrayList<Requisicao>) projetoDao
							.listeTodos();
					for (int i = 0; i < manipulaProjeto.size(); i++) {
						if (manipulaProjeto.get(i).getNomeProjet()
								.equalsIgnoreCase(nome.toString().trim())
								&& manipulaProjeto.get(i).getIdProjeto() == Integer
										.parseInt(codigo)
								&& manipulaProjeto.get(i)
										.getPorcentagemConclusao() == 100) {
							JOptionPane.showMessageDialog(null, ""
									+ manipulaProjeto.get(i).getIdProjeto()
									+ "\n\n"
									+ manipulaProjeto.get(i).getNomeProjet()
									+ "\n\n"
									+ manipulaProjeto.get(i).getDataPedido()
									+ "\n"
									+ manipulaProjeto.get(i).getTempoEntrega()
									+ "\n\n\n"
									+ manipulaProjeto.get(i)
											.getDefinicaoProjeto() + "\n\n"
									+ manipulaProjeto.get(i).getTipoExecucao()
									+ "\n");

						}
					}

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum projeto foi selecionado");
				}

			}
		});
		btnVisualizar.setToolTipText("Visualiza informa\u00E7\u00F5es ");
		btnVisualizar.setBounds(435, 428, 102, 33);
		contentPane.add(btnVisualizar);
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numero = (String) table.getModel().getValueAt(
						table.getSelectedRow(), 0);

				manipulaProjeto = (ArrayList<Requisicao>) projetoDao
						.listeTodos();

				manipulaTrabalho = (ArrayList<Job>) jobDao.listeTodos();

				for (int i = 0; i < manipulaProjeto.size(); i++) {
					projeto = manipulaProjeto.get(i);

					if (projeto.getIdProjeto() == Integer.parseInt(numero)) {
						for (int j = 0; j < manipulaTrabalho.size(); j++) {
							if (projeto.getIdProjeto() == manipulaTrabalho.get(
									j).getIdProjeto()) {
								trabalho = new Job();
								trabalho.setIdProjeto(manipulaTrabalho.get(j)
										.getIdProjeto());
								jobDao.exclua(trabalho);
							}

						}

						projetoDao.exclua(projeto);

					}

				}

				tabelaSincronizada(idPessoa);
				posicaoCorreta();
			}
		});
	}

	public void posicaoCorreta() {
		int indice = 1;

		manipulaProjeto = (ArrayList<Requisicao>) projetoDao.listeTodos();
		try {
			indice += manipulaProjeto.get(manipulaProjeto.size() - 1)
					.getIdProjeto();
		} catch (Exception exp) {

		} finally {
			campoCodigoProjeto.setText("" + indice);
		}

	}

	public void tabelaSincronizada(int id) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);

		manipulaProjeto = (ArrayList<Requisicao>) projetoDao.listeTodos();

		for (int i = 0; i < manipulaProjeto.size(); i++) {
			if (manipulaProjeto.get(i).getIdPessoa() == id) {
				model.addRow(new String[] {
						"" + manipulaProjeto.get(i).getIdProjeto(),
						"" + manipulaProjeto.get(i).getNomeProjet(),
						"" + manipulaProjeto.get(i).getPorcentagemConclusao()
								+ "% concluido",
						"R$"
								+ manipulaProjeto.get(i).getCustos()
										.getOrcamento() });
			}
		}

	}

	public void limpaTela() {
		campoNomeProjeto.setText("");
		campoDataEmissao.setText("");
		campoDataEntrega.setText("");
		campoDescricaoProjeto.setText("");
	}
	
	private void mudarMascara(boolean cnpj)  
	{  
	    try{  
	  
	        this.campoCpfCnpj.setValue(null);  
	        if(cnpj)  
	        {  
	            this.campoCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(mascaraCNPJ));  
	        }  
	        else  
	        {  
	            this.campoCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));  
	        }  
	  
	    }catch(Exception pe)  
	    {  
	        pe.printStackTrace();  
	    }  
	}  
}