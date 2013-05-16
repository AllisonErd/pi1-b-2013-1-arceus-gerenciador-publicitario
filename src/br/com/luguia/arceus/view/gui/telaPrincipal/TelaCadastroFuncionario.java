package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoPesquisa;
	private JTextField campoSenha;
	private JTable table;
	private JTextField campoCodigo;
	private JComboBox boxTipoPesquisa;
	private JTextField campoLogin;

	FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	ArrayList<Funcionario> manipulaFuncionario = new ArrayList<>();
	Funcionario funcionario = new Funcionario();
	private int chaveDeControle = 0;

	int i = 3;
	int j = 1;
	
	public TelaCadastroFuncionario() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				conectBanco();
				
				posicaoCorreta();
				
				limpaList();
				
				
				
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

		JLabel lblNewLabel = new JLabel("F u n c i o n \u00E1 r i o s");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 351, 34);
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

		final String[] setores = { "Atendimento", "Criação", "Financeiro",
				"Produção", "Midia" };
		final JComboBox campoSetor = new JComboBox();
		campoSetor.setModel(new DefaultComboBoxModel(setores));
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
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampo();
				
			}
		});
		btnLimpar.setBounds(403, 62, 91, 23);
		painelDeComponentes.add(btnLimpar);

		JButton botaoCadastrar = new JButton("Salvar");
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
					funcionario.setTipo("Financeiro");

					if (chaveDeControle == 1) {
						funcionarioDAO.altere(funcionario);
						chaveDeControle = 0;
					} else {
					
						
						System.out.println("entrou");
						funcionarioDAO.insira(funcionario);
						
					}
					
					limpaCampo();

					funcionario = new Funcionario();
				}
			}
		});

		botaoCadastrar.setBounds(506, 62, 91, 23);
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
		table.setModel(new DefaultTableModel(new Object[][] { { null, null,
				null }, }, new String[] { "Cod", "Nome", "Departamento" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.setBounds(12, 12, 564, 162);

		panel_3.add(table);

		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(121, 20, 371, 20);
		panel_2.add(campoPesquisa);
		campoPesquisa.setColumns(10);

		final String modelo[] = { "Nome", "Codigo" };
		boxTipoPesquisa = new JComboBox(modelo);
		boxTipoPesquisa.setBounds(10, 20, 101, 20);
		panel_2.add(boxTipoPesquisa);

		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = campoPesquisa.getText().toString().trim();

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);

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
		botaoPesquisar.setBounds(504, 16, 94, 23);
		panel_2.add(botaoPesquisar);

		JButton botaoAtualizar = new JButton("Alterar");
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
							"Ninguém foi selecionado !");
				}
			}
		});
		botaoAtualizar.setBounds(401, 249, 91, 23);
		panel_2.add(botaoAtualizar);

		JButton boatoExcluir = new JButton("Excluir");
		boatoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
				
				manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO.listeTodos();
				
				for(int i = 0; i<manipulaFuncionario.size(); i++){
					funcionario = manipulaFuncionario.get(i);
					if(funcionario.getId() == Integer.parseInt(numero)){
						funcionarioDAO.exclua(funcionario);
					}
					funcionario = new Funcionario();
				}
				
				//funcionarioDAO.altere(anulaFuncionario(manipulaFuncionario.get(Integer.parseInt(numero)-1)));
				
				
				//funcionarioDAO.exclua(manipulaFuncionario.indexOf();//get(Integer.parseInt(numero)-1));
				limpaTabela();
			}
		});
		boatoExcluir.setBounds(509, 249, 89, 23);
		panel_2.add(boatoExcluir);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botaoVoltar.setBounds(12, 249, 91, 23);
		panel_2.add(botaoVoltar);

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

	}

	public void posicaoCorreta() {
		try{
		InputStream is = new FileInputStream("banco.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		
		InputStream iss = new FileInputStream("chave.txt");
		InputStreamReader isrs = new InputStreamReader(iss);
		BufferedReader brs = new BufferedReader(isrs);
		String ss = brs.readLine();
		
		if(s.equalsIgnoreCase("false")){
		manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO
				.listeTodos();
		int id = manipulaFuncionario.get(manipulaFuncionario.size() - 1)
				.getId();
		id = id + 1;
		campoCodigo.setText("" + id);
		}else{
		if(ss.equalsIgnoreCase(" ")){
				campoCodigo.setText(""+i);
				i++;	
			}else{
				campoCodigo.setText(""+j);
				j++;
			}
			
			
		}
		
		
		}catch(Exception ex){
			
		}
	}

	public Funcionario anulaFuncionario(Funcionario funcionario){
		
		//funcionario.setLogin("Desativado!");
		//funcionario.setNome("Desativado");
		//funcionario.setSenha("Desativado");
		funcionario.setTipo("Desativado");
		
		return funcionario;
	}
	
	public void limpaList(){
		
		try {
			InputStream is = new FileInputStream("chave.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
		
			
			if(s.equalsIgnoreCase("vazio")){
				manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO.listeTodos();
				
				for(int i = 0; i< manipulaFuncionario.size(); i++){
					funcionarioDAO.exclua(manipulaFuncionario.get(i));
				}
				campoCodigo.setText("1");
			}
			
		} catch (IOException e1) {
			
		}catch (NullPointerException e2){
			
		}
		
	
	
	}
	
	public void conectBanco() {
		try{
		InputStream is = new FileInputStream("banco.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		
		if(s.equalsIgnoreCase("true")){
			
			funcionarioDAO.bancoConectado(true);
		
			manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO
					.listeTodos();
			for(int i = 0; i< manipulaFuncionario.size(); i++){
				funcionarioDAO.insira(manipulaFuncionario.get(i));
				
			}
		}else{
			funcionarioDAO.bancoConectado(false);
		}
	
		}catch (IOException e1) {
			
		}
	}
	
	
	
}
