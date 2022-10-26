package com.senai.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.domain.model.Parceiro;

@Repository
public interface ParceiroRepository extends JpaRepository<Parceiro, Long>{

}
