package br.com.luguia.arceus.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class MySqlController {

	private Connection con = null;
	private PreparedStatement stmt = null;
	
	public void cadastrar(String query, String parametros) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/arceus1.1", "root", "1234");

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
					"jdbc:mysql://localhost:3306/Arceus", "root", "1234");

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
