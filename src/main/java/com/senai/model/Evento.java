package com.senai.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Evento {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String foto;
	private String titulo;
	private String resumo;
	@Column(name = "localidade")
	private String local;
	private Date data;
	private Date horario;
	
	
	@ElementCollection
	@CollectionTable(name="PALESTRANTE")
	private Set<String> palestrantes = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "evento")
	private List<Parceiro> parceiros;
}
