package com.teste.testeStarWars.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.testeStarWars.model.Planeta;



@Repository
public interface PlanetaRepository  extends JpaRepository <Planeta,Long>{
	
		public Optional<Planeta> findByNomeContainingIgnoreCase(String  nome);
		
}
