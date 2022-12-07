package com.VideoGameApp.Api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.VideoGameApp.Api.Dto.RAWGVideoGamesResponse;

public class RAWGVideoAPI {

	public ResponseEntity<RAWGVideoGamesResponse> callRAWGVideoApi() {
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key", "6f0d4986dfmshdc21c4d44ae6b72p1d6e87jsn601bbd2604ba");
		headers.set("X-RapidAPI-Host", "rawg-video-games-database.p.rapidapi.com");
		HttpEntity request = new HttpEntity(headers);
		ResponseEntity<RAWGVideoGamesResponse> response = rt.exchange(
				"https://rawg-video-games-database.p.rapidapi.com/games?key=8f7683104ba4475f99acc3903ec302ea",
				HttpMethod.GET,
				request, RAWGVideoGamesResponse.class);
		System.out.println(response.getBody());
		return response;
	}
}
