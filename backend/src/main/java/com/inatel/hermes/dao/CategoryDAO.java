package com.inatel.hermes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.hermes.entities.Category;

public interface CategoryDAO extends JpaRepository<Category, Long>{
	
	

}
