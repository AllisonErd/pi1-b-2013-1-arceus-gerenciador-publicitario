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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.luguia.arceus.model.Contato;
import br.com.luguia.arceus.model.Endereco;
import br.com.luguia.arceus.model.PessoaFisica;
import br.com.luguia.arceus.model.PessoaJuridica;
import br.com.luguia.arceus.model.Telefone;
import br.com.luguia.arceus.model.dao.array.PessoaFisicaDAO;
import br.com.luguia.arceus.model.dao.array.PessoaJuridicaDAO;

public class TelaCadastroCliente extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoCodigo;
	private JTextField campoCpfCnpj;
	private JTextField campoRua;
	private JTextField campoBairro;
	private JTextField campoCidade;
	private JTextField campoCep;
	private JTextField campoTelefonefixo;
	private JTextField campoTelefoneCelular;
	private JTextField campoEmail;
	private JTextField campoPesquisa;
	private JComboBox boxTipoCliente;
	private JTable table;
	private JComboBox boxTipoPesquisa;
	private JTextArea campoComplemento;

	private JTextField campoRg;
	private JTextField campoEstado;

	PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
	ArrayList<PessoaJuridica> manipulaPessoaJuridica = new ArrayList<>();
	PessoaJuridica pessoaJuridica = new PessoaJuridica();
	
	PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
	ArrayList<PessoaFisica> manipulaPessoaFisicas = new ArrayList<>();
	PessoaFisica pessoaFisica = new PessoaFisica();
	
	private int chaveDeControle = 0;
	
	Contato contato = new Contato();
	Endereco endereco = new Endereco();
	Telefone telefone = new Telefone();
	
	private boolean fisico = false;
	
	
	public TelaCadastroCliente() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				posicaoCorreta();
				limpaList();
			}
		});
		setResizable(false);
		setTitle("Cadastro de Cliente");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
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

		JLabel lblNewLabel = new JLabel("C l i e n t e s");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 234, 34);
		panel.add(lblNewLabel);

		JPanel painelDeComponentes = new JPanel();
		painelDeComponentes.setBorder(new TitledBorder(null,
				"D a d o s   C a d a s t r a i s", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		painelDeComponentes.setBounds(10, 114, 607, 309);
		contentPane.add(painelDeComponentes);
		painelDeComponentes.setLayout(null);

		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(10, 34, 46, 14);
		painelDeComponentes.add(labelNome);

		campoNome = new JTextField();
		campoNome.setBounds(55, 28, 438, 20);
		painelDeComponentes.add(campoNome);
		campoNome.setColumns(10);

		JLabel labelCodigo = new JLabel("N\u00BA");
		labelCodigo.setFont(new Font("Dialog", Font.BOLD, 20));
		labelCodigo.setBounds(500, 34, 27, 33);
		painelDeComponentes.add(labelCodigo);

		campoCodigo = new JTextField();
		campoCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		campoCodigo.setFont(new Font("Dialog", Font.BOLD, 26));
		campoCodigo.setEditable(false);
		campoCodigo.setBounds(528, 28, 69, 52);
		painelDeComponentes.add(campoCodigo);
		campoCodigo.setColumns(10);

		boxTipoCliente = new JComboBox();
		boxTipoCliente.setModel(new DefaultComboBoxModel(new String[] { "---",
				"F\u00EDsico", "Jur\u00EDdico" }));

		boxTipoCliente.addItemListener(this);

		boxTipoCliente.setBounds(111, 60, 63, 20);
		painelDeComponentes.add(boxTipoCliente);

		JLabel lblTipoDeCliente = new JLabel("Tipo de Cliente");
		lblTipoDeCliente.setBounds(10, 63, 83, 14);
		painelDeComponentes.add(lblTipoDeCliente);

		campoCpfCnpj = new JTextField();
		campoCpfCnpj.setBounds(264, 60, 106, 20);
		painelDeComponentes.add(campoCpfCnpj);
		campoCpfCnpj.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 92, 587, 2);
		painelDeComponentes.add(separator);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 106, 587, 192);
		painelDeComponentes.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Endere\u00E7o", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblRua = new JLabel("Rua");
		lblRua.setHorizontalAlignment(SwingConstants.LEFT);
		lblRua.setBounds(10, 14, 37, 14);
		panel_1.add(lblRua);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro.setBounds(10, 45, 46, 14);
		panel_1.add(lblBairro);

		campoRua = new JTextField();
		campoRua.setBounds(59, 11, 484, 20);
		panel_1.add(campoRua);
		campoRua.setColumns(10);

		campoBairro = new JTextField();
		campoBairro.setBounds(59, 42, 246, 20);
		panel_1.add(campoBairro);
		campoBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setBounds(10, 74, 39, 14);
		panel_1.add(lblCidade);

		campoCidade = new JTextField();
		campoCidade.setBounds(59, 71, 246, 20);
		panel_1.add(campoCidade);
		campoCidade.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(315, 48, 28, 14);
		panel_1.add(lblCep);

		campoCep = new JTextField();
		campoCep.setBounds(364, 42, 70, 20);
		panel_1.add(campoCep);
		campoCep.setColumns(10);
		
		campoEstado = new JTextField();
		campoEstado.setColumns(10);
		campoEstado.setBounds(364, 71, 179, 20);
		panel_1.add(campoEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(315, 74, 46, 14);
		panel_1.add(lblEstado);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComplemento.setBounds(10, 106, 79, 14);
		panel_1.add(lblComplemento);
		
		campoComplemento = new JTextArea();
		campoComplemento.setBounds(99, 102, 444, 50);
		panel_1.add(campoComplemento);

		JPanel fichaContatoCliente = new JPanel();
		tabbedPane.addTab("Contato", null, fichaContatoCliente, null);
		fichaContatoCliente.setLayout(null);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(44, 41, 57, 14);
		fichaContatoCliente.add(lblTelefone);

		campoTelefonefixo = new JTextField();
		campoTelefonefixo.setBounds(96, 35, 121, 20);
		fichaContatoCliente.add(campoTelefonefixo);
		campoTelefonefixo.setColumns(10);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(44, 72, 57, 14);
		fichaContatoCliente.add(lblCelular);

		campoTelefoneCelular = new JTextField();
		campoTelefoneCelular.setColumns(10);
		campoTelefoneCelular.setBounds(96, 66, 121, 20);
		fichaContatoCliente.add(campoTelefoneCelular);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(44, 100, 46, 14);
		fichaContatoCliente.add(lblEmail);

		campoEmail = new JTextField();
		campoEmail.setText(null);
		campoEmail.setBounds(96, 97, 345, 20);
		fichaContatoCliente.add(campoEmail);
		campoEmail.setColumns(10);

		JFormattedTextField formattedTextField = null;
	

		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setBounds(192, 63, 62, 14);
		painelDeComponentes.add(lblCpfcnpj);
		
		campoRg = new JTextField();
		campoRg.setEditable(false);
		campoRg.setEnabled(false);
		campoRg.setColumns(10);
		campoRg.setBounds(413, 59, 80, 20);
		painelDeComponentes.add(campoRg);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(382, 62, 27, 14);
		painelDeComponentes.add(lblRg);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(644, 67, 2, 393);
		contentPane.add(separator_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "P e s q u i s a r",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(656, 67, 528, 356);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_3.setBounds(10, 51, 508, 294);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null,
				null }, }, new String[] { "New column", "New column",
				"New column" }));
		table.setBounds(12, 12, 484, 270);
		panel_3.add(table);

		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(121, 20, 293, 20);
		panel_2.add(campoPesquisa);
		campoPesquisa.setColumns(10);
		final String items[] = { "Nome", "Codigo" };

		boxTipoPesquisa = new JComboBox(items);

		boxTipoPesquisa.setBounds(10, 20, 101, 20);
		panel_2.add(boxTipoPesquisa);
		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = campoPesquisa.getText().toString().trim();

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);

				
				manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO
						.listeTodos();
				for (int i = 0; i < manipulaPessoaJuridica.size(); i++) {
					if (manipulaPessoaJuridica.get(i).getNome()
							.equalsIgnoreCase(nome)) {

						model.addRow(new String[] {
								"" + manipulaPessoaJuridica.get(i).getId(),
								"" + manipulaPessoaJuridica.get(i).getNome(),
								"" + manipulaPessoaJuridica.get(i).getCnpj()});

					}

				}
				
					
					manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO
							.listeTodos();
					for (int i = 0; i < manipulaPessoaFisicas.size(); i++) {
						if (manipulaPessoaFisicas.get(i).getNome()
								.equalsIgnoreCase(nome)) {

							model.addRow(new String[] {
									"" + manipulaPessoaFisicas.get(i).getId(),
									"" + manipulaPessoaFisicas.get(i).getNome(),
									"" + manipulaPessoaFisicas.get(i).getCpf()});

						}

					}
					
				
			}
		});
		botaoPesquisar.setBounds(426, 17, 92, 23);
		panel_2.add(botaoPesquisar);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botaoVoltar.setBounds(299, 437, 98, 23);
		contentPane.add(botaoVoltar);

		JButton botaoCadastrar = new JButton("Salvar");
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (campoNome.getText().toString().equalsIgnoreCase("")
						|| campoCpfCnpj.getText().equalsIgnoreCase("")
						|| campoTelefonefixo.getText().toString().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"Preencha obrigatoriamente\n NOME, CPF/CNPJ E TELEFONE FIXO ! ");
					
				} else if(fisico == false){									
					
					cadastraClienteJuridico();
							
					
					if (chaveDeControle == 1) {
						pessoaJuridicaDAO.altere(pessoaJuridica);
						chaveDeControle = 0;
					} else {
						pessoaJuridicaDAO.insira(pessoaJuridica);
					}
						
					limpaCampo();

					pessoaJuridica = new PessoaJuridica();
					endereco = new Endereco();
					contato = new Contato();
					telefone = new Telefone();
				}else {
					cadastraClienteFisico();
							
					
					if (chaveDeControle == 1) {
						pessoaFisicaDAO.altere(pessoaFisica);
						chaveDeControle = 0;
					} else {
						pessoaFisicaDAO.insira(pessoaFisica);
					}
						
					limpaCampo();

					pessoaFisica = new PessoaFisica();
					endereco = new Endereco();
					contato = new Contato();
					telefone = new Telefone();
				}
				
			}
		});

		botaoCadastrar.setBounds(519, 437, 98, 23);
		contentPane.add(botaoCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limpaCampo();
				
			}
		});
		btnLimpar.setBounds(409, 437, 98, 23);
		contentPane.add(btnLimpar);

		JButton botaoAlterar = new JButton("Alterar");
		botaoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					chaveDeControle = 1;
					String codigo, nome;

					codigo = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 0);
					nome = (String) table.getModel().getValueAt(
							table.getSelectedRow(), 1);
					
									
					alteraPessoaJuridica(nome, codigo);
					alteraPessoaFisica(nome, codigo);
					

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"Ninguém foi selecionado !");
				}
				
			}
		});
		botaoAlterar.setBounds(992, 435, 89, 23);
		contentPane.add(botaoAlterar);

		JButton botaoCancelar = new JButton("Excluir");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
				
				manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO.listeTodos();
												
				pessoaJuridicaDAO.altere(anulaPessoaJuridica(manipulaPessoaJuridica.get(Integer.parseInt(numero)-1)));
				
				
				
				manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO.listeTodos();
					
				pessoaFisicaDAO.altere(anulaPessoaFisica(manipulaPessoaFisicas.get(Integer.parseInt(numero)-1)));
				
				limpaTabela();
				
			}
		});
		botaoCancelar.setBounds(1093, 435, 89, 23);
		contentPane.add(botaoCancelar);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {

			if (e.getItem().toString().equalsIgnoreCase("F\u00EDsico")) {
				campoRg.setEnabled(true);
				campoRg.setEditable(true);
				fisico = true;
			} else {
				campoRg.setEnabled(false);
				campoRg.setEditable(false);
				campoRg.setText("");
				fisico = false;
			}

		}

	}
	
	public void limpaCampo(){
		
		campoRg.setText("");
		campoEmail.setText("");
		campoCidade.setText("");
		campoCep.setText("");
		campoBairro.setText("");
		campoRua.setText("");
		campoNome.setText("");
		campoCpfCnpj.setText("");
		campoTelefoneCelular.setText("");
		campoNome.setText("");
		campoEstado.setText("");
		campoTelefonefixo.setText("");
		campoComplemento.setText("");
		
		posicaoCorreta();
	}
	
	public void limpaTabela() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);

		model.addRow(new String[] { "", "", "" });

	}

	public void posicaoCorreta() {
		
		try{
		manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO
			.listeTodos();
		int idFisic = manipulaPessoaFisicas.get(manipulaPessoaFisicas.size() - 1).getId();
		
		idFisic = idFisic+1;
		
		
		manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO
				.listeTodos();
		
		int id = manipulaPessoaJuridica.get(manipulaPessoaJuridica.size() - 1).getId();
		id = id + 1;
	
		
		
		if(id>= idFisic){
			campoCodigo.setText("" + id);
		}else {
			campoCodigo.setText("" + idFisic);
		}
		
		}catch(Exception e){
			int i = Integer.parseInt(campoCodigo.getText().toString());
			i ++;
			campoCodigo.setText(""+i);
			
		}
		//	campoCodigo.setText("" + id);
	}
	
	public PessoaJuridica anulaPessoaJuridica(PessoaJuridica pessoaJuridica){
		
		//funcionario.setLogin("Desativado!");
		//funcionario.setNome("Desativado");
		//funcionario.setSenha("Desativado");
		
		pessoaJuridica.setCnpj("Desativado");
		
		return pessoaJuridica;
	}
	
	public PessoaFisica anulaPessoaFisica(PessoaFisica pessoaFisica){
		
		//funcionario.setLogin("Desativado!");
		//funcionario.setNome("Desativado");
		//funcionario.setSenha("Desativado");
		
		pessoaFisica.setCpf("Desativado");
		
		return pessoaFisica;
	}
	
	
	public void cadastraClienteJuridico() {
		pessoaJuridica.setId(Integer.parseInt(campoCodigo.getText().toString().trim()));
		pessoaJuridica.setNome(campoNome.getText().toString().trim());
		pessoaJuridica.setCnpj(campoCpfCnpj.getText().toString().trim());
		
		endereco.setBairro(campoBairro.getText().toString().trim());
		endereco.setCep(campoCep.getText().toString().trim());
		endereco.setCidade(campoCidade.getText().toString().trim());
		endereco.setComplemento(campoComplemento.getText().toString().trim());
		endereco.setEstado(campoEstado.getText().toString().trim());
		endereco.setRua(campoRua.getText().toString().trim());
		
		pessoaJuridica.setEndereco(endereco);
		
		telefone.setTelefoneFixo(campoTelefonefixo.getText().toString().trim());
		telefone.setTelefoneCel(campoTelefoneCelular.getText().toString().trim());
		
		contato.setTelefone(telefone);					
		contato.setEmail(campoEmail.getText().toString().trim());					
		
		pessoaJuridica.setContato(contato);
	}
	
	public void cadastraClienteFisico(){
		pessoaFisica.setId(Integer.parseInt(campoCodigo.getText().toString().trim()));
		pessoaFisica.setNome(campoNome.getText().toString().trim());
		pessoaFisica.setCpf(campoCpfCnpj.getText().toString().trim());
		pessoaFisica.setRg(campoRg.getText().toString().trim());
		endereco.setBairro(campoBairro.getText().toString().trim());
		endereco.setCep(campoCep.getText().toString().trim());
		endereco.setCidade(campoCidade.getText().toString().trim());
		endereco.setComplemento(campoComplemento.getText().toString().trim());
		endereco.setEstado(campoEstado.getText().toString().trim());
		endereco.setRua(campoRua.getText().toString().trim());
		
		pessoaFisica.setEndereco(endereco);
		
		telefone.setTelefoneFixo(campoTelefonefixo.getText().toString().trim());
		telefone.setTelefoneCel(campoTelefoneCelular.getText().toString().trim());
		
		contato.setTelefone(telefone);					
		contato.setEmail(campoEmail.getText().toString().trim());					
		
		pessoaFisica.setContato(contato);
		
	}
	
	public void alteraPessoaJuridica(String nome, String codigo){
		manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO.listeTodos();
		
		
		
		for (int i = 0; i < manipulaPessoaJuridica.size(); i++) {
			if (manipulaPessoaJuridica.get(i).getNome().equalsIgnoreCase(nome.toString().trim())
					&& manipulaPessoaJuridica.get(i).getId() == Integer.parseInt(codigo)) {
				
				campoCodigo.setText(""
						+ manipulaPessoaJuridica.get(i).getId());
				campoNome.setText(""
						+ manipulaPessoaJuridica.get(i).getNome());
				campoBairro.setText(""+manipulaPessoaJuridica.get(i).getEndereco().getBairro());
				campoCep.setText(""+manipulaPessoaJuridica.get(i).getEndereco().getCep());
				campoCidade.setText(""+manipulaPessoaJuridica.get(i).getEndereco().getCidade());
				campoComplemento.setText(""+manipulaPessoaJuridica.get(i).getEndereco().getComplemento());
				campoCpfCnpj.setText(""+manipulaPessoaJuridica.get(i).getCnpj());
				campoEmail.setText(""+manipulaPessoaJuridica.get(i).getContato().getEmail());
				campoEstado.setText(""+manipulaPessoaJuridica.get(i).getEndereco().getEstado());
				campoRua.setText(""+manipulaPessoaJuridica.get(i).getEndereco().getRua());
				campoTelefoneCelular.setText(""+manipulaPessoaJuridica.get(i).getContato().getTelefone().getTelefoneCel());
				campoTelefonefixo.setText(""+manipulaPessoaJuridica.get(i).getContato().getTelefone().getTelefoneFixo());

			}
		}
		limpaTabela();
	}
	
	public void alteraPessoaFisica(String nome, String codigo){
		
manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO.listeTodos();
		
		
		
		for (int i = 0; i < manipulaPessoaFisicas.size(); i++) {
			if (manipulaPessoaFisicas.get(i).getNome().equalsIgnoreCase(nome.toString().trim())
					&& manipulaPessoaFisicas.get(i).getId() == Integer.parseInt(codigo)) {
				System.out.println("entrou");
				campoCodigo.setText(""
						+ manipulaPessoaFisicas.get(i).getId());
				campoNome.setText(""
						+ manipulaPessoaFisicas.get(i).getNome());
				campoBairro.setText(""+manipulaPessoaFisicas.get(i).getEndereco().getBairro());
				campoCep.setText(""+manipulaPessoaFisicas.get(i).getEndereco().getCep());
				campoCidade.setText(""+manipulaPessoaFisicas.get(i).getEndereco().getCidade());
				campoComplemento.setText(""+manipulaPessoaFisicas.get(i).getEndereco().getComplemento());
				campoCpfCnpj.setText(""+manipulaPessoaFisicas.get(i).getCpf());
				campoRg.setText(""+manipulaPessoaFisicas.get(i).getRg());//diferencial!!
				campoEmail.setText(""+manipulaPessoaFisicas.get(i).getContato().getEmail());
				campoEstado.setText(""+manipulaPessoaFisicas.get(i).getEndereco().getEstado());
				campoRua.setText(""+manipulaPessoaFisicas.get(i).getEndereco().getRua());
				campoTelefoneCelular.setText(""+manipulaPessoaFisicas.get(i).getContato().getTelefone().getTelefoneCel());
				campoTelefonefixo.setText(""+manipulaPessoaFisicas.get(i).getContato().getTelefone().getTelefoneFixo());
				
				campoRg.setEditable(true);
				campoRg.setEnabled(true);
				
			}
		}
		limpaTabela();
		
	}
	public void limpaList(){
		
		try {
			InputStream is = new FileInputStream("chave.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
		
			if(s.equalsIgnoreCase("vazio")){
				manipulaPessoaFisicas = (ArrayList<PessoaFisica>) pessoaFisicaDAO.listeTodos();
				manipulaPessoaJuridica = (ArrayList<PessoaJuridica>) pessoaJuridicaDAO.listeTodos();
				
				for(int i = 0; i< manipulaPessoaFisicas.size(); i++){
					pessoaFisicaDAO.exclua(manipulaPessoaFisicas.get(i));
				}
					
				for(int i = 0; i< manipulaPessoaJuridica.size(); i++){
						pessoaJuridicaDAO.exclua(manipulaPessoaJuridica.get(i));
				}
				
				campoCodigo.setText("1");
			}
				
		} catch (IOException e1) {
			
		}catch (NullPointerException e2){
			
		}
	}
	
	
}
