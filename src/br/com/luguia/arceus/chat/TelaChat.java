package br.com.luguia.arceus.chat;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class TelaChat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField campoMenssagem;

	private JTextPane telaDialogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaChat dialog = new TelaChat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaChat() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// FIcar online!
				}

			@Override
			public void windowClosing(WindowEvent e) {
				// Fica offline
				JOptionPane.showMessageDialog(null, "Saindo...");
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaChat.class.getResource("/Images24x24/user_comments.png")));
		setTitle("Chat");
		setBounds(100, 100, 250, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		telaDialogo = new JTextPane();
		telaDialogo.setBounds(10, 11, 214, 201);
		contentPanel.add(telaDialogo);

		campoMenssagem = new JTextField();
		campoMenssagem.setBounds(10, 243, 214, 31);
		contentPanel.add(campoMenssagem);
		campoMenssagem.setColumns(10);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnEnviar.setIcon(new ImageIcon(TelaChat.class
				.getResource("/Images16x16/accept.png")));
		btnEnviar.setBounds(62, 277, 104, 23);
		contentPanel.add(btnEnviar);

		JLabel lblDigiteAquiSua = new JLabel("Digite aqui sua menssagem");
		lblDigiteAquiSua.setBounds(10, 223, 165, 14);
		contentPanel.add(lblDigiteAquiSua);
	}

}