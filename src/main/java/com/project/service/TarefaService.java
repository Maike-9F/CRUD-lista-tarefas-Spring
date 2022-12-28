package com.project.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.TarefaRequestDTO;
import com.project.dto.TarefaResponseDTO;
import com.project.entity.Tarefa;
import com.project.exceptions.NotFoundObjException;
import com.project.repository.TarefaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	public TarefaResponseDTO salvar(TarefaRequestDTO request) {
		Tarefa tarefa = new ModelMapper().map(request, Tarefa.class);
		
		tarefa = tarefaRepository.save(tarefa);
		
		TarefaResponseDTO response = new ModelMapper().map(tarefa, TarefaResponseDTO.class);
		
		return response;
	}
	
	public TarefaResponseDTO buscarId(Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		
		if(tarefa.isEmpty()) {
			throw new NotFoundObjException("Não foi encontrada nenhuma tarefa com o id: "+id);
		}
		
		TarefaResponseDTO response = new ModelMapper().map(tarefa.get(), TarefaResponseDTO.class);
		return response;
	}
	
	public List<TarefaResponseDTO> buscarTudo(){
		List<Tarefa> tarefas = tarefaRepository.findAll();
		
		List<TarefaResponseDTO> response = tarefas.stream().map(tarefa -> new ModelMapper().map(tarefa, TarefaResponseDTO.class)).toList();
		
		return response;
	}
	
	public TarefaResponseDTO atualizar(Long id, TarefaRequestDTO request) {
		try {
			Tarefa tarefa = tarefaRepository.getReferenceById(id);
			
			new ModelMapper().map(request, tarefa);
			
			tarefa = tarefaRepository.save(tarefa);
			
			TarefaResponseDTO response = new ModelMapper().map(tarefa, TarefaResponseDTO.class);
			return response;
		
		} catch (EntityNotFoundException e) {
			throw new NotFoundObjException("não existe tarefa com o id: "+id);
		}
		
	}
	
	public void excluir(Long id) {
		if(tarefaRepository.existsById(id)) {
			tarefaRepository.deleteById(id);
		} else {
			throw new NotFoundObjException("não existe tarefa com o id: "+id);
		}
		
	}
	
	public List<TarefaResponseDTO> buscarTitulo(String titulo) {
		List<Tarefa> tarefas = tarefaRepository.findByTituloLike("%"+titulo+"%");
		
		List<TarefaResponseDTO> response = tarefas.stream().map(tarefa -> new ModelMapper().map(tarefa, TarefaResponseDTO.class)).toList();
		return response;
	}
	
	public List<TarefaResponseDTO> buscarDescricao(String descricao){
		List<Tarefa> tarefas = tarefaRepository.findByDescricaoLike("%"+descricao+"%");
		
		List<TarefaResponseDTO> response = tarefas.stream().map(tarefa -> new ModelMapper().map(tarefa, TarefaResponseDTO.class)).toList();
		return response;
	}
}
