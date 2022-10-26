package com.senai.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Projeto {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String foto;
	private String titulo;
	private String resumo;
	private String tecnologias;
	private String equipe;
	
	@ManyToMany(mappedBy = "projetos")
	private List<Parceiro> parceiros;
	
	@ManyToMany(mappedBy = "projetos")	
	private List<Equipe> equipes;
	
	@OneToMany(mappedBy = "projeto")
	private List<Artigo> artigos;
}
