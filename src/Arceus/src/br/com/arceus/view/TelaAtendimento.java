package Arceus.src.br.com.arceus.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaAtendimento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtendimento frame = new TelaAtendimento();
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
	public TelaAtendimento() {
		setTitle("Setor de Atendimento");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnNovo = new JButton("Pesquisar Cliente");
		btnNovo.setBounds(10, 60, 153, 23);
		contentPane.add(btnNovo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "C l i e n t e", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 95, 413, 177);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(9, 33, 46, 14);
		panel_1.add(lblCodigo);
		
		textField = new JTextField();
		textField.setBounds(65, 27, 30, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(105, 33, 46, 14);
		panel_1.add(lblCliente);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 27, 257, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 65, 46, 14);
		panel_1.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(65, 59, 338, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 95, 46, 14);
		panel_1.add(lblEndereo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(65, 89, 338, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(9, 124, 46, 14);
		panel_1.add(lblCidade);
		
		textField_4 = new JTextField();
		textField_4.setBounds(65, 118, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(161, 124, 22, 14);
		panel_1.add(lblUf);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(188, 118, 55, 20);
		panel_1.add(comboBox);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(254, 124, 30, 14);
		panel_1.add(lblCep);
		
		textField_5 = new JTextField();
		textField_5.setBounds(282, 118, 121, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 149, 46, 14);
		panel_1.add(lblTelefone);
		
		textField_6 = new JTextField();
		textField_6.setBounds(65, 143, 30, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(105, 143, 86, 20);
		panel_1.add(textField_7);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(229, 149, 38, 14);
		panel_1.add(lblCelular);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(277, 143, 30, 20);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(317, 143, 86, 20);
		panel_1.add(textField_9);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(433, 78, 18, 393);
		contentPane.add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Observa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 283, 413, 177);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 25, 393, 141);
		panel_2.add(textPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "P r o j e t o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(441, 95, 743, 365);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNomeDoProjeto = new JLabel("Nome do Projeto");
		lblNomeDoProjeto.setBounds(237, 27, 92, 14);
		panel_3.add(lblNomeDoProjeto);
		
		textField_11 = new JTextField();
		textField_11.setBounds(337, 24, 396, 20);
		panel_3.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNumeroDoProjeto = new JLabel("Numero do Projeto:");
		lblNumeroDoProjeto.setBounds(10, 30, 106, 14);
		panel_3.add(lblNumeroDoProjeto);
		
		textField_12 = new JTextField();
		textField_12.setBounds(126, 24, 86, 20);
		panel_3.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setBounds(237, 58, 35, 14);
		panel_3.add(lblInicio);
		
		textField_15 = new JTextField();
		textField_15.setBounds(270, 55, 86, 20);
		panel_3.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblTermino = new JLabel("Termino");
		lblTermino.setBounds(366, 58, 46, 14);
		panel_3.add(lblTermino);
		
		textField_16 = new JTextField();
		textField_16.setBounds(422, 55, 86, 20);
		panel_3.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblDataDaEmisso = new JLabel("Data da Emiss\u00E3o:");
		lblDataDaEmisso.setBounds(20, 61, 92, 14);
		panel_3.add(lblDataDaEmisso);
		
		textField_17 = new JTextField();
		textField_17.setBounds(126, 55, 86, 20);
		panel_3.add(textField_17);
		textField_17.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 214, 723, 140);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es Financeiras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(0, 0, 355, 140);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es de Produ\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(365, 0, 358, 140);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Servi\u00E7os", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(10, 86, 723, 83);
		panel_3.add(panel_7);
		
		table = new JTable();
		
		table_1 = new JTable();
		
		JScrollBar scrollBar = new JScrollBar();
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_7.setLayout(gl_panel_7);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(10, 180, 89, 23);
		panel_3.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(123, 180, 89, 23);
		panel_3.add(btnCancelar);
		
		JLabel lblAtendente = new JLabel("Atendente");
		lblAtendente.setBounds(530, 58, 67, 14);
		panel_3.add(lblAtendente);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(607, 55, 126, 20);
		panel_3.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Projeto de numero:");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(954, 69, 173, 23);
		contentPane.add(lblNewLabel_1);
		
		textField_10 = new JTextField();
		textField_10.setBounds(1129, 62, 43, 31);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
	}
}
