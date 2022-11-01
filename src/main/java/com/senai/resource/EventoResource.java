package com.senai.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.model.Evento;
import com.senai.repository.EventoRepository;
import com.senai.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoResource {

	@Autowired
	private EventoService eventoService;
	@Autowired
	private EventoRepository eventoRepository;
	
	@GetMapping
	public ResponseEntity<List<Evento>> findAll(){
		List<Evento> eventos = eventoService.findAll();
		return ResponseEntity.ok().body(eventos);
	}
	
	@GetMapping("/{eventoId}")
	public ResponseEntity<Evento> find(@PathVariable("eventoId") Long id){
		Evento evento = eventoService.findById(id);
		return ResponseEntity.ok().body(evento);
	}
	
	@PostMapping
	public ResponseEntity<Evento> save(@RequestBody Evento evento){
		eventoService.save(evento);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{eventoId}")
	public ResponseEntity<Void> delete(@PathVariable("eventoId") Long eventoId){
		eventoService.delete(eventoId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{eventoId}")
	public ResponseEntity<Evento> update(@RequestBody Evento evento, @PathVariable("eventoId") Long eventoId){
		Optional<Evento> eventoAtual = eventoRepository.findById(eventoId);

		if (eventoAtual.isPresent()) {
			BeanUtils.copyProperties(evento, eventoAtual.get(), "id");
			
			Evento eventoSalva = eventoService.save(eventoAtual.get());
			return ResponseEntity.ok(eventoSalva);
		}
		else return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
