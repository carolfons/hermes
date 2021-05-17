package com.inatel.hermes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.hermes.entities.Ong;

public interface OngDAO extends JpaRepository<Ong, Long> {

}
