package com.senai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.model.Equipe;
import com.senai.model.Evento;
import com.senai.repository.EquipeRepository;

@Service
public class EquipeService {
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	
	public List<Equipe> findAll(){
		return equipeRepository.findAll();
	}
	
	public Equipe findById(Long id) {
		Optional<Equipe> obj = equipeRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Equipe save(Equipe equipe) {
		return equipeRepository.save(equipe);
	}
	
	public void delete(Long id) {
		equipeRepository.deleteById(id);
	}
}
