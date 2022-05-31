package com.ferchichi.personne;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ferchichi.personne.entities.Personne;
import com.ferchichi.personne.service.PersonneService;

@SpringBootTest
class PersonneApplicationTests {

	@Autowired
	PersonneService persService;
	
	@Test
	void contextLoads() {
		List<Personne> perses = persService.findByMachine("Test");
		for (Personne P: perses) {
			System.out.println(P);
		}
	}

}
