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

import com.senai.model.Artigo;
import com.senai.repository.ArtigoRepository;
import com.senai.service.ArtigoService;

@RestController
@RequestMapping("/artigos")
public class ArtigoResource {

	@Autowired
	private ArtigoService artigoService;
	@Autowired
	private ArtigoRepository artigoRepository;
	
	@GetMapping
	public ResponseEntity<List<Artigo>> findAll(){
		List<Artigo> artigos = artigoService.findAll();
		return ResponseEntity.ok().body(artigos);
	}
	
	@GetMapping("/{artigoId}")
	public ResponseEntity<Artigo> find(@PathVariable("artigoId") Long id){
		Artigo artigo = artigoService.findById(id);
		return ResponseEntity.ok().body(artigo);
	}
	
	@PostMapping
	public ResponseEntity<Artigo> save(@RequestBody Artigo artigo){
		artigoService.save(artigo);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{artigoId}")
	public ResponseEntity<Void> delete(@PathVariable("artigoId") Long artigoId){
		artigoService.delete(artigoId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{artigoId}")
	public ResponseEntity<Artigo> update(@RequestBody Artigo artigo, @PathVariable("artigoId") Long artigoId){
		Optional<Artigo> artigoAtual = artigoRepository.findById(artigoId);

		if (artigoAtual.isPresent()) {
			BeanUtils.copyProperties(artigo, artigoAtual.get(), "id");
			
			Artigo artigoSalva = artigoService.save(artigoAtual.get());
			return ResponseEntity.ok(artigoSalva);
		}
		else return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
