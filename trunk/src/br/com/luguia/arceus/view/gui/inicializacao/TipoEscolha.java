package br.com.luguia.arceus.view.gui.inicializacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.luguia.arceus.view.gui.telaPrincipal.TelaPrincipal;

public class TipoEscolha extends JFrame {

	private JPanel contentPane;
	private TelaPrincipal telaPrincipal;

	public TipoEscolha() {
		setTitle("Tipo de Teste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager
				.getColor("Button.disabledToolBarBorderBackground"));
		panel_1.setBounds(0, 0, 284, 261);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Populado");

		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(47, 79, 79));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledText"));
		btnNewButton.setBounds(55, 72, 160, 40);
		panel_1.add(btnNewButton);

		JButton btnNopopulado = new JButton("N\u00E3o-Populado");
		btnNopopulado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
				dispose();

			}
		});
		btnNopopulado.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNopopulado.setForeground(new Color(47, 79, 79));
		btnNopopulado.setBackground(UIManager.getColor("Button.disabledText"));
		btnNopopulado.setBounds(55, 151, 160, 40);
		panel_1.add(btnNopopulado);

		JButton btnInicio = new JButton("Inicio");
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
		btnInicio.setBounds(215, 227, 59, 23);
		panel_1.add(btnInicio);
	}

}