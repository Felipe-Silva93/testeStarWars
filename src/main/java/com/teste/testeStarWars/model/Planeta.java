package com.teste.testeStarWars.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;




@Entity
@Table(name="tb_planetas") 
public class Planeta {
	
		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long id;

	    
	    @NotBlank(message="Nome não definido")
	    @Size(min=3, message="O nome deve ter pelo menos 3 caracteres")
	    private String nome;

	    @NotBlank(message="Clima não definido")
	    @Size(min=3, message="O clima deve ter pelo menos 3 caracteres")
	    private String clima;

	    @NotBlank(message="Terreno não definido")
	    @Size(min=3, message="O terreno deve ter pelo menos 3 caracteres")
	    private String terreno;
	    
	    private int aparicoes;


		public int getAparicoes() {
			return aparicoes;
		}

		public void setAparicoes(int aparicoes) {
			this.aparicoes = aparicoes;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getClima() {
			return clima;
		}

		public void setClima(String clima) {
			this.clima = clima;
		}

		public String getTerreno() {
			return terreno;
		}

		public void setTerreno(String terreno) {
			this.terreno = terreno;
		}

		
	    
	    

}
