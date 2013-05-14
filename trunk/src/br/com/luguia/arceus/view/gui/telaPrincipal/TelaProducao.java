package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaProducao extends JFrame {

	private JPanel contentPane;
	private JTable tabelaSolicitacoesFinanceiro;
	private JTextArea campoDescricaoPedido;
	private JTextArea listaPrecoEquipamentos;

	private JTextField campoValorTotal;

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
				"Solicitações recentes do setor Financeiro",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 67, 450, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descricao;
				descricao = (String) tabelaSolicitacoesFinanceiro.getModel()
						.getValueAt(
								tabelaSolicitacoesFinanceiro.getSelectedRow(),
								1);

				campoDescricaoPedido.setText(descricao + "");

			}
		});
		btnAbrir.setBounds(349, 171, 89, 23);
		panel_1.add(btnAbrir);

		tabelaSolicitacoesFinanceiro = new JTable();
		tabelaSolicitacoesFinanceiro.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, }, new String[] {
						"New column", "New column", "New column" }));
		tabelaSolicitacoesFinanceiro.setBounds(10, 26, 329, 168);
		panel_1.add(tabelaSolicitacoesFinanceiro);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 205, 430, 2);
		panel_1.add(separator_1);

		JLabel lblEnviar = new JLabel("Descri\u00E7\u00E3o completa do pedido");
		lblEnviar.setBounds(10, 212, 150, 14);
		panel_1.add(lblEnviar);

		JButton btnAtualizar = new JButton("Atualizar");

		btnAtualizar.setBounds(351, 22, 89, 23);
		panel_1.add(btnAtualizar);

		campoDescricaoPedido = new JTextArea();
		campoDescricaoPedido.setBounds(10, 237, 428, 145);
		panel_1.add(campoDescricaoPedido);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(470, 71, 1, 389);
		contentPane.add(separator);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Retorna dados ao Setor Financeiro", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3.setBounds(481, 67, 642, 393);
		contentPane.add(panel_3);

		campoValorTotal = new JTextField();
		campoValorTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		campoValorTotal.setColumns(10);

		JButton button = new JButton("Enviar");

		JLabel label = new JLabel("Total gasto");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));

		listaPrecoEquipamentos = new JTextArea();

		JLabel lblNewLabel_1 = new JLabel(
				"Relatorio do valor que ser\u00E1 gasto em equipamentos e servis\u00E7os para esse projeto");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3
				.setHorizontalGroup(gl_panel_3
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_3
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																Alignment.TRAILING,
																gl_panel_3
																		.createSequentialGroup()
																		.addComponent(
																				listaPrecoEquipamentos,
																				GroupLayout.DEFAULT_SIZE,
																				412,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_panel_3
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_3
																										.createSequentialGroup()
																										.addGap(39)
																										.addComponent(
																												label,
																												GroupLayout.PREFERRED_SIZE,
																												111,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								campoValorTotal,
																								GroupLayout.PREFERRED_SIZE,
																								188,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_panel_3
																										.createSequentialGroup()
																										.addGap(125)
																										.addComponent(
																												button,
																												GroupLayout.PREFERRED_SIZE,
																												63,
																												GroupLayout.PREFERRED_SIZE))))
														.addComponent(
																lblNewLabel_1))
										.addContainerGap()));
		gl_panel_3
				.setVerticalGroup(gl_panel_3
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_3
										.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addComponent(
																				label,
																				GroupLayout.PREFERRED_SIZE,
																				25,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(11)
																		.addComponent(
																				campoValorTotal,
																				GroupLayout.PREFERRED_SIZE,
																				54,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				button))
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addComponent(
																				listaPrecoEquipamentos,
																				GroupLayout.DEFAULT_SIZE,
																				334,
																				Short.MAX_VALUE)
																		.addContainerGap()))));
		panel_3.setLayout(gl_panel_3);
	}
}
