package com.senai.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	private String equipe;

	@ElementCollection
	@CollectionTable(name = "TECNOLOGIA")
	private Set<String> tecnologias = new HashSet<>();
	
	@OneToMany
    @JoinTable(
        name="PROJETO_ARTIGO",
        joinColumns = @JoinColumn( name="projeto_id"),
        inverseJoinColumns = @JoinColumn( name="artigo_id")
    )
	private List<Artigo> artigo;
	
	
	@ManyToMany
    @JoinTable(
        name="PROJETO_EQUIPE",
        joinColumns = @JoinColumn( name="projeto_id"),
        inverseJoinColumns = @JoinColumn( name="equipe_id")
    )
	private List<Equipe> equipes;

	@ManyToMany
    @JoinTable(
        name="PROJETO_PARCEIRO",
        joinColumns = @JoinColumn( name="projeto_id"),
        inverseJoinColumns = @JoinColumn( name="parceiro_id")
    )
	private List<Parceiro> parceiros;
}
