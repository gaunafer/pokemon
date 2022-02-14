package com.pokemon.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pokemon.web.app.entity.Pokemon;
import com.pokemon.web.app.entity.Response;

@Controller
@ResponseBody
public class PokemonController {
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public Pokemon[] listar(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		Response response = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon", Response.class);
		System.out.println(response.getResults());
		System.out.println(response.getNext());
		//Pokemon[] pokes = (Pokemon[]) response.getResults().toArray();
		Pokemon[] arr3 = response.getResults().stream().toArray(Pokemon[]::new);
		return arr3;
	}
}
