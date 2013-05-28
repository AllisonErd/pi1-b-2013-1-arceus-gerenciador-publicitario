package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.luguia.arceus.model.Requisicao;
import br.com.luguia.arceus.model.dao.array.ProjetoDAO;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;

public class TelaMidia extends JFrame {

	private JTextPane campoMapaMidia;
	private JTextPane campoInformacoesProjeto;
	private JPanel contentPane;
	private JTable tabelaProjetosProntos;
	private ProjetoDAO projetoDao = new ProjetoDAO();
	private ArrayList<Requisicao> manipulaProjeto;
	private Requisicao projeto;

	private int idProjeto = 0;
	private JTable tabelaProjetosConcluidos;

	public TelaMidia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMidia.class.getResource("/Images24x24/movie_track.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tabelaSincronizada();

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

		JLabel lblNewLabel = new JLabel(" M \u00ED d i a");
		lblNewLabel.setIcon(new ImageIcon(TelaMidia.class
				.getResource("/images/movie_track.png")));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 217, 56);
		panel.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informações do Projeto",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(394, 67, 490, 170);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		campoInformacoesProjeto = new JTextPane();
		campoInformacoesProjeto.setBounds(10, 23, 470, 130);
		panel_2.add(campoInformacoesProjeto);

		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(523, 23, 17, 130);
		panel_2.add(scrollBar_2);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null,

		"Mapa de midia", TitledBorder.LEADING,

