package Arceus.src.br.com.arceus.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Arceus.src.br.com.arceus.controll.GerenciadorDeConeccoes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class TelaCriação extends JFrame {

	private JPanel contentPane;
	private JTable tabelaSolicitacoesAprovadas;
	private JTextArea campoInformacoes;
	GerenciadorDeConeccoes gc = new GerenciadorDeConeccoes();
	private JTextField campoCodigo;
	private JTextField campoNome;
	private JTextField campoMeioExibição;
	private String andamento;
	private JTextField textField;
	private int cont;
	public TelaCriação() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				gc.tabelaFinanceiro(
						"SELECT * from atender where valor_pedido != ?", "0",
						tabelaSolicitacoesAprovadas);
			}
		});
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

		JLabel lblNewLabel = new JLabel("C r i a \u00E7 \u00E3 o");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 195, 34);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null,
				"Solicita\u00E7\u00F5es Aprovadas", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 67, 436, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String informacoes, codigo;

				informacoes = (String) tabelaSolicitacoesAprovadas
						.getModel()
						.getValueAt(
								tabelaSolicitacoesAprovadas.getSelectedRow(), 2);
				campoInformacoes.setText(informacoes + "");

				codigo = (String) tabelaSolicitacoesAprovadas
						.getModel()
						.getValueAt(
								tabelaSolicitacoesAprovadas.getSelectedRow(), 0);
				campoCodigo.setText(codigo + "");

			}
		});
		btnAbrir.setBounds(337, 189, 89, 23);
		panel_1.add(btnAbrir);

		tabelaSolicitacoesAprovadas = new JTable();
		tabelaSolicitacoesAprovadas.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, }, new String[] {
						"New column", "New column", "New column" }));
		tabelaSolicitacoesAprovadas.setBounds(10, 21, 319, 361);
		panel_1.add(tabelaSolicitacoesAprovadas);

		JButton botaoAtualiza = new JButton("Atualiza");
		botaoAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gc.tabelaFinanceiro(
						"SELECT * from atender where valor_pedido != ?", "0",
						tabelaSolicitacoesAprovadas);
			}
		});
		botaoAtualiza.setBounds(337, 155, 89, 23);
		panel_1.add(botaoAtualiza);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null,
				"Informa\u00E7\u00F5es Gerais", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_2.setBounds(456, 67, 728, 192);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(364, 11, 1, 170);
		panel_2.add(separator);

		campoInformacoes = new JTextArea();
		campoInformacoes.setLineWrap(true);
		campoInformacoes.setBounds(12, 23, 341, 158);
		panel_2.add(campoInformacoes);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Job's", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3.setBounds(456, 270, 612, 190);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(396, 24, 55, 16);
		panel_3.add(lblCodigo);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 24, 41, 16);
		panel_3.add(lblNome);

		JLabel lblMeioDeExibio = new JLabel("Meio de exibi\u00E7\u00E3o");
		lblMeioDeExibio.setBounds(12, 54, 95, 16);
		panel_3.add(lblMeioDeExibio);

		JLabel lblAndamento = new JLabel("Andamento:");
		lblAndamento.setBounds(396, 52, 73, 16);
		panel_3.add(lblAndamento);

		campoCodigo = new JTextField();
		campoCodigo.setEditable(false);
		campoCodigo.setBounds(444, 22, 55, 20);
		panel_3.add(campoCodigo);
		campoCodigo.setColumns(10);

		campoNome = new JTextField();
		campoNome.setBounds(55, 22, 323, 20);
		panel_3.add(campoNome);
		campoNome.setColumns(10);

		campoMeioExibição = new JTextField();
		campoMeioExibição.setBounds(114, 52, 264, 20);
		panel_3.add(campoMeioExibição);
		campoMeioExibição.setColumns(10);

		JRadioButton rdbtnDesenvolvendo = new JRadioButton("Desenvolvendo");
		rdbtnDesenvolvendo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				andamento = "Desenvolvendo";
			}
		});
		rdbtnDesenvolvendo.setBounds(483, 50, 112, 24);
		panel_3.add(rdbtnDesenvolvendo);

		JRadioButton rdbtnDesenvolvido = new JRadioButton("Desenvolvido");
		rdbtnDesenvolvido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				andamento = "Desenvolvido";
			}
		});
		rdbtnDesenvolvido.setBounds(483, 82, 121, 24);
		panel_3.add(rdbtnDesenvolvido);

		ButtonGroup bt = new ButtonGroup();
		bt.add(rdbtnDesenvolvendo);
		bt.add(rdbtnDesenvolvido);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gc.cadastrar(
						"insert into projeto (NOME_PROJETO, ID_SETOR, ID_PROJETO) VALUES (?,?,?)",
						"" + campoNome.getText().toString().trim() + "#" + "4"
								+ "#" + campoCodigo.getText().toString().trim()
								+ "");
				
				gc.cadastrar(
						"insert into midia (EXECUCAO_PROJETO, MEIOS_EXECUCAO, ID_SETOR, ID_PROJETO) VALUES (?,?,?,?)",
						"" + andamento + "#"
								+ campoMeioExibição.getText().toString().trim()
								+ "#" + "4" + "#"
								+ campoCodigo.getText().toString().trim() + "");
			
				gc.cadastrar(
						"insert into criacao (PRIORIDADE_PROJETO, DEFINICAO_PROJETO, ID_SETOR, ID_PROJETO) VALUES (?,?,?,?)",
						"" + cont + "#"+"implementar"+"#"+"4"+"#"+campoCodigo.getText().toString().trim()+"");//jkjk
			
			}
		});
		btnOk.setBounds(497, 152, 98, 26);
		panel_3.add(btnOk);

		JLabel lblDataDaExibio = new JLabel("Data da exibi\u00E7\u00E3o");
		lblDataDaExibio.setBounds(12, 86, 95, 16);
		panel_3.add(lblDataDaExibio);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(114, 84, 73, 20);
		panel_3.add(textField);
		
		JLabel lblPrioridade = new JLabel("Prioridade");
		lblPrioridade.setBounds(12, 114, 67, 16);
		panel_3.add(lblPrioridade);
		
		String prioridade[] = {"N1","N2","N3","N4"};
		
		final JComboBox comboPrioridade = new JComboBox(prioridade);
		comboPrioridade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cont = (comboPrioridade.getSelectedIndex()+1);
			}
		});
		comboPrioridade.setBounds(114, 110, 73, 25);
		panel_3.add(comboPrioridade);
	}
}
