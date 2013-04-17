package Arceus.src.br.com.arceus.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Arceus.src.br.com.arceus.controll.GerenciadorDeConeccoes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMidia extends JFrame {

	private JPanel contentPane;
	private JTable tabelaJobsProntos;

	GerenciadorDeConeccoes gc = new GerenciadorDeConeccoes();
	
	public TelaMidia() {
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
		
		JLabel lblNewLabel = new JLabel("M \u00ED d i a");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 141, 34);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Job's Finalizados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 67, 614, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String d = "Desenvolvido";
				gc.tabelaMidia(
						"SELECT * from midia where EXECUCAO_PROJETO = ?", d,
						tabelaJobsProntos);
				
				
				String codigo,nome,descricao;
				
				
				
			}
		});
		btnAbrir.setBounds(275, 343, 89, 23);
		panel_1.add(btnAbrir);
		
		tabelaJobsProntos = new JTable();
		tabelaJobsProntos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tabelaJobsProntos.setBounds(10, 25, 594, 298);
		panel_1.add(tabelaJobsProntos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es do Job's", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(634, 67, 550, 393);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 23, 265, 168);
		panel_2.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(299, 23, 241, 168);
		panel_2.add(textPane_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 218, 530, 2);
		panel_2.add(separator);
	}
}
