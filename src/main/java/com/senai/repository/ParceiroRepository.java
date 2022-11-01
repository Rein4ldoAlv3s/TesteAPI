package com.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.model.Parceiro;

@Repository
public interface ParceiroRepository extends JpaRepository<Parceiro, Long>{

}
