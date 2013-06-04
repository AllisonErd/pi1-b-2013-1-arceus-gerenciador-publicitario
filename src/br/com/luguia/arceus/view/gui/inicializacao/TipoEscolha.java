package br.com.luguia.arceus.view.gui.inicializacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.luguia.arceus.control.MySqlController;
import br.com.luguia.arceus.model.Funcionario;
import br.com.luguia.arceus.model.dao.array.FuncionarioDAO;

public class TipoEscolha extends JFrame {

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private ArrayList<Funcionario> manipulaFuncionario;
	//private Funcionario funcionario;
	private	MySqlController mc = new MySqlController();
	
		private JPanel contentPane;

	public TipoEscolha() {
		setTitle("Tipo de Teste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 284, 261);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Populado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populaBanco();
				dispose();
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(TipoEscolha.class
				.getResource("/Images24x24/folder_full.png")));

		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(47, 79, 79));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledText"));
		btnNewButton.setBounds(66, 72, 160, 40);
		panel_1.add(btnNewButton);

		JButton btnNopopulado = new JButton("N\u00E3o-Populado");
		btnNopopulado.setIcon(new ImageIcon(TipoEscolha.class
				.getResource("/Images24x24/folder_edit.png")));
		btnNopopulado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				bancoVazio();
				dispose();

			}
		});
		btnNopopulado.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNopopulado.setForeground(new Color(47, 79, 79));
		btnNopopulado.setBackground(UIManager.getColor("Button.disabledText"));
		btnNopopulado.setBounds(66, 150, 160, 40);
		panel_1.add(btnNopopulado);

		JButton btnInicio = new JButton("Inicio");
		btnInicio.setIcon(new ImageIcon(TipoEscolha.class
				.getResource("/Images16x16/accept.png")));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscolhaBanco escolha = new EscolhaBanco();
				escolha.setVisible(true);

				dispose();
			}
		});
		btnInicio.setBackground(UIManager.getColor("Button.disabledText"));
		btnInicio.setFont(new Font("Calibri", Font.BOLD, 12));
		btnInicio.setForeground(new Color(47, 79, 79));
		btnInicio.setBounds(192, 225, 82, 25);
		panel_1.add(btnInicio);
	}

	public void populaBanco(){
		manipulaFuncionario = (ArrayList<Funcionario>) funcionarioDAO
				.listeTodos();
		
		if(manipulaFuncionario.size()>=1){
			new TelaLogin().setVisible(true);
		}else{
			mc.alterar("insert into funcionario(id_func, nome, login, senha, tipo) values ('0', 'admin', 'arceus', 'pepeka', 'admin')");
			mc.alterar("insert into funcionario(id_func, nome, login, senha, tipo) values ('1', 'Henrique', 'henrique', '123', 'criacao')");
			mc.alterar("insert into funcionario(id_func, nome, login, senha, tipo) values ('2', 'David', 'david', '123', 'midia')");
			mc.alterar("insert into funcionario(id_func, nome, login, senha, tipo) values ('3', 'Filipe', 'filipe', '123', 'financeiro')");
			mc.alterar("insert into funcionario(id_func, nome, login, senha, tipo) values ('4', 'Alison', 'alison', '123', 'producao')");
			mc.alterar("insert into funcionario(id_func, nome, login, senha, tipo) values ('5', 'Lunga', 'lunga', '123', 'atendimento')");
			mc.alterar("insert into pessoa (id_pessoa, nome) values ('1','Pedro')");
			mc.alterar("insert into pessoa (id_pessoa, nome) values ('2','Lugia Developers')");
			mc.alterar("insert into pessoa_fisica (id_pessoa, rg, cpf) values ('1','8.465.765', '098.354.678-02')");
			mc.alterar("insert into pessoa_juridica (id_pessoa, CNPJ) values ('2', '100.000.000/0000-00')");
			mc.alterar("insert into contato (id_pessoa, e_mail ) values ('1', 'pedro@hotmail.com')");
			mc.alterar("insert into contato (id_pessoa, e_mail ) values ('2', 'lugia@lugiadevelopers.com')");
			mc.alterar("insert into telefones (id_pessoa, telefone_fixo, telefone_cell) values ('1', '(81)8957-3485', '(81)9978-7986')");
			mc.alterar("insert into telefones (id_pessoa, telefone_fixo, telefone_cell) values ('2', '(81)3661-1269', '(81)9654-9876')");
			mc.alterar("insert into endereco (id_pessoa, rua, bairro, cep, cidade, estado, complemento) values ('1', 'laranjeiras', 'cohab1', '55540-098', 'caruaru', 'pernambuco', 'proximo ao patio')");
			mc.alterar("insert into endereco (id_pessoa, rua, bairro, cep, cidade, estado, complemento) values ('2', 'empresarial', 'centro', '55540-100', 'caruaru', 'pernambuco', 'proximo ao shopping')");
			mc.alterar("insert into requisicao (id_pessoa, id_projeto, nome_projeto, data_pedido, data_entrega, definicao_projeto, tipo_execucao, custo_equipamento, porcentagem_conclusao) values ('1', '1', 'teste1', '12/03/2012', '12/05/2012', 'comercial', '', '', '0' )");
			mc.alterar("insert into requisicao (id_pessoa, id_projeto, nome_projeto, data_pedido, data_entrega, definicao_projeto, tipo_execucao, custo_equipamento, porcentagem_conclusao) values ('2', '2', 'teste01', '25/01/2013', '12/03/2013', 'comercial', '', '', '0' )");
			mc.alterar("insert into financeiro(id_projeto, orcamento, custo, desconto, ganho) values ('1', '0.0', '0.0', '0.0', '0.0')");
			mc.alterar("insert into financeiro(id_projeto, orcamento, custo, desconto, ganho) values ('2', '0.0', '0.0', '0.0', '0.0')");
		
			new TelaLogin().setVisible(true);
		}
		
		
	}

	public void bancoVazio(){
		mc.excluir("drop table telefones");
		mc.excluir("drop table pessoa_juridica");
		mc.excluir("drop table pessoa_fisica");
		mc.excluir("drop table contato");
		mc.excluir("drop table endereco");
		mc.excluir("drop table financeiro");
		mc.excluir("drop table job");
		mc.excluir("drop table requisicao");
		mc.excluir("drop table funcionario");
		mc.excluir("drop table pessoa");
		
		
		mc.alterar("CREATE TABLE Pessoa (id_pessoa int(6)not null,nome varchar(100),primary key (id_pessoa))");
		mc.alterar("CREATE TABLE Pessoa_Fisica (id_pessoa int(6)not null,RG varchar(9),	CPF varchar(15),primary key (id_pessoa),FOREIGN KEY(id_pessoa) 	REFERENCES Pessoa (id_pessoa))");
		mc.alterar("CREATE TABLE Pessoa_Juridica (	id_pessoa int(6)not null, CNPJ varchar(20),primary key (id_pessoa),	FOREIGN KEY(id_pessoa) 	REFERENCES Pessoa (id_pessoa))");
		mc.alterar("CREATE TABLE Funcionario (id_func int(10),nome varchar(100),	login varchar(22) not null,	senha varchar(63) not null,	tipo varchar(30),	primary key (id_func)	)");
		mc.alterar("CREATE TABLE contato (	id_pessoa int (6) not null,	e_mail varchar(50),	primary key (id_pessoa),	foreign key (id_pessoa)		references pessoa (id_pessoa))");
		mc.alterar("CREATE TABLE telefones (	id_pessoa int (6) not null,			telefone_fixo varchar(20),			telefone_cell varchar(20),			primary key (id_pessoa),	foreign key (id_pessoa)		references pessoa (id_pessoa)	)");
		mc.alterar("CREATE TABLE endereco (				id_pessoa int (6) not null,		Rua varchar(100),			Bairro varchar(100),		Cep varchar(15),		Cidade varchar(100),	Estado varchar(100),Complemento varchar(100),primary key (id_pessoa),foreign key (id_pessoa)	references pessoa (id_pessoa))");
		mc.alterar("CREATE TABLE Requisicao (id_pessoa int (6) not null,	id_projeto int(6)not null, nome_projeto varchar(100), data_pedido varchar(10), data_entrega varchar(10), definicao_projeto varchar(1000), tipo_execucao varchar(100),	custo_equipamento varchar(1000), porcentagem_conclusao int (3), primary key (id_projeto, id_pessoa), foreign key (id_pessoa)	references pessoa (id_pessoa))");
		mc.alterar("CREATE TABLE Financeiro (id_projeto int (6)not null, orcamento float, custo float, desconto float, ganho float, primary key (id_projeto), foreign key (id_projeto) references Requisicao (id_projeto))");
		mc.alterar("CREATE TABLE Job (id_job int (6) not null,id_projeto int (6)not null, id_func int (6)not null,nome_job varchar (100), caracteristicas_job varchar (1000), prioridade_job int (1),status_job varchar (20), primary key (id_job),foreign key (id_projeto) references Requisicao (id_projeto), foreign key (id_func) references funcionario (id_func))");
		
		mc.alterar("insert into funcionario(id_func, nome, login, senha, tipo) values ('0', 'admin', 'arceus', 'pepeka', 'admin')");

		
		new TelaLogin().setVisible(true);
		
		
		
		
	}
}