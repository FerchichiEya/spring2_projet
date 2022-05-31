package com.ferchichi.personne.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ferchichi.personne.entities.Machine;

@Repository
public interface MachineRepositroy extends JpaRepository<Machine, Long> {

}
