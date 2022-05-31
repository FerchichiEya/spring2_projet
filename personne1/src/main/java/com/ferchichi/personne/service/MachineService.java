package com.ferchichi.personne.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ferchichi.personne.entities.Machine;



public interface MachineService {
	Machine saveMachine(Machine b);
	Machine getMachineById(long id);
	void deleteMachineById(long id);
	Machine updateMachine(Machine b);
	Page<Machine> getAllMachineParPage(int page, int size);
	List <Machine> findAll();
}
