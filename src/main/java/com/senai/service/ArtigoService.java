package com.senai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.model.Artigo;
import com.senai.repository.ArtigoRepository;

@Service
public class ArtigoService {
	
	@Autowired
	private ArtigoRepository artigoRepository;
	
	
	public List<Artigo> findAll(){
		return artigoRepository.findAll();
	}
	
	public Artigo findById(Long id) {
		Optional<Artigo> obj = artigoRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Artigo save(Artigo artigo) {
		return artigoRepository.save(artigo);
	}
	
	public void delete(Long id) {
		artigoRepository.deleteById(id);
	}
}
