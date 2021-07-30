package com.teste.testeStarWars.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teste.testeStarWars.model.Planeta;
import com.teste.testeStarWars.model.PlanetaApiExterna;
import com.teste.testeStarWars.repository.PlanetaRepository;
import com.teste.testeStarWars.serviceapi.ConsumoAPI;


@Service
public class ServicePlaneta {

	@Autowired
	public PlanetaRepository repository;

	@Autowired
	public ConsumoAPI consumo;
	
	public ResponseEntity<List<Planeta>> listaDePlanetas() {
		List<Planeta> lista = repository.findAll();
		if (lista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(lista);
			
		}
	}

	public ResponseEntity<Planeta> buscarPorNome(String nome){
		Optional<Planeta> planetaExistente = repository.findByNomeContainingIgnoreCase(nome);
		return planetaExistente.map(resp->ResponseEntity.status(200).body(resp)).orElse(ResponseEntity.status(404).build());
	}
	
	public ResponseEntity<Planeta> buscarPorId(Long id){
		Optional<Planeta> planetaExistente = repository.findById(id);
		return planetaExistente.map(resp->ResponseEntity.status(200).body(resp)).orElse(ResponseEntity.status(404).build());
	}
	
	public ResponseEntity<Planeta> adicionarPlaneta(Planeta planetaNovo){
		
		Optional<Planeta> planetaExistente = repository.findByNomeContainingIgnoreCase(planetaNovo.getNome());
		
		if(planetaNovo.getNome().length()<3|| planetaNovo.getClima().length()<3 || planetaNovo.getTerreno().length()<3) {
			return ResponseEntity.status(404).build();
		}
		else if(planetaExistente.isPresent()) {
			 return ResponseEntity.status(302).build();
		}
		else {
			
			PlanetaApiExterna[] listaDePlanetas = consumo.getPlanetasApi().getResults();
			for(int i=0;i<listaDePlanetas.length;i++) {
				 if(listaDePlanetas[i].getName().compareToIgnoreCase(planetaNovo.getNome())==0) {
					 planetaNovo.setAparicoes(listaDePlanetas[i].getFilms().length);
					 break;
				 }
				 else {
					 planetaNovo.setAparicoes(0);
				 }
			}
			Optional.ofNullable(repository.save(planetaNovo));
			return ResponseEntity.status(201).body(planetaNovo);
		}
		
	}
	
	public ResponseEntity<Planeta> deletarPlaneta(Long id) {
		Optional<Planeta> planetaExistente = repository.findById(id);
		 if(planetaExistente.isPresent()) {
			 repository.deleteById(id);
			 return ResponseEntity.status(200).build();
		 }else {
			 return ResponseEntity.status(404).build();
		 }
		
	
	}
	
	
	
	
}
