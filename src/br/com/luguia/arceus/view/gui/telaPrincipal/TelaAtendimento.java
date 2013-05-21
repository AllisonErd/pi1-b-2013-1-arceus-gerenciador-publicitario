package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.luguia.arceus.model.PessoaFisica;
import br.com.luguia.arceus.model.PessoaJuridica;
import br.com.luguia.arceus.model.dao.array.PessoaFisicaDAO;
import br.com.luguia.arceus.model.dao.array.PessoaJuridicaDAO;
import javax.swing.JTextPane;
import javax.swing.UIManager;



public class TelaAtendimento extends JFrame {

	private JPanel contentPane;
	private JTextField campoCodigoProjeto;
	private JTextField campoNomeProjeto;
	private JTextField campoDataEntrega;
	private JTextField campoDataEmissao;
	private JTextField campoCpfCnpj;
	
	private PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
	private ArrayList<PessoaJuridica> manipulaPessoaJuridica;
	//private PessoaJuridica pessoaJuridica;

	private PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
	private ArrayList<PessoaFisica> manipulaPessoaFisicas;
	//private PessoaFisica pessoaFisica;
	
	//private String codigo;
	private boolean fisico = true;
	
	private JTextArea campoCaracteristicas;
	private JTable table;

	public TelaAtendimento() {
		setTitle("Setor de Atendimento");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1194, 56);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("A t e n d i m e n t o");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 290, 34);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "C l i e n t e",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 122, 413, 303);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		campoCaracteristicas = new JTextArea();
		campoCaracteristicas.setBounds(10, 23, 393, 269);
		panel_1.add(campoCaracteristicas);
		campoCaracteristicas.setBackground(UIManager.getColor("CheckBox.background"));
		campoCaracteristicas.setEditable(false);

		JButton btnNovo = new JButton("Pesquisar Cliente");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				String cpfCnpj = campoCpfCnpj.getText().toString().trim();
				
				if(fisico == true){
					manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO
							.listeTodos();
					
					for (int i = 0; i < manipulaPessoaFisicas.size(); i++) {
			
						if (manipulaPessoaFisicas.get(i).getCpf()
								.equalsIgnoreCase(cpfCnpj)) {
							
							
							
							campoCaracteristicas.setText(""+ manipulaPessoaFisicas.get(i).getId()+
															"\n"+manipulaPessoaFisicas.get(i).getNome()+
															 "\n"+manipulaPessoaFisicas.get(i).getRg()+
															 "\n"+manipulaPessoaFisicas.get(i).getCpf()+
															 "\n\n"+manipulaPessoaFisicas.get(i).getContato().getEmail()+
															 "\n"+manipulaPessoaFisicas.get(i).getContato().getTelefone().getTelefoneFixo()+
															 "\n"+manipulaPessoaFisicas.get(i).getContato().getTelefone().getTelefoneCel()+
															 "\n\n"+manipulaPessoaFisicas.get(i).getEndereco().getRua()+
															 "\n"+manipulaPessoaFisicas.get(i).getEndereco().getBairro()+
															 "\n"+manipulaPessoaFisicas.get(i).getEndereco().getCep()+
															 "\n"+manipulaPessoaFisicas.get(i).getEndereco().getCidade()+
															 "\n"+manipulaPessoaFisicas.get(i).getEndereco().getEstado()+
															 "\n"+manipulaPessoaFisicas.get(i).getEndereco().getComplemento());

							

						}

					}
					
				}else if(fisico == false){
					manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO
							.listeTodos();

					for (int i = 0; i < manipulaPessoaJuridica.size(); i++) {
						if (manipulaPessoaJuridica.get(i).getCnpj()
								.equalsIgnoreCase(cpfCnpj)) {

							campoCaracteristicas.setText(""+manipulaPessoaJuridica.get(i).getId()+
														 "\n"+manipulaPessoaJuridica.get(i).getNome()+
														 "\n"+manipulaPessoaJuridica.get(i).getCnpj()+
														 "\n\n"+manipulaPessoaJuridica.get(i).getContato().getEmail()+
														 "\n"+manipulaPessoaJuridica.get(i).getContato().getTelefone().getTelefoneFixo()+
														 "\n"+manipulaPessoaJuridica.get(i).getContato().getTelefone().getTelefoneCel()+
														 "\n\n"+manipulaPessoaJuridica.get(i).getEndereco().getRua()+
														 "\n"+manipulaPessoaJuridica.get(i).getEndereco().getBairro()+
														 "\n"+manipulaPessoaJuridica.get(i).getEndereco().getCep()+
														 "\n"+manipulaPessoaJuridica.get(i).getEndereco().getCidade()+
														 "\n"+manipulaPessoaJuridica.get(i).getEndereco().getEstado()+
														 "\n"+manipulaPessoaJuridica.get(i).getEndereco().getComplemento());
							}

					}
					
				}
				
				
			}
		});

		btnNovo.setBounds(269, 66, 154, 23);
		contentPane.add(btnNovo);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(433, 78, 18, 393);
		contentPane.add(separator);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "P r o j e t o",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(441, 95, 513, 330);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNomeDoProjeto = new JLabel("Nome do Projeto");
		lblNomeDoProjeto.setBounds(20, 29, 106, 14);
		panel_3.add(lblNomeDoProjeto);

		campoNomeProjeto = new JTextField();
		campoNomeProjeto.setBounds(126, 26, 377, 20);
		panel_3.add(campoNomeProjeto);
		campoNomeProjeto.setColumns(10);

		JLabel lblTermino = new JLabel("Entrega do Projeto");
		lblTermino.setBounds(301, 61, 106, 14);
		panel_3.add(lblTermino);

		campoDataEntrega = new JTextField();
		campoDataEntrega.setBounds(417, 58, 86, 20);
		panel_3.add(campoDataEntrega);
		campoDataEntrega.setColumns(10);

		JLabel lblDataDaEmisso = new JLabel("Data da Emiss\u00E3o:");
		lblDataDaEmisso.setBounds(20, 61, 98, 14);
		panel_3.add(lblDataDaEmisso);

		campoDataEmissao = new JTextField();
		campoDataEmissao.setBounds(126, 58, 86, 20);
		panel_3.add(campoDataEmissao);
		campoDataEmissao.setColumns(10);
		
				JPanel panel_6 = new JPanel();
				panel_6.setBounds(10, 88, 498, 113);
				panel_3.add(panel_6);
				panel_6.setBorder(new TitledBorder(null,
						"Informa\u00E7\u00F5es de Produ\u00E7\u00E3o",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_6.setLayout(null);
				
						final JTextArea campoDescricaoProjeto = new JTextArea();
						campoDescricaoProjeto.setLineWrap(true);
						campoDescricaoProjeto.setBounds(12, 23, 476, 79);
						panel_6.add(campoDescricaoProjeto);
							//TODO concatenar a frase Projetos relacionados a : com o nome da pessoa selecionada!! 
								JPanel panel_5 = new JPanel();
								panel_5.setBounds(10, 212, 498, 107);
								panel_3.add(panel_5);
								panel_5.setBorder(new TitledBorder(null,
										"Projetos relacionados a : ", TitledBorder.LEADING,
										TitledBorder.TOP, null, null));
								panel_5.setLayout(null);
								
								table = new JTable();
								table.setModel(new DefaultTableModel(
									new Object[][] {
										{null, null, null},
										{null, null, null},
										{null, null, null},
									},
									new String[] {
										"New column", "New column", "New column"
									}
								));
								table.setBounds(10, 24, 478, 72);
								panel_5.add(table);

		JLabel lblNewLabel_1 = new JLabel("Codigo do Projeto :");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(738, 67, 163, 23);
		contentPane.add(lblNewLabel_1);

		campoCodigoProjeto = new JTextField();
		campoCodigoProjeto.setEditable(false);
		campoCodigoProjeto.setBounds(911, 62, 43, 31);
		contentPane.add(campoCodigoProjeto);
		campoCodigoProjeto.setColumns(10);

	

		campoCpfCnpj = new JTextField();
		campoCpfCnpj.setFont(new Font("Dialog", Font.BOLD, 14));
		campoCpfCnpj.setHorizontalAlignment(SwingConstants.CENTER);
		campoCpfCnpj.setColumns(10);
		campoCpfCnpj.setBounds(76, 66, 181, 23);
		contentPane.add(campoCpfCnpj);

		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpfcnpj.setBounds(10, 72, 56, 14);
		contentPane.add(lblCpfcnpj);

		JRadioButton rdbtnFisico = new JRadioButton("Fisico", true);
		rdbtnFisico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fisico = true;

			}
		});
		rdbtnFisico.setBounds(10, 97, 72, 17);
		contentPane.add(rdbtnFisico);

		JRadioButton rdbtnJuridico = new JRadioButton("Juridico");
		rdbtnJuridico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fisico = false;
			}
		});
		rdbtnJuridico.setBounds(83, 97, 78, 17);
		contentPane.add(rdbtnJuridico);

		ButtonGroup gp = new ButtonGroup();
		gp.add(rdbtnFisico);
		gp.add(rdbtnJuridico);

		JButton novoCliente = new JButton("Cadastrar");
		novoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroCliente().setVisible(true);
			}
		});
		novoCliente.setBounds(325, 436, 98, 23);
		contentPane.add(novoCliente);
		
				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.setBounds(629, 437, 98, 23);
				contentPane.add(btnConfirmar);
				
						JButton botaoOrcamento = new JButton("Or\u00E7amento");
						botaoOrcamento.setBounds(742, 437, 98, 23);
						contentPane.add(botaoOrcamento);
						
								JButton botaoCancela = new JButton("Cancelar");
								botaoCancela.setBounds(856, 436, 98, 23);
								contentPane.add(botaoCancela);
								botaoCancela.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {

										dispose();
									}
								});
				btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});
	}
}