package Arceus.src.br.com.arceus.controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GerenciadorDeConeccoes {

	private Connection con = null;
	private PreparedStatement stmt = null;

	public void cadastrar(String query, String parametros) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Arceus", "root", "1234");

			stmt = con.prepareStatement(query);

			String[] token = parametros.split("#");
			for (int i = 0; i < token.length; i++) {
				stmt.setString(i + 1, token[i]);
			}
			stmt.executeUpdate();

			stmt.close();
			con.close();

		} catch (SQLException e) {
			
			System.err.println("Erro tipo 1" + e);
		} catch (ClassNotFoundException e) {
			System.err.println("Erro tipo 2" + e);
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
	
	public void exibir(String query, String parametro, JTable tela){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Arceus", "root", "1234");

			stmt = con.prepareStatement(query);

			stmt.setString(1, parametro);
			
			ResultSet rs;
			
			rs = stmt.executeQuery();
			
			DefaultTableModel model = (DefaultTableModel) tela.getModel();
			
			model.setNumRows(0);
			
			while(rs.next()){
				model.addRow(new Object[]{rs.getString("ID_PESSOA"),rs.getString("NOME"),rs.getString("E_MAIL")});
			}
			
			
			stmt.close();
			con.close();

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
	
	public void excluir(String query, JTable tabela){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Arceus", "root", "1234");

			stmt = con.prepareStatement(query);

			String index;
			
			index = (String) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
			
			stmt.setString(1, index);
			stmt.executeUpdate();
			
			
			stmt.close();
			con.close();

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
	
	public int getCodigo(){
		int cont = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Arceus", "root", "1234");

			stmt = con.prepareStatement("select id_pessoa from pessoa order by id_pessoa desc limit 1");
			ResultSet rs;
			
			rs = stmt.executeQuery();
			
			
			while(rs.next()){
				cont =Integer.parseInt(rs.getString("ID_PESSOA"));
			}
			 

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
		
		
		return cont+1;
	}
}
