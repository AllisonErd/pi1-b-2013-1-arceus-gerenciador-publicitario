package br.com.luguia.arceus.chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class TelaChat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaChat.class.getResource("/Images24x24/user_comments.png")));
		setTitle("Chat");
		setBounds(100, 100, 250, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 11, 214, 201);
		contentPanel.add(textPane);
		
		textField = new JTextField();
		textField.setBounds(10, 243, 214, 31);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setIcon(new ImageIcon(TelaChat.class.getResource("/Images16x16/accept.png")));
		btnEnviar.setBounds(62, 277, 104, 23);
		contentPanel.add(btnEnviar);
		
		JLabel lblDigiteAquiSua = new JLabel("Digite aqui sua menssagem");
		lblDigiteAquiSua.setBounds(10, 223, 165, 14);
		contentPanel.add(lblDigiteAquiSua);
	}
}
