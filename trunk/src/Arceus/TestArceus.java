package Arceus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TestArceus {

	/**
	 * @param args
	 *            Modelo para inserir dados no banco, bastante horroroso mais ja
	 *            funciona ^^
	 */
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			int option = Integer
					.parseInt(JOptionPane
							.showInputDialog("1 = Criar\n2 = Ver\n3 = Editar\n4 = Excluir "));
			String query = "";
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/lol", "root", "1234");

			switch (option) {

			case 1:

				String nome,
				cidade;
				int cep;

				nome = JOptionPane.showInputDialog("Informe seu nome");
				cidade = JOptionPane.showInputDialog("Ola " + nome
						+ "\nInforme sua cidade");
				cep = Integer.parseInt(JOptionPane
						.showInputDialog("Agora informe seu cep"));

				query = "insert into pessoa (E_MAIL, CIDADE, CEP, BAIRRO, RUA, NOME, ID_PESSOA) VALUES(?,?,?,?,?,?,?)";

				stmt = con.prepareStatement(query);

				stmt.setString(1, null);
				stmt.setString(2, cidade);
				stmt.setInt(3, cep);
				stmt.setString(4, null);
				stmt.setString(5, null);
				stmt.setString(6, nome);
				stmt.setString(7, null);

				stmt.executeUpdate();

				stmt.close();
				con.close();

				break;

			case 2:
				String nomeLista = "";
				String nomePesquisa = JOptionPane
						.showInputDialog("Informar nome para pesquisa!");
				query = "SELECT * FROM pessoa WHERE nome = ?";

				stmt = con.prepareStatement(query);
				stmt.setString(1, nomePesquisa);

				ResultSet res;
				res = stmt.executeQuery();

				while (res.next()) {
					if (res.getString("nome").equalsIgnoreCase(nomePesquisa)) {
						nomeLista += res.getString("nome") + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, nomeLista);
				stmt.close();
				con.close();

				break;
			case 3:

				int id = Integer
						.parseInt(JOptionPane
								.showInputDialog("informar o codigo de quem deseja alterar o nome!"));
				String newName = JOptionPane
						.showInputDialog("Informar novo nome para a pessoa de codigo"
								+ id);

				query = "UPDATE `lol`.`pessoa` SET `NOME`='" + newName
						+ "' WHERE `ID_PESSOA`='" + id + "'";

				stmt = con.prepareStatement(query);

				stmt.executeUpdate();

				stmt.close();
				con.close();

				break;
			case 4:
				String nomeDelet = JOptionPane
						.showInputDialog("informe a pessoa a ser excluida!");
				query = "DELETE FROM `lol`.`pessoa` WHERE `NOME`='" + nomeDelet
						+ "'";

				stmt = con.prepareStatement(query);

				stmt.executeUpdate();

				stmt.close();
				con.close();
				break;

			default:
				break;
			}

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
}
