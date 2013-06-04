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
import javax.swing.ImageIcon;

public class EscolhaBanco extends JFrame {

	private JPanel contentPane;

	public EscolhaBanco() {

		setResizable(false);
		setTitle("Escolha de Persistencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 294, 271);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnSql = new JButton("MySQL");
		btnSql.setIcon(new ImageIcon(EscolhaBanco.class.getResource("/images/database.png")));
		btnSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ConfigSql().setVisible(true);

				dispose();

			}
		});
		btnSql.setForeground(new Color(47, 79, 79));
		btnSql.setFont(new Font("Calibri", Font.BOLD, 13));
		btnSql.setBackground(UIManager.getColor("Button.focus"));
		btnSql.setBounds(71, 102, 155, 81);
		panel.add(btnSql);
	}
}