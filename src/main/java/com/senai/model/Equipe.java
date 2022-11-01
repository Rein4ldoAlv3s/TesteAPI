package com.senai.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String categoria;
	private String orientador;
	private String aluno;
	
	
	@ElementCollection
	@CollectionTable(name="PROFISSIONAL")
	private Set<String> profissionais = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "equipes")
	private List<Projeto> projetos;
	
}
