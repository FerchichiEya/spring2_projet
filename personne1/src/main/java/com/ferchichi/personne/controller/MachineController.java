package com.ferchichi.personne.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ferchichi.personne.entities.Machine;
import com.ferchichi.personne.service.MachineService;



@Controller 
class MachineController {
	@Autowired
	MachineService machineService;
	
	@RequestMapping("/showCreateMachine")
	public String showCreateMachine(ModelMap modelMap) {
		Machine machine = new Machine();
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("machine", machine);
		return "formMachine";
	}
	

	@RequestMapping("/saveMachine")
	public String saveProduit(@Valid Machine machine, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formMachine";
		machineService.saveMachine(machine);
		return "redirect:/ListeMachine";
	}
	

	@RequestMapping("/ListeMachine")
	public String listeOwners(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Page<Machine> machines= machineService.getAllMachineParPage(page, size);
		modelMap.addAttribute("machines", machines);
		modelMap.addAttribute("pages", new int[machines.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListeMachine";
	}
	
	@RequestMapping("/supprimerMachine")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		machineService.deleteMachineById(id);
		Page<Machine> machines = machineService.getAllMachineParPage(page, size);
		modelMap.addAttribute("machines", machines);
		modelMap.addAttribute("pages", new int[machines.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListeMachine";
	}
	

	@RequestMapping("/modifierMachine")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Machine machine = machineService.getMachineById(id);
		modelMap.addAttribute("machine", machine);
		modelMap.addAttribute("mode", "edit");
		return "formMachine";
	}
}
