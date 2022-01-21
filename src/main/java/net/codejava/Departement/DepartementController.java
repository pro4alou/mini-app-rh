package net.codejava.Departement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartementController {
	
	@Autowired
	private DepartementRepository repo;
	
	@GetMapping("/departements")
	public String listDepartements(Model model) {
		List<Departement> listDepartements = repo.findAll();
		model.addAttribute("listDepartements", listDepartements);
		return "departements";
	}
	
	@GetMapping("/departements/new")
	public String showCategoryNewForm(Model model) {
		model.addAttribute("departement", new Departement());
		
		return "departement_form";
	
	}
	
	@PostMapping("/departements/save")
	public String saveDepartement(Departement departement) {
		
		repo.save(departement);
		
		return "redirect:/departements";
	}
	
	@GetMapping("/departements/edit/{id}")
	public String showEditDepartementForm(@PathVariable("id") Integer id, Model model) {
		Departement departement = repo.findById(id).get();
		model.addAttribute("departement", departement);
		return "departement_form";
	}
	
	@GetMapping("/departements/delete/{id}")
	public String deleteDepartement(@PathVariable("id") Integer id, Model model) {
		repo.deleteById(id);
		
		return "redirect:/departements";
	}
	
	@GetMapping("retourAcueilDep")
	public String viewHomePage() {
		return "index";
	}
	
	}


