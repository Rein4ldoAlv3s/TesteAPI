package com.senai.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.domain.model.Palestrante;

@Repository
public interface PalestranteRepository extends JpaRepository<Palestrante, Long>{

}
