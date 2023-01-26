package com.VideoGameApp.Api.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RAWGVideoGamesResponse {
	@JsonProperty("next")
	private String next;
	@JsonProperty("previous")
	private String previous;
	@JsonProperty("results")
	private List<Result> results;
	
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}

	
}
