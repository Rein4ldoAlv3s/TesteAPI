package com.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.model.Artigo;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long>{

}
