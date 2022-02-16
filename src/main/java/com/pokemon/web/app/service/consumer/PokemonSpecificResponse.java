package com.pokemon.web.app.service.consumer;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonSpecificResponse {
	
	public PokemonSpecificResponse() {
	}
	
	private String name;
	private Sprites sprites;
	private String weight;
	private List<Abilities> abilities;
	//private Species species;
	private List<Move> moves;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sprites getSprites() {
		return sprites;
	}
	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}

	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public List<Abilities> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Abilities> abilities) {
		this.abilities = abilities;
	}
	
	/*public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}*/
	public List<Move> getMoves() {
		return moves;
	}
	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}


}
