package com.pokemon.web.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
	
	public Pokemon() {
	}

	public Pokemon(String name, List<String> images, String weight, List<String> abilities) {
		super();
		this.name = name;
		this.images = images;
		this.weight = weight;
		this.abilities = abilities;
	}


	private String name;
	private List<String> images;
	private String weight;
	private List<String> abilities;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public List<String> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<String> abilities) {
		this.abilities = abilities;
	}
	
	

}
