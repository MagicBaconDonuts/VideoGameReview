package com.VideoGameApp.Api.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
	@JsonProperty("name")
	private String name;
	@JsonProperty("background_image")
	private String background_image;// add images in the future
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBackground_image() {
		return background_image;
	}
	public void setBackground_image(String background_image) {
		this.background_image = background_image;
	}
	
	
}
