package com.senai.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.domain.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}
