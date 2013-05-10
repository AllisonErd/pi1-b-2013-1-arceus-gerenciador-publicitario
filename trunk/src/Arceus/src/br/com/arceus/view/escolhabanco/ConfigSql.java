package Arceus.src.br.com.arceus.view.escolhabanco;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class ConfigSql extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
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
					ConfigSql frame = new ConfigSql();
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
	public ConfigSql() {
		setTitle("Setings");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 294, 271);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(10, 36, 274, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 100, 274, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 166, 274, 28);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Host");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 75, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pass");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 141, 46, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(179, 220, 105, 40);
		panel.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Calibri", Font.BOLD, 13));
		btnVoltar.setBackground(new Color(0, 0, 0));
		btnVoltar.setForeground(new Color(0, 0, 255));
		btnVoltar.setBounds(10, 220, 105, 40);
		panel.add(btnVoltar);
	}
}
