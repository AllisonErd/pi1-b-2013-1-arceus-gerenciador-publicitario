package br.com.luguia.arceus.view.gui.inicializacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.luguia.arceus.control.MySqlController;
import br.com.luguia.arceus.model.Funcionario;
import br.com.luguia.arceus.model.dao.array.FuncionarioDAO;

public class ConfigSql extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField campoHost;
	private JTextField campoUser;
	private JTextField campo;
	private JPasswordField campoPass;
	private Funcionario adm;
	private FuncionarioDAO fDao = new FuncionarioDAO();
	MySqlController msc;
	private ArrayList<Funcionario> manipulaFuncionario;

	public ConfigSql() {
		setTitle("Setings");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 294, 271);
		contentPane.add(panel);
		panel.setLayout(null);

		campoHost = new JTextField("jdbc:mysql://localhost:3306/arceus");
		campoHost.setForeground(new Color(0, 0, 0));
		campoHost.setBackground(new Color(255, 255, 255));
		campoHost.setBounds(10, 36, 274, 28);
		panel.add(campoHost);
		campoHost.setColumns(10);

		campoUser = new JTextField();
		campoUser.setText("root");
		campoUser.setBounds(10, 100, 274, 28);
		panel.add(campoUser);
		campoUser.setColumns(10);

		JLabel lblNewLabel = new JLabel("Host");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 75, 46, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Pass");
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 141, 46, 14);
		panel.add(lblNewLabel_2);

		JButton botaoContinua = new JButton("Continuar");
		botaoContinua.setIcon(new ImageIcon(ConfigSql.class
				.getResource("/Images16x16/next.png")));
		botaoContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (campoHost.getText().toString().trim().equalsIgnoreCase("")
						|| campoPass.getText().toString().trim()
								.equalsIgnoreCase("")
						|| campoUser.getText().toString().trim()
								.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"Preencha todos os campos !");
				} else {
					try {
						FileWriter fw = new FileWriter("ConectBanco.txt");

						fw.write(campoHost.getText().toString().trim()
								+ "#&V&#"
								+ campoUser.getText().toString().trim()
								+ "#&V&#"
								+ campoPass.getText().toString().trim());

						fw.close();

					} catch (IOException e1) {
						System.err.println("Erro do tipo IOException!!!");
					} finally {
						boolean insereAdm = false;
						msc = new MySqlController();
						if (msc.conectado() == true) {

							manipulaFuncionario = (ArrayList<Funcionario>) fDao
									.listeTodos();

						//	for (int i = 0; i < manipulaFuncionario.size(); i++) {
							//	if (manipulaFuncionario.get(i).getId() != 0) {
								//	insereAdm = true;
								//} else {
									//insereAdm = false;
									//break;
								//}
							
//							if(manipulaFuncionario.size()==0){
//								insereAdm = true;
//								
//							}
//
//							if (insereAdm == true) {
//								adm = new Funcionario();
//
//								adm.setId(0);
//								adm.setLogin("arceus");
//								adm.setNome("admin");
//								adm.setSenha("pepeka");
//								adm.setTipo("admin");
//
//								fDao.insira(adm);
//							}

							new TipoEscolha().setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null,
									"Falha na conexão!!");
						}

					}

				}

			}
		});
		botaoContinua.setFont(new Font("Calibri", Font.BOLD, 13));
		botaoContinua.setForeground(new Color(0, 0, 255));
		botaoContinua.setBackground(UIManager.getColor("CheckBox.foreground"));
		botaoContinua.setBounds(159, 220, 125, 40);
		panel.add(botaoContinua);

		JButton botaoVolta = new JButton("Voltar");
		botaoVolta.setIcon(new ImageIcon(ConfigSql.class
				.getResource("/Images16x16/back.png")));
		botaoVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EscolhaBanco().setVisible(true);

				dispose();

			}
		});
		botaoVolta.setFont(new Font("Calibri", Font.BOLD, 13));
		botaoVolta.setBackground(UIManager.getColor("CheckBox.foreground"));
		botaoVolta.setForeground(new Color(0, 0, 255));
		botaoVolta.setBounds(10, 220, 105, 40);
		panel.add(botaoVolta);

		campoPass = new JPasswordField();
		campoPass.setBounds(10, 167, 272, 28);
		panel.add(campoPass);
	}
}
