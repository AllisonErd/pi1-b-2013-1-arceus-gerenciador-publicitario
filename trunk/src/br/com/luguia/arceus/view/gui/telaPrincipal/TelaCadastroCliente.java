package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.luguia.arceus.model.Contato;
import br.com.luguia.arceus.model.Endereco;
import br.com.luguia.arceus.model.PessoaFisica;
import br.com.luguia.arceus.model.PessoaJuridica;
import br.com.luguia.arceus.model.Telefone;
import br.com.luguia.arceus.model.dao.array.PessoaFisicaDAO;
import br.com.luguia.arceus.model.dao.array.PessoaJuridicaDAO;

public class TelaCadastroCliente extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoCodigo;
	private JTextField campoCpfCnpj;
	private JTextField campoRua;
	private JTextField campoBairro;
	private JTextField campoCidade;
	private JTextField campoCep;
	private JTextField campoTelefonefixo;
	private JTextField campoTelefoneCelular;
	private JTextField campoEmail;
	private JTextField campoPesquisa;
	private JComboBox boxTipoCliente;
	private JTable tableFisica;
	private JComboBox boxTipoPesquisa;
	private JTextArea campoComplemento;

	private JTextField campoRg;
	private JTextField campoEstado;

	private PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
	private ArrayList<PessoaJuridica> manipulaPessoaJuridica;
	private PessoaJuridica pessoaJuridica;

	private PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
	private ArrayList<PessoaFisica> manipulaPessoaFisicas;
	private PessoaFisica pessoaFisica;

	private int chaveDeControle = 0;

	private Contato contato;
	private Endereco endereco;
	private Telefone telefone;

	private boolean fisico = false;
	private boolean codigo = false;
	private boolean pesquisaFisico = true;

	private int idFisic = 0;
	private int id = 0;
	private JTable tableJuridica;

	public TelaCadastroCliente() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				posicaoCorreta();

			}
		});
		setResizable(false);
		setTitle("Cadastro de Cliente");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1194, 56);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(" C l i e n t e s");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/images/community_users.png")));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 319, 56);
		panel.add(lblNewLabel);

		JPanel painelDeComponentes = new JPanel();
		painelDeComponentes.setBorder(new TitledBorder(null,
				"D a d o s   C a d a s t r a i s", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		painelDeComponentes.setBounds(10, 67, 607, 356);
		contentPane.add(painelDeComponentes);
		painelDeComponentes.setLayout(null);

		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(10, 34, 46, 14);
		painelDeComponentes.add(labelNome);

		campoNome = new JTextField();
		campoNome.setBounds(55, 28, 438, 20);
		painelDeComponentes.add(campoNome);
		campoNome.setColumns(10);

		JLabel labelCodigo = new JLabel("N\u00BA");
		labelCodigo.setFont(new Font("Dialog", Font.BOLD, 20));
		labelCodigo.setBounds(500, 34, 27, 33);
		painelDeComponentes.add(labelCodigo);

		campoCodigo = new JTextField();
		campoCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		campoCodigo.setFont(new Font("Dialog", Font.BOLD, 26));
		campoCodigo.setEditable(false);
		campoCodigo.setBounds(528, 28, 69, 52);
		painelDeComponentes.add(campoCodigo);
		campoCodigo.setColumns(10);

		boxTipoCliente = new JComboBox();
		boxTipoCliente.setModel(new DefaultComboBoxModel(new String[] { "---",
				"F\u00EDsico", "Jur\u00EDdico" }));

		boxTipoCliente.addItemListener(this);

		boxTipoCliente.setBounds(111, 60, 63, 20);
		painelDeComponentes.add(boxTipoCliente);

		JLabel lblTipoDeCliente = new JLabel("Tipo de Cliente");
		lblTipoDeCliente.setBounds(10, 63, 83, 14);
		painelDeComponentes.add(lblTipoDeCliente);

		campoCpfCnpj = new JTextField();
		campoCpfCnpj.setBounds(264, 60, 106, 20);
		painelDeComponentes.add(campoCpfCnpj);
		campoCpfCnpj.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 112, 587, 2);
		painelDeComponentes.add(separator);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 133, 587, 192);
		painelDeComponentes.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Endere\u00E7o", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblRua = new JLabel("Rua");
		lblRua.setHorizontalAlignment(SwingConstants.LEFT);
		lblRua.setBounds(10, 14, 37, 14);
		panel_1.add(lblRua);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro.setBounds(10, 45, 46, 14);
		panel_1.add(lblBairro);

		campoRua = new JTextField();
		campoRua.setBounds(59, 11, 484, 20);
		panel_1.add(campoRua);
		campoRua.setColumns(10);

		campoBairro = new JTextField();
		campoBairro.setBounds(59, 42, 246, 20);
		panel_1.add(campoBairro);
		campoBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setBounds(10, 74, 39, 14);
		panel_1.add(lblCidade);

		campoCidade = new JTextField();
		campoCidade.setBounds(59, 71, 246, 20);
		panel_1.add(campoCidade);
		campoCidade.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(315, 48, 28, 14);
		panel_1.add(lblCep);

		campoCep = new JTextField();
		campoCep.setBounds(364, 42, 70, 20);
		panel_1.add(campoCep);
		campoCep.setColumns(10);

		campoEstado = new JTextField();
		campoEstado.setColumns(10);
		campoEstado.setBounds(364, 71, 179, 20);
		panel_1.add(campoEstado);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(315, 74, 46, 14);
		panel_1.add(lblEstado);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComplemento.setBounds(10, 106, 79, 14);
		panel_1.add(lblComplemento);

		campoComplemento = new JTextArea();
		campoComplemento.setText(" ");
		campoComplemento.setBounds(99, 102, 444, 50);
		panel_1.add(campoComplemento);

		JPanel fichaContatoCliente = new JPanel();
		tabbedPane.addTab("Contato", null, fichaContatoCliente, null);
		fichaContatoCliente.setLayout(null);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(44, 41, 57, 14);
		fichaContatoCliente.add(lblTelefone);

		campoTelefonefixo = new JTextField();
		campoTelefonefixo.setBounds(96, 35, 121, 20);
		fichaContatoCliente.add(campoTelefonefixo);
		campoTelefonefixo.setColumns(10);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(44, 72, 57, 14);
		fichaContatoCliente.add(lblCelular);

		campoTelefoneCelular = new JTextField();
		campoTelefoneCelular.setColumns(10);
		campoTelefoneCelular.setBounds(96, 66, 121, 20);
		fichaContatoCliente.add(campoTelefoneCelular);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(44, 100, 46, 14);
		fichaContatoCliente.add(lblEmail);

		campoEmail = new JTextField();
		campoEmail.setText(null);
		campoEmail.setBounds(96, 97, 345, 20);
		fichaContatoCliente.add(campoEmail);
		campoEmail.setColumns(10);

		JFormattedTextField formattedTextField = null;

		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setBounds(192, 63, 62, 14);
		painelDeComponentes.add(lblCpfcnpj);

		campoRg = new JTextField();
		campoRg.setEditable(false);
		campoRg.setEnabled(false);
		campoRg.setColumns(10);
		campoRg.setBounds(413, 59, 80, 20);
		painelDeComponentes.add(campoRg);

		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(382, 62, 27, 14);
		painelDeComponentes.add(lblRg);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(644, 67, 2, 393);
		contentPane.add(separator_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "P e s q u i s a r",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(656, 67, 528, 356);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_3.setBounds(10, 55, 508, 290);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		tableFisica = new JTable();
		tableFisica.setModel(new DefaultTableModel(new Object[][] { { null,
				null, null }, }, new String[] { "New column", "New column",
				"New column" }));
		tableFisica.setBounds(12, 30, 468, 107);
		panel_3.add(tableFisica);

		tableJuridica = new JTable();
		tableJuridica.setModel(new DefaultTableModel(new Object[][] { { null,
				null, null }, }, new String[] { "New column", "New column",
				"New column" }));
		tableJuridica.setBounds(12, 171, 468, 107);
		panel_3.add(tableJuridica);
		// TODO
		JRadioButton radioJuridica = new JRadioButton("Juridica", false);
		radioJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisaFisico = false;
			}
		});
		radioJuridica.setBounds(12, 145, 81, 14);
		panel_3.add(radioJuridica);

		JRadioButton radioFisica = new JRadioButton("Fisica", true);
		radioFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisaFisico = true;
			}
		});
		radioFisica.setBounds(12, 8, 66, 14);
		panel_3.add(radioFisica);

		ButtonGroup grupRadio = new ButtonGroup();
		grupRadio.add(radioJuridica);
		grupRadio.add(radioFisica);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(482, 30, 17, 107);
		panel_3.add(scrollBar);

		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(482, 171, 17, 107);
		panel_3.add(scrollBar_1);

		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(88, 23, 290, 20);
		panel_2.add(campoPesquisa);
		campoPesquisa.setColumns(10);
		final String items[] = { "Nome", "Codigo" };

		boxTipoPesquisa = new JComboBox(items);
		boxTipoPesquisa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {

					if (e.getItem().toString().equalsIgnoreCase("Nome")) {
						codigo = false;

					} else {
						codigo = true;
					}

				}

			}
		});

		boxTipoPesquisa.setBounds(10, 23, 66, 20);
		panel_2.add(boxTipoPesquisa);
		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/Images16x16/page_search.png")));
		botaoPesquisar.setBounds(388, 22, 130, 23);
		panel_2.add(botaoPesquisar);
		botaoPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				DefaultTableModel model = (DefaultTableModel) tableFisica
						.getModel();

				DefaultTableModel model2 = (DefaultTableModel) tableJuridica
						.getModel();

				String nome = campoPesquisa.getText().toString().trim();

				if (codigo == false && pesquisaFisico == false) {
					model2.setNumRows(0);
					manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO
							.listeTodos();

					for (int i = 0; i < manipulaPessoaJuridica.size(); i++) {
						if (manipulaPessoaJuridica.get(i).getNome()
								.equalsIgnoreCase(nome)) {

							model2.addRow(new String[] {
									"" + manipulaPessoaJuridica.get(i).getId(),
									""
											+ manipulaPessoaJuridica.get(i)
													.getNome(),
									""
											+ manipulaPessoaJuridica.get(i)
													.getCnpj() });

						}

					}
				}

				if (codigo == false && pesquisaFisico == true) {
					model.setNumRows(0);
					manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO
							.listeTodos();

					for (int i = 0; i < manipulaPessoaFisicas.size(); i++) {
						if (manipulaPessoaFisicas.get(i).getNome()
								.equalsIgnoreCase(nome)) {

							model.addRow(new String[] {
									"" + manipulaPessoaFisicas.get(i).getId(),
									"" + manipulaPessoaFisicas.get(i).getNome(),
									"" + manipulaPessoaFisicas.get(i).getCpf() });

						}

					}
				}
				try {
					if (codigo == true && pesquisaFisico == false) {
						model2.setNumRows(0);
						manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO
								.listeTodos();

						for (int i = 0; i < manipulaPessoaJuridica.size(); i++) {
							if (manipulaPessoaJuridica.get(i).getId() == Integer
									.parseInt(nome)) {

								model2.addRow(new String[] {
										""
												+ manipulaPessoaJuridica.get(i)
														.getId(),
										""
												+ manipulaPessoaJuridica.get(i)
														.getNome(),
										""
												+ manipulaPessoaJuridica.get(i)
														.getCnpj() });

							}

						}

					}

					if (codigo == true && pesquisaFisico == true) {
						model.setNumRows(0);
						manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO
								.listeTodos();

						for (int i = 0; i < manipulaPessoaFisicas.size(); i++) {
							if (manipulaPessoaFisicas.get(i).getId() == Integer
									.parseInt(nome)) {

								model.addRow(new String[] {
										""
												+ manipulaPessoaFisicas.get(i)
														.getId(),
										""
												+ manipulaPessoaFisicas.get(i)
														.getNome(),
										""
												+ manipulaPessoaFisicas.get(i)
														.getCpf() });
							}
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Informe o codigo!");
				}

			}
		});

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/Images16x16/back.png")));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botaoVoltar.setBounds(238, 437, 113, 23);
		contentPane.add(botaoVoltar);

		JButton botaoCadastrar = new JButton("Salvar");
		botaoCadastrar.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/Images16x16/database_accept.png")));
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (campoNome.getText().toString().equalsIgnoreCase("")
						|| campoCpfCnpj.getText().toString()
								.equalsIgnoreCase("")
						|| campoTelefonefixo.getText().toString()
								.equalsIgnoreCase("")

						|| campoBairro.getText().toString()
								.equalsIgnoreCase("")
						|| campoCep.getText().toString().toString()
								.equalsIgnoreCase("")
						|| campoCidade.getText().toString()
								.equalsIgnoreCase("")
						|| campoComplemento.getText().toString()
								.equalsIgnoreCase("")
						|| campoEmail.getText().toString().equalsIgnoreCase("")
						|| campoEstado.getText().toString()
								.equalsIgnoreCase("")
						|| campoRua.getText().toString().equalsIgnoreCase("")
						|| campoTelefoneCelular.getText().toString()
								.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"Preencha todos os campos!! ");

				} else if (fisico == false) {
					// TODO
					// a pessoa esta sendo criada em uma função e retornando
					// para aque! cadastraClienteJuridico()

					if (chaveDeControle == 1) {
						pessoaJuridicaDAO.altere(cadastraClienteJuridico());
						chaveDeControle = 0;
					} else {
						if ((verificaCpf(campoCpfCnpj.getText().toString()) + validaCnpj(campoCpfCnpj
								.getText().toString())) != 0) {
							JOptionPane
									.showMessageDialog(
											null,
											"Cadastro não concluido\n 			Ja existe um cliente cadastrado com o CNPJ que esta sendo informado!!");
						} else {
							pessoaJuridicaDAO.insira(cadastraClienteJuridico());
						}

					}

					limpaCampo();

					// pessoaJuridica = new PessoaJuridica();
					// endereco = new Endereco();
					// contato = new Contato();
					// telefone = new Telefone();
				} else {
					// TODO

					if (chaveDeControle == 1) {
						pessoaFisicaDAO.altere(cadastraClienteFisico());
						chaveDeControle = 0;
					} else {

						if ((verificaCpf(campoCpfCnpj.getText().toString()) + validaCnpj(campoCpfCnpj
								.getText().toString())) != 0) {
							JOptionPane
									.showMessageDialog(
											null,
											"Cadastro não concluido\n 			Ja existe um cliente cadastrado com o CPF que esta sendo informado!!");
						} else {
							pessoaFisicaDAO.insira(cadastraClienteFisico());
						}
					}

					limpaCampo();

					// pessoaFisica = new PessoaFisica();
					// endereco = new Endereco();
					// contato = new Contato();
					// telefone = new Telefone();
				}

			}
		});

		botaoCadastrar.setBounds(504, 437, 113, 23);
		contentPane.add(botaoCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/Images16x16/page.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limpaCampo();

			}
		});
		btnLimpar.setBounds(376, 437, 105, 23);
		contentPane.add(btnLimpar);

		JButton botaoAlterar = new JButton("Alterar");
		botaoAlterar.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/Images16x16/page_edit.png")));
		botaoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					chaveDeControle = 1;
					String codigo, nome;

					codigo = (String) tableFisica.getModel().getValueAt(
							tableFisica.getSelectedRow(), 0);
					nome = (String) tableFisica.getModel().getValueAt(
							tableFisica.getSelectedRow(), 1);

					alteraPessoaJuridica(nome, codigo);
					alteraPessoaFisica(nome, codigo);

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Ninguém foi selecionado !");
				}

			}
		});
		botaoAlterar.setBounds(953, 434, 105, 23);
		contentPane.add(botaoAlterar);

		JButton botaoCancelar = new JButton("Excluir");
		botaoCancelar.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/Images16x16/page_remove.png")));
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO criado agora, testa!!
				try {
					String numero = (String) tableFisica.getModel().getValueAt(
							tableFisica.getSelectedRow(), 0);

					manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO
							.listeTodos();

					for (int i = 0; i < manipulaPessoaFisicas.size(); i++) {
						pessoaFisica = manipulaPessoaFisicas.get(i);
						if (pessoaFisica.getId() == Integer.parseInt(numero)) {
							pessoaFisicaDAO.exclua(pessoaFisica);
						}

					}
				} catch (ArrayIndexOutOfBoundsException a1) {
					String numero2 = (String) tableJuridica.getModel()
							.getValueAt(tableJuridica.getSelectedRow(), 0);

					manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO
							.listeTodos();

					for (int i = 0; i < manipulaPessoaJuridica.size(); i++) {
						pessoaJuridica = manipulaPessoaJuridica.get(i);
						if (pessoaJuridica.getId() == Integer.parseInt(numero2)) {
							pessoaJuridicaDAO.exclua(pessoaJuridica);
						}

					}

				} finally {
					limpaTabela();
				}

			}
		});
		botaoCancelar.setBounds(1068, 434, 105, 23);
		contentPane.add(botaoCancelar);
		
		JButton btnNewButton = new JButton("Atualizar Tabelas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posicaoCorreta();
			}
		});
		btnNewButton.setBounds(656, 434, 126, 23);
		contentPane.add(btnNewButton);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {

			if (e.getItem().toString().equalsIgnoreCase("F\u00EDsico")) {
				campoRg.setEnabled(true);
				campoRg.setEditable(true);
				fisico = true;
			} else {
				campoRg.setEnabled(false);
				campoRg.setEditable(false);
				campoRg.setText("");
				fisico = false;
			}

		}

	}

	public void limpaCampo() {

		campoRg.setText("");
		campoEmail.setText("");
		campoCidade.setText("");
		campoCep.setText("");
		campoBairro.setText("");
		campoRua.setText("");
		campoNome.setText("");
		campoCpfCnpj.setText("");
		campoTelefoneCelular.setText("");
		campoNome.setText("");
		campoEstado.setText("");
		campoTelefonefixo.setText("");
		campoComplemento.setText("");

		posicaoCorreta();
	}

	public void limpaTabela() {
		DefaultTableModel model = (DefaultTableModel) tableFisica.getModel();
		model.setNumRows(0);

		model.addRow(new String[] { "", "", "" });
		tabelaSincronizada();
	}

	public void posicaoCorreta() {

		// TUDO
		try {
			manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO
					.listeTodos();
			idFisic = manipulaPessoaFisicas.get(
					manipulaPessoaFisicas.size() - 1).getId();

			idFisic = idFisic + 1;

		} catch (ArrayIndexOutOfBoundsException ai) {
			// System.out.println("1");

		}

		try {
			manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO
					.listeTodos();

			id = manipulaPessoaJuridica.get(manipulaPessoaJuridica.size() - 1)
					.getId();
			id = id + 1;

		} catch (ArrayIndexOutOfBoundsException ai) {
			// System.out.println("2");
		}

		if (id > idFisic) {
			campoCodigo.setText("" + id);
		} else if (id < idFisic) {
			campoCodigo.setText("" + idFisic);
		} else {
			campoCodigo.setText("1");
		}

		tabelaSincronizada();

	}

	public PessoaJuridica cadastraClienteJuridico() {
		pessoaJuridica = new PessoaJuridica();
		endereco = new Endereco();
		telefone = new Telefone();
		contato = new Contato();

		pessoaJuridica.setId(Integer.parseInt(campoCodigo.getText().toString()
				.trim()));
		pessoaJuridica.setNome(campoNome.getText().toString().trim());
		pessoaJuridica.setCnpj(campoCpfCnpj.getText().toString().trim());

		endereco.setBairro(campoBairro.getText().toString().trim());
		endereco.setCep(campoCep.getText().toString().trim());
		endereco.setCidade(campoCidade.getText().toString().trim());
		endereco.setComplemento(campoComplemento.getText().toString().trim());
		endereco.setEstado(campoEstado.getText().toString().trim());
		endereco.setRua(campoRua.getText().toString().trim());

		pessoaJuridica.setEndereco(endereco);

		telefone.setTelefoneFixo(campoTelefonefixo.getText().toString().trim());
		telefone.setTelefoneCel(campoTelefoneCelular.getText().toString()
				.trim());

		contato.setTelefone(telefone);
		contato.setEmail(campoEmail.getText().toString().trim());

		pessoaJuridica.setContato(contato);

		return pessoaJuridica;
	}

	public PessoaFisica cadastraClienteFisico() {
		pessoaFisica = new PessoaFisica();
		endereco = new Endereco();
		telefone = new Telefone();
		contato = new Contato();

		pessoaFisica.setId(Integer.parseInt(campoCodigo.getText().toString()
				.trim()));
		pessoaFisica.setNome(campoNome.getText().toString().trim());
		pessoaFisica.setCpf(campoCpfCnpj.getText().toString().trim());
		pessoaFisica.setRg(campoRg.getText().toString().trim());
		endereco.setBairro(campoBairro.getText().toString().trim());
		endereco.setCep(campoCep.getText().toString().trim());
		endereco.setCidade(campoCidade.getText().toString().trim());
		endereco.setComplemento(campoComplemento.getText().toString().trim());
		endereco.setEstado(campoEstado.getText().toString().trim());
		endereco.setRua(campoRua.getText().toString().trim());

		pessoaFisica.setEndereco(endereco);

		telefone.setTelefoneFixo(campoTelefonefixo.getText().toString().trim());
		telefone.setTelefoneCel(campoTelefoneCelular.getText().toString()
				.trim());

		contato.setTelefone(telefone);
		contato.setEmail(campoEmail.getText().toString().trim());

		pessoaFisica.setContato(contato);

		return pessoaFisica;
	}

	public void alteraPessoaJuridica(String nome, String codigo) {
		manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO
				.listeTodos();

		for (int i = 0; i < manipulaPessoaJuridica.size(); i++) {
			if (manipulaPessoaJuridica.get(i).getNome()
					.equalsIgnoreCase(nome.toString().trim())
					&& manipulaPessoaJuridica.get(i).getId() == Integer
							.parseInt(codigo)) {

				campoCodigo.setText("" + manipulaPessoaJuridica.get(i).getId());
				campoNome.setText("" + manipulaPessoaJuridica.get(i).getNome());
				campoBairro.setText(""
						+ manipulaPessoaJuridica.get(i).getEndereco()
								.getBairro());
				campoCep.setText(""
						+ manipulaPessoaJuridica.get(i).getEndereco().getCep());
				campoCidade.setText(""
						+ manipulaPessoaJuridica.get(i).getEndereco()
								.getCidade());
				campoComplemento.setText(""
						+ manipulaPessoaJuridica.get(i).getEndereco()
								.getComplemento());
				campoCpfCnpj.setText(""
						+ manipulaPessoaJuridica.get(i).getCnpj());
				campoEmail
						.setText(""
								+ manipulaPessoaJuridica.get(i).getContato()
										.getEmail());
				campoEstado.setText(""
						+ manipulaPessoaJuridica.get(i).getEndereco()
								.getEstado());
				campoRua.setText(""
						+ manipulaPessoaJuridica.get(i).getEndereco().getRua());
				campoTelefoneCelular.setText(""
						+ manipulaPessoaJuridica.get(i).getContato()
								.getTelefone().getTelefoneCel());
				campoTelefonefixo.setText(""
						+ manipulaPessoaJuridica.get(i).getContato()
								.getTelefone().getTelefoneFixo());

			}
		}
		limpaTabela();
	}

	public void alteraPessoaFisica(String nome, String codigo) {

		manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO
				.listeTodos();

		for (int i = 0; i < manipulaPessoaFisicas.size(); i++) {
			if (manipulaPessoaFisicas.get(i).getNome()
					.equalsIgnoreCase(nome.toString().trim())
					&& manipulaPessoaFisicas.get(i).getId() == Integer
							.parseInt(codigo)) {

				campoCodigo.setText("" + manipulaPessoaFisicas.get(i).getId());
				campoNome.setText("" + manipulaPessoaFisicas.get(i).getNome());
				campoBairro.setText(""
						+ manipulaPessoaFisicas.get(i).getEndereco()
								.getBairro());
				campoCep.setText(""
						+ manipulaPessoaFisicas.get(i).getEndereco().getCep());
				campoCidade.setText(""
						+ manipulaPessoaFisicas.get(i).getEndereco()
								.getCidade());
				campoComplemento.setText(""
						+ manipulaPessoaFisicas.get(i).getEndereco()
								.getComplemento());
				campoCpfCnpj
						.setText("" + manipulaPessoaFisicas.get(i).getCpf());
				campoRg.setText("" + manipulaPessoaFisicas.get(i).getRg());// diferencial!!
				campoEmail.setText(""
						+ manipulaPessoaFisicas.get(i).getContato().getEmail());
				campoEstado.setText(""
						+ manipulaPessoaFisicas.get(i).getEndereco()
								.getEstado());
				campoRua.setText(""
						+ manipulaPessoaFisicas.get(i).getEndereco().getRua());
				campoTelefoneCelular.setText(""
						+ manipulaPessoaFisicas.get(i).getContato()
								.getTelefone().getTelefoneCel());
				campoTelefonefixo.setText(""
						+ manipulaPessoaFisicas.get(i).getContato()
								.getTelefone().getTelefoneFixo());

				campoRg.setEditable(true);
				campoRg.setEnabled(true);

			}
		}
		limpaTabela();

	}

	public void tabelaSincronizada() {
		try {
			DefaultTableModel model = (DefaultTableModel) tableFisica
					.getModel();
			model.setNumRows(0);

			DefaultTableModel model2 = (DefaultTableModel) tableJuridica
					.getModel();
			model2.setNumRows(0);

			manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO
					.listeTodos();

			for (int i = 0; i < manipulaPessoaFisicas.size(); i++) {

				model.addRow(new String[] {
						"" + manipulaPessoaFisicas.get(i).getId(),
						"" + manipulaPessoaFisicas.get(i).getNome(),
						""
								+ manipulaPessoaFisicas.get(i).getContato()
										.getTelefone().getTelefoneFixo() });

			}

			manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO
					.listeTodos();

			for (int i = 0; i < manipulaPessoaJuridica.size(); i++) {

				model2.addRow(new String[] {
						"" + manipulaPessoaJuridica.get(i).getId(),
						"" + manipulaPessoaJuridica.get(i).getNome(),
						""
								+ manipulaPessoaJuridica.get(i).getContato()
										.getTelefone().getTelefoneFixo() });

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int verificaCpf(String test) {
		int valida = 0;

		manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO
				.listeTodos();

		for (int i = 0; i < manipulaPessoaFisicas.size(); i++) {

			if (manipulaPessoaFisicas.get(i).getCpf().equalsIgnoreCase(test)) {
				valida = 1;

				break;
			} else {
				valida = 0;
			}
		}
		System.out.println(valida);
		return valida;

	}

	public int validaCnpj(String test) {
		int valida = 0;

		manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO
				.listeTodos();

		for (int i = 0; i < manipulaPessoaJuridica.size(); i++) {

			if (manipulaPessoaJuridica.get(i).getCnpj().equalsIgnoreCase(test)) {
				valida = 1;

				break;
			} else {
				valida = 0;
			}
		}
		System.out.println(valida);
		return valida;
	}
}
