package com.pokemon.web.app.service.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.pokemon.web.app.entity.Pokemon;
import com.pokemon.web.app.entity.apiEntities.PokemonListResponse;
import com.pokemon.web.app.entity.apiEntities.PokemonSpecificResponse;

@Service
public class PokemonConsumer {
	
	public List<Pokemon> findAll() {
		
		RestTemplate restTemplate = new RestTemplate();
		PokemonListResponse response = new PokemonListResponse();
		response = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon?offset=0&limit=10", PokemonListResponse.class);
		List<Pokemon> pokes = new ArrayList<Pokemon>();
		for (Pokemon p : response.getResults()) {
			pokes.add(this.findOne(p.getName()));
		}
/*
		while (response.getNext() != null) {
			response = restTemplate.getForObject(response.getNext(), PokemonListResponse.class);
			for (Pokemon p : response.getResults()) {
				pokes.add(this.findOne(p.getName()));
			}
		}*/
		return pokes;
		//return (Pokemon[]) pokes;
	}
	public Pokemon findOne(String idOrName) {
		RestTemplate restTemplate = new RestTemplate();
		PokemonSpecificResponse response = new PokemonSpecificResponse();
		response = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+idOrName, PokemonSpecificResponse.class);
		List<String> abilities = response.getAbilities().stream().map(a -> a.getAbility().getName()).collect(Collectors.toList());
		
		Pokemon p = new Pokemon(response.getName(), response.getSprites().getImages() ,response.getWeight(), abilities);
		return p;
	}

}
