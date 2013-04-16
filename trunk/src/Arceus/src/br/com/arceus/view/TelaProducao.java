package Arceus.src.br.com.arceus.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class TelaProducao extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;

	public TelaProducao() {
		setTitle("Setor de Produ\u00E7\u00E3o");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1194, 56);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("P r o d u \u00E7 \u00E3 o");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 228, 34);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Solicita\u00E7\u00F5es setor de Atendimento",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 67, 450, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.setBounds(351, 99, 89, 23);
		panel_1.add(btnAbrir);

		table = new JTable();
		table.setBounds(10, 26, 329, 168);
		panel_1.add(table);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 205, 430, 2);
		panel_1.add(separator_1);

		JLabel lblEnviar = new JLabel("Enviar Setor Atendimento");
		lblEnviar.setBounds(10, 212, 150, 14);
		panel_1.add(lblEnviar);

		table_4 = new JTable();
		table_4.setBounds(10, 237, 329, 145);
		panel_1.add(table_4);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(351, 288, 89, 23);
		panel_1.add(btnEnviar);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(470, 71, 1, 389);
		contentPane.add(separator);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Lista de Materiais",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(481, 67, 703, 206);
		contentPane.add(panel_2);

		table_1 = new JTable();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_2
						.createSequentialGroup()
						.addGap(4)
						.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 683,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel_2
						.createSequentialGroup()
						.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 179,
								GroupLayout.PREFERRED_SIZE).addGap(4)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Setor Financeiro",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(481, 284, 703, 176);
		contentPane.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null,
				"Solicitar ao setor Financeiro", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Receber setor Financeiro",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);

		JButton btnEnviar_1 = new JButton("Enviar");

		JButton btnAddALista = new JButton("Add a Lista");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3
				.setHorizontalGroup(gl_panel_3
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_3
										.createSequentialGroup()
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																panel_4,
																GroupLayout.PREFERRED_SIZE,
																360,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGap(134)
																		.addComponent(
																				btnEnviar_1)))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(separator_2,
												GroupLayout.PREFERRED_SIZE, 7,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																panel_5,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																Alignment.TRAILING,
																gl_panel_3
																		.createSequentialGroup()
																		.addComponent(
																				btnAddALista)
																		.addGap(123)))));
		gl_panel_3
				.setVerticalGroup(gl_panel_3
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_3
										.createSequentialGroup()
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_3
																						.createParallelGroup(
																								Alignment.TRAILING,
																								false)
																						.addComponent(
																								panel_5,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								panel_4,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_panel_3
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								btnEnviar_1)
																						.addComponent(
																								btnAddALista)))
														.addComponent(
																separator_2,
																GroupLayout.PREFERRED_SIZE,
																151,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		table_3 = new JTable();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_5
						.createSequentialGroup()
						.addComponent(table_3, GroupLayout.PREFERRED_SIZE, 314,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(
				Alignment.LEADING).addComponent(table_3,
				GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE));
		panel_5.setLayout(gl_panel_5);

		table_2 = new JTable();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_4
						.createSequentialGroup()
						.addComponent(table_2, GroupLayout.PREFERRED_SIZE, 347,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(
				Alignment.LEADING).addComponent(table_2,
				GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE));
		panel_4.setLayout(gl_panel_4);
		panel_3.setLayout(gl_panel_3);
	}

}
