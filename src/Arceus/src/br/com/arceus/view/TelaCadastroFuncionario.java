package Arceus.src.br.com.arceus.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JFormattedTextField campoDataDeCadastro;
	private JTextField campoRua;
	private JTextField campoBairro;
	private JTextField campoCidade;
	private JTextField campoCep;
	private JTextField campoTelefone1;
	private JTextField campoNumeroCelular;
	private JTextField campoEmail;
	private JTextField campoPesquisa;
	private JTextField campoSalario;
	private JTextField campoSenha;
	private JTable table;
	private JTextField campoCodigo;
	private JComboBox boxTipoPesquisa;
	
	GerenciadorDeConeccoes gc = new GerenciadorDeConeccoes();

	int cod = gc.getCodigo();

	public TelaCadastroFuncionario() {

		setResizable(false);
		setTitle("Cadastro de Funcion\u00E1rios");

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

		JLabel lblNewLabel = new JLabel("F u n c i o n \u00E1 r i o s");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 351, 34);
		panel.add(lblNewLabel);

		JPanel painelDeComponentes = new JPanel();
		painelDeComponentes.setBorder(new TitledBorder(null,
				"D a d o s   C a d a s t r a i s", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		painelDeComponentes.setBounds(10, 114, 607, 309);
		contentPane.add(painelDeComponentes);
		painelDeComponentes.setLayout(null);

		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(10, 33, 37, 14);
		painelDeComponentes.add(labelNome);

		campoNome = new JTextField();
		campoNome.setBounds(57, 30, 261, 20);
		painelDeComponentes.add(campoNome);
		campoNome.setColumns(10);

		JLabel labelDataDeCadastro = new JLabel("Data de Admiss\u00E3o");
		labelDataDeCadastro.setBounds(10, 62, 109, 14);
		painelDeComponentes.add(labelDataDeCadastro);

		try {
			campoDataDeCadastro = new JFormattedTextField(new MaskFormatter(
					"##/##/####"));
			campoDataDeCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		campoDataDeCadastro.setBounds(122, 59, 70, 20);
		painelDeComponentes.add(campoDataDeCadastro);
		campoDataDeCadastro.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 115, 587, 2);
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
		campoCidade.setBounds(341, 70, 202, 20);
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
		lblTelefone.setBounds(10, 14, 57, 14);
		fichaContatoCliente.add(lblTelefone);

		campoTelefone1 = new JTextField();
		campoTelefone1.setBounds(74, 14, 121, 20);
		fichaContatoCliente.add(campoTelefone1);
		campoTelefone1.setColumns(10);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 45, 57, 14);
		fichaContatoCliente.add(lblCelular);

		campoNumeroCelular = new JTextField();
		campoNumeroCelular.setColumns(10);
		campoNumeroCelular.setBounds(74, 43, 121, 20);
		fichaContatoCliente.add(campoNumeroCelular);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 73, 46, 14);
		fichaContatoCliente.add(lblEmail);

		campoEmail = new JTextField();
		campoEmail.setBounds(74, 73, 345, 20);
		fichaContatoCliente.add(campoEmail);
		campoEmail.setColumns(10);

		JLabel lblSalrio = new JLabel("Sal\u00E1rio");
		lblSalrio.setBounds(204, 63, 52, 14);
		painelDeComponentes.add(lblSalrio);

		campoSalario = new JTextField();
		campoSalario.setBounds(248, 59, 70, 20);
		painelDeComponentes.add(campoSalario);
		campoSalario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(319, 61, 46, 14);
		painelDeComponentes.add(lblSenha);

		final JComboBox sexo = new JComboBox();
		sexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino",
				"Feminino" }));
		sexo.setBounds(497, 28, 100, 20);
		painelDeComponentes.add(sexo);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setBounds(446, 31, 46, 14);
		painelDeComponentes.add(lblSexo);

		JLabel Setor = new JLabel("Setor");
		Setor.setHorizontalAlignment(SwingConstants.RIGHT);
		Setor.setBounds(446, 62, 46, 14);
		painelDeComponentes.add(Setor);

		final JComboBox campoSetor = new JComboBox();
		campoSetor.setModel(new DefaultComboBoxModel(new String[] {
				"Atendimento", "Criação", "Financeiro", "Produção", "Midia" }));
		campoSetor.setBounds(497, 57, 100, 20);
		painelDeComponentes.add(campoSetor);

		campoSenha = new JTextField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(370, 59, 70, 20);
		painelDeComponentes.add(campoSenha);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(319, 32, 46, 14);
		painelDeComponentes.add(lblCodigo);

		campoCodigo = new JTextField();
		campoCodigo.setEditable(false);
		campoCodigo.setColumns(10);
		campoCodigo.setBounds(370, 30, 70, 20);
		painelDeComponentes.add(campoCodigo);

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
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"CODIGO", "NOME", "EMAIL", "CARGO"
			}
		));
		table.setBounds(12, 12, 484, 270);
		panel_3.add(table);

		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(121, 20, 291, 20);
		panel_2.add(campoPesquisa);
		campoPesquisa.setColumns(10);

		final String modelo[] = {"Cliente","Codigo"};
		boxTipoPesquisa = new JComboBox(modelo);		
		boxTipoPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoPesquisa.setText("");
			}
		});
		boxTipoPesquisa.setBounds(10, 20, 101, 20);
		panel_2.add(boxTipoPesquisa);
		
		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modelo[boxTipoPesquisa.getSelectedIndex()].equalsIgnoreCase("Cliente")){
				
				gc.exibir("select * from pessoa where nome LIKE ?", "%"+campoPesquisa
						.getText().toString().trim()+"%"
						+ "", table);// lembrar de conectar com o
				// campo q recebe o nome a
				// ser pesquisado!
				}else{
					try {
						int aux = Integer.parseInt(campoPesquisa.getText().toString().trim());
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "Informar apenas numero");
					}
					gc.exibir("select * from pessoa where ID_PESSOA = ?", campoPesquisa
							.getText().toString().trim()
							+ "", table);
				}

			}
		});
		botaoPesquisar.setBounds(424, 17, 94, 23);
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
		botaoVoltar.setBounds(320, 437, 91, 23);
		contentPane.add(botaoVoltar);

		campoCodigo.setText(cod + "");// cria o codigo e o coloca na variavel

		JButton botaoCadastrar = new JButton("OK");
		botaoCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int idSetor = campoSetor.getSelectedIndex() + 1;
				String sexoP = "";
				if (sexo.getSelectedIndex() == 0) {
					sexoP = "M";
				} else {
					sexoP = "F";
				}

				gc.cadastrar(
						"insert into pessoa (E_MAIL, CIDADE, CEP, BAIRRO, RUA, NOME, ID_PESSOA) VALUES(?,?,?,?,?,?,?)",
						"" + campoEmail.getText().toString().trim() + "#"
								+ campoCidade.getText().toString().trim() + "#"
								+ campoCep.getText().toString().trim() + "#"
								+ campoBairro.getText().toString().trim() + "#"
								+ campoRua.getText().toString().trim() + "#"
								+ campoNome.getText().toString().trim() + "#"
								+ campoCodigo.getText().toString().trim() + "");

				gc.cadastrar(
						"insert into funcionario(SENHA_FUNC, SALARIO, SEXO, ID_SETOR, ID_PESSOA) VALUES (?,?,?,?,?)",
						"" + campoSenha.getText().toString().trim() + "#"
								+ campoSalario.getText().toString().trim()
								+ "#" + sexoP + "#" + idSetor + "#"
								+ campoCodigo.getText().toString().trim() + "");
				gc.cadastrar(
						"insert into telefones (TELEFONE_CEL, TELEFONE, ID_PESSOA) VALUES(?,?,?)",
						""

						+ campoNumeroCelular.getText().toString().trim() + "#"

						+ campoTelefone1.getText().toString().trim() + "#"
								+ campoCodigo.getText().toString().trim() + "");

				gc.cadastrar(
						"insert into cadastra (DATA_ADMISSAO, ID_SETOR, ID_PESSOA) VALUES(?,?,?)",
						"" + campoDataDeCadastro.getText().toString().trim()
								+ "#" + idSetor + "#"
								+ campoCodigo.getText().toString().trim() + "");

				campoCodigo.setText((Integer.parseInt(campoCodigo.getText()
						.toString()) + 1) + ""); // atualiza o codigo

				JOptionPane.showMessageDialog(null,
						"Usuario " + campoNome.getText()
								+ " cadastrado com sucesso");

				campoNome.setText("");

				campoDataDeCadastro.setText("");
				campoSalario.setText("");
				campoSenha.setText("");
				campoRua.setText("");
				campoBairro.setText("");
				campoCidade.setText("");
				campoCep.setText("");
				campoTelefone1.setText("");
				campoNumeroCelular.setText("");
				campoEmail.setText("");

			}
		});

		botaoCadastrar.setBounds(526, 437, 91, 23);
		contentPane.add(botaoCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNome.setText("");
				campoCodigo.setText("");
				campoDataDeCadastro.setText("");
				campoSalario.setText("");
				campoSenha.setText("");
				campoRua.setText("");
				campoBairro.setText("");
				campoCidade.setText("");
				campoCep.setText("");
				campoTelefone1.setText("");
				campoNumeroCelular.setText("");
				campoEmail.setText("");

			}
		});
		btnLimpar.setBounds(423, 437, 91, 23);
		contentPane.add(btnLimpar);

		JButton botaoAtualizar = new JButton("Alterar");
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo, nome, email;
				try {
					codigo = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 0);
					nome = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 1);
					email = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 2);

					campoCodigo.setText(codigo + "");
					campoNome.setText(nome + "");
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
		botaoAtualizar.setBounds(990, 435, 91, 23);
		contentPane.add(botaoAtualizar);

		JButton boatoExcluir = new JButton("Excluir");
		boatoExcluir.addActionListener(new ActionListener() {
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
		boatoExcluir.setBounds(1093, 435, 89, 23);
		contentPane.add(boatoExcluir);
	}

}
