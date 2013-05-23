package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.luguia.arceus.model.Financeiro;
import br.com.luguia.arceus.model.Requisicao;
import br.com.luguia.arceus.model.dao.array.ProjetoDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;

public class TelaProducao extends JFrame {

	private JPanel contentPane;
	private JTable tabelaSolicitacoesFinanceiro;
	private JTextArea campoDescricaoPedido;
	private JTextArea listaPrecoEquipamentos;

	private JTextField campoValorTotal;

	private ProjetoDAO projetoDao = new ProjetoDAO();
	private ArrayList<Requisicao> manipulaProjeto;
	private Requisicao projeto;
	private Financeiro custos;
	private int chaveControle = 0;
	
	
	public TelaProducao() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			
				tabelaSincronizada();
				limpaCampos();
			}
		});

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

		JLabel lblNewLabel = new JLabel(" P r o d u \u00E7 \u00E3 o");
		lblNewLabel.setIcon(new ImageIcon(TelaProducao.class.getResource("/images/chart.png")));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 366, 56);
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
		btnAbrir.setIcon(new ImageIcon(TelaProducao.class.getResource("/Images16x16/accept.png")));
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String codigo, nome;

					codigo = (String) tabelaSolicitacoesFinanceiro.getModel().getValueAt(
							tabelaSolicitacoesFinanceiro.getSelectedRow(), 0);
					nome = (String) tabelaSolicitacoesFinanceiro.getModel().getValueAt(
							tabelaSolicitacoesFinanceiro.getSelectedRow(), 1);

					manipulaProjeto = (ArrayList<Requisicao>) projetoDao
							.listeTodos();
					for (int i = 0; i < manipulaProjeto.size(); i++) {
						if (manipulaProjeto.get(i).getNomeProjet()
								.equalsIgnoreCase(nome.toString().trim())
								&& manipulaProjeto.get(i).getIdProjeto() == Integer
										.parseInt(codigo)) {
							chaveControle = 1;
							campoDescricaoPedido.setText(""
									+ manipulaProjeto.get(i).getDefinicaoProjeto());
							
							projeto = new Requisicao();
							custos = new Financeiro();
							projeto.setIdProjeto(manipulaProjeto.get(i).getIdProjeto());
							
						}
					}
					

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Ninguém foi selecionado !");
				}

			}
		});
		btnAbrir.setBounds(314, 171, 124, 23);
		panel_1.add(btnAbrir);

		tabelaSolicitacoesFinanceiro = new JTable();
		tabelaSolicitacoesFinanceiro.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, }, new String[] {
						"New column", "New column", "New column" }));
		tabelaSolicitacoesFinanceiro.setBounds(10, 26, 267, 168);
		panel_1.add(tabelaSolicitacoesFinanceiro);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 205, 430, 2);
		panel_1.add(separator_1);

		JLabel lblEnviar = new JLabel("Descri\u00E7\u00E3o completa do pedido");
		lblEnviar.setBounds(10, 212, 202, 14);
		panel_1.add(lblEnviar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setIcon(new ImageIcon(TelaProducao.class.getResource("/Images16x16/database.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaSincronizada();
			}
		});

		btnAtualizar.setBounds(314, 22, 126, 23);
		panel_1.add(btnAtualizar);

		campoDescricaoPedido = new JTextArea();
		campoDescricaoPedido.setBounds(10, 237, 404, 145);
		panel_1.add(campoDescricaoPedido);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(287, 26, 17, 168);
		panel_1.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(423, 237, 17, 145);
		panel_1.add(scrollBar_1);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(470, 71, 1, 389);
		contentPane.add(separator);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Retorna dados ao Setor Financeiro", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3.setBounds(481, 67, 703, 393);
		contentPane.add(panel_3);

		campoValorTotal = new JTextField();
		campoValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		campoValorTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		campoValorTotal.setColumns(10);

		JButton button = new JButton("Enviar");
		button.setIcon(new ImageIcon(TelaProducao.class.getResource("/Images16x16/accept.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chaveControle == 1){
					projeto.setCustoEquipamento(listaPrecoEquipamentos.getText().toString());
					projeto.setPorcentagemConclusao(10);				
					
					String dinheiro[] = campoValorTotal.getText().toString().trim().split(",");
					custos.setCusto(Double.parseDouble(dinheiro[0]+"."+dinheiro[1]));
					
					projeto.setCustos(custos);
					
					projetoDao.altere(projeto, 4);
					
					
				}else{
					JOptionPane.showMessageDialog(null, "Você esqueceu de escolher o projeto na lista!");
				}
				
				tabelaSincronizada();
				limpaCampos();
				
			}
		});

		JLabel label = new JLabel("Total gasto");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));

		listaPrecoEquipamentos = new JTextArea();

		JLabel lblNewLabel_1 = new JLabel(
				"Relatorio do valor que ser\u00E1 gasto em equipamentos e servis\u00E7os para esse projeto");
		
		JLabel lblOCampoTotal = new JLabel("o campo total gasto deve apenas acc ,");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(listaPrecoEquipamentos, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_3.createSequentialGroup()
										.addGap(39)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
									.addComponent(campoValorTotal, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblOCampoTotal))
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel_1))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addGap(11)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblOCampoTotal)
							.addGap(33)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(campoValorTotal, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(listaPrecoEquipamentos, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
							.addContainerGap())))
		);
		panel_3.setLayout(gl_panel_3);
	}

	public void tabelaSincronizada() {

		DefaultTableModel model = (DefaultTableModel) tabelaSolicitacoesFinanceiro.getModel();
		model.setNumRows(0);

		manipulaProjeto = (ArrayList<Requisicao>) projetoDao
				.listeTodos();

		for (int i = 0; i < manipulaProjeto.size(); i++) {
			if(manipulaProjeto.get(i).getPorcentagemConclusao()==5){
			model.addRow(new String[] {
					"" + manipulaProjeto.get(i).getIdProjeto(),
					"" + manipulaProjeto.get(i).getNomeProjet(),
					"" + manipulaProjeto.get(i).getPorcentagemConclusao()+"% concluido",
					"R$" + manipulaProjeto.get(i).getCustos().getOrcamento()});
			}
		}
		
	}
	
	public void limpaCampos(){
		campoDescricaoPedido.setText("");
		campoValorTotal.setText("0,00");
		listaPrecoEquipamentos.setText("");
	}
}
