package net.codejava.employe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.codejava.Departement.Departement;
import net.codejava.Departement.DepartementRepository;

@Controller
public class EmployeController {
	
	@Autowired
	private EmployeRepository employeRepo;
	
	@Autowired
	private DepartementRepository departementRepo;
	
	@GetMapping("/employes/new")
	public String showNewEmployeForm(Model model) {
		List<Departement> listDepartements = departementRepo.findAll();
								
		model.addAttribute("employe", new Employe());
	    model.addAttribute("listDepartements", listDepartements);
		
		return "employe_form";
	}
	
	@PostMapping("/employes/save")
	public String saveEmploye(Employe employe) {
		
		employeRepo.save(employe);
		return "redirect:/employes";
	}
	
	@GetMapping("/employes")
	public String listEmployes(Model model) {
	
		List<Employe> listEmployes = employeRepo.findAll();
		model.addAttribute("listEmployes", listEmployes);
		return "employes";
		
	}
	
	@GetMapping("employes/edit/{id}")
	public String showEditEmployeForm(@PathVariable("id") Integer id, Model model) {
		Employe employe = employeRepo.findById(id).get();
		model.addAttribute("employe", employe);
		
		List<Departement> listDepartements = departementRepo.findAll();
		
		
		model.addAttribute("listDepartements", listDepartements);
		
		return "employe_form";
	}
	
	@GetMapping("employes/delete/{id}")
	public String deleteEmploye(@PathVariable("id") Integer id, Model model) {
		employeRepo.deleteById(id);
		
		return "redirect:/employes";
	}
	
	@GetMapping("retourAcueil")
	public String viewHomePage() {
		return "index";
	}
	
	
	}
	

