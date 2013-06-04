package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.luguia.arceus.model.Funcionario;
import br.com.luguia.arceus.model.Job;
import br.com.luguia.arceus.model.Requisicao;
import br.com.luguia.arceus.model.dao.array.CriacaoDAO;
import br.com.luguia.arceus.model.dao.array.FuncionarioDAO;
import br.com.luguia.arceus.model.dao.array.ProjetoDAO;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class TelaCriação extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JTable tabelaSolicitacoesAprovadas;
	private JTextArea campoInformacoes;
	private JComboBox comboPrioridade;
	private JTextField campoCodigo;
	private JTextField campoNome;
	private String andamento;
	private int cont;
	private boolean projetoAberto;
	private JTextArea campoCaracteristicasJob;
	private JTextArea campoCaracteristicaJobPendente;

	private ProjetoDAO projetoDao = new ProjetoDAO();
	private ArrayList<Requisicao> manipulaProjeto;
	private Requisicao projeto;
	private JTable tabelaFuncionarioCriacao;
	private JTable tabelaJobs;

	private CriacaoDAO jobDao = new CriacaoDAO();
	private ArrayList<Job> manipulaTrabalho;
	private Job trabalho;

	private FuncionarioDAO funcionarioDao = new FuncionarioDAO();
	private ArrayList<Funcionario> manipulaFuncionario;
	private Funcionario funcionario;
	private int prioridade = 1;
	private int codigoJob;

	private Funcionario funcionarioLogado = new Funcionario();
	private JTable tabelaProjetoConcluido;

	public TelaCriação() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCriação.class.getResource("/Images16x16/favorite.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				funcionarioLogado();
				tabelaSincronizada();
				tabelaJobSincronizada();
				tabelaProjetoSincronizada();
			}
		});

		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1194, 56);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("C r i a \u00E7 \u00E3 o");
		lblNewLabel.setIcon(new ImageIcon(TelaCriação.class.getResource("/images/favorite.png")));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 258, 34);
		panel.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(468, 67, 416, 393);
		contentPane.add(panel_3);
		panel_3.setBorder(new TitledBorder(null, "Job's", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 20, 41, 16);
		panel_3.add(lblNome);

		campoNome = new JTextField();
		campoNome.setBounds(55, 18, 245, 26);
		panel_3.add(campoNome);
		campoNome.setColumns(10);

		JButton btnOk = new JButton("Enviar");
		btnOk.setIcon(new ImageIcon(TelaCriação.class.getResource("/Images16x16/accept.png")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO

				try {
					String codigo;

					codigo = (String) tabelaFuncionarioCriacao.getModel()
							.getValueAt(
									tabelaFuncionarioCriacao.getSelectedRow(),
									0);

					manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDao
							.listeTodos();

					for (int i = 0; i < manipulaFuncionario.size(); i++) {
						if (manipulaFuncionario.get(i).getId() == Integer
								.parseInt(codigo)) {

							if (projetoAberto = true) {
								if (campoCodigo.getText().toString().trim()
										.equalsIgnoreCase("")
										|| campoNome.getText().toString()
												.trim().equalsIgnoreCase("")
										|| campoCaracteristicasJob.getText()
												.toString().trim()
												.equalsIgnoreCase("")) {
									JOptionPane.showMessageDialog(null,
											"Preencha todos os campos!");
								} else {

									trabalho = new Job();

									trabalho.setCaracteristicasJob(campoCaracteristicasJob
											.getText().toString());
									trabalho.setIdJob(codigoJob);
									trabalho.setIdFuncionario(Integer
											.parseInt(codigo));
									trabalho.setIdProjeto(Integer
											.parseInt(campoCodigo.getText()
													.toString().trim()));
									trabalho.setNomeJob(campoNome.getText()
											.toString().trim());
									// tratar o campo prioridade
									trabalho.setPrioridadeJob(prioridade);
									trabalho.setStatus("desenvolvendo");
									jobDao.insira(trabalho);

									projeto = new Requisicao();
									projeto.setIdProjeto(Integer
											.parseInt(campoCodigo.getText()
													.toString().trim()));
									projeto.setPorcentagemConclusao(atualizaProgresso(Integer
											.parseInt(campoCodigo.getText()
													.toString().trim())));

									projetoDao.altere(projeto, 3);

									limpaCampo();
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"Escolha algum projeto na lista");
							}

						}

					}

				} catch (ArrayIndexOutOfBoundsException exp) {
					JOptionPane.showMessageDialog(null,
							"Escolha algum funcionario para enviar o Job!");
				}finally{
					tabelaSincronizada();
					tabelaJobSincronizada();
					tabelaProjetoSincronizada();
				}

				
			}
		});

		btnOk.setBounds(291, 346, 115, 36);
		panel_3.add(btnOk);

		String prioridade[] = { "Prioridade 1", "Prioridade 2", "Prioridade 3",
				"Prioridade 4", "Prioridade 5" };
		comboPrioridade = new JComboBox(prioridade);
		comboPrioridade.addItemListener(this);
		comboPrioridade.setBounds(291, 242, 116, 25);
		panel_3.add(comboPrioridade);

		campoCaracteristicasJob = new JTextArea();
		campoCaracteristicasJob.setLineWrap(true);
	
		JScrollPane scrollCaracteristicasJob = new JScrollPane(campoCaracteristicasJob);
		scrollCaracteristicasJob.setBounds(12, 74, 394, 155);
		panel_3.add(scrollCaracteristicasJob);

		JLabel lblCaracteristicasDoJob = new JLabel("Caracteristicas do Job");
		lblCaracteristicasDoJob.setBounds(12, 47, 138, 16);
		panel_3.add(lblCaracteristicasDoJob);

		tabelaFuncionarioCriacao = new JTable();
		tabelaFuncionarioCriacao.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Código", "Nome"
			}
		));
		tabelaFuncionarioCriacao.getColumnModel().getColumn(1).setPreferredWidth(274);
		
		JScrollPane scrollFuncionarioCriacao = new JScrollPane(tabelaFuncionarioCriacao);
		scrollFuncionarioCriacao.setBounds(12, 261, 267, 121);
		panel_3.add(scrollFuncionarioCriacao);

		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setBounds(12, 240, 82, 16);
		panel_3.add(lblFuncionario);

		campoCodigo = new JTextField();
		campoCodigo.setBounds(356, 15, 50, 29);
		panel_3.add(campoCodigo);
		campoCodigo.setEditable(false);
		campoCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(308, 18, 55, 16);
		panel_3.add(lblCodigo);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 67, 444, 393);
		contentPane.add(tabbedPane_1);

		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Solicitações Aprovadas", null, panel_1, null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 416, 343);
		panel_1.add(panel_2);
		panel_2.setBorder(new TitledBorder(null, "Solicitações",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);

		campoInformacoes = new JTextArea();
		campoInformacoes.setLineWrap(true);
		JScrollPane scrollInformacoes = new JScrollPane(campoInformacoes);
		scrollInformacoes.setBounds(10, 174, 394, 124);
		panel_2.add(scrollInformacoes);

		tabelaSolicitacoesAprovadas = new JTable();
		tabelaSolicitacoesAprovadas.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, }, new String[] {
						"Código", "Nome", "Percentual de Conclusão" }));
		
		JScrollPane scrollSolicitacoesAprovadas = new JScrollPane(tabelaSolicitacoesAprovadas);
		scrollSolicitacoesAprovadas.setBounds(10, 22, 394, 124);
		panel_2.add(scrollSolicitacoesAprovadas);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.setIcon(new ImageIcon(TelaCriação.class.getResource("/Images16x16/accept.png")));
		btnAbrir.setBounds(303, 298, 101, 34);
		panel_2.add(btnAbrir);

		JButton botaoAtualiza = new JButton("Atualizar");
		botaoAtualiza.setIcon(new ImageIcon(TelaCriação.class.getResource("/Images16x16/database.png")));
		botaoAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaSincronizada();
				tabelaJobSincronizada();
				tabelaProjetoSincronizada();
				limpaCampo();
			}
		});
		botaoAtualiza.setBounds(184, 298, 107, 34);
		panel_2.add(botaoAtualiza);

		JLabel lblCaracteristicas = new JLabel("Caracteristicas");
		lblCaracteristicas.setBounds(10, 157, 89, 14);
		panel_2.add(lblCaracteristicas);
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					projetoAberto = true;

					String codigo;

					codigo = (String) tabelaSolicitacoesAprovadas.getModel()
							.getValueAt(
									tabelaSolicitacoesAprovadas
											.getSelectedRow(), 0);

					manipulaProjeto = (ArrayList<Requisicao>) projetoDao
							.listeTodos();

					for (int i = 0; i < manipulaProjeto.size(); i++) {
						if (manipulaProjeto.get(i).getIdProjeto() == Integer
								.parseInt(codigo)) {
							campoInformacoes.setText(""
									+ manipulaProjeto.get(i)
											.getDefinicaoProjeto());
							campoCodigo.setText(codigo + "");
						}

					}

				} catch (ArrayIndexOutOfBoundsException exp) {
					JOptionPane.showMessageDialog(null,
							"Escolha algum projeto na lista!");
				}
			}
		});

		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Job's pendentes", null, panel_4, null);
		panel_4.setLayout(null);

		JButton btnSelecionar = new JButton("Abrir");
		btnSelecionar.setIcon(new ImageIcon(TelaCriação.class.getResource("/Images16x16/accept.png")));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String codigo;

					codigo = (String) tabelaJobs.getModel().getValueAt(
							tabelaJobs.getSelectedRow(), 0);

					manipulaTrabalho = (ArrayList<Job>) jobDao.listeTodos();

					for (int i = 0; i < manipulaTrabalho.size(); i++) {

						if (manipulaTrabalho.get(i).getIdJob() == Integer
								.parseInt(codigo)) {
							campoCaracteristicaJobPendente.setText(""
									+ manipulaTrabalho.get(i)
											.getCaracteristicasJob());

						}

					}

				} catch (ArrayIndexOutOfBoundsException exp) {
					JOptionPane.showMessageDialog(null,
							"Escolha algum projeto na lista!");
				}

			}
		});
		btnSelecionar.setBounds(330, 324, 99, 37);
		panel_4.add(btnSelecionar);

		campoCaracteristicaJobPendente = new JTextArea();
		campoCaracteristicaJobPendente.setLineWrap(true);
		campoCaracteristicaJobPendente.setBounds(10, 199, 419, 121);
		panel_4.add(campoCaracteristicaJobPendente);

		JLabel label = new JLabel("Caracteristicas do Job");
		label.setBounds(10, 172, 419, 16);
		panel_4.add(label);

		tabelaJobs = new JTable();
		tabelaJobs.setModel(new DefaultTableModel(new Object[][] { { null,
				null, null }, }, new String[] { "New column", "New column",
				"New column" }));
		tabelaJobs.setBounds(10, 38, 419, 123);
		panel_4.add(tabelaJobs);

		JLabel lblJobs = new JLabel(" Job's");
		lblJobs.setBounds(10, 11, 419, 16);
		panel_4.add(lblJobs);

		JButton btnFinalizado = new JButton("Finalizado");
		btnFinalizado.setIcon(new ImageIcon(TelaCriação.class.getResource("/Images16x16/folder_accept.png")));
		btnFinalizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int porcentagem = 0;
				try {
					String codigo;

					codigo = (String) tabelaJobs.getModel()
							.getValueAt(
									tabelaJobs
											.getSelectedRow(), 0);

					manipulaTrabalho = (ArrayList<Job>) jobDao
							.listeTodos();

					manipulaProjeto = (ArrayList<Requisicao>) projetoDao
							.listeTodos();
					
					for (int i = 0; i < manipulaTrabalho.size(); i++) {
						if (manipulaTrabalho.get(i).getIdJob() == Integer
								.parseInt(codigo)) {
							trabalho = new Job();
							trabalho.setStatus("desenvolvido");
							trabalho.setIdJob(manipulaTrabalho.get(i).getIdJob());
							
							jobDao.altera(trabalho);
							for(int j = 0; j < manipulaProjeto.size(); j++){
								if(manipulaProjeto.get(j).getIdProjeto() == manipulaTrabalho.get(i).getIdProjeto()){
									porcentagem = manipulaProjeto.get(j).getPorcentagemConclusao();
								}
							}
							
							projeto = new Requisicao();
							projeto.setIdProjeto(manipulaTrabalho.get(i).getIdProjeto());
							projeto.setPorcentagemConclusao(porcentagem+3);
							
							projetoDao.altere(projeto, 3);
							
							//informar aque que foi desenvolvido
						}

					}

				} catch (ArrayIndexOutOfBoundsException exp) {
					JOptionPane.showMessageDialog(null,
							"Escolha algum projeto na lista!");
				}finally{
					tabelaSincronizada();
					tabelaJobSincronizada();
					tabelaProjetoSincronizada();
					campoCaracteristicaJobPendente.setText("");
				}
			}
		});
		btnFinalizado.setBounds(10, 324, 114, 37);
		panel_4.add(btnFinalizado);
		
		JButton btnAtualiza = new JButton("Atualizar");
		btnAtualiza.setIcon(new ImageIcon(TelaCriação.class.getResource("/Images16x16/database.png")));
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaSincronizada();
				tabelaJobSincronizada();
				tabelaProjetoSincronizada();
			}
		});
		btnAtualiza.setBounds(211, 324, 107, 37);
		panel_4.add(btnAtualiza);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Projetos Concluidos", null, panel_5, null);
		panel_5.setLayout(null);
		
		tabelaProjetoConcluido = new JTable();
		tabelaProjetoConcluido.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tabelaProjetoConcluido.setBounds(10, 38, 419, 282);
		panel_5.add(tabelaProjetoConcluido);
		
		JLabel lblProjetosConcluidos = new JLabel("Projetos concluidos");
		lblProjetosConcluidos.setBounds(10, 11, 419, 16);
		panel_5.add(lblProjetosConcluidos);
		
		JButton btnMidia = new JButton("M\u00EDdia");
		btnMidia.setIcon(new ImageIcon(TelaCriação.class.getResource("/Images16x16/movie_track.png")));
		btnMidia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String codigo, nome;

					codigo = (String) tabelaProjetoConcluido.getModel().getValueAt(
							tabelaProjetoConcluido.getSelectedRow(), 0);
					nome = (String) tabelaProjetoConcluido.getModel().getValueAt(
							tabelaProjetoConcluido.getSelectedRow(), 1);

					manipulaProjeto = (ArrayList<Requisicao>) projetoDao
							.listeTodos();
					for (int i = 0; i < manipulaProjeto.size(); i++) {
						if (manipulaProjeto.get(i).getNomeProjet()
								.equalsIgnoreCase(nome.toString().trim())
								&& manipulaProjeto.get(i).getIdProjeto() == Integer
										.parseInt(codigo) && manipulaProjeto.get(i).getPorcentagemConclusao()>20) {
							
							projeto = new Requisicao();
							projeto.setPorcentagemConclusao(80);
							projeto.setIdProjeto(manipulaProjeto.get(i).getIdProjeto());
							
							projetoDao.altere(projeto, 3);
						}
					}
					

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum projeto foi selecionad");
				}finally{
					tabelaSincronizada();
					tabelaJobSincronizada();
					tabelaProjetoSincronizada();
					
				}
				
				
			}
		});
		btnMidia.setBounds(340, 324, 89, 39);
		panel_5.add(btnMidia);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setIcon(new ImageIcon(TelaCriação.class.getResource("/Images16x16/database.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaSincronizada();
				tabelaJobSincronizada();
				tabelaProjetoSincronizada();
				
				
			}
		});
		btnAtualizar.setBounds(213, 324, 115, 39);
		panel_5.add(btnAtualizar);

		ButtonGroup bt = new ButtonGroup();

	}

	public void tabelaSincronizada() {

		DefaultTableModel model = (DefaultTableModel) tabelaSolicitacoesAprovadas
				.getModel();
		model.setNumRows(0);

		manipulaProjeto = (ArrayList<Requisicao>) projetoDao.listeTodos();

		for (int i = 0; i < manipulaProjeto.size(); i++) {
			if (manipulaProjeto.get(i).getPorcentagemConclusao() >= 20 && manipulaProjeto.get(i).getPorcentagemConclusao()<80) {
				model.addRow(new String[] {
						"" + manipulaProjeto.get(i).getIdProjeto(),
						"" + manipulaProjeto.get(i).getNomeProjet(),
						"" + manipulaProjeto.get(i).getPorcentagemConclusao()
								+ "% concluido" });
			}
		}
		tabelaFuncionarioSincronizada();

	}

	public void tabelaFuncionarioSincronizada() {

		DefaultTableModel model = (DefaultTableModel) tabelaFuncionarioCriacao
				.getModel();
		model.setNumRows(0);

		manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDao
				.listeTodos();

		for (int i = 0; i < manipulaFuncionario.size(); i++) {
			if (manipulaFuncionario.get(i).getTipo()
					.equalsIgnoreCase("criacao")) {
				model.addRow(new String[] {
						"" + manipulaFuncionario.get(i).getId(),
						"" + manipulaFuncionario.get(i).getNome() });
			}
		}
		posicaoCorreta();
	}

	public void posicaoCorreta() {
		int indice = 1;

		manipulaTrabalho = (ArrayList<Job>) jobDao.listeTodos();
		try {
			indice += manipulaTrabalho.get(manipulaTrabalho.size() - 1)
					.getIdJob();
		} catch (Exception exp) {

		} finally {
			codigoJob = indice;
		}

	}

	public int atualizaProgresso(int codigoProjeto) {
		int progresso = 1;

		manipulaProjeto = (ArrayList<Requisicao>) projetoDao.listeTodos();

		for (int i = 0; i < manipulaProjeto.size(); i++) {
			if (codigoProjeto == manipulaProjeto.get(i).getIdProjeto()
					&& manipulaProjeto.get(i).getPorcentagemConclusao() >= 20) {
				progresso += manipulaProjeto.get(i).getPorcentagemConclusao();
			}
		}

		return progresso;
	}

	public void limpaCampo() {
		campoCaracteristicasJob.setText("");
		campoCodigo.setText("");
		campoInformacoes.setText("");
		campoNome.setText("");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			// "Prioridade 1", "Prioridade 2", "Prioridade 3","Prioridade 4",
			// "Prioridade 5"
			if (e.getItem().toString().equalsIgnoreCase("Prioridade 1")) {
				prioridade = 1;
			} else if (e.getItem().toString().equalsIgnoreCase("Prioridade 2")) {
				prioridade = 2;
			} else if (e.getItem().toString().equalsIgnoreCase("Prioridade 3")) {
				prioridade = 3;
			} else if (e.getItem().toString().equalsIgnoreCase("Prioridade 4")) {
				prioridade = 4;
			} else if (e.getItem().toString().equalsIgnoreCase("Prioridade 5")) {
				prioridade = 5;
			}

		}

	}

	public void funcionarioLogado() {
		InputStream is;
		try {
			is = new FileInputStream("ReferenciaFuncionario.txt");

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String idFuncionario = br.readLine();

			manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDao
					.listeTodos();

			for (int i = 0; i < manipulaFuncionario.size(); i++) {
				if (manipulaFuncionario.get(i).getId() == Integer
						.parseInt(idFuncionario)) {
					funcionarioLogado = manipulaFuncionario.get(i);
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void tabelaJobSincronizada() {

		DefaultTableModel model = (DefaultTableModel) tabelaJobs.getModel();
		model.setNumRows(0);

		manipulaTrabalho = (ArrayList<Job>) jobDao.listeTodos();

		for (int i = 0; i < manipulaTrabalho.size(); i++) {
			// if insserido para que o usuario master não conste na lista!
			if (manipulaTrabalho.get(i).getIdFuncionario() == funcionarioLogado
					.getId() && manipulaTrabalho.get(i).getStatus().equalsIgnoreCase("desenvolvendo")) {
				model.addRow(new String[] {
						"" + manipulaTrabalho.get(i).getIdJob(),
						"" + manipulaTrabalho.get(i).getNomeJob(),
						"" + manipulaTrabalho.get(i).getPrioridadeJob() });
			}
		}

	}
	
	
	public void tabelaProjetoSincronizada() {
		int idProjeto;
		int quantidadeJobs = 0;
		int quantidadeJobsFinalizados = 0;
		
		DefaultTableModel model = (DefaultTableModel) tabelaProjetoConcluido.getModel();
		model.setNumRows(0);

		
		
		manipulaProjeto = (ArrayList<Requisicao>) projetoDao.listeTodos();
		manipulaTrabalho = (ArrayList<Job>) jobDao.listeTodos();
		
		for (int i = 0; i < manipulaProjeto.size(); i++) {
		idProjeto = manipulaProjeto.get(i).getIdProjeto();
	
		
			if(manipulaProjeto.get(i).getPorcentagemConclusao() >20 && manipulaProjeto.get(i).getPorcentagemConclusao() <80){
			
			for (int j = 0; j < manipulaTrabalho.size(); j++) {
			
				if (manipulaTrabalho.get(j).getIdProjeto() == idProjeto && manipulaTrabalho.get(j).getStatus().equalsIgnoreCase("desenvolvido")) {
					
					quantidadeJobsFinalizados+=1;
					
			}
						
			}
			for(int k = 0; k<manipulaTrabalho.size();k++){
				if(manipulaTrabalho.get(k).getIdProjeto() == idProjeto){
					quantidadeJobs+=1;
				}
			}
			
			}
			
			if(quantidadeJobs == quantidadeJobsFinalizados && manipulaProjeto.get(i).getPorcentagemConclusao()>20 && manipulaProjeto.get(i).getPorcentagemConclusao()<80){
				
				model.addRow(new String[] {
						"" + manipulaProjeto.get(i).getIdProjeto(),
						"" + manipulaProjeto.get(i).getNomeProjet(),
						"" + manipulaProjeto.get(i).getPorcentagemConclusao()+"% concluido" });
			}
			quantidadeJobs = 0;
			quantidadeJobsFinalizados = 0;
				
		}
		

	}
	

}
