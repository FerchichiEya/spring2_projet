package com.ferchichi.personne.service;

import java.util.List;

import com.ferchichi.personne.entities.Role;


public interface RoleService {
	 List <Role> findAll();
	    
	 Role saveRole(Role r);
	 Role updateRole(Role r);
	 Role getRole (Long idRole);
}
