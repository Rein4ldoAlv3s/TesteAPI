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

import com.senai.model.Revista;
import com.senai.repository.RevistaRepository;
import com.senai.service.RevistaService;

@RestController
@RequestMapping("/revistas")
public class RevistaResource {

	@Autowired
	private RevistaService revistaService;
	@Autowired
	private RevistaRepository revistaRepository;
	
	@GetMapping
	public ResponseEntity<List<Revista>> findAll(){
		List<Revista> revistas = revistaService.findAll();
		return ResponseEntity.ok().body(revistas);
	}
	
	@GetMapping("/{revistaId}")
	public ResponseEntity<Revista> find(@PathVariable("revistaId") Long id){
		Revista revista = revistaService.findById(id);
		return ResponseEntity.ok().body(revista);
	}
	
	@PostMapping
	public ResponseEntity<Revista> save(@RequestBody Revista revista){
		revistaService.save(revista);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{revistaId}")
	public ResponseEntity<Void> delete(@PathVariable("revistaId") Long revistaId){
		revistaService.delete(revistaId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{revistaId}")
	public ResponseEntity<Revista> update(@RequestBody Revista revista, @PathVariable("revistaId") Long revistaId){
		Optional<Revista> revistaAtual = revistaRepository.findById(revistaId);

		if (revistaAtual.isPresent()) {
			BeanUtils.copyProperties(revista, revistaAtual.get(), "id");
			
			Revista revistaSalva = revistaService.save(revistaAtual.get());
			return ResponseEntity.ok(revistaSalva);
		}
		else return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
