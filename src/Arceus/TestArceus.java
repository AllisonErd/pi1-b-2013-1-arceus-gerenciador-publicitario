package Arceus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TestArceus {

	/**
	 * @param args
	 * Modelo para inserir dados no banco, bastante horroroso mais ja funciona ^^
	 */
	public static void main(String[] args) {

		int option = Integer
				.parseInt(JOptionPane.showInputDialog("informar 1"));

		switch (option) {

		case 1:
			Connection con = null;
			PreparedStatement stmt = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/lol", "root", "1234");

				String query = "insert into pessoa (E_MAIL, CIDADE, CEP, BAIRRO, RUA, NOME, ID_PESSOA) VALUES(?,?,?,?,?,?,?)";

				stmt = con.prepareStatement(query);

				String nome = JOptionPane.showInputDialog("Informe seu nome");
				stmt.setString(1, "henrique_araujo91@outlook"); // alterar o
																// campo de
																// email no
																// banco pois
																// estamos com
																// quantidade de
																// caracteres
																// insuficientes!!
				stmt.setString(2, "belo jardim");
				stmt.setInt(3, 55155410);
				stmt.setString(4, null);
				stmt.setString(5, "Boaventura");
				stmt.setString(6, nome);
				stmt.setInt(7, 5);

				stmt.executeUpdate();

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

			break;

		default:
			break;
		}

	}

}
