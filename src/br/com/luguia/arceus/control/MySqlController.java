package br.com.luguia.arceus.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.luguia.arceus.model.ConectBd;



public class MySqlController {

	ConectBd cbd = new ConectBd();
	private Connection con = null;
	private PreparedStatement stmt = null;
	
	public void cadastrar(String query, String parametros) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					cbd.getHost(), cbd.getUser(), cbd.getPass());

			stmt = con.prepareStatement(query);

			String[] token = parametros.split("#");
			for (int i = 0; i < token.length; i++) {
				stmt.setString(i + 1, token[i]);
			}
			stmt.executeUpdate();

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
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

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					cbd.getHost(), cbd.getUser(), cbd.getPass());

			stmt = con.prepareStatement(query);

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
	
	
}
