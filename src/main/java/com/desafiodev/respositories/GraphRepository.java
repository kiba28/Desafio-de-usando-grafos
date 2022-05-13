package com.desafiodev.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiodev.entities.Graph;

public interface GraphRepository extends JpaRepository<Graph, Long> {

}
