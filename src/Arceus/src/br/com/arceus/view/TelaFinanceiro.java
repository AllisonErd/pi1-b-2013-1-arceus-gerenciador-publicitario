package Arceus.src.br.com.arceus.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class TelaFinanceiro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFinanceiro frame = new TelaFinanceiro();
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
	public TelaFinanceiro() {
		setResizable(false);
		setTitle("Setor financeiro");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblSolicitaoDeOramento = new JLabel("Solicita\u00E7\u00E3o de Or\u00E7amento");
		lblSolicitaoDeOramento.setBounds(10, 68, 152, 16);
		contentPane.add(lblSolicitaoDeOramento);
		
		JList list = new JList();
		list.setBounds(12, 96, 488, 132);
		contentPane.add(list);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 240, 500, 3);
		contentPane.add(separator);
		
		JLabel lblDescrioDoPedido = new JLabel("Descri\u00E7\u00E3o do pedido");
		lblDescrioDoPedido.setBounds(10, 255, 152, 16);
		contentPane.add(lblDescrioDoPedido);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 283, 490, 132);
		contentPane.add(textArea);
		
		JButton btnSolicitaCusto = new JButton("Solicita Custo");
		btnSolicitaCusto.setBounds(10, 433, 112, 26);
		contentPane.add(btnSolicitaCusto);
		
		JButton btnRetornaOramento = new JButton("Sair");
		btnRetornaOramento.setBounds(902, 433, 112, 26);
		contentPane.add(btnRetornaOramento);
		
		JLabel lblCustoDeProduo = new JLabel("Pedidos avaliado pelo setor de produ\u00E7\u00E3o");
		lblCustoDeProduo.setBounds(526, 68, 238, 16);
		contentPane.add(lblCustoDeProduo);
		
		JList list_1 = new JList();
		list_1.setBounds(526, 96, 488, 217);
		contentPane.add(list_1);
		
		textField = new JTextField();
		textField.setBounds(900, 325, 114, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCusto.setBounds(770, 327, 112, 16);
		contentPane.add(lblCusto);
		
		JLabel lblLucro = new JLabel("Lucro");
		lblLucro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLucro.setBounds(770, 356, 112, 16);
		contentPane.add(lblLucro);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(900, 354, 114, 20);
		contentPane.add(textField_1);
		
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
		separator_2.setBounds(512, 66, 2, 393);
		contentPane.add(separator_2);
		
		JButton button = new JButton("Retorna Or\u00E7.");
		button.setBounds(778, 433, 112, 26);
		contentPane.add(button);
	}
}
