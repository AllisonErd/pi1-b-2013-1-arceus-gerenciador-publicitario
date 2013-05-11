package Arceus.src.br.com.arceus.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaAjuda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAjuda frame = new TelaAjuda();
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
	public TelaAjuda() {
		setTitle("Ajuda e Suporte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 350, 249);
		contentPane.add(panel);
		
		JButton btnOk = new JButton("Ok");
		
		JLabel lblAjudaESuporte = new JLabel("Ajuda e Suporte T\u00E9cnico especializado");
		lblAjudaESuporte.setFont(new Font("Calibri", Font.BOLD, 12));
		
		JLabel lblContatos = new JLabel("Contatos");
		
		JLabel lblHomePage = new JLabel("Home Page:");
		
		JLabel lblEmail = new JLabel("e-mail:");
		
		JLabel lblxxxxxxxxxx = new JLabel("(xx)xxxx-xxxx");
		
		JLabel label = new JLabel("(xx)xxxx-xxxx");
		
		JLabel lblWwwaguardando = new JLabel("www.aguardandohomepage.com.br");
		
		JLabel lblAguardandoemailcombr = new JLabel("aguardando@email.com.br");
		
		JLabel lblSuporteemailcombr = new JLabel("suporte@email.com.br");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(71)
							.addComponent(lblAjudaESuporte, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(139)
							.addComponent(lblContatos, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(80)
							.addComponent(lblxxxxxxxxxx, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(127)
							.addComponent(lblHomePage, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(144)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(80)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblWwwaguardando, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblAguardandoemailcombr, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(10)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel.createSequentialGroup()
												.addGap(10)
												.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
											.addComponent(lblSuporteemailcombr, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))))))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblAjudaESuporte, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(lblContatos)
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblxxxxxxxxxx)
						.addComponent(label))
					.addGap(11)
					.addComponent(lblHomePage)
					.addGap(11)
					.addComponent(lblWwwaguardando)
					.addGap(10)
					.addComponent(lblEmail)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAguardandoemailcombr)
					.addGap(10)
					.addComponent(lblSuporteemailcombr)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOk)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
}
