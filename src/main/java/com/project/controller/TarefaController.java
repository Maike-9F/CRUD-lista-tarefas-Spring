package com.project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.dto.TarefaRequestDTO;
import com.project.dto.TarefaResponseDTO;
import com.project.service.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;
	
	@PostMapping
	public ResponseEntity<TarefaResponseDTO> salvar(@RequestBody @Valid TarefaRequestDTO request){
		TarefaResponseDTO response = tarefaService.salvar(request);
		
		URI localtion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
		
		return ResponseEntity.created(localtion).body(response);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TarefaResponseDTO> buscarId(@PathVariable Long id){
		TarefaResponseDTO response = tarefaService.buscarId(id);
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<TarefaResponseDTO>> buscarTudo(){
		List<TarefaResponseDTO> response = tarefaService.buscarTudo();
		
		return ResponseEntity.ok().body(response);
	}
	
	@PatchMapping(value = "{id}")
	public ResponseEntity<TarefaResponseDTO> atualizar(@PathVariable Long id,@RequestBody @Valid TarefaRequestDTO request){
		TarefaResponseDTO response = tarefaService.atualizar(id, request);
		
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id){
		tarefaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/titulo/{titulo}")
	public ResponseEntity<List<TarefaResponseDTO>> buscarTitulo(@PathVariable String titulo){
		List<TarefaResponseDTO> response = tarefaService.buscarTitulo(titulo);
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value = "/descricao/{descricao}")
	public ResponseEntity<List<TarefaResponseDTO>> buscarDescricao(@PathVariable String descricao){
		List<TarefaResponseDTO> response = tarefaService.buscarDescricao(descricao);
		
		return ResponseEntity.ok().body(response);
	}
	
}
