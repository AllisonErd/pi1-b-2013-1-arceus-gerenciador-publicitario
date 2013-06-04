package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.naming.LimitExceededException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import br.com.luguia.arceus.model.Financeiro;
import br.com.luguia.arceus.model.Requisicao;
import br.com.luguia.arceus.model.dao.array.ProjetoDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import java.awt.Toolkit;

public class TelaFinanceiro extends JFrame {

	private JPanel contentPane;
	private JTextField campoLucro;
	private JTextField campoTotalCaixa;
	private JTable tabelaSolicitacoes;
	
	private JTable tabelaPedidosAvaliados;

	private ProjetoDAO projetoDao = new ProjetoDAO();
	private ArrayList<Requisicao> manipulaProjeto;
	private Requisicao projeto;
	private Financeiro custo;
	private JTextField campoDesconto;
	
	public TelaFinanceiro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFinanceiro.class.getResource("/Images24x24/calculator.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				tabelaSincronizada();
				
			}
		});



		setResizable(false);
		setTitle("Setor financeiro");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1032, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1194, 56);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(" F i n a n c e i r o");
		lblNewLabel.setIcon(new ImageIcon(TelaFinanceiro.class.getResource("/images/calculator.png")));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 344, 56);
		panel.add(lblNewLabel);

		JLabel lblSolicitaoDeOramento = new JLabel(
				"Solicita\u00E7\u00E3o de Or\u00E7amento");
		lblSolicitaoDeOramento.setBounds(10, 68, 152, 16);
		contentPane.add(lblSolicitaoDeOramento);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 240, 500, 3);
		contentPane.add(separator);

		JLabel lblDescrioDoPedido = new JLabel("Descri\u00E7\u00E3o do pedido");
		lblDescrioDoPedido.setBounds(10, 255, 152, 16);
		contentPane.add(lblDescrioDoPedido);

		final JTextArea campoDescricao = new JTextArea();
		campoDescricao.setLineWrap(true);
		
		JScrollPane scrollDescricao = new JScrollPane(campoDescricao);
		scrollDescricao.setBounds(10, 283, 490, 132);
		contentPane.add(scrollDescricao);
		

		JButton btnSolicitaCusto = new JButton("Solicita Custo");
		btnSolicitaCusto.setIcon(new ImageIcon(TelaFinanceiro.class.getResource("/Images16x16/calculator_add.png")));
		btnSolicitaCusto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String codigo, nome;

					codigo = (String) tabelaSolicitacoes.getModel().getValueAt(
							tabelaSolicitacoes.getSelectedRow(), 0);
					nome = (String) tabelaSolicitacoes.getModel().getValueAt(
							tabelaSolicitacoes.getSelectedRow(), 1);

					manipulaProjeto = (ArrayList<Requisicao>) projetoDao
							.listeTodos();
					for (int i = 0; i < manipulaProjeto.size(); i++) {
						if (manipulaProjeto.get(i).getNomeProjet()
								.equalsIgnoreCase(nome.toString().trim())
								&& manipulaProjeto.get(i).getIdProjeto() == Integer
										.parseInt(codigo)) {
							
							projeto = new Requisicao();
							projeto.setIdProjeto(manipulaProjeto.get(i).getIdProjeto());
							projeto.setPorcentagemConclusao(5);
							
							projetoDao.altere(projeto, 3);
							
							campoDescricao.setText("");
						}
					}
					

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Ninguém foi selecionado !");
				} finally{
					tabelaSincronizada();
					
				}
			
				
				
			}
		});
	
		btnSolicitaCusto.setBounds(10, 428, 142, 31);
		contentPane.add(btnSolicitaCusto);

		JButton btnRetornaOramento = new JButton("Voltar");
		btnRetornaOramento.setIcon(new ImageIcon(TelaFinanceiro.class.getResource("/Images16x16/back.png")));
		btnRetornaOramento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnRetornaOramento.setBounds(738, 428, 112, 31);
		contentPane.add(btnRetornaOramento);

		JLabel lblCustoDeProduo = new JLabel(
				"Pedidos avaliado pelo setor de produ\u00E7\u00E3o");
		lblCustoDeProduo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustoDeProduo.setBounds(776, 68, 238, 16);
		contentPane.add(lblCustoDeProduo);

		JLabel lblLucro = new JLabel("Lucro");
		lblLucro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLucro.setBounds(770, 323, 112, 16);
		contentPane.add(lblLucro);

		campoLucro = new JTextField();
		campoLucro.setHorizontalAlignment(SwingConstants.CENTER);
		campoLucro.setText("0");
		campoLucro.setColumns(10);
		campoLucro.setBounds(900, 321, 114, 31);
		contentPane.add(campoLucro);

		campoTotalCaixa = new JTextField();
		campoTotalCaixa.setEditable(false);
		campoTotalCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		campoTotalCaixa.setColumns(10);
		campoTotalCaixa.setBounds(900, 395, 114, 31);
		contentPane.add(campoTotalCaixa);

		JLabel lblTotalEmCaixa = new JLabel("Total em caixa");
		lblTotalEmCaixa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalEmCaixa.setBounds(770, 397, 112, 16);
		contentPane.add(lblTotalEmCaixa);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(512, 96, 2, 363);
		contentPane.add(separator_2);

		JButton button = new JButton("Retorna Or\u00E7.");
		button.setIcon(new ImageIcon(TelaFinanceiro.class.getResource("/Images16x16/accept.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String codigo, nome;

					codigo = (String) tabelaPedidosAvaliados.getModel().getValueAt(
							tabelaPedidosAvaliados.getSelectedRow(), 0);
					nome = (String) tabelaPedidosAvaliados.getModel().getValueAt(
							tabelaPedidosAvaliados.getSelectedRow(), 1);

					manipulaProjeto = (ArrayList<Requisicao>) projetoDao
							.listeTodos();
					for (int i = 0; i < manipulaProjeto.size(); i++) {
						if (manipulaProjeto.get(i).getNomeProjet()
								.equalsIgnoreCase(nome.toString().trim())
								&& manipulaProjeto.get(i).getIdProjeto() == Integer
										.parseInt(codigo)) {

							projeto = new Requisicao();
							custo = new Financeiro();
							
							double desconto = Double.parseDouble(campoDesconto.getText().toString().trim());
							double lucro = Double.parseDouble(campoLucro.getText().toString().trim());
							
							
							projeto.setIdProjeto(manipulaProjeto.get(i).getIdProjeto());
							
							projeto.setPorcentagemConclusao(15);
							custo.setCusto(manipulaProjeto.get(i).getCustos().getCusto());
							custo.setDesconto(desconto);
							custo.setGanho(lucro - desconto);
							custo.setOrcamento(manipulaProjeto.get(i).getCustos().getCusto()+(lucro - desconto));
							//(lucro+manipulaProjeto.get(i).getCustos().getCusto())-desconto
							projeto.setCustos(custo);

							projetoDao.altere(projeto, 2);
							projetoDao.altere(projeto, 3);
							
						}
					}
					

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Ninguém foi selecionado !");
				}finally{
					tabelaSincronizada();
					campoDesconto.setText("0");
					campoLucro.setText("0");
				}
				
			}
		});
	
		button.setBounds(862, 428, 152, 31);
		contentPane.add(button);

		tabelaSolicitacoes = new JTable();
		tabelaSolicitacoes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Código", "Nome Projeto", "Data Soliciação", "Data Entrega"
			}
		));
		tabelaSolicitacoes.getColumnModel().getColumn(0).setPreferredWidth(15);
		tabelaSolicitacoes.getColumnModel().getColumn(1).setPreferredWidth(150);
		
		
		JScrollPane scrollSolicitacoes = new JScrollPane(tabelaSolicitacoes);
		scrollSolicitacoes.setBounds(20, 96, 480, 132);
		contentPane.add(scrollSolicitacoes);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setIcon(new ImageIcon(TelaFinanceiro.class.getResource("/Images16x16/database.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaSincronizada();
			}
		});

		btnAtualizar.setBounds(457, 57, 112, 31);
		contentPane.add(btnAtualizar);

		tabelaPedidosAvaliados = new JTable();
		tabelaPedidosAvaliados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Código", "Nome Projeto", "Custo de Produção"
			}
		));
		
		
		JScrollPane scrollPedidosAvaliados = new JScrollPane(tabelaPedidosAvaliados);
		scrollPedidosAvaliados.setBounds(536, 95, 478, 216);
		contentPane.add(scrollPedidosAvaliados);
		
		JButton btnVisualizar = new JButton("Ver Caracteristicas");
		btnVisualizar.setIcon(new ImageIcon(TelaFinanceiro.class.getResource("/Images16x16/page_search.png")));
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					String codigo, nome;

					codigo = (String) tabelaSolicitacoes.getModel().getValueAt(
							tabelaSolicitacoes.getSelectedRow(), 0);
					nome = (String) tabelaSolicitacoes.getModel().getValueAt(
							tabelaSolicitacoes.getSelectedRow(), 1);

					manipulaProjeto = (ArrayList<Requisicao>) projetoDao
							.listeTodos();
					for (int i = 0; i < manipulaProjeto.size(); i++) {
						if (manipulaProjeto.get(i).getNomeProjet()
								.equalsIgnoreCase(nome.toString().trim())
								&& manipulaProjeto.get(i).getIdProjeto() == Integer
										.parseInt(codigo)) {

							campoDescricao.setText(""
									+ manipulaProjeto.get(i).getIdProjeto()+
									"\n"+manipulaProjeto.get(i).getNomeProjet()+
									"\n"+manipulaProjeto.get(i).getDataPedido()+
									"\n"+manipulaProjeto.get(i).getTempoEntrega()+
									"\n"+manipulaProjeto.get(i).getDefinicaoProjeto());
							

						}
					}
					

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Ninguém foi selecionado !");
				}
			
			}
		});
		btnVisualizar.setBounds(315, 428, 185, 30);
		contentPane.add(btnVisualizar);
		
		campoDesconto = new JTextField();
		campoDesconto.setText("0");
		campoDesconto.setHorizontalAlignment(SwingConstants.CENTER);
		campoDesconto.setColumns(10);
		campoDesconto.setBounds(900, 362, 114, 31);
		contentPane.add(campoDesconto);
		
		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesconto.setBounds(770, 364, 112, 16);
		contentPane.add(lblDesconto);
		
		JButton btnCadastraFuncionario = new JButton("Cadastrar funcionario");
		btnCadastraFuncionario.setIcon(new ImageIcon(TelaFinanceiro.class.getResource("/Images16x16/user_add.png")));
		btnCadastraFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroFuncionario().setVisible(true);
			}
		});
		btnCadastraFuncionario.setBounds(536, 428, 179, 30);
		contentPane.add(btnCadastraFuncionario);
	}
	
	
	public void tabelaSincronizada() {

		DefaultTableModel model = (DefaultTableModel) tabelaSolicitacoes.getModel();
		model.setNumRows(0);

		manipulaProjeto = (ArrayList<Requisicao>) projetoDao
				.listeTodos();

		for (int i = 0; i < manipulaProjeto.size(); i++) {
			if(manipulaProjeto.get(i).getPorcentagemConclusao()==0){
			model.addRow(new String[] {
					"" + manipulaProjeto.get(i).getIdProjeto(),
					"" + manipulaProjeto.get(i).getNomeProjet(),
					"" + manipulaProjeto.get(i).getDataPedido(),
					"" + manipulaProjeto.get(i).getTempoEntrega()});
			}
		}
		tabelaPedidosAvaliados();
	}
	
	public void tabelaPedidosAvaliados() {

		DefaultTableModel model = (DefaultTableModel) tabelaPedidosAvaliados.getModel();
		model.setNumRows(0);

		manipulaProjeto = (ArrayList<Requisicao>) projetoDao
				.listeTodos();

		for (int i = 0; i < manipulaProjeto.size(); i++) {
			if(manipulaProjeto.get(i).getPorcentagemConclusao()==10){
			
				model.addRow(new String[] {
					"" + manipulaProjeto.get(i).getIdProjeto(),
					"" + manipulaProjeto.get(i).getNomeProjet(),
					"R$" + manipulaProjeto.get(i).getCustos().getCusto()});
			}
		}
		totalCaixa();
	}

	public void totalCaixa(){
		double total = 0;
		manipulaProjeto = (ArrayList<Requisicao>) projetoDao
				.listeTodos();

		for (int i = 0; i < manipulaProjeto.size(); i++) {
			if(manipulaProjeto.get(i).getPorcentagemConclusao()>=20){
				total+=manipulaProjeto.get(i).getCustos().getGanho();
			}
		
		}
		campoTotalCaixa.setText("R$ "+total+"0");
	}
}
