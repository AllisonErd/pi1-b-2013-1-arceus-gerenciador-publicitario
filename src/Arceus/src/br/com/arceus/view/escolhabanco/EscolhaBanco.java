package Arceus.src.br.com.arceus.view.escolhabanco;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class EscolhaBanco extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolhaBanco frame = new EscolhaBanco();
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
	public EscolhaBanco() {
		setEnabled(false);
		setResizable(false);
		setTitle("Escolha de Persistencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 294, 271);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Array List");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(66, 72, 155, 40);
		panel.add(btnNewButton);
		
		JButton btnSql = new JButton("SQL");
		btnSql.setForeground(Color.BLUE);
		btnSql.setFont(new Font("Calibri", Font.BOLD, 13));
		btnSql.setBackground(Color.BLACK);
		btnSql.setBounds(66, 166, 155, 40);
		panel.add(btnSql);
	}
}
