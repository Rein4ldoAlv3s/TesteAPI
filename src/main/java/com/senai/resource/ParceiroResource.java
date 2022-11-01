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

import com.senai.model.Parceiro;
import com.senai.repository.ParceiroRepository;
import com.senai.model.Parceiro;
import com.senai.service.ParceiroService;

@RestController
@RequestMapping("/parceiros")
public class ParceiroResource {
	
	@Autowired
	private ParceiroService parceiroService;
	@Autowired
	private ParceiroRepository parceiroRepository;
	
	@GetMapping
	public ResponseEntity<List<Parceiro>> findAll(){
		List<Parceiro> parceiros = parceiroService.findAll();
		return ResponseEntity.ok().body(parceiros);
	}
	
	@GetMapping("/{parceiroId}")
	public ResponseEntity<Parceiro> find(@PathVariable("parceiroId") Long id){
		Parceiro parceiro = parceiroService.findById(id);
		return ResponseEntity.ok().body(parceiro);
	}
	
	@PostMapping
	public ResponseEntity<Parceiro> save(@RequestBody Parceiro parceiro){
		parceiroService.save(parceiro);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{parceiroId}")
	public ResponseEntity<Void> delete(@PathVariable("parceiroId") Long parceiroId){
		parceiroService.delete(parceiroId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{parceiroId}")
	public ResponseEntity<Parceiro> update(@RequestBody Parceiro parceiro, @PathVariable("parceiroId") Long parceiroId){
		Optional<Parceiro> parceiroAtual = parceiroRepository.findById(parceiroId);

		if (parceiroAtual.isPresent()) {
			BeanUtils.copyProperties(parceiro, parceiroAtual.get(), "id");
			
			Parceiro parceiroSalva = parceiroService.save(parceiroAtual.get());
			return ResponseEntity.ok(parceiroSalva);
		}
		else return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