		TitledBorder.TOP, null, null));
		panel_3.setBounds(394, 248, 490, 212);
		contentPane.add(panel_3);

		campoMapaMidia = new JTextPane();
		campoMapaMidia.setBounds(10, 23, 470, 144);
		panel_3.add(campoMapaMidia);

		JButton btnGravarMapa = new JButton("Gravar Mapa");
		btnGravarMapa.setIcon(new ImageIcon(TelaMidia.class.getResource("/Images16x16/accept.png")));
		btnGravarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (campoMapaMidia.getText().toString().trim()
						.equalsIgnoreCase("")
						&& idProjeto == 0) {
					JOptionPane
							.showMessageDialog(null,
									"Preencha o campo referente as informações do mapa de mídia do projeto!  ");
				} else {
					projeto = new Requisicao();
					projeto.setIdProjeto(idProjeto);
					projeto.setTipoExecucao(campoMapaMidia.getText().toString().trim());
					projeto.setPorcentagemConclusao(100);
					projetoDao.altere(projeto, 5);
					
					projetoDao.altere(projeto, 3);
					
					campoInformacoesProjeto.setText("");
					campoMapaMidia.setText("");
				}
				tabelaSincronizada();
				
			}
		});
		btnGravarMapa.setBounds(349, 173, 131, 28);
		panel_3.add(btnGravarMapa);

		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(523, 23, 17, 130);
		panel_3.add(scrollBar_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 68, 372, 391);
		contentPane.add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Projetos em andamento", null, panel_4, null);
		panel_4.setLayout(null);
		
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 0, 367, 363);
				panel_4.add(panel_1);
				panel_1.setBorder(new TitledBorder(null, "Projetos aguardando mapa de midia",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setLayout(null);
				
						JButton btnAbrir = new JButton("Abrir");
						btnAbrir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								try {

									String codigo, nome;

									codigo = (String) tabelaProjetosProntos.getModel()
											.getValueAt(tabelaProjetosProntos.getSelectedRow(),
													0);
									nome = (String) tabelaProjetosProntos.getModel()
											.getValueAt(tabelaProjetosProntos.getSelectedRow(),
													1);

									manipulaProjeto = (ArrayList<Requisicao>) projetoDao
											.listeTodos();
									for (int i = 0; i < manipulaProjeto.size(); i++) {
										if (manipulaProjeto.get(i).getNomeProjet()
												.equalsIgnoreCase(nome.toString().trim())
												&& manipulaProjeto.get(i).getIdProjeto() == Integer
														.parseInt(codigo)
												&& manipulaProjeto.get(i)
														.getPorcentagemConclusao() == 80) {
											campoInformacoesProjeto.setText(""
													+ manipulaProjeto.get(i).getIdProjeto()
													+ "\n\n"
													+ manipulaProjeto.get(i).getNomeProjet()
													+ "\n\n"
													+ manipulaProjeto.get(i).getDataPedido()
													+ "\n"
													+ manipulaProjeto.get(i).getTempoEntrega()
													+ "\n\n\n"
													+ manipulaProjeto.get(i)
															.getDefinicaoProjeto() + "\n");

											idProjeto = manipulaProjeto.get(i).getIdProjeto();
										}
									}

								} catch (ArrayIndexOutOfBoundsException e1) {
									JOptionPane.showMessageDialog(null,
											"Nenhum projeto foi selecionad");
								} finally {
									tabelaSincronizada();
								}

							}
						});
						btnAbrir.setIcon(new ImageIcon(TelaMidia.class
								.getResource("/Images16x16/accept.png")));
						
								btnAbrir.setBounds(242, 323, 113, 28);
								panel_1.add(btnAbrir);
								
										tabelaProjetosProntos = new JTable();
										tabelaProjetosProntos.setModel(new DefaultTableModel(new Object[][] { {
												null, null, null }, }, new String[] { "New column",
												"New column", "New column" }));
										tabelaProjetosProntos.setBounds(10, 25, 329, 291);
										panel_1.add(tabelaProjetosProntos);
										
												JScrollBar scrollBar = new JScrollBar();
												scrollBar.setBounds(338, 25, 17, 291);
												panel_1.add(scrollBar);
												
														JButton btnAtualiza = new JButton("Atualizar");
														btnAtualiza.setIcon(new ImageIcon(TelaMidia.class.getResource("/Images16x16/database.png")));
														btnAtualiza.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																tabelaSincronizada();
															}
														});
														btnAtualiza.setBounds(119, 323, 113, 28);
														panel_1.add(btnAtualiza);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Historico de projetos concluidos", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(null, "Projetos Finalizados",
								TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(0, 0, 367, 363);
		panel_5.add(panel_6);
		
		JButton button = new JButton("Abrir");
		button.setIcon(new ImageIcon(TelaMidia.class.getResource("/Images16x16/accept.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String codigo, nome;

					codigo = (String) tabelaProjetosConcluidos.getModel()
							.getValueAt(tabelaProjetosConcluidos.getSelectedRow(),
									0);
					nome = (String) tabelaProjetosConcluidos.getModel()
							.getValueAt(tabelaProjetosConcluidos.getSelectedRow(),
									1);

					manipulaProjeto = (ArrayList<Requisicao>) projetoDao
							.listeTodos();
					for (int i = 0; i < manipulaProjeto.size(); i++) {
						if (manipulaProjeto.get(i).getNomeProjet()
								.equalsIgnoreCase(nome.toString().trim())
								&& manipulaProjeto.get(i).getIdProjeto() == Integer
										.parseInt(codigo)
								&& manipulaProjeto.get(i)
										.getPorcentagemConclusao() == 100) {
							JOptionPane.showMessageDialog(null, ""
									+ manipulaProjeto.get(i).getIdProjeto()
									+ "\n\n"
									+ manipulaProjeto.get(i).getNomeProjet()
									+ "\n\n"
									+ manipulaProjeto.get(i).getDataPedido()
									+ "\n"
									+ manipulaProjeto.get(i).getTempoEntrega()
									+ "\n\n\n"
									+ manipulaProjeto.get(i)
									.getDefinicaoProjeto() + "\n\n"
									+ manipulaProjeto.get(i)
									.getTipoExecucao() + "\n");
						

							//idProjeto = manipulaProjeto.get(i).getIdProjeto();
						}
					}

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum projeto foi selecionado");
				} finally {
					tabelaSincronizada();
					tabelaSincronizadaProjetosConcluidos();
				}
			}
		});
		button.setBounds(242, 323, 113, 28);
		panel_6.add(button);
		
		tabelaProjetosConcluidos = new JTable();
		tabelaProjetosConcluidos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tabelaProjetosConcluidos.setBounds(10, 25, 329, 291);
		panel_6.add(tabelaProjetosConcluidos);
		
		JScrollBar scrollBar_3 = new JScrollBar();
		scrollBar_3.setBounds(338, 25, 17, 291);
		panel_6.add(scrollBar_3);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setIcon(new ImageIcon(TelaMidia.class.getResource("/Images16x16/database.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaSincronizadaProjetosConcluidos();
			}
		});
		btnAtualizar.setBounds(131, 323, 101, 28);
		panel_6.add(btnAtualizar);
	}

	public void tabelaSincronizada() {

		DefaultTableModel model = (DefaultTableModel) tabelaProjetosProntos
				.getModel();
		model.setNumRows(0);

		manipulaProjeto = (ArrayList<Requisicao>) projetoDao.listeTodos();

		for (int i = 0; i < manipulaProjeto.size(); i++) {
			if (manipulaProjeto.get(i).getPorcentagemConclusao() == 80) {
				model.addRow(new String[] {
						"" + manipulaProjeto.get(i).getIdProjeto(),
						"" + manipulaProjeto.get(i).getNomeProjet(),
						"" + manipulaProjeto.get(i).getPorcentagemConclusao()
								+ "% concluido" });
			}

		}
		tabelaSincronizadaProjetosConcluidos();

	}

	public void tabelaSincronizadaProjetosConcluidos() {

		DefaultTableModel model = (DefaultTableModel) tabelaProjetosConcluidos
				.getModel();
		model.setNumRows(0);

		manipulaProjeto = (ArrayList<Requisicao>) projetoDao.listeTodos();

		for (int i = 0; i < manipulaProjeto.size(); i++) {
			if (manipulaProjeto.get(i).getPorcentagemConclusao() == 100) {
				model.addRow(new String[] {
						"" + manipulaProjeto.get(i).getIdProjeto(),
						"" + manipulaProjeto.get(i).getNomeProjet(),
						"" + manipulaProjeto.get(i).getPorcentagemConclusao()
								+ "% concluido" });
			}

		}

	}
}
