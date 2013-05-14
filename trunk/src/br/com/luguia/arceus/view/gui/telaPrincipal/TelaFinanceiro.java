package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class TelaFinanceiro extends JFrame {

	private JPanel contentPane;
	private JTextField campoLucro;
	private JTextField textField_2;
	private JTable tabelaSolicitacoes;
	
	private JTable tabelaPedidosAvaliados;

	public TelaFinanceiro() {



		setResizable(false);
		setTitle("Setor financeiro");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1032, 500);
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

		JLabel lblNewLabel = new JLabel("F i n a n c e i r o");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 255, 34);
		panel.add(lblNewLabel);

		JLabel lblSolicitaoDeOramento = new JLabel(
				"Solicita\u00E7\u00E3o de Or\u00E7amento");
		lblSolicitaoDeOramento.setBounds(10, 68, 152, 16);
		contentPane.add(lblSolicitaoDeOramento);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 240, 500, 3);
		contentPane.add(separator);

		JLabel lblDescrioDoPedido = new JLabel("Descri\u00E7\u00E3o do pedido");
		lblDescrioDoPedido.setBounds(10, 255, 152, 16);
		contentPane.add(lblDescrioDoPedido);

		final JTextArea campoDescricao = new JTextArea();
		campoDescricao.setBounds(10, 283, 490, 132);
		contentPane.add(campoDescricao);

		JButton btnSolicitaCusto = new JButton("Solicita Custo");
	
		btnSolicitaCusto.setBounds(10, 433, 112, 26);
		contentPane.add(btnSolicitaCusto);

		JButton btnRetornaOramento = new JButton("Voltar");
		btnRetornaOramento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnRetornaOramento.setBounds(902, 433, 112, 26);
		contentPane.add(btnRetornaOramento);

		JLabel lblCustoDeProduo = new JLabel(
				"Pedidos avaliado pelo setor de produ\u00E7\u00E3o");
		lblCustoDeProduo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustoDeProduo.setBounds(776, 68, 238, 16);
		contentPane.add(lblCustoDeProduo);

		JLabel lblLucro = new JLabel("Lucro");
		lblLucro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLucro.setBounds(770, 356, 112, 16);
		contentPane.add(lblLucro);

		campoLucro = new JTextField();
		campoLucro.setHorizontalAlignment(SwingConstants.CENTER);
		campoLucro.setText("0");
		campoLucro.setColumns(10);
		campoLucro.setBounds(900, 354, 114, 20);
		contentPane.add(campoLucro);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(900, 384, 114, 20);
		contentPane.add(textField_2);

		JLabel lblTotalEmCaixa = new JLabel("Total em caixa");
		lblTotalEmCaixa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalEmCaixa.setBounds(770, 386, 112, 16);
		contentPane.add(lblTotalEmCaixa);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(512, 96, 2, 363);
		contentPane.add(separator_2);

		JButton button = new JButton("Retorna Or\u00E7.");
	
		button.setBounds(778, 433, 112, 26);
		contentPane.add(button);

		tabelaSolicitacoes = new JTable();
		tabelaSolicitacoes.setModel(new DefaultTableModel(new Object[][] { {
				null, null, null }, }, new String[] { "New column",
				"New column", "New column" }));
		tabelaSolicitacoes.setBounds(20, 96, 472, 132);
		contentPane.add(tabelaSolicitacoes);

		JButton btnAtualizar = new JButton("Atualizar");

		btnAtualizar.setBounds(468, 65, 89, 23);
		contentPane.add(btnAtualizar);

		tabelaPedidosAvaliados = new JTable();
		tabelaPedidosAvaliados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tabelaPedidosAvaliados.setBounds(536, 95, 480, 216);
		contentPane.add(tabelaPedidosAvaliados);
	}
}
