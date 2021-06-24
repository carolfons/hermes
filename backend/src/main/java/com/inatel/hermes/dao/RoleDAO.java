package com.inatel.hermes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.hermes.entities.Role;



public interface RoleDAO extends JpaRepository<Role, Long> {

	Role findByNomeRole(String role);
}
