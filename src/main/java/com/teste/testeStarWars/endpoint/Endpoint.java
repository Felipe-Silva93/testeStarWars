package com.teste.testeStarWars.endpoint;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.testeStarWars.model.Planeta;
import com.teste.testeStarWars.model.PlanetaApiExterna;
import com.teste.testeStarWars.model.TesteApi;
import com.teste.testeStarWars.service.ServicePlaneta;
import com.teste.testeStarWars.serviceapi.ConsumoAPI;




@RestController
@RequestMapping("/planetas")
@CrossOrigin("*")
public class Endpoint {

	@Autowired
	private ServicePlaneta service;
	
	@Autowired
	private ConsumoAPI consumo;
	
	@GetMapping
	public ResponseEntity<PlanetaApiExterna[]>GetAllApi(){	
		TesteApi listaPlanetas = consumo.getPlanetasApi();
		return ResponseEntity.status(200).body(listaPlanetas.getResults());
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<Planeta>>GetAll(){		
		return service.listaDePlanetas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Planeta> GetById(@PathVariable Long id){
		return service.buscarPorId(id);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Planeta> GetByNome(@PathVariable String nome){
		return service.buscarPorNome(nome);
		
	}
	@PostMapping
	public ResponseEntity<Planeta> post(@ RequestBody Planeta planeta){
		return service.adicionarPlaneta(planeta);
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Planeta> delete(@PathVariable Long id) {
	 return service.deletarPlaneta(id);
	}
}
