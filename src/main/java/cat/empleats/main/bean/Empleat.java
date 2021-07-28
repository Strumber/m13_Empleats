package cat.empleats.main.bean;

public class Empleat {
	private int id ;
	private String nom;
	private Categoria categoria; //passar a ser Objecte Categoria
	private Double sou;
	//public static int IdSiguiente = 4;
	
	public Empleat(int id, String nom, Categoria categoria, Double sou) {
		this.id = id;
		this.nom = nom;
		this.categoria = categoria;
		this.sou = sou;
				
	}
	//constructor per defecte

	public Empleat() {
	}
	
	
	//Getter i Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id =id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getSou() {
		return sou;
	}

	public void setSou(Double sou) {
		this.sou = sou;
	}
	
	
	
	
	

}
