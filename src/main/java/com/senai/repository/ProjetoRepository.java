package com.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

}
