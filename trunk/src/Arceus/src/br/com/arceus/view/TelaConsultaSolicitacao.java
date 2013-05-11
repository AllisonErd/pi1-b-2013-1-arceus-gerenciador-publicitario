package Arceus.src.br.com.arceus.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class TelaConsultaSolicitacao extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaSolicitacao frame = new TelaConsultaSolicitacao();
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
	public TelaConsultaSolicitacao() {
		setTitle("Consulta de Solicitação");
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
		
		JLabel lblNewLabel = new JLabel("S o l i c i t a ç ã o");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		
		lblNewLabel.setBounds(10, 11, 353, 34);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pesquisar Solicita\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 67, 576, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 32, 46, 14);
		panel_1.add(lblCodigo);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setBounds(124, 32, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(166, 29, 293, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(50, 29, 46, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(477, 28, 89, 23);
		panel_1.add(btnPesquisar);
		
		JList list = new JList();
		list.setBounds(10, 72, 556, 264);
		panel_1.add(list);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.setBounds(477, 359, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(357, 359, 89, 23);
		panel_1.add(btnCancelar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es Gerais da Solicita\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(586, 67, 598, 393);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JList list_1 = new JList();
		list_1.setBounds(10, 71, 578, 265);
		panel_2.add(list_1);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(260, 359, 89, 23);
		panel_2.add(btnOk);
		
		JLabel lblDetalhesDaSolicitao = new JLabel("Detalhes da Solicita\u00E7\u00E3o");
		lblDetalhesDaSolicitao.setBounds(10, 33, 124, 14);
		panel_2.add(lblDetalhesDaSolicitao);
	}
}
