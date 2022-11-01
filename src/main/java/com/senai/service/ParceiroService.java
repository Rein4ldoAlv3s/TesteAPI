package com.senai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.model.Parceiro;
import com.senai.repository.ParceiroRepository;

@Service
public class ParceiroService {

	@Autowired
	private ParceiroRepository parceiroRepository;
	
	public List<Parceiro> findAll(){
		return parceiroRepository.findAll();
	}
	
	public Parceiro findById(Long id) {
		Optional<Parceiro> obj = parceiroRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Parceiro save(Parceiro parceiro) {
		return parceiroRepository.save(parceiro);
	}
	
	public void delete(Long id) {
		parceiroRepository.deleteById(id);
	}
	
	public Parceiro update(Parceiro parceiro, Long parceiroId) {
		Optional<Parceiro> parceiroAtual = parceiroRepository.findById(parceiroId);
		
		BeanUtils.copyProperties(parceiro, parceiroAtual.get(), "id");
		
		return parceiro;
	}
	
}
