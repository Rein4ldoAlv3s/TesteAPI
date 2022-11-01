package com.senai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.model.Projeto;
import com.senai.repository.ProjetoRepository;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	
	public List<Projeto> findAll(){
		return projetoRepository.findAll();
	}
	
	public Projeto findById(Long id) {
		Optional<Projeto> obj = projetoRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Projeto save(Projeto projeto) {
		return projetoRepository.save(projeto);
	}
	
	public void delete(Long id) {
		projetoRepository.deleteById(id);
	}
}
