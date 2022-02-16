package com.pokemon.web.app.controllers;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


import com.pokemon.web.app.entity.Pokemon;
import com.pokemon.web.app.service.consumer.PokemonConsumer;


@Controller
@ResponseBody
public class PokemonController {
	@Autowired
	PokemonConsumer pokemonConsumer;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public List<Pokemon> listar(Model model,@PathVariable(required=false) Integer id) {
		System.out.println("hola");
		List<Pokemon> pokes = pokemonConsumer.findAll();
		return pokes;
	}
	@RequestMapping(value = {"/{idOrName}"}, method = RequestMethod.GET)
	public Pokemon getPokemon(Model model,@PathVariable() String idOrName) {
		Pokemon pokemon = pokemonConsumer.findOne(idOrName); 
		return pokemon;
	}
}