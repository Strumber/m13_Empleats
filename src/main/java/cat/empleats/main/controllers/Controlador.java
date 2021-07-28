package cat.empleats.main.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cat.empleats.main.bean.Empleat;
import cat.empleats.main.bean.Usuari;
import cat.empleats.main.repository.BaseDatos;

@Controller // Convertim en un servlet, atén peticions http
@RequestMapping("")
public class Controlador {

	BaseDatos bd = new BaseDatos();
	Usuari usuari;

	@GetMapping("/")
	public String iniciar(Model model) {
		model.addAttribute("titulo", "FORMULARI D' ACCES");

		return "login";

	}

	@PostMapping("/")
	public String login(Usuari usuari, Model model, @RequestParam String nom, @RequestParam String password) {

		if (usuari.getNom().equals("Jordi") && usuari.getPassword().equals("12345")) {

			ArrayList<Empleat> empleats = bd.getEmpleats();
			model.addAttribute("usuari", usuari);
			this.usuari = usuari;
			model.addAttribute("empleats", empleats);
			model.addAttribute("empleat", new Empleat());
			model.addAttribute("boton", "Inserta empleat");
			model.addAttribute("action", "/insertar");

			return "consulta";

		} else {

			return "login";
		}

	}

	@PostMapping("/insertar")
	public String insertar(Empleat empleat, Model model) {
		bd.inserta(empleat);
		ArrayList<Empleat> empleats = bd.getEmpleats();
		model.addAttribute("usuari", this.usuari);
		model.addAttribute("empleats", empleats);
		model.addAttribute("boton", "Inserta empleat");
		model.addAttribute("action", "/insertar");
		model.addAttribute("empleat", new Empleat());

		return "consulta";

	}

	@GetMapping("/borrado/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Empleat> empleats = bd.getEmpleats();
		model.addAttribute("empleats", empleats);
		model.addAttribute("usuari", this.usuari);
		model.addAttribute("boton", "Inserta empleats");
		model.addAttribute("action", "/insertar");
		model.addAttribute("empleat", new Empleat());
		return "consulta";
	}

	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Empleat empleat = bd.getEmpleat(id);
		ArrayList<Empleat> empleats = bd.getEmpleats();
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", empleat);
		model.addAttribute("usuari", this.usuari);
		model.addAttribute("boton", "Modifica empleat");
		model.addAttribute("action", "/modificar");

		return "consulta";

	}

	@PostMapping("/modificar")
	public String modificar2(Empleat empleat, Model model) {
		bd.modifica(empleat);
		ArrayList<Empleat> empleats = bd.getEmpleats();
		model.addAttribute("usuari", this.usuari);
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", new Empleat());
		model.addAttribute("boton", "Inserta empleat");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}

	@PostMapping("/especial")
	public String login2(Model model, @RequestParam String categoria) {

		ArrayList<Empleat> empleats = new ArrayList<Empleat>();
		ArrayList<Empleat> empleatssinF = bd.getEmpleats();
		if (categoria.equals("todos")) {
			empleats = empleatssinF;

		} else {
			for (Empleat e : empleatssinF) {
				String pepe = e.getCategoria().getNomCategoria();
				if (pepe.equals(categoria)) {
					empleats.add(e);
				}
			}

		}

		model.addAttribute("empleats", empleats);
		model.addAttribute("usuari", usuari);
		model.addAttribute("empleat", new Empleat());
		model.addAttribute("boton", "Inserta empleat");
		model.addAttribute("action", "/insertar");

		return "consulta";

	}

}
