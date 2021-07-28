package cat.empleats.main.bean;

public enum Categoria {
	DIRECTOR("DIRECTOR"),MENTOR("MENTOR"),STAFF("STAFF");
	
	private String nomCategoria;

	private Categoria(String categ) {
		this.nomCategoria = categ;
	}

	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String categ) {
		this.nomCategoria = categ;
	}
	
	

}
