package Arceus.src.br.com.arceus.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class TelaLogin extends JFrame {

	private JPanel painelPrincipal;
	private JPasswordField campoSenhaUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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

		JComboBox boxUsuario = new JComboBox();
		boxUsuario.setBounds(42, 56, 217, 20);
		painelComponentes.add(boxUsuario);

		campoSenhaUsuario = new JPasswordField();
		campoSenhaUsuario.setBounds(42, 115, 217, 20);
		painelComponentes.add(campoSenhaUsuario);

		JLabel lblUSU = new JLabel("U s u \u00E1 r i o");
		lblUSU.setBounds(43, 31, 73, 14);
		painelComponentes.add(lblUSU);

		JLabel lblSEN = new JLabel("S e n h a");
		lblSEN.setBounds(42, 90, 59, 14);
		painelComponentes.add(lblSEN);

		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaPrincipal().setVisible(true);// chamando a tela
														// principal
				setEnabled(false);// desativando a tela login
				setVisible(false);// ocultando a tela login
			}
		});
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
