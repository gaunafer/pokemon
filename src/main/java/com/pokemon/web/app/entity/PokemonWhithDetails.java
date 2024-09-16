package com.pokemon.web.app.entity;

import java.util.List;

public class PokemonWhithDetails extends Pokemon {
	
	private String description;
	private List<String> moves;
	
	public PokemonWhithDetails(String name, List<String> images, String weight, List<String> abilities,
			String description, List<String> moves) {
		super(name, images, weight, abilities);
		this.description = description;
		this.moves = moves;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getMoves() {
		return moves;
	}
	public void setMoves(List<String> moves) {
		this.moves = moves;
	}
	

}
