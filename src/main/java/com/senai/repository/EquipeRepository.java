package com.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.model.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long>{

}
