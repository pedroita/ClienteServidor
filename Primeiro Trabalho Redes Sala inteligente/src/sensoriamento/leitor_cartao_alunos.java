package sensoriamento;

public class leitor_cartao_alunos {
	private int id;
	private String strnome_aluno;
	private int id_aluno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStrnome_aluno() {
		return strnome_aluno;
	}

	public void setStrnome_aluno(String strnome_aluno) {
		this.strnome_aluno = strnome_aluno;
	}

	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}

	@Override
	public String toString() {
		return "leitor_cartao_alunos [id=" + id + ", strnome_aluno=" + strnome_aluno + ", id_aluno=" + id_aluno + "]";
	}
	
}
