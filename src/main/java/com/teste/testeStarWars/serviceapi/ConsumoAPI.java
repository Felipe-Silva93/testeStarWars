package com.teste.testeStarWars.serviceapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.teste.testeStarWars.model.TesteApi;

@FeignClient(name= "planetaApi",url = "https://swapi.dev/api/planets/")
public interface ConsumoAPI {
	
	 @RequestMapping(method = RequestMethod.GET, value = "")
	TesteApi getPlanetasApi();

}
