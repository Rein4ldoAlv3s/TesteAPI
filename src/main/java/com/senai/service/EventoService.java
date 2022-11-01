package com.senai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.model.Evento;
import com.senai.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	
	public List<Evento> findAll(){
		return eventoRepository.findAll();
	}
	
	public Evento findById(Long id) {
		Optional<Evento> obj = eventoRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Evento save(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	public void delete(Long id) {
		eventoRepository.deleteById(id);
	}
	
	public Evento update(Evento evento, Long eventoId) {
		Optional<Evento> eventoAtual = eventoRepository.findById(eventoId);
		
		BeanUtils.copyProperties(evento, eventoAtual.get(), "id");
		
		return evento;
	}
}
