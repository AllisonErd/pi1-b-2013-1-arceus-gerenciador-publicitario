package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



public class TelaAtendimento extends JFrame {

	private JPanel contentPane;
	private JTextField campoCodigoProjeto;
	private JTextField campoNomeProjeto;
	private JTextField campoDataEntrega;
	private JTextField campoDataEmissao;
	private JTable table_1;
	private JTextField campoNomeCliente;
	private String cliente;
	private String codigo;

	


	
	private JTable tabelaCliente;
	private JTextField campoValorProjeto;

	public TelaAtendimento() {
		setTitle("Setor de Atendimento");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1194, 56);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("A t e n d i m e n t o");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 290, 34);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "C l i e n t e",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 122, 413, 56);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		tabelaCliente = new JTable();
		tabelaCliente.setEnabled(false);
		tabelaCliente.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column" }));
		tabelaCliente.setBounds(10, 21, 393, 16);
		panel_1.add(tabelaCliente);

		JButton btnNovo = new JButton("Pesquisar Cliente");

		btnNovo.setBounds(145, 92, 154, 23);
		contentPane.add(btnNovo);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(433, 78, 18, 393);
		contentPane.add(separator);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Observa\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 190, 413, 150);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "P r o j e t o",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(441, 95, 743, 365);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNomeDoProjeto = new JLabel("Nome do Projeto");
		lblNomeDoProjeto.setBounds(20, 29, 106, 14);
		panel_3.add(lblNomeDoProjeto);

		campoNomeProjeto = new JTextField();
		campoNomeProjeto.setBounds(126, 26, 382, 20);
		panel_3.add(campoNomeProjeto);
		campoNomeProjeto.setColumns(10);

		JLabel lblTermino = new JLabel("Entrega do Projeto");
		lblTermino.setBounds(237, 58, 106, 14);
		panel_3.add(lblTermino);

		campoDataEntrega = new JTextField();
		campoDataEntrega.setBounds(361, 55, 86, 20);
		panel_3.add(campoDataEntrega);
		campoDataEntrega.setColumns(10);

		JLabel lblDataDaEmisso = new JLabel("Data da Emiss\u00E3o:");
		lblDataDaEmisso.setBounds(20, 61, 98, 14);
		panel_3.add(lblDataDaEmisso);

		campoDataEmissao = new JTextField();
		campoDataEmissao.setBounds(126, 55, 86, 20);
		panel_3.add(campoDataEmissao);
		campoDataEmissao.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 214, 723, 140);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null,
				"Informa\u00E7\u00F5es Financeiras", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_5.setBounds(0, 0, 355, 140);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		campoValorProjeto = new JTextField();
		campoValorProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		campoValorProjeto.setText("0");
		campoValorProjeto.setBounds(114, 57, 114, 20);
		panel_5.add(campoValorProjeto);
		campoValorProjeto.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null,
				"Informa\u00E7\u00F5es de Produ\u00E7\u00E3o",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(365, 0, 358, 140);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		final JTextArea campoDescricaoProjeto = new JTextArea();
		campoDescricaoProjeto.setLineWrap(true);
		campoDescricaoProjeto.setBounds(12, 23, 334, 105);
		panel_6.add(campoDescricaoProjeto);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Servi\u00E7os",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(10, 86, 723, 83);
		panel_3.add(panel_7);

		//table = new JTable();

		table_1 = new JTable();

		JScrollBar scrollBar = new JScrollBar();
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(gl_panel_7.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_7
						.createSequentialGroup()
						.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 678,
								Short.MAX_VALUE)
						.addGap(18)
						.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addContainerGap()));
		gl_panel_7.setVerticalGroup(gl_panel_7
				.createParallelGroup(Alignment.LEADING)
				.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 60,
						Short.MAX_VALUE)
				.addGroup(
						gl_panel_7
								.createSequentialGroup()
								.addComponent(scrollBar,
										GroupLayout.DEFAULT_SIZE, 60,
										Short.MAX_VALUE).addContainerGap()));
		panel_7.setLayout(gl_panel_7);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnConfirmar.setBounds(10, 180, 98, 23);
		panel_3.add(btnConfirmar);

		JButton botaoOrcamento = new JButton("Or\u00E7amento");

		botaoOrcamento.setBounds(123, 180, 98, 23);
		panel_3.add(botaoOrcamento);

		JButton botaoCancela = new JButton("Cancelar");
		botaoCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		botaoCancela.setBounds(237, 179, 98, 23);
		panel_3.add(botaoCancela);

		JLabel lblNewLabel_1 = new JLabel("Codigo do Projeto :");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(954, 69, 173, 23);
		contentPane.add(lblNewLabel_1);

		campoCodigoProjeto = new JTextField();
		campoCodigoProjeto.setEditable(false);
		campoCodigoProjeto.setBounds(1129, 62, 43, 31);
		contentPane.add(campoCodigoProjeto);
		campoCodigoProjeto.setColumns(10);

	

		campoNomeCliente = new JTextField();
		campoNomeCliente.setColumns(10);
		campoNomeCliente.setBounds(309, 68, 88, 20);
		contentPane.add(campoNomeCliente);

		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpfcnpj.setBounds(243, 71, 56, 14);
		contentPane.add(lblCpfcnpj);

		JRadioButton rdbtnFisico = new JRadioButton("Fisico");
		rdbtnFisico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cliente = "fisico";

			}
		});
		rdbtnFisico.setBounds(41, 64, 78, 23);
		contentPane.add(rdbtnFisico);

		JRadioButton rdbtnJuridico = new JRadioButton("Juridico");
		rdbtnJuridico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente = "juridico";
			}
		});
		rdbtnJuridico.setBounds(123, 65, 78, 23);
		contentPane.add(rdbtnJuridico);

		ButtonGroup gp = new ButtonGroup();
		gp.add(rdbtnFisico);
		gp.add(rdbtnJuridico);

		JButton novoCliente = new JButton("Cadastrar");
		novoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroCliente().setVisible(true);
			}
		});
		novoCliente.setBounds(325, 436, 98, 23);
		contentPane.add(novoCliente);
	}
}