package com.ferchichi.personne.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ferchichi.personne.entities.Machine;
import com.ferchichi.personne.repos.MachineRepositroy;

@Service
public class MachineServiceImpl implements MachineService {

	@Autowired
	MachineRepositroy machineRepositroy;
	
	@Override
	public Machine saveMachine(Machine b) {
		// TODO Auto-generated method stub
		return machineRepositroy.save(b);
	}

	@Override
	public Machine getMachineById(long id) {
		// TODO Auto-generated method stub
		return machineRepositroy.getById(id);
	}

	@Override
	public void deleteMachineById(long id) {
		// TODO Auto-generated method stub
		machineRepositroy.deleteById(id);
	}

	@Override
	public Machine updateMachine(Machine b) {
		// TODO Auto-generated method stub
		return machineRepositroy.save(b);
	}

	@Override
	public Page<Machine> getAllMachineParPage(int page, int size) {
		// TODO Auto-generated method stub
		return machineRepositroy.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Machine> findAll() {
		// TODO Auto-generated method stub
		return machineRepositroy.findAll();
	}

}
