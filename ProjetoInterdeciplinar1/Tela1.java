package Telas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class Tela1 extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldNaturalidade;
	private JComboBox comboBox;
	private JComboBox comboBox_estados;
	private JTextField textFieldRG;
	private JLabel lblRg;
	private JComboBox comboBoxEstadoCivil;
	private JLabel lblEstadoCivil;
	private JLabel lblProfisso;
	private JLabel lblDataNaiscimento;
	private JLabel lblSsp;
	private JComboBox comboBoxExpedidor;
	private JLabel lblCpf;
	private JTextField textFieldDataNascimento;
	private JTextField textFieldCPF;

	private JRadioButton radNulo;

	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnMasculino;
	private JTextField textFieldProficaoConjuge;
	private JLabel lblTempo;
	private JTextField textFieldTempoCasado;
	private JLabel lblNomeConjuge;
	private JTextField textFieldNomeConjuge;
	private JLabel lblFiliaoPai;
	private JTextField textFieldNomePai;
	private JLabel lblMe;
	private JTextField textFieldNomeMae;
	private JTextField textFieldEndereco;
	private JLabel lblUf;
	private JLabel lblCidade;
	private JTextField textFieldCidade;
	private JTextField textFieldCelularDDD;
	private JTextField textFieldTelefoneCelular;
	private JLabel lblTelCelular;
	private JLabel lblResidencial;
	private JTextField textFieldTelefoneResidencial;
	private JTextField textFieldResidencialDDD;
	private JTextField textFieldCep;
	private JTextField textFieldNumero;
	private JLabel lblN;
	private JLabel lblCep;
	private JLabel lblComercial;
	private JTextField textFieldComercialDDD;
	private JTextField textFieldTelefoneComercial;
	private JTextField textFieldBairro;
	private JLabel lblBairro;
	private JLabel lblComplemento;
	private JTextField textFieldComplemento;
	private JTextField textFieldReferencia;
	private JTextField textFieldProficao;
	private JLabel lblProfio;
	private JLabel lblReferencia;
	private JLabel lblAutorizados;
	private JTextField textFieldAutorizados;
	private JLabel lblObs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 frame = new Tela1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Tela1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(42, 10, 46, 14);
		contentPane.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(98, 8, 676, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblNaturalidade = new JLabel("Naturalidade");
		lblNaturalidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNaturalidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNaturalidade.setBounds(10, 41, 77, 14);
		contentPane.add(lblNaturalidade);

		textFieldNaturalidade = new JTextField();
		textFieldNaturalidade.setBounds(98, 39, 190, 20);
		contentPane.add(textFieldNaturalidade);
		textFieldNaturalidade.setColumns(10);

		String[] estados = { "", "BR", "USA" };

		comboBox_estados = new JComboBox(estados);
		comboBox_estados.setBackground(Color.WHITE);
		comboBox_estados.setBounds(298, 39, 62, 20);
		contentPane.add(comboBox_estados);

		textFieldRG = new JTextField();
		textFieldRG.setBounds(98, 70, 261, 20);
		contentPane.add(textFieldRG);
		textFieldRG.setColumns(10);

		lblRg = new JLabel("RG");
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRg.setBounds(10, 73, 77, 14);
		contentPane.add(lblRg);

		comboBoxEstadoCivil = new JComboBox(new String[] { "", "Solteiro",
				"Casado" });

		comboBoxEstadoCivil.addItemListener(this);

		comboBoxEstadoCivil.setBackground(Color.WHITE);
		comboBoxEstadoCivil.setBounds(98, 101, 106, 20);
		contentPane.add(comboBoxEstadoCivil);

		lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstadoCivil.setBounds(11, 104, 77, 14);
		contentPane.add(lblEstadoCivil);

		lblProfisso = new JLabel("Profiss\u00E3o Conjuge");
		lblProfisso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProfisso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProfisso.setBounds(214, 104, 111, 14);
		contentPane.add(lblProfisso);

		lblDataNaiscimento = new JLabel("Data Nascimento");
		lblDataNaiscimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNaiscimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataNaiscimento.setBounds(419, 41, 106, 14);
		contentPane.add(lblDataNaiscimento);

		lblSsp = new JLabel("SSP/");
		lblSsp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSsp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSsp.setBounds(369, 72, 40, 14);
		contentPane.add(lblSsp);

		comboBoxExpedidor = new JComboBox(new String[] { "", "SSP", "SDS" });
		comboBoxExpedidor.setBackground(Color.WHITE);
		comboBoxExpedidor.setBounds(419, 70, 56, 20);
		contentPane.add(comboBoxExpedidor);

		lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(485, 73, 40, 14);
		contentPane.add(lblCpf);

		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setBounds(535, 39, 140, 20);
		contentPane.add(textFieldDataNascimento);
		textFieldDataNascimento.setColumns(10);

		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(535, 70, 140, 20);

		contentPane.add(textFieldCPF);

		rdbtnMasculino = new JRadioButton("Masculino", false);// sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
		rdbtnMasculino.setBackground(Color.WHITE);
		rdbtnMasculino.setBounds(681, 38, 109, 23);
		contentPane.add(rdbtnMasculino);

		rdbtnFeminino = new JRadioButton("Feminino", false);
		rdbtnFeminino.setBackground(Color.WHITE);
		rdbtnFeminino.setBounds(681, 69, 109, 23);
		contentPane.add(rdbtnFeminino);

		radNulo = new JRadioButton("nulo", true); // add um botao nulo que não
													// sera visualizado

		ButtonGroup grupRadio = new ButtonGroup();
		grupRadio.add(rdbtnMasculino);
		grupRadio.add(rdbtnFeminino);
		grupRadio.add(radNulo);

		textFieldProficaoConjuge = new JTextField();
		textFieldProficaoConjuge.setBounds(335, 101, 286, 20);
		textFieldProficaoConjuge.setEnabled(false);// esta dizendo que a janela
													// de texto esta
													// desativada!!
		contentPane.add(textFieldProficaoConjuge);
		textFieldProficaoConjuge.setColumns(10);

		lblTempo = new JLabel("Tempo");
		lblTempo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTempo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTempo.setBounds(564, 103, 111, 14);
		contentPane.add(lblTempo);

		textFieldTempoCasado = new JTextField();
		textFieldTempoCasado.setEnabled(false);
		textFieldTempoCasado.setBounds(688, 101, 86, 20);
		contentPane.add(textFieldTempoCasado);
		textFieldTempoCasado.setColumns(10);

		lblNomeConjuge = new JLabel("Nome Conjuge");
		lblNomeConjuge.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeConjuge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeConjuge.setBounds(0, 134, 99, 14);
		contentPane.add(lblNomeConjuge);

		textFieldNomeConjuge = new JTextField();
		textFieldNomeConjuge.setEnabled(false);
		textFieldNomeConjuge.setBounds(98, 132, 676, 20);
		contentPane.add(textFieldNomeConjuge);
		textFieldNomeConjuge.setColumns(10);

		lblFiliaoPai = new JLabel("Filia\u00E7\u00E3o Pai");
		lblFiliaoPai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFiliaoPai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFiliaoPai.setBounds(10, 165, 78, 14);
		contentPane.add(lblFiliaoPai);

		textFieldNomePai = new JTextField();
		textFieldNomePai.setBounds(98, 163, 676, 20);
		contentPane.add(textFieldNomePai);
		textFieldNomePai.setColumns(10);

		lblMe = new JLabel("M\u00E3e");
		lblMe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMe.setBounds(0, 196, 88, 14);
		contentPane.add(lblMe);

		textFieldNomeMae = new JTextField();
		textFieldNomeMae.setBounds(98, 194, 676, 20);
		contentPane.add(textFieldNomeMae);
		textFieldNomeMae.setColumns(10);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(98, 225, 288, 20);
		contentPane.add(textFieldEndereco);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(0, 228, 88, 14);
		contentPane.add(lblEndereo);

		final JComboBox comboBoxUF = new JComboBox(new Object[] { "", "PE",
				"PB" });
		comboBoxUF.setBackground(Color.WHITE);
		comboBoxUF.setBounds(98, 256, 56, 20);
		contentPane.add(comboBoxUF);

		lblUf = new JLabel("U.F.");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUf.setBounds(0, 259, 88, 14);
		contentPane.add(lblUf);

		lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(164, 259, 46, 14);
		contentPane.add(lblCidade);

		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(214, 256, 172, 20);
		contentPane.add(textFieldCidade);

		textFieldCelularDDD = new JTextField();
		textFieldCelularDDD.setColumns(10);
		textFieldCelularDDD.setBounds(98, 287, 34, 20);
		contentPane.add(textFieldCelularDDD);

		textFieldTelefoneCelular = new JTextField();
		textFieldTelefoneCelular.setColumns(10);
		textFieldTelefoneCelular.setBounds(142, 287, 99, 20);
		contentPane.add(textFieldTelefoneCelular);

		lblTelCelular = new JLabel("Tel: Celular");
		lblTelCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelCelular.setBounds(0, 290, 88, 14);
		contentPane.add(lblTelCelular);

		lblResidencial = new JLabel("Residencial");
		lblResidencial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResidencial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResidencial.setBounds(286, 290, 88, 14);
		contentPane.add(lblResidencial);

		textFieldTelefoneResidencial = new JTextField();
		textFieldTelefoneResidencial.setColumns(10);
		textFieldTelefoneResidencial.setBounds(426, 287, 99, 20);
		contentPane.add(textFieldTelefoneResidencial);

		textFieldResidencialDDD = new JTextField();
		textFieldResidencialDDD.setColumns(10);
		textFieldResidencialDDD.setBounds(382, 287, 34, 20);
		contentPane.add(textFieldResidencialDDD);

		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(426, 256, 99, 20);
		contentPane.add(textFieldCep);

		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(426, 225, 99, 20);
		contentPane.add(textFieldNumero);

		lblN = new JLabel("N\u00BA");
		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblN.setBounds(328, 228, 88, 14);
		contentPane.add(lblN);

		lblCep = new JLabel("Cep");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCep.setBounds(328, 259, 88, 14);
		contentPane.add(lblCep);

		lblComercial = new JLabel("Comercial");
		lblComercial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComercial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComercial.setBounds(535, 290, 88, 14);
		contentPane.add(lblComercial);

		textFieldComercialDDD = new JTextField();
		textFieldComercialDDD.setColumns(10);
		textFieldComercialDDD.setBounds(631, 287, 34, 20);
		contentPane.add(textFieldComercialDDD);

		textFieldTelefoneComercial = new JTextField();
		textFieldTelefoneComercial.setColumns(10);
		textFieldTelefoneComercial.setBounds(675, 287, 99, 20);
		contentPane.add(textFieldTelefoneComercial);

		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(630, 225, 144, 20);
		contentPane.add(textFieldBairro);

		lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBairro.setBounds(532, 228, 88, 14);
		contentPane.add(lblBairro);

		lblComplemento = new JLabel(" Complemento");
		lblComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComplemento.setBounds(532, 258, 91, 14);
		contentPane.add(lblComplemento);

		textFieldComplemento = new JTextField();
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(630, 256, 144, 20);
		contentPane.add(textFieldComplemento);

		textFieldReferencia = new JTextField();
		textFieldReferencia.setColumns(10);
		textFieldReferencia.setBounds(98, 318, 427, 20);
		contentPane.add(textFieldReferencia);

		textFieldProficao = new JTextField();
		textFieldProficao.setColumns(10);
		textFieldProficao.setBounds(630, 318, 144, 20);
		contentPane.add(textFieldProficao);

		lblProfio = new JLabel("Profi\u00E7\u00E3o");
		lblProfio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProfio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProfio.setBounds(532, 320, 91, 14);
		contentPane.add(lblProfio);

		lblReferencia = new JLabel("Referencia");
		lblReferencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReferencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReferencia.setBounds(0, 321, 88, 14);
		contentPane.add(lblReferencia);

		lblAutorizados = new JLabel("Autorizados");
		lblAutorizados.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutorizados.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAutorizados.setBounds(0, 352, 88, 14);
		contentPane.add(lblAutorizados);

		textFieldAutorizados = new JTextField();
		textFieldAutorizados.setColumns(10);
		textFieldAutorizados.setBounds(98, 349, 676, 20);
		contentPane.add(textFieldAutorizados);

		final JTextPane textPaneObservacao = new JTextPane();
		textPaneObservacao.setBackground(Color.WHITE);
		textPaneObservacao.setBounds(98, 380, 676, 78);
		contentPane.add(textPaneObservacao);

		lblObs = new JLabel("Obs.");
		lblObs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObs.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblObs.setBounds(0, 402, 88, 14);
		contentPane.add(lblObs);

		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean cpf = textFieldCPF.getText().toString().matches("\\d*");

				boolean foneResidencial = textFieldTelefoneResidencial
						.getText().toString().matches("\\d*");
				boolean foneComercial = textFieldTelefoneComercial.getText()
						.toString().matches("\\d*");
				boolean foneCelular = textFieldTelefoneCelular.getText()
						.toString().matches("\\d*");

				boolean foneResidencialDDD = textFieldResidencialDDD.getText()
						.toString().matches("\\d*");
				boolean foneComercialDDD = textFieldComercialDDD.getText()
						.toString().matches("\\d*");
				boolean foneCelularDDD = textFieldCelularDDD.getText()
						.toString().matches("\\d*");

				boolean cep = textFieldCep.getText().toString().matches("\\d*");

				boolean numero = textFieldNumero.getText().toString()
						.matches("\\d*");

				boolean Nome = textFieldNome.getText().toString()
						.matches("\\D*");
				boolean Naturalidade = textFieldNaturalidade.getText()
						.toString().matches("\\D*");
				boolean RG = textFieldRG.getText().toString().matches("\\D*");
				boolean DataNascimento = textFieldDataNascimento.getText()
						.toString().matches("\\D*");

				boolean ProficaoConjuge = textFieldProficaoConjuge.getText()
						.toString().matches("\\D*");
				boolean TempoCasado = textFieldTempoCasado.getText().toString()
						.matches("\\D*");
				boolean NomeConjuge = textFieldNomeConjuge.getText().toString()
						.matches("\\D*");
				boolean NomePai = textFieldNomePai.getText().toString()
						.matches("\\D*");

				boolean NomeMae = textFieldNomeMae.getText().toString()
						.matches("\\D*");
				boolean Endereco = textFieldEndereco.getText().toString()
						.matches("\\D*");
				boolean Cidade = textFieldCidade.getText().toString()
						.matches("\\D*");
				boolean Bairro = textFieldBairro.getText().toString()
						.matches("\\D*");

				boolean Complemento = textFieldComplemento.getText().toString()
						.matches("\\D*");
				boolean Referencia = textFieldReferencia.getText().toString()
						.matches("\\D*");
				boolean Proficao = textFieldProficao.getText().toString()
						.matches("\\D*");
				boolean Autorizados = textFieldAutorizados.getText().toString()
						.matches("\\D*");

				String frase = "Cadastro não realizado!!\nInformar apenas numeros em";
				String frase2 = "Cadastro não realizado!!\nInformar apenas texto em";

				if (cpf == false || foneCelular == false
						|| foneCelularDDD == false || foneComercial == false
						|| foneComercialDDD == false
						|| foneResidencial == false
						|| foneResidencialDDD == false || cep == false
						|| numero == false)

				{

					if (cpf == false) {
						frase += "\ncpf";
					}
					if (foneResidencial == false) {
						frase += "\nTelefone Residencial";
					}
					if (foneComercial == false) {
						frase += "\nTelefone Comercial";
					}
					if (foneCelular == false) {
						frase += "\nTelefone Celular";
					}
					if (foneResidencialDDD == false) {

						frase += "\nDDD Residencial";
					}
					if (foneComercialDDD == false) {
						frase += "\nDDD Comercial";
					}
					if (foneCelularDDD == false) {
						frase += "\nDDD Celular";
					}
					if (cep == false) {
						frase += "\ncep";

					}
					if (numero == false) {
						frase += "\nNº";

					}
					JOptionPane.showMessageDialog(null, frase);
				} else if (Nome == false || Naturalidade == false
						|| RG == false || DataNascimento == false

						|| ProficaoConjuge == false || TempoCasado == false
						|| NomeConjuge == false || NomePai == false

						|| NomeMae == false || Endereco == false
						|| Cidade == false || Bairro == false

						|| Complemento == false || Referencia == false
						|| Proficao == false || Autorizados == false) {

					if (Nome == false) {
						frase2 += "\nNome";
					}
					if (Naturalidade == false) {
						frase2 += "\nNaturalidade";
					}
					if (RG == false) {
						frase2 += "\nRG";
					}
					if (DataNascimento == false) {
						frase2 += "\nDataNascimento";
					}

					if (ProficaoConjuge == false) {
						frase2 += "\nProficaoConjuge";
					}
					if (TempoCasado == false) {
						frase2 += "\nTempoCasado";
					}
					if (NomeConjuge == false) {
						frase2 += "\nNomeConjuge";
					}
					if (NomePai == false) {
						frase2 += "\nNomePai";
					}

					if (NomeMae == false) {
						frase2 += "\nNomeMae";
					}
					if (Endereco == false) {
						frase2 += "\nEndereco";
					}
					if (Cidade == false) {
						frase2 += "\nCidade";
					}
					if (Bairro == false) {
						frase2 += "\nBairro";
					}

					if (Complemento == false) {
						frase2 += "\nComplemento";
					}
					if (Referencia == false) {
						frase2 += "\nReferencia";
					}
					if (Proficao == false) {
						frase2 += "\nProficao";
					}
					if (Autorizados == false) {
						frase2 += "\nAutorizados";
					}
					JOptionPane.showMessageDialog(null, frase2);

				} else {
					JOptionPane.showMessageDialog(null,
							"O usuário foi adicionado com sucesso");
				}
			}
		});
		botaoCadastrar.setBackground(Color.WHITE);
		botaoCadastrar
				.setIcon(new ImageIcon("C:\\Users\\XXX\\Pictures\\1.png"));
		botaoCadastrar.setBounds(145, 527, 143, 23);
		contentPane.add(botaoCadastrar);

		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// limpa as caixas de texto
				textFieldAutorizados.setText("");
				textFieldBairro.setText("");
				textFieldCelularDDD.setText("");
				textFieldCep.setText("");
				textFieldCidade.setText("");
				textFieldComercialDDD.setText("");
				textFieldComplemento.setText("");
				textFieldCPF.setText("");
				textFieldDataNascimento.setText("");
				textFieldEndereco.setText("");
				textFieldNaturalidade.setText("");
				textFieldNome.setText("");
				textFieldNomeConjuge.setText("");
				textFieldNomeMae.setText("");
				textFieldNomePai.setText("");
				textFieldNumero.setText("");
				textFieldProficao.setText("");
				textFieldProficaoConjuge.setText("");
				textFieldReferencia.setText("");
				textFieldResidencialDDD.setText("");
				textFieldRG.setText("");
				textFieldTelefoneCelular.setText("");
				textFieldTelefoneComercial.setText("");
				textFieldTelefoneResidencial.setText("");
				textFieldTempoCasado.setText("");

				textPaneObservacao.setText("");

				comboBox_estados.actionPerformed(null);
				comboBoxExpedidor.actionPerformed(null);
				comboBoxEstadoCivil.actionPerformed(null);
				comboBoxUF.actionPerformed(null);

				radNulo.setSelected(true);

			}
		});
		botaoLimpar.setIcon(new ImageIcon("C:\\Users\\XXX\\Pictures\\2.png"));
		botaoLimpar.setBackground(Color.WHITE);
		botaoLimpar.setBounds(369, 527, 143, 23);
		contentPane.add(botaoLimpar);

		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		botaoCancelar.setIcon(new ImageIcon("C:\\Users\\XXX\\Pictures\\3.png"));
		botaoCancelar.setBackground(Color.WHITE);
		botaoCancelar.setBounds(597, 527, 143, 23);
		contentPane.add(botaoCancelar);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {

			if (e.getItem().toString().equalsIgnoreCase("casado")) {
				textFieldProficaoConjuge.setEnabled(true);
				textFieldTempoCasado.setEnabled(true);
				textFieldNomeConjuge.setEnabled(true);
			} else {
				textFieldProficaoConjuge.setEnabled(false);
				textFieldTempoCasado.setEnabled(false);
				textFieldNomeConjuge.setEnabled(false);
				textFieldProficaoConjuge.setText("");
				textFieldTempoCasado.setText("");
				textFieldNomeConjuge.setText("");
			}

		}
	}
}
