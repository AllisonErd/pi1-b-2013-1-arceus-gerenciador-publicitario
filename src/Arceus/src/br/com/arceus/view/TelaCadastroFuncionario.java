package Arceus.src.br.com.arceus.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JPasswordField;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField campoNomeCliente;
	private JTextField campoCodigoCliente;
	private JTextField campoCpfCnpj;
	private JTextField campoDataDeCadastro;
	private JTextField campoRua;
	private JTextField campoBairro;
	private JTextField campoCidade;
	private JTextField campoCep;
	private JTextField campoDdd1;
	private JTextField campoTelefone1;
	private JTextField campoDddCelular;
	private JTextField campoNumeroCelular;
	private JTextField campoEmail;
	private JTextField campoPesquisa;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroFuncionario() {
		setResizable(false);
		setTitle("Cadastro de Funcion\u00E1rios");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		painelDeComponentes.setBorder(new TitledBorder(null, "D a d o s   C a d a s t r a i s", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		painelDeComponentes.setBounds(10, 114, 607, 309);
		contentPane.add(painelDeComponentes);
		painelDeComponentes.setLayout(null);
		
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(10, 34, 46, 14);
		painelDeComponentes.add(labelNome);
		
		campoNomeCliente = new JTextField();
		campoNomeCliente.setBounds(66, 28, 398, 20);
		painelDeComponentes.add(campoNomeCliente);
		campoNomeCliente.setColumns(10);
		
		JLabel labelCodigo = new JLabel("Codigo");
		labelCodigo.setBounds(474, 31, 46, 14);
		painelDeComponentes.add(labelCodigo);
		
		campoCodigoCliente = new JTextField();
		campoCodigoCliente.setBounds(520, 28, 77, 20);
		painelDeComponentes.add(campoCodigoCliente);
		campoCodigoCliente.setColumns(10);
		
		campoCpfCnpj = new JTextField();
		campoCpfCnpj.setBounds(520, 59, 77, 20);
		painelDeComponentes.add(campoCpfCnpj);
		campoCpfCnpj.setColumns(10);
		
		JLabel labelSexo = new JLabel("Sexo");
		labelSexo.setBounds(10, 91, 46, 14);
		painelDeComponentes.add(labelSexo);
		
		JRadioButton radioMasculino = new JRadioButton("Masculino");
		radioMasculino.setBounds(66, 87, 82, 23);
		painelDeComponentes.add(radioMasculino);
		
		JRadioButton radioFeminino = new JRadioButton("Feminino");
		radioFeminino.setBounds(159, 87, 109, 23);
		painelDeComponentes.add(radioFeminino);
		
		JLabel labelDataDeCadastro = new JLabel("Data de Admiss\u00E3o");
		labelDataDeCadastro.setBounds(10, 65, 91, 14);
		painelDeComponentes.add(labelDataDeCadastro);
		
		campoDataDeCadastro = new JTextField();
		campoDataDeCadastro.setBounds(111, 59, 123, 20);
		painelDeComponentes.add(campoDataDeCadastro);
		campoDataDeCadastro.setColumns(10);
		
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
		lblTelefone.setBounds(10, 14, 57, 14);
		fichaContatoCliente.add(lblTelefone);
		
		campoDdd1 = new JTextField();
		campoDdd1.setBounds(62, 8, 34, 20);
		fichaContatoCliente.add(campoDdd1);
		campoDdd1.setColumns(10);
		
		campoTelefone1 = new JTextField();
		campoTelefone1.setBounds(111, 8, 121, 20);
		fichaContatoCliente.add(campoTelefone1);
		campoTelefone1.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setBounds(100, 14, 16, 14);
		fichaContatoCliente.add(label);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 45, 57, 14);
		fichaContatoCliente.add(lblCelular);
		
		campoDddCelular = new JTextField();
		campoDddCelular.setColumns(10);
		campoDddCelular.setBounds(62, 39, 34, 20);
		fichaContatoCliente.add(campoDddCelular);
		
		JLabel label_2 = new JLabel("-");
		label_2.setBounds(100, 45, 16, 14);
		fichaContatoCliente.add(label_2);
		
		campoNumeroCelular = new JTextField();
		campoNumeroCelular.setColumns(10);
		campoNumeroCelular.setBounds(111, 39, 121, 20);
		fichaContatoCliente.add(campoNumeroCelular);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 73, 46, 14);
		fichaContatoCliente.add(lblEmail);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(62, 70, 345, 20);
		fichaContatoCliente.add(campoEmail);
		campoEmail.setColumns(10);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio");
		lblSalrio.setBounds(244, 65, 37, 14);
		painelDeComponentes.add(lblSalrio);
		
		textField = new JTextField();
		textField.setBounds(291, 59, 86, 20);
		painelDeComponentes.add(textField);
		textField.setColumns(10);
		
		JLabel lblTempoNaEmpresa = new JLabel("Tempo na empresa");
		lblTempoNaEmpresa.setBounds(420, 62, 100, 14);
		painelDeComponentes.add(lblTempoNaEmpresa);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(464, 91, 46, 14);
		painelDeComponentes.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(520, 90, 77, 20);
		painelDeComponentes.add(passwordField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(644, 67, 2, 393);
		contentPane.add(separator_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "P e s q u i s a r", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(656, 67, 528, 356);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		/*
		 * Henrique...Esse Painel aqui tá vazio propositalmete. Pelo simples fato de definirmos
		 * o que agente vai por nele. Pq pus uma Tabela e não ficou muito legal, mas...pra vc ir trabalhando
		 * vai assim mesmo. Vê aê o que fica melhor!
		 * 
		 */
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 51, 508, 294);
		panel_2.add(panel_3);
		
		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(121, 20, 298, 20);
		panel_2.add(campoPesquisa);
		campoPesquisa.setColumns(10);
		
		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.setBounds(429, 17, 89, 23);
		panel_2.add(botaoPesquisar);
		
		JComboBox boxTipoPesquisa = new JComboBox();
		boxTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Cliente"}));
		boxTipoPesquisa.setBounds(10, 20, 101, 20);
		panel_2.add(boxTipoPesquisa);
		
		JButton botaoNovoCadastro = new JButton("Novo");
		botaoNovoCadastro.setBounds(10, 67, 89, 23);
		contentPane.add(botaoNovoCadastro);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(20, 437, 89, 23);
		contentPane.add(botaoVoltar);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(528, 437, 89, 23);
		contentPane.add(botaoCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(279, 437, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton botaoAlterar = new JButton("Alterar");
		botaoAlterar.setBounds(1095, 434, 89, 23);
		contentPane.add(botaoAlterar);
		
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(656, 437, 89, 23);
		contentPane.add(botaoCancelar);
	}
}
