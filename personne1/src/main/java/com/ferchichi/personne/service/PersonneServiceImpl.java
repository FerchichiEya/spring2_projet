package com.ferchichi.personne.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ferchichi.personne.entities.Personne;
import com.ferchichi.personne.repos.PersonneRepository;
@Service
public class PersonneServiceImpl implements PersonneService {

	@Autowired
	PersonneRepository personneRepository;
	
	@Override
	public Personne savePersonne(Personne p) {
		// TODO Auto-generated method stub
		return personneRepository.save(p);
	}

	@Override
	public Personne updatePersonne(Personne p) {
		// TODO Auto-generated method stub
		return personneRepository.save(p);
	}

	@Override
	public void deletePersonne(Personne p) {
		// TODO Auto-generated method stub
		personneRepository.delete(p);
	}

	@Override
	public void deletePersonneById(Long id) {
		// TODO Auto-generated method stub
		personneRepository.deleteById(id);
	}

	@Override
	public Personne getPersonneById(Long id) {
		// TODO Auto-generated method stub
		return personneRepository.getById(id);
	}

	@Override
	public List<Personne> getAllPersonne() {
		// TODO Auto-generated method stub
		return personneRepository.findAll();
	}

	@Override
	public Page<Personne> getAllPersonneParPage(int page, int size) {
		// TODO Auto-generated method stub
		return personneRepository.findAll(PageRequest.of(page, size));
	}

	public List<Personne> findByMachine(String machine) {
		// TODO Auto-generated method stub
		return personneRepository.findByMachine(machine);
	}

	
}
