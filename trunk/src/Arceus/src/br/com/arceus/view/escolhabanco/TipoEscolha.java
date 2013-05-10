package Arceus.src.br.com.arceus.view.escolhabanco;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class TipoEscolha extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-10,19
	 */
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipoEscolha frame = new TipoEscolha();
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
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(55, 72, 160, 40);
		panel_1.add(btnNewButton);
		
		JButton btnNopopulado = new JButton("N\u00E3o-Populado");
		btnNopopulado.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNopopulado.setForeground(new Color(0, 0, 255));
		btnNopopulado.setBackground(new Color(0, 0, 0));
		btnNopopulado.setBounds(55, 151, 160, 40);
		panel_1.add(btnNopopulado);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setBackground(new Color(0, 0, 0));
		btnInicio.setFont(new Font("Calibri", Font.BOLD, 12));
		btnInicio.setForeground(new Color(0, 0, 255));
		btnInicio.setBounds(94, 227, 89, 23);
		panel_1.add(btnInicio);
	}

}
