package sensoriamento;

public class chave_projetor {
	private int id;
	private Boolean status_projetor;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getStatus_projetor() {
		return status_projetor;
	}

	public void setStatus_projetor(Boolean status_projetor) {
		this.status_projetor = status_projetor;
	}

	@Override
	public String toString() {
		return "chave_projetor [id=" + id + ", status_projetor=" + status_projetor + "]";
	}
}
