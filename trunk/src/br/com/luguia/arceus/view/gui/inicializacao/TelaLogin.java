package br.com.luguia.arceus.view.gui.inicializacao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class TelaLogin extends JFrame {

	private JPanel painelPrincipal;
	private JPasswordField campoSenhaUsuario;
	private JTextField campoNomeUsuario;

	
	
	public TelaLogin() {
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Arceus Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);

		JPanel painelComponentes = new JPanel();
		painelComponentes.setBorder(new TitledBorder(null, "Efetuar Login",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		painelComponentes.setBounds(69, 32, 310, 174);
		painelPrincipal.add(painelComponentes);
		painelComponentes.setLayout(null);

		campoSenhaUsuario = new JPasswordField();
		campoSenhaUsuario.setBounds(42, 115, 217, 20);
		painelComponentes.add(campoSenhaUsuario);

		JLabel lblUSU = new JLabel("U s u \u00E1 r i o");
		lblUSU.setBounds(43, 31, 73, 14);
		painelComponentes.add(lblUSU);

		JLabel lblSEN = new JLabel("S e n h a");
		lblSEN.setBounds(42, 90, 59, 14);
		painelComponentes.add(lblSEN);

		campoNomeUsuario = new JTextField();
		campoNomeUsuario.setBounds(42, 56, 217, 20);
		painelComponentes.add(campoNomeUsuario);
		campoNomeUsuario.setColumns(10);

		JButton botaoEntrar = new JButton("Entrar");
		
		botaoEntrar.setBounds(290, 237, 89, 23);
		painelPrincipal.add(botaoEntrar);

		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);// fecha a tela de login
			}
		});
		botaoSair.setBounds(69, 237, 89, 23);
		painelPrincipal.add(botaoSair);
	}

	
}
