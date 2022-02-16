package com.pokemon.web.app.service.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.pokemon.web.app.entity.Pokemon;
import com.pokemon.web.app.entity.PokemonListResponse;
import com.pokemon.web.app.entity.PokemonSpecificResponse;

@Service
public class PokemonConsumer {
	
	public List<Pokemon> findAll() {
		
		RestTemplate restTemplate = new RestTemplate();
		PokemonListResponse response = new PokemonListResponse();
		response = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon?offset=0&limit=1000", PokemonListResponse.class);
		List<Pokemon> pokes = new ArrayList<Pokemon>();
		pokes = response.getResults().stream().map(p -> findOne(p.getName())).collect(Collectors.toList());
		List<Pokemon> tmp = new ArrayList<Pokemon>();
		while (response.getNext() != null) {
			response = restTemplate.getForObject(response.getNext(), PokemonListResponse.class);
			tmp = response.getResults().stream().map(p -> findOne(p.getName())).collect(Collectors.toList());
			pokes = Stream.concat(pokes.stream(), tmp.stream()).collect(Collectors.toList());
		}
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
