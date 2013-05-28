package br.com.luguia.arceus.view.gui.inicializacao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.luguia.arceus.model.Funcionario;
import br.com.luguia.arceus.model.dao.array.FuncionarioDAO;
import br.com.luguia.arceus.view.gui.telaPrincipal.TelaPrincipal;

public class TelaLogin extends JFrame {

	private JPanel painelPrincipal;
	private JPasswordField campoSenhaUsuario;
	private JTextField campoNomeUsuario;
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private ArrayList<Funcionario> manipulaFuncionario;

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
		campoSenhaUsuario.setBounds(42, 115, 217, 28);
		painelComponentes.add(campoSenhaUsuario);

		JLabel lblUSU = new JLabel("U s u \u00E1 r i o");
		lblUSU.setBounds(43, 31, 73, 14);
		painelComponentes.add(lblUSU);

		JLabel lblSEN = new JLabel("S e n h a");
		lblSEN.setBounds(42, 90, 59, 14);
		painelComponentes.add(lblSEN);

		campoNomeUsuario = new JTextField();
		campoNomeUsuario.setBounds(42, 56, 217, 28);
		painelComponentes.add(campoNomeUsuario);
		campoNomeUsuario.setColumns(10);

		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean conect = false;
				String nome = "";
				manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO
						.listeTodos();

				for (int i = 0; i < manipulaFuncionario.size(); i++) {
					if (manipulaFuncionario.get(i).getLogin()
							.equals(campoNomeUsuario.getText().toString().trim())
							&& manipulaFuncionario.get(i).getSenha()
									.equals(campoSenhaUsuario.getText().toString().trim())) {
						nome = manipulaFuncionario.get(i).getNome();
						conect = true;
						gravaReferenciaFuncionario(manipulaFuncionario.get(i).getId());
						new TelaPrincipal().setVisible(true);
						dispose();
						
					} 

				}
				if (conect == false) {
					JOptionPane.showMessageDialog(null,
							"Senha ou login incorreto!");
					//campoNomeUsuario.setText("");
					campoSenhaUsuario.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "Bem vindo "+nome);
				}

			}
		});
		botaoEntrar.setIcon(new ImageIcon(TelaLogin.class
				.getResource("/Images16x16/accept.png")));

		botaoEntrar.setBounds(273, 217, 106, 43);
		painelPrincipal.add(botaoEntrar);

		JButton botaoSair = new JButton("Sair");
		botaoSair.setIcon(new ImageIcon(TelaLogin.class
				.getResource("/Images16x16/folder.png")));
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);// fecha a tela de login
			}
		});
		botaoSair.setBounds(69, 217, 106, 43);
		painelPrincipal.add(botaoSair);
	}

	public void gravaReferenciaFuncionario(int idFuncionario){
		FileWriter fw = null;
		try {
			fw = new FileWriter("ReferenciaFuncionario.txt");

			fw.write(""+idFuncionario);

			fw.close();

		} catch (IOException e1) {
			
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
}
