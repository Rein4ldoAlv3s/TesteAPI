package com.senai.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senai.domain.model.enums.Categoria;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Equipe {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String foto;
	private String nome;
	private String pequenoCurriculo;
	private Categoria categoria;
	private String professor;
	private String aluno;
	private String profissionais;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "equipe_projeto", 
				joinColumns = @JoinColumn(name = "equipe_id"),
				inverseJoinColumns = @JoinColumn(name = "projeto_id"))
	private List<Projeto> projetos;
	
}
