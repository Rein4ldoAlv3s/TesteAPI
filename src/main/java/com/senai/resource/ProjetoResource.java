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

import com.senai.model.Projeto;
import com.senai.repository.ProjetoRepository;
import com.senai.service.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoResource {

	@Autowired
	private ProjetoService projetoService;
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@GetMapping
	public ResponseEntity<List<Projeto>> findAll(){
		List<Projeto> projetos = projetoService.findAll();
		return ResponseEntity.ok().body(projetos);
	}
	
	@GetMapping("/{projetoId}")
	public ResponseEntity<Projeto> find(@PathVariable("projetoId") Long id){
		Projeto projeto = projetoService.findById(id);
		return ResponseEntity.ok().body(projeto);
	}
	
	@PostMapping
	public ResponseEntity<Projeto> save(@RequestBody Projeto projeto){
		projetoService.save(projeto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{projetoId}")
	public ResponseEntity<Void> delete(@PathVariable("projetoId") Long projetoId){
		projetoService.delete(projetoId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{projetoId}")
	public ResponseEntity<Projeto> update(@RequestBody Projeto projeto, @PathVariable("projetoId") Long projetoId){
		Optional<Projeto> projetoAtual = projetoRepository.findById(projetoId);

		if (projetoAtual.isPresent()) {
			BeanUtils.copyProperties(projeto, projetoAtual.get(), "id");
			
			Projeto projetoSalva = projetoService.save(projetoAtual.get());
			return ResponseEntity.ok(projetoSalva);
		}
		else return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
