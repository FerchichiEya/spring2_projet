package com.ferchichi.personne.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ferchichi.personne.entities.Personne;

public interface PersonneService {
	Personne savePersonne(Personne p);

	Personne updatePersonne(Personne p);

	void deletePersonne(Personne p);

	void deletePersonneById(Long id);

	Personne getPersonneById(Long id);

	List<Personne> getAllPersonne();

	Page<Personne> getAllPersonneParPage(int page, int size);
	
	List<Personne> findByMachine(String machine);
}
