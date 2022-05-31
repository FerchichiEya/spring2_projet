package com.ferchichi.personne.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ferchichi.personne.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
