public class Projeto {

	private int Id_Projeto;
	private String Nome_Projeto;

	private Projeto(int id, String nome) {
		this.Id_Projeto = id;
		this.Nome_Projeto = nome;
	}

	public int getId() {
		return Id_Projeto;
	}

	public void setId(int Id_Projeto) {
		this.Id_Projeto = Id_Projeto;
	}

	public String getNome() {
		return Nome_Projeto;
	}

	public void setNome(String Nome_Projeto) {
		this.Nome_Projeto = Nome_Projeto;
	}
}
