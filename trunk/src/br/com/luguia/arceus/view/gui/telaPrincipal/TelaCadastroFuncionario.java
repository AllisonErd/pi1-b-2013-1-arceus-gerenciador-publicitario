package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.luguia.arceus.model.Funcionario;
import br.com.luguia.arceus.model.dao.array.FuncionarioDAO;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;

public class TelaCadastroFuncionario extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoPesquisa;
	private JTextField campoSenha;
	private JTable table;
	private JTextField campoCodigo;
	private JComboBox boxTipoPesquisa;
	private JTextField campoLogin;

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private ArrayList<Funcionario> manipulaFuncionario;
	private Funcionario funcionario;
	private int chaveDeControle = 0;

	private String setor = "ATENDIMENTO";
	private JComboBox campoSetor ;
	
	public TelaCadastroFuncionario() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				posicaoCorreta();

			}
		});

		setResizable(false);
		setTitle("Cadastro de Funcion\u00E1rios");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 500);
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

		JLabel lblNewLabel = new JLabel(" F u n c i o n \u00E1 r i o s");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/images/users.png")));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 408, 56);
		panel.add(lblNewLabel);

		JPanel painelDeComponentes = new JPanel();
		painelDeComponentes.setBorder(new TitledBorder(null,
				"D a d o s   C a d a s t r a i s", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		painelDeComponentes.setBounds(10, 67, 612, 97);
		contentPane.add(painelDeComponentes);
		painelDeComponentes.setLayout(null);

		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(12, 30, 35, 14);
		painelDeComponentes.add(labelNome);

		campoNome = new JTextField();
		campoNome.setBounds(57, 27, 272, 20);
		painelDeComponentes.add(campoNome);
		campoNome.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(181, 57, 46, 14);
		painelDeComponentes.add(lblSenha);

		JLabel Setor = new JLabel("Setor");
		Setor.setHorizontalAlignment(SwingConstants.RIGHT);
		Setor.setBounds(324, 30, 46, 14);
		painelDeComponentes.add(Setor);

		final String[] setores = { "Atendimento", "Cria��o", "Financeiro",
				"Produ��o", "Midia" };
		campoSetor = new JComboBox(setores);
		campoSetor.addItemListener(this);
	
		campoSetor.setBounds(380, 27, 100, 20);
		painelDeComponentes.add(campoSetor);

		campoSenha = new JTextField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(232, 55, 97, 20);
		painelDeComponentes.add(campoSenha);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(476, 29, 46, 14);
		painelDeComponentes.add(lblCodigo);

		campoCodigo = new JTextField("");
		campoCodigo.setEditable(false);
		campoCodigo.setColumns(10);
		campoCodigo.setBounds(527, 27, 70, 20);
		painelDeComponentes.add(campoCodigo);

		campoLogin = new JTextField();
		campoLogin.setColumns(10);
		campoLogin.setBounds(57, 55, 114, 20);
		painelDeComponentes.add(campoLogin);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(10, 57, 36, 14);
		painelDeComponentes.add(lblLogin);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/Images16x16/page.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampo();

			}
		});
		btnLimpar.setBounds(380, 57, 100, 23);
		painelDeComponentes.add(btnLimpar);

		JButton botaoCadastrar = new JButton("Salvar");
		botaoCadastrar.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/Images16x16/database_accept.png")));
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				funcionario = new Funcionario();

				if (campoNome.getText().toString().equalsIgnoreCase("")
						|| campoSenha.getText().equalsIgnoreCase("")
						|| campoLogin.getText().toString().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"Preencha todos os campos! ");

				} else {
					
						
					
					funcionario.setId(Integer.parseInt(campoCodigo.getText()
							.toString()));
					funcionario.setNome(campoNome.getText().toString());
					funcionario.setLogin(campoLogin.getText().toString());
					funcionario.setSenha(campoSenha.getText().toString());
					funcionario.setTipo(setor);

					if (chaveDeControle == 1) {

						funcionarioDAO.altere(funcionario);

						chaveDeControle = 0;
					} else {
						if(verificaLogin(campoLogin.getText().toString()) == false){
							JOptionPane.showMessageDialog(null, "Este login ja existe!");
							campoLogin.setText("");
						}else{	
						funcionarioDAO.insira(funcionario);
						}
					}

					limpaCampo();

				}
			}
		});
		botaoCadastrar.setBounds(497, 57, 100, 23);
		painelDeComponentes.add(botaoCadastrar);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "P e s q u i s a r",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(12, 176, 610, 284);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_3.setBounds(10, 51, 588, 186);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Cod", "Nome", "Departamento" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.setBounds(12, 12, 550, 162);

		panel_3.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(561, 12, 17, 162);
		panel_3.add(scrollBar);

		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(121, 20, 355, 20);
		panel_2.add(campoPesquisa);
		campoPesquisa.setColumns(10);

		final String modelo[] = { "Nome", "Codigo" };
		boxTipoPesquisa = new JComboBox(modelo);
		boxTipoPesquisa.setBounds(10, 20, 101, 20);
		panel_2.add(boxTipoPesquisa);

		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/Images16x16/search.png")));
		botaoPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);

				String nome = campoPesquisa.getText().toString().trim();

				manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO
						.listeTodos();

				for (int i = 0; i < manipulaFuncionario.size(); i++) {
					if (manipulaFuncionario.get(i).getNome()
							.equalsIgnoreCase(nome)) {

						model.addRow(new String[] {
								"" + manipulaFuncionario.get(i).getId(),
								"" + manipulaFuncionario.get(i).getNome(),
								"" + manipulaFuncionario.get(i).getTipo() });

					}

				}

			}
		});
		botaoPesquisar.setBounds(486, 17, 112, 23);
		panel_2.add(botaoPesquisar);

		JButton botaoAtualizar = new JButton("Alterar");
		botaoAtualizar.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/Images16x16/page_edit.png")));
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					chaveDeControle = 1;
					String codigo, nome;

					codigo = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 0);
					nome = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 1);

					manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO
							.listeTodos();
					for (int i = 0; i < manipulaFuncionario.size(); i++) {
						if (manipulaFuncionario.get(i).getNome()
								.equalsIgnoreCase(nome.toString().trim())
								&& manipulaFuncionario.get(i).getId() == Integer
										.parseInt(codigo)) {

							campoCodigo.setText(""
									+ manipulaFuncionario.get(i).getId());
							campoNome.setText(""
									+ manipulaFuncionario.get(i).getNome());
							campoLogin.setText(""
									+ manipulaFuncionario.get(i).getLogin());
							campoSenha.setText(""
									+ manipulaFuncionario.get(i).getSenha());

						}
					}
					limpaTabela();

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Ningu�m foi selecionado !");
				}
			}
		});
		botaoAtualizar.setBounds(372, 249, 107, 23);
		panel_2.add(botaoAtualizar);

		JButton boatoExcluir = new JButton("Excluir");
		boatoExcluir.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/Images16x16/database_remove.png")));
		boatoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numero = (String) table.getModel().getValueAt(
						table.getSelectedRow(), 0);

				manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO
						.listeTodos();

				for (int i = 0; i < manipulaFuncionario.size(); i++) {
					funcionario = manipulaFuncionario.get(i);
					if (funcionario.getId() == Integer.parseInt(numero)) {
						funcionarioDAO.exclua(funcionario);
					}

				}

				limpaTabela();
			}
		});
		boatoExcluir.setBounds(497, 249, 101, 23);
		panel_2.add(boatoExcluir);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/Images16x16/back.png")));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botaoVoltar.setBounds(12, 249, 99, 23);
		panel_2.add(botaoVoltar);
		
		JButton btnAtualizarTabela = new JButton("Atualizar tabela");
		btnAtualizarTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posicaoCorreta();
			}
		});
		btnAtualizarTabela.setBounds(121, 249, 112, 23);
		panel_2.add(btnAtualizarTabela);

	}

	public void limpaCampo() {
		campoCodigo.setText("");
		campoLogin.setText("");
		campoNome.setText("");
		campoSenha.setText("");
		posicaoCorreta();
		
	}

	public void limpaTabela() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);

		model.addRow(new String[] { "", "", "" });
		tabelaSincronizada();
	}

	public void posicaoCorreta() {
		int indice = 1;
		
		manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO
				.listeTodos();
		try {
			indice += manipulaFuncionario.get(manipulaFuncionario.size() - 1)
					.getId();
		} catch (Exception exp) {

		} finally {
			campoCodigo.setText("" + indice);
		}
		tabelaSincronizada();
	}

	public void tabelaSincronizada() {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);

		manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO
				.listeTodos();

		for (int i = 0; i < manipulaFuncionario.size(); i++) {
			//if insserido para que o usuario master n�o conste na lista!
			if(manipulaFuncionario.get(i).getId()!=0){
			model.addRow(new String[] {
					"" + manipulaFuncionario.get(i).getId(),
					"" + manipulaFuncionario.get(i).getNome(),
					"" + manipulaFuncionario.get(i).getTipo() });
			}
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	
		if (e.getItem().toString().equalsIgnoreCase("Atendimento")) {
			setor = "ATENDIMENTO";
		} else if(e.getItem().toString().equalsIgnoreCase("Cria��o")){
			setor = "CRIACAO";
		} else if(e.getItem().toString().equalsIgnoreCase("Financeiro")){
			setor = "FINANCEIRO";
		} else if(e.getItem().toString().equalsIgnoreCase("Produ��o")){
			setor = "PRODUCAO";
		} else if(e.getItem().toString().equalsIgnoreCase("Midia")){
			setor = "MIDIA";
		}

	}
	
	
	public boolean verificaLogin(String loginTest) {
		boolean valida = false;
		
		manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO
				.listeTodos();

		for (int i = 0; i < manipulaFuncionario.size(); i++) {
			
			if(manipulaFuncionario.get(i).getLogin().equalsIgnoreCase(loginTest)){
				valida =  false;
				
				break;
			}else{
				valida = true;
			}
		}
		return valida;
	}
}
