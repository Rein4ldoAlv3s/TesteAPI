package com.senai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.model.Revista;
import com.senai.model.Revista;
import com.senai.repository.RevistaRepository;

@Service
public class RevistaService {

	@Autowired
	private RevistaRepository revistaRepository;

	public List<Revista> findAll() {
		return revistaRepository.findAll();
	}

	public Revista findById(Long id) {
		Optional<Revista> obj = revistaRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Revista save(Revista revista) {
		return revistaRepository.save(revista);
	}
	
	public void delete(Long id) {
		revistaRepository.deleteById(id);
	}
	
	public Revista update(Revista revista, Long revistaId) {
		Optional<Revista> revistaAtual = revistaRepository.findById(revistaId);
		
		BeanUtils.copyProperties(revista, revistaAtual.get(), "id");
		
		return revista;
	}
}
