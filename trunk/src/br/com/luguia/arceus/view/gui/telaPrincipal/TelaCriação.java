package br.com.luguia.arceus.view.gui.telaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.luguia.arceus.model.Requisicao;
import br.com.luguia.arceus.model.dao.array.ProjetoDAO;

public class TelaCriação extends JFrame {

	private JPanel contentPane;
	private JTable tabelaSolicitacoesAprovadas;
	private JTextArea campoInformacoes;
	private JComboBox comboPrioridade;
	private JTextField campoCodigo;
	private JTextField campoNome;
	private String andamento;
	private int cont;

	private ProjetoDAO projetoDao = new ProjetoDAO();
	private ArrayList<Requisicao> manipulaProjeto;
	private Requisicao projeto;
	private JTable table;
	private JTable table_1;

	public TelaCriação() {
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

		JLabel lblNewLabel = new JLabel("C r i a \u00E7 \u00E3 o");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 195, 34);
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
		campoNome.setBounds(55, 18, 238, 20);
		panel_3.add(campoNome);
		campoNome.setColumns(10);

		JButton btnOk = new JButton("OK");

		btnOk.setBounds(308, 356, 98, 26);
		panel_3.add(btnOk);

		String prioridade[] = { "Prioridade 1", "Prioridade 2", "Prioridade 3", "Prioridade 4", "Prioridade 5" };
		comboPrioridade = new JComboBox(prioridade);
		comboPrioridade.setBounds(308, 242, 99, 25);
		panel_3.add(comboPrioridade);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(12, 74, 394, 155);
		panel_3.add(textArea);

		JLabel lblCaracteristicasDoJob = new JLabel("Caracteristicas do Job");
		lblCaracteristicasDoJob.setBounds(12, 47, 138, 16);
		panel_3.add(lblCaracteristicasDoJob);

		table = new JTable();
		table.setBounds(12, 261, 281, 121);
		panel_3.add(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, }, new String[] {
						"New column", "New column" }));

		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setBounds(12, 240, 82, 16);
		panel_3.add(lblFuncionario);

		campoCodigo = new JTextField();
		campoCodigo.setBounds(365, 15, 41, 23);
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
		panel_1.setBorder(new TitledBorder(null,
				"", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 416, 343);
		panel_1.add(panel_2);
		panel_2.setBorder(new TitledBorder(null,
				"Solicitações", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_2.setLayout(null);

		campoInformacoes = new JTextArea();
		campoInformacoes.setLineWrap(true);
		campoInformacoes.setBounds(10, 174, 394, 124);
		panel_2.add(campoInformacoes);
		
				tabelaSolicitacoesAprovadas = new JTable();
				tabelaSolicitacoesAprovadas.setBounds(10, 22, 394, 124);
				panel_2.add(tabelaSolicitacoesAprovadas);
				tabelaSolicitacoesAprovadas.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null }, }, new String[] {
								"New column", "New column", "New column" }));
				
						JButton btnAbrir = new JButton("Abrir");
						btnAbrir.setBounds(218, 309, 89, 23);
						panel_2.add(btnAbrir);
						
								JButton botaoAtualiza = new JButton("Atualiza");
								botaoAtualiza.setBounds(317, 309, 89, 23);
								panel_2.add(botaoAtualiza);
								
								JLabel lblCaracteristicas = new JLabel("Caracteristicas");
								lblCaracteristicas.setBounds(10, 157, 89, 14);
								panel_2.add(lblCaracteristicas);
						btnAbrir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String informacoes, codigo;

								informacoes = (String) tabelaSolicitacoesAprovadas
										.getModel()
										.getValueAt(
												tabelaSolicitacoesAprovadas.getSelectedRow(), 2);
								campoInformacoes.setText(informacoes + "");

								codigo = (String) tabelaSolicitacoesAprovadas
										.getModel()
										.getValueAt(
												tabelaSolicitacoesAprovadas.getSelectedRow(), 0);
								campoCodigo.setText(codigo + "");

							}
						});

		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Job's pendentes", null, panel_4, null);
		panel_4.setLayout(null);

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBounds(330, 331, 99, 23);
		panel_4.add(btnSelecionar);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(10, 199, 419, 121);
		panel_4.add(textArea_1);

		JLabel label = new JLabel("Caracteristicas do Job");
		label.setBounds(10, 172, 419, 16);
		panel_4.add(label);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_1.setBounds(10, 38, 419, 123);
		panel_4.add(table_1);

		JLabel lblJobs = new JLabel(" Job's");
		lblJobs.setBounds(10, 11, 419, 16);
		panel_4.add(lblJobs);

		JButton btnFinalizado = new JButton("Finalizado");
		btnFinalizado.setBounds(10, 331, 99, 23);
		panel_4.add(btnFinalizado);
		table.getColumnModel().getColumn(1).setPreferredWidth(274);

		ButtonGroup bt = new ButtonGroup();

	}

	public void tabelaSincronizada() {

		DefaultTableModel model = (DefaultTableModel) tabelaSolicitacoesAprovadas
				.getModel();
		model.setNumRows(0);

		manipulaProjeto = (ArrayList<Requisicao>) projetoDao.listeTodos();

		for (int i = 0; i < manipulaProjeto.size(); i++) {
			if (manipulaProjeto.get(i).getPorcentagemConclusao() >= 20) {
				model.addRow(new String[] {
						"" + manipulaProjeto.get(i).getIdProjeto(),
						"" + manipulaProjeto.get(i).getNomeProjet(),
						"" + manipulaProjeto.get(i).getPorcentagemConclusao()
								+ "% concluido" });
			}
		}

	}
}
