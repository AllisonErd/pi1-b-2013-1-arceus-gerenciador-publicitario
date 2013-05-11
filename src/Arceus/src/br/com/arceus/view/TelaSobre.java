package Arceus.src.br.com.arceus.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TelaSobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre frame = new TelaSobre();
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
	public TelaSobre() {
		setTitle("Sobre Arceus");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 424, 249);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSistemaArceusAdvertsing = new JLabel("Sistema Arceus Advertsing Manangement.");
		lblSistemaArceusAdvertsing.setFont(new Font("Calibri", Font.BOLD, 12));
		lblSistemaArceusAdvertsing.setBounds(10, 36, 404, 14);
		panel.add(lblSistemaArceusAdvertsing);
		
		JLabel lblLugiaDevelopers = new JLabel("Lugia Developers.");
		lblLugiaDevelopers.setFont(new Font("Calibri", Font.BOLD, 12));
		lblLugiaDevelopers.setBounds(10, 11, 404, 14);
		panel.add(lblLugiaDevelopers);
		
		JLabel lblTodos = new JLabel("Todos os direitos reservados.");
		lblTodos.setFont(new Font("Calibri", Font.BOLD, 12));
		lblTodos.setBounds(10, 61, 404, 14);
		panel.add(lblTodos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(50, 142, 118, 96);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogoEmpresa = new JLabel("Logo Empresa");
		lblLogoEmpresa.setBounds(10, 40, 98, 14);
		panel_1.add(lblLogoEmpresa);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(243, 142, 118, 96);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLogoArceus = new JLabel("Logo Arceus");
		lblLogoArceus.setBounds(10, 41, 98, 14);
		panel_2.add(lblLogoArceus);
	}
}
