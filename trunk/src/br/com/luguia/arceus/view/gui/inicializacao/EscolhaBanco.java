package br.com.luguia.arceus.view.gui.inicializacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class EscolhaBanco extends JFrame {

	private JPanel contentPane;

	public EscolhaBanco() {

		setResizable(false);
		setTitle("Escolha de Persistencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 294, 271);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Array List");
		btnNewButton.setForeground(new Color(47, 79, 79));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton.setBackground(UIManager.getColor("Button.focus"));
		btnNewButton.setBounds(66, 72, 155, 40);
		panel.add(btnNewButton);

		JButton btnSql = new JButton("MySQL");
		btnSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ConfigSql().setVisible(true);

				dispose();

			}
		});
		btnSql.setForeground(new Color(47, 79, 79));
		btnSql.setFont(new Font("Calibri", Font.BOLD, 13));
		btnSql.setBackground(UIManager.getColor("Button.focus"));
		btnSql.setBounds(66, 166, 155, 40);
		panel.add(btnSql);
	}
}