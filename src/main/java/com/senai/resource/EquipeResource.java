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

import com.senai.model.Equipe;
import com.senai.repository.EquipeRepository;
import com.senai.service.EquipeService;

@RestController
@RequestMapping("/equipes")
public class EquipeResource {

	@Autowired
	private EquipeService equipeService;
	@Autowired
	private EquipeRepository equipeRepository;
	
	@GetMapping
	public ResponseEntity<List<Equipe>> findAll(){
		List<Equipe> equipes = equipeService.findAll();
		return ResponseEntity.ok().body(equipes);
	}
	
	@GetMapping("/{equipeId}")
	public ResponseEntity<Equipe> find(@PathVariable("equipeId") Long id){
		Equipe equipe = equipeService.findById(id);
		return ResponseEntity.ok().body(equipe);
	}
	
	@PostMapping
	public ResponseEntity<Equipe> save(@RequestBody Equipe equipe){
		equipeService.save(equipe);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{equipeId}")
	public ResponseEntity<Void> delete(@PathVariable("equipeId") Long equipeId){
		equipeService.delete(equipeId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{equipeId}")
	public ResponseEntity<Equipe> update(@RequestBody Equipe equipe, @PathVariable("equipeId") Long equipeId){
		Optional<Equipe> equipeAtual = equipeRepository.findById(equipeId);

		if (equipeAtual.isPresent()) {
			BeanUtils.copyProperties(equipe, equipeAtual.get(), "id");
			
			Equipe equipeSalva = equipeService.save(equipeAtual.get());
			return ResponseEntity.ok(equipeSalva);
		}
		else return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
