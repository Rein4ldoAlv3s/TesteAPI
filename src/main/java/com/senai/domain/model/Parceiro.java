package com.senai.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Parceiro {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String logo;
	private String nome;
	
	@JsonIgnore
	@ManyToOne
	private Evento evento;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "parceiro_projeto", 
				joinColumns = @JoinColumn(name = "parceiro_id"),
				inverseJoinColumns = @JoinColumn(name = "projeto_id"))
	private List<Projeto> projetos;
}
