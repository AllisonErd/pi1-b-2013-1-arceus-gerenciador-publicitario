package br.com.luguia.arceus.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.luguia.arceus.model.Contato;
import br.com.luguia.arceus.model.Endereco;
import br.com.luguia.arceus.model.Financeiro;
import br.com.luguia.arceus.model.Funcionario;
import br.com.luguia.arceus.model.Job;
import br.com.luguia.arceus.model.PessoaFisica;
import br.com.luguia.arceus.model.PessoaJuridica;
import br.com.luguia.arceus.model.Requisicao;
import br.com.luguia.arceus.model.Telefone;

public class MySqlController {

	private ArrayList<Funcionario> model;
	private ArrayList<PessoaFisica> modelFisica;
	private ArrayList<PessoaJuridica> modelJuridica;
	private ArrayList<Requisicao> modelRequisicao;
	private ArrayList<Job> modeloJob;

	private Funcionario func;
	private PessoaFisica pessoaFisica;
	private PessoaJuridica pessoaJuridica;
	private Requisicao requisicao;
	private Job job;

	private Endereco endereco;
	private Contato contato;
	private Telefone telefone;

	private Financeiro financeiro;

	private String host;
	private String user;
	private String pass;

	public boolean conectado() {
		this.parametrosConexao();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(this.host, this.user, this.pass);

			return true;

		} catch (ClassNotFoundException e) {

			return false;
		} catch (SQLException e) {

			return false;
		}

	}

	public void parametrosConexao() {
		try {

			InputStream is = new FileInputStream("ConectBanco.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();

			String tokens[] = s.split("#&V&#");

			this.host = tokens[0];
			this.user = tokens[1];
			this.pass = tokens[2];

			br.close();
		} catch (Exception e2) {

			e2.printStackTrace();
		}
	}

	private Connection con = null;
	private PreparedStatement stmt = null;

	public void cadastrar(String query, String parametros) {
	this.parametrosConexao();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(this.host, this.user, this.pass);

			stmt = con.prepareStatement(query);

			String[] token = parametros.split("#&V&#");
			for (int i = 0; i < token.length; i++) {
				stmt.setString(i + 1, token[i]);
			}
			stmt.executeUpdate();

			// stmt.close();
			// con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null,"Informe os parâmetros corretos para a conexão!");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				stmt.close();
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void excluir(String query) {
		this.parametrosConexao();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(this.host, this.user, this.pass);

			stmt = con.prepareStatement(query);

			stmt.executeUpdate();

			// stmt.close();
			// con.close();

		} catch (SQLException e) {
			System.err.println("Erro " + e);
		} catch (ClassNotFoundException e) {
			System.err.println("Erro " + e);
		} finally {
			try {
				stmt.close();
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void exibir(String query, int tipo) {
		this.parametrosConexao();
		
		model = new ArrayList<>();
		modelFisica = new ArrayList<>();
		modelJuridica = new ArrayList<>();
		modelRequisicao = new ArrayList<>();
		modeloJob = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(this.host, this.user, this.pass);

			stmt = con.prepareStatement(query);

			ResultSet rs;

			rs = stmt.executeQuery();
			switch (tipo) {
			case 1:
				while (rs.next()) {

					func = new Funcionario();

					func.setSenha(rs.getString("senha"));
					func.setNome(rs.getString("nome"));
					func.setTipo(rs.getString("tipo"));
					func.setLogin(rs.getString("login"));
					func.setId(Integer.parseInt(rs.getString("id_func")));

					this.model.add(func);
				}
				break;

			case 2:
				while (rs.next()) {

					pessoaFisica = new PessoaFisica();

					pessoaFisica.setId(Integer.parseInt(rs
							.getString("id_pessoa")));
					pessoaFisica.setNome(rs.getString("nome"));
					pessoaFisica.setRg(rs.getString("RG"));
					pessoaFisica.setCpf(rs.getString("CPF"));

					endereco = new Endereco();
					endereco.setRua(rs.getString("RUA"));
					endereco.setCep(rs.getString("CEP"));
					endereco.setBairro(rs.getString("BAIRRO"));
					endereco.setCidade(rs.getString("CIDADE"));
					endereco.setEstado(rs.getString("ESTADO"));
					endereco.setComplemento(rs.getString("COMPLEMENTO"));

					pessoaFisica.setEndereco(endereco);

					contato = new Contato();
					contato.setEmail(rs.getString("E_MAIL"));

					telefone = new Telefone();
					telefone.setTelefoneCel(rs.getString("TELEFONE_CELL"));
					telefone.setTelefoneFixo(rs.getString("TELEFONE_FIXO"));

					contato.setTelefone(telefone);
					pessoaFisica.setContato(contato);
					;

					this.modelFisica.add(pessoaFisica);
				}
				break;

			case 3:
				while (rs.next()) {

					pessoaJuridica = new PessoaJuridica();

					pessoaJuridica.setId(Integer.parseInt(rs
							.getString("id_pessoa")));
					pessoaJuridica.setNome(rs.getString("nome"));
					pessoaJuridica.setCnpj(rs.getString("CNPJ"));

					endereco = new Endereco();

					endereco.setRua(rs.getString("RUA"));
					endereco.setCep(rs.getString("CEP"));
					endereco.setBairro(rs.getString("BAIRRO"));
					endereco.setCidade(rs.getString("CIDADE"));
					endereco.setEstado(rs.getString("ESTADO"));
					endereco.setComplemento(rs.getString("COMPLEMENTO"));

					pessoaJuridica.setEndereco(endereco);

					contato = new Contato();
					contato.setEmail(rs.getString("E_MAIL"));

					telefone = new Telefone();
					telefone.setTelefoneCel(rs.getString("TELEFONE_CELL"));
					telefone.setTelefoneFixo(rs.getString("TELEFONE_FIXO"));

					contato.setTelefone(telefone);
					pessoaJuridica.setContato(contato);
					;

					this.modelJuridica.add(pessoaJuridica);
				}
				break;
			case 4:
				while (rs.next()) {

					requisicao = new Requisicao();

					requisicao.setCustoEquipamento(rs
							.getString("custo_equipamento"));
					requisicao.setDataPedido(rs.getString("data_pedido"));
					requisicao.setDefinicaoProjeto(rs
							.getString("definicao_projeto"));
					requisicao.setIdProjeto(Integer.parseInt(rs
							.getString("id_projeto")));
					requisicao.setNomeProjet(rs.getString("nome_projeto"));
					requisicao.setPorcentagemConclusao(Integer.parseInt(rs
							.getString("porcentagem_conclusao")));
//					requisicao.setPrioridadeProjeto(Integer.parseInt(rs
//							.getString("prioridade")));
					requisicao.setTempoEntrega(rs.getString("data_entrega"));
					requisicao.setTipoExecucao(rs.getString("tipo_execucao"));
					requisicao.setIdPessoa(Integer.parseInt(rs
							.getString("id_pessoa")));

					financeiro = new Financeiro();
					financeiro.setCusto(Double.parseDouble(rs
							.getString("custo")));
					financeiro.setDesconto(Double.parseDouble(rs
							.getString("desconto")));
					financeiro.setGanho(Double.parseDouble(rs
							.getString("ganho")));
					financeiro.setOrcamento(Double.parseDouble(rs
							.getString("orcamento")));

					requisicao.setCustos(financeiro);

					this.modelRequisicao.add(requisicao);
				}

				break;
			case 5:
				while (rs.next()) {

					job = new Job();

					job.setIdJob(Integer.parseInt(rs.getString("id_job")));
					job.setIdProjeto(Integer.parseInt(rs
							.getString("id_projeto")));
					job.setIdFuncionario(Integer.parseInt(rs
							.getString("id_func")));
					job.setNomeJob(rs.getString("nome_job"));
					job.setCaracteristicasJob(rs
							.getString("caracteristicas_job"));
					job.setPrioridadeJob(Integer.parseInt(rs
							.getString("prioridade_job")));
					job.setStatus(rs.getString("status_job"));
					this.modeloJob.add(job);
				}
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro 1" + e);
		} catch (ClassNotFoundException e) {
			System.err.println("Erro 2" + e);
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void alterar(String query) {
		this.parametrosConexao();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(this.host, this.user, this.pass);

			stmt = con.prepareStatement(query);

			stmt.executeUpdate();

			// stmt.close();
			// con.close();

		} catch (SQLException e) {
			System.err.println("Erro " + e);
		} catch (ClassNotFoundException e) {
			System.err.println("Erro " + e);
		} finally {
			try {
				stmt.close();
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public List<Funcionario> getListaFuncionario() {

		return this.model;

	}

	public List<PessoaFisica> getListaPessoaFisica() {

		return this.modelFisica;

	}

	public List<PessoaJuridica> getListaPessoaJuridica() {

		return this.modelJuridica;

	}

	public List<Requisicao> getListaRequisicao() {
		return this.modelRequisicao;
	}

	public List<Job> getListaJob() {
		return this.modeloJob;
	}
}
