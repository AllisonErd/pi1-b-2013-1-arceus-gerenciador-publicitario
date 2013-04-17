package Arceus.src.br.com.arceus.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Arceus.src.br.com.arceus.controll.GerenciadorDeConeccoes;
import java.awt.Scrollbar;

public class TelaCadastroCliente extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JTextField campoNomeCliente;
	private JTextField campoCodigoCliente;
	private JTextField campoCpfCnpj;
	private JTextField campoRua;
	private JTextField campoBairro;
	private JTextField campoCidade;
	private JTextField campoCep;
	private JTextField campoTelefonefixo;
	private JTextField campoNumeroCelular;
	private JTextField campoEmail;
	private JTextField campoPesquisa;
	private JComboBox sexo;
	private JComboBox boxTipoCliente;
	private JTable table;
	private JComboBox boxTipoPesquisa;

	GerenciadorDeConeccoes gc = new GerenciadorDeConeccoes();

	private int cod = gc.getCodigo("select id_pessoa from pessoa order by id_pessoa desc limit 1"
			,"ID_PESSOA");
	private int activate = 0;
	private JFormattedTextField campoData;

	public TelaCadastroCliente() {
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

		JLabel lblNewLabel = new JLabel("C l i e n t e s");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 234, 34);
		panel.add(lblNewLabel);

		JPanel painelDeComponentes = new JPanel();
		painelDeComponentes.setBorder(new TitledBorder(null,
				"D a d o s   C a d a s t r a i s", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		painelDeComponentes.setBounds(10, 114, 607, 309);
		contentPane.add(painelDeComponentes);
		painelDeComponentes.setLayout(null);

		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(10, 34, 46, 14);
		painelDeComponentes.add(labelNome);

		campoNomeCliente = new JTextField();
		campoNomeCliente.setBounds(55, 28, 249, 20);
		painelDeComponentes.add(campoNomeCliente);
		campoNomeCliente.setColumns(10);

		JLabel labelCodigo = new JLabel("Codigo");
		labelCodigo.setBounds(505, 31, 46, 14);
		painelDeComponentes.add(labelCodigo);

		campoCodigoCliente = new JTextField();
		campoCodigoCliente.setEditable(false);
		campoCodigoCliente.setBounds(551, 28, 46, 20);
		painelDeComponentes.add(campoCodigoCliente);
		campoCodigoCliente.setColumns(10);

		
		
		boxTipoCliente = new JComboBox();
		boxTipoCliente.setModel(new DefaultComboBoxModel(new String[] {
				"---","F\u00EDsico", "Jur\u00EDdico" }));

		boxTipoCliente.addItemListener(this);

		boxTipoCliente.setBounds(111, 60, 63, 20);
		painelDeComponentes.add(boxTipoCliente);

		JLabel lblTipoDeCliente = new JLabel("Tipo de Cliente");
		lblTipoDeCliente.setBounds(10, 63, 83, 14);
		painelDeComponentes.add(lblTipoDeCliente);

		campoCpfCnpj = new JTextField();
		campoCpfCnpj.setBounds(273, 60, 106, 20);
		painelDeComponentes.add(campoCpfCnpj);
		campoCpfCnpj.setColumns(10);

		JLabel labelSexo = new JLabel("Sexo");
		labelSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSexo.setBounds(433, 63, 46, 14);
		painelDeComponentes.add(labelSexo);

		JLabel labelDataDeCadastro = new JLabel("Data de Cadastro");
		labelDataDeCadastro.setBounds(318, 31, 100, 14);
		painelDeComponentes.add(labelDataDeCadastro);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 116, 587, 2);
		painelDeComponentes.add(separator);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 129, 587, 169);
		painelDeComponentes.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Endere\u00E7o", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(44, 48, 46, 14);
		panel_1.add(lblRua);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(44, 76, 46, 14);
		panel_1.add(lblBairro);

		campoRua = new JTextField();
		campoRua.setBounds(95, 45, 448, 20);
		panel_1.add(campoRua);
		campoRua.setColumns(10);

		campoBairro = new JTextField();
		campoBairro.setBounds(95, 70, 187, 20);
		panel_1.add(campoBairro);
		campoBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(292, 76, 46, 14);
		panel_1.add(lblCidade);

		campoCidade = new JTextField();
		campoCidade.setBounds(331, 70, 212, 20);
		panel_1.add(campoCidade);
		campoCidade.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(44, 104, 46, 14);
		panel_1.add(lblCep);

		campoCep = new JTextField();
		campoCep.setBounds(95, 98, 187, 20);
		panel_1.add(campoCep);
		campoCep.setColumns(10);

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

		campoNumeroCelular = new JTextField();
		campoNumeroCelular.setColumns(10);
		campoNumeroCelular.setBounds(96, 66, 121, 20);
		fichaContatoCliente.add(campoNumeroCelular);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(44, 100, 46, 14);
		fichaContatoCliente.add(lblEmail);

		campoEmail = new JTextField();
		campoEmail.setBounds(96, 97, 345, 20);
		fichaContatoCliente.add(campoEmail);
		campoEmail.setColumns(10);

		sexo = new JComboBox(new DefaultComboBoxModel(new String[] {
				"Masculino", "Feminino" }));
		sexo.setBounds(497, 60, 100, 20);
		painelDeComponentes.add(sexo);

		JFormattedTextField formattedTextField = null;
		try {
			campoData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		campoData.setHorizontalAlignment(SwingConstants.CENTER);
		campoData.setColumns(10);
		campoData.setBounds(423, 28, 70, 20);
		painelDeComponentes.add(campoData);

		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setBounds(192, 63, 63, 14);
		painelDeComponentes.add(lblCpfcnpj);

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

		/*
		 * Henrique...Esse Painel aqui tá vazio propositalmete. Pelo simples
		 * fato de definirmos o que agente vai por nele. Pq pus uma Tabela e não
		 * ficou muito legal, mas...pra vc ir trabalhando vai assim mesmo. Vê aê
		 * o que fica melhor!
		 */
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_3.setBounds(10, 51, 508, 294);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null,
				null }, }, new String[] { "New column", "New column",
				"New column" }));
		table.setBounds(12, 12, 484, 270);
		panel_3.add(table);

		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(121, 20, 293, 20);
		panel_2.add(campoPesquisa);
		campoPesquisa.setColumns(10);
		final String items[] = { "Nome","Codigo" };

		boxTipoPesquisa = new JComboBox(items);

		boxTipoPesquisa.setBounds(10, 20, 101, 20);
		panel_2.add(boxTipoPesquisa);
		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (items[boxTipoPesquisa.getSelectedIndex()]
						.equalsIgnoreCase("Nome")) {

					gc.exibir("select * from pessoa where nome LIKE ?", "%"
							+ campoPesquisa.getText().toString().trim() + "%"
							+ "", table);// lembrar de conectar com o
					// campo q recebe o nome a
					// ser pesquisado!
				} else {
					try {
						int aux = Integer.parseInt(campoPesquisa.getText()
								.toString().trim());
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,
								"Informar apenas numero");
					}
					gc.exibir("select * from pessoa where ID_PESSOA = ?",
							campoPesquisa.getText().toString().trim() + "",
							table);
				}

			}
		});
		botaoPesquisar.setBounds(426, 17, 92, 23);
		panel_2.add(botaoPesquisar);

		JButton botaoNovoCadastro = new JButton("Novo");
		botaoNovoCadastro.setBounds(10, 67, 89, 23);
		contentPane.add(botaoNovoCadastro);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botaoVoltar.setBounds(299, 437, 98, 23);
		contentPane.add(botaoVoltar);

		campoCodigoCliente.setText(cod + "");// cria o codigo e o coloca na
												// variavel

		JButton botaoCadastrar = new JButton("OK");
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sexoP = "";
				if (sexo.getSelectedIndex() == 0) {
					sexoP = "M";
				} else {
					sexoP = "F";
				}

				gc.cadastrar(
						"insert into pessoa (E_MAIL, CIDADE, CEP, BAIRRO, RUA, NOME, ID_PESSOA) VALUES(?,?,?,?,?,?,?)",
						""
								+ campoEmail.getText().toString().trim()
								+ "#"
								+ campoCidade.getText().toString().trim()
								+ "#"
								+ campoCep.getText().toString().trim()
								+ "#"
								+ campoBairro.getText().toString().trim()
								+ "#"
								+ campoRua.getText().toString().trim()
								+ "#"
								+ campoNomeCliente.getText().toString().trim()
								+ "#"
								+ campoCodigoCliente.getText().toString()
										.trim() + "");

				gc.cadastrar("insert into cliente (ID_PESSOA) VALUES(?)", ""
						+ campoCodigoCliente.getText().toString().trim() + "");
				if (activate == 1) {
					gc.cadastrar(
							"insert into clientefisico (SEXO, CPF, ID_PESSOA) VALUES (?,?,?)",
							""
									+ sexoP
									+ "#"
									+ campoCpfCnpj.getText().toString().trim()
									+ "#"
									+ campoCodigoCliente.getText().toString()
											.trim() + "");
				} else {
					gc.cadastrar(
							"insert into clientejuridico (CNPJ, ID_PESSOA) VALUES (?,?)",
							""
									+ campoCpfCnpj.getText().toString().trim()
									+ "#"
									+ campoCodigoCliente.getText().toString()
											.trim() + "");
				}
				gc.cadastrar(
						"insert into cadastra (DATA_ADMISSAO, ID_SETOR, ID_PESSOA) VALUES(?,?,?)",
						""
								+ campoData.getText().toString().trim()
								+ "#6#"
								+ campoCodigoCliente.getText().toString()
										.trim() + "");

				gc.cadastrar(
						"insert into telefones (TELEFONE_CEL, TELEFONE, ID_PESSOA) VALUES(?,?,?)",
						""

								+ campoNumeroCelular.getText().toString()
										.trim()
								+ "#"

								+ campoTelefonefixo.getText().toString().trim()
								+ "#"
								+ campoCodigoCliente.getText().toString()
										.trim() + "");

				campoCodigoCliente.setText((Integer.parseInt(campoCodigoCliente
						.getText().toString()) + 1) + ""); // atualiza o codigo

				JOptionPane.showMessageDialog(null, "Cliente "
						+ campoNomeCliente.getText()
						+ " cadastrado com sucesso");

				campoEmail.setText("");
				campoCidade.setText("");
				campoCep.setText("");
				campoBairro.setText("");
				campoRua.setText("");
				campoNomeCliente.setText("");
				campoCpfCnpj.setText("");
				campoNumeroCelular.setText("");
				campoNomeCliente.setText("");
				campoData.setText("");
				campoTelefonefixo.setText("");
			}
		});
		botaoCadastrar.setBounds(519, 437, 98, 23);
		contentPane.add(botaoCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoEmail.setText("");
				campoCidade.setText("");
				campoCep.setText("");
				campoBairro.setText("");
				campoRua.setText("");
				campoNomeCliente.setText("");
				campoCpfCnpj.setText("");
				campoNumeroCelular.setText("");
				campoNomeCliente.setText("");
				campoData.setText("");
				campoTelefonefixo.setText("");
			}
		});
		btnLimpar.setBounds(409, 437, 98, 23);
		contentPane.add(btnLimpar);

		JButton botaoAlterar = new JButton("Alterar");
		botaoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo, nome, email;
				try {
					codigo = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 0);
					nome = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 1);
					email = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 2);

					campoCodigoCliente.setText(codigo + "");
					campoNomeCliente.setText(nome + "");
					campoEmail.setText(email + "");

					gc.excluir("delete from telefones where ID_PESSOA = ? ",
							table); // melhorar//
									// esse
									// codigo
					gc.excluir("delete from funcionario where ID_PESSOA = ? ",
							table);
					gc.excluir("delete from cadastra where ID_PESSOA = ? ",
							table);

					gc.excluir("delete from pessoa where ID_PESSOA = ? ", table);
				} catch (ArrayIndexOutOfBoundsException excep) {
					JOptionPane.showMessageDialog(null,
							"Selecione alguem na lista");
				}
			}
		});
		botaoAlterar.setBounds(992, 435, 89, 23);
		contentPane.add(botaoAlterar);

		JButton botaoCancelar = new JButton("Excluir");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gc.excluir("delete from telefones where ID_PESSOA = ? ", table); // melhorar//
				// esse
				// codigo

				gc.excluir("delete from cadastra where ID_PESSOA = ? ", table);

				gc.excluir("delete from funcionario where ID_PESSOA = ? ",
						table);

				gc.excluir("delete from pessoa where ID_PESSOA = ? ", table);

				JOptionPane.showMessageDialog(null, "Excluido com sucesso");
			}
		});
		botaoCancelar.setBounds(1093, 435, 89, 23);
		contentPane.add(botaoCancelar);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {

			if (e.getItem().toString().equalsIgnoreCase("F\u00EDsico")) {
				sexo.setEnabled(true);
				activate = 1;
			} else {
				sexo.setEnabled(false);

			}

		}

	}
}
