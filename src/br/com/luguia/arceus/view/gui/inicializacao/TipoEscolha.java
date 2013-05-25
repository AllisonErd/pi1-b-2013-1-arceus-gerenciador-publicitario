package br.com.luguia.arceus.view.gui.inicializacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TipoEscolha extends JFrame {

	private JPanel contentPane;

	public TipoEscolha() {
		setTitle("Tipo de Teste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 284, 261);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Populado");
		btnNewButton.setIcon(new ImageIcon(TipoEscolha.class
				.getResource("/Images24x24/folder_full.png")));

		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(47, 79, 79));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledText"));
		btnNewButton.setBounds(66, 72, 160, 40);
		panel_1.add(btnNewButton);

		JButton btnNopopulado = new JButton("N\u00E3o-Populado");
		btnNopopulado.setIcon(new ImageIcon(TipoEscolha.class
				.getResource("/Images24x24/folder_edit.png")));
		btnNopopulado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new TelaLogin().setVisible(true);
				dispose();

			}
		});
		btnNopopulado.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNopopulado.setForeground(new Color(47, 79, 79));
		btnNopopulado.setBackground(UIManager.getColor("Button.disabledText"));
		btnNopopulado.setBounds(66, 150, 160, 40);
		panel_1.add(btnNopopulado);

		JButton btnInicio = new JButton("Inicio");
		btnInicio.setIcon(new ImageIcon(TipoEscolha.class
				.getResource("/Images16x16/accept.png")));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscolhaBanco escolha = new EscolhaBanco();
				escolha.setVisible(true);

				dispose();
			}
		});
		btnInicio.setBackground(UIManager.getColor("Button.disabledText"));
		btnInicio.setFont(new Font("Calibri", Font.BOLD, 12));
		btnInicio.setForeground(new Color(47, 79, 79));
		btnInicio.setBounds(192, 225, 82, 25);
		panel_1.add(btnInicio);
	}

}