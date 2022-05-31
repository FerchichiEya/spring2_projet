package com.ferchichi.personne.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ferchichi.personne.entities.Machine;
import com.ferchichi.personne.entities.Personne;
import com.ferchichi.personne.service.MachineService;
import com.ferchichi.personne.service.PersonneService;

@Controller
public class PersonneController {

	@Autowired
	PersonneService personneService;
	@Autowired
	MachineService machineService;

	@RequestMapping("/showCreatePersonne")
	public String showCreatePersonne(ModelMap modelMap) {
		List<Machine> machines = machineService.findAll();
		Personne pers = new Personne();
		Machine machine = new Machine();
		machine = machines.get(0); //
		pers.setMachine(machine);
		modelMap.addAttribute("personne", pers);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("machines", machines);
		return "formPersonne";
	}

	@RequestMapping("/savePersonne")
	public String savePersonne(@Valid Personne personne, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formPersonne";
		personneService.savePersonne(personne);
		return "redirect:/ListePersonne";
	}

	@RequestMapping("/searchPersonne")
	public String searchPersonne(ModelMap modelMap, @Valid String machinenom) {
		List<Personne> personnes = personneService.findByMachine(machinenom);

		modelMap.addAttribute("personnes", personnes);

		return "/RechercherListPersonne";
	}

	@RequestMapping("/ListePersonne")
	public String listeOwners(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Page<Personne> pers = personneService.getAllPersonneParPage(page, size);
		modelMap.addAttribute("personnes", pers);
		modelMap.addAttribute("pages", new int[pers.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListePersonne";
	}

	@RequestMapping("/supprimerPersonne")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		personneService.deletePersonneById(id);
		Page<Personne> pers = personneService.getAllPersonneParPage(page, size);
		modelMap.addAttribute("personnes", pers);
		modelMap.addAttribute("pages", new int[pers.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListePersonne";
	}

	@RequestMapping("/modifierPersonne")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Personne pers = personneService.getPersonneById(id);
		List<Machine> machines = machineService.findAll();
		modelMap.addAttribute("personne", pers);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("machines", machines);
		return "formPersonne";
	}
}
