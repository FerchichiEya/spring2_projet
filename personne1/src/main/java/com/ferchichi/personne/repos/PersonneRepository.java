package com.ferchichi.personne.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ferchichi.personne.entities.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

	@Query("select p from Personne p, Machine m where p.machine.idMachine = m.idMachine and m.nomMachine like %:machine%")
	List<Personne> findByMachine(@Param("machine") String machine);

	

}
