package cat.empleats.main.repository;

import java.util.ArrayList;
import java.util.Iterator;

import cat.empleats.main.bean.Categoria;
import cat.empleats.main.bean.Empleat;

public class BaseDatos {

	ArrayList<Empleat> empleats = new ArrayList<Empleat>();

	public BaseDatos() {
		empleats.add(new Empleat(1, "Eduard Lara", Categoria.MENTOR, 30000.00));
		empleats.add(new Empleat(2, "Sofia Garcia",Categoria.STAFF, 25000.00));
		empleats.add(new Empleat(3, "Jordi TheBoss", Categoria.DIRECTOR, 50000.00));
	}

	public ArrayList<Empleat> getEmpleats() {
		return empleats;
	}

	public void setEmpleats(ArrayList<Empleat> empleats) {
		this.empleats = empleats;
	}

	public void inserta(Empleat empleat) {
		empleats.add(empleat);
		empleat.setId(empleats.size());
		if (empleat.getCategoria()==Categoria.DIRECTOR)
			empleat.setSou(50000.0);
		else if (empleat.getCategoria()==Categoria.MENTOR)
			empleat.setSou(30000.0);
		else 
			empleat.setSou(25000.0);
	}

	public void borrar(int id) {
		Iterator<Empleat> it = empleats.iterator();

		while (it.hasNext()) {
			Empleat li = it.next();
			if (li.getId() == id) {
				it.remove();
				break;
			}
		}
	}

	public Empleat getEmpleat(int id) {
		
		Empleat empleat = null;

		for (Empleat li : empleats) {
			if (li.getId() == id) {
				empleat = li;
				break;
			}
		}

		return empleat;
	}

	public void modifica (Empleat empleat) {
		Iterator<Empleat> it = empleats.iterator();
		
		while (it.hasNext()) {
			Empleat li = it.next();
			if (li.getId()==empleat.getId()) {
				li.setNom(empleat.getNom());
				li.setCategoria(empleat.getCategoria());
				//li.setSou(empleat.getSou());
				if (li.getCategoria()==Categoria.DIRECTOR)
					li.setSou(50000.0);
				else if (li.getCategoria()==Categoria.MENTOR)
					li.setSou(30000.0);
				else 
					li.setSou(25000.0);
				break;
			}
		}
	}
}
