package com.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.model.Revista;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Long>{

}
