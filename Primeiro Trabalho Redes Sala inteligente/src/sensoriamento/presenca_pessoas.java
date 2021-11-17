package sensoriamento;

public class presenca_pessoas {
	private int id;
	private String status_pessoas;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus_pessoas() {
		return status_pessoas;
	}

	public void setStatus_pessoas(String status_pessoas) {
		this.status_pessoas = status_pessoas;
	}

	@Override
	public String toString() {
		return "presenca_pessoas [id=" + id + ", status_pessoas=" + status_pessoas + "]";
	}
}
