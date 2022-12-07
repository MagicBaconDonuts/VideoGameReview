package com.VideoGameApp.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.VideoGameApp.Api.RAWGVideoAPI;
import com.VideoGameApp.Api.Dto.RAWGVideoGamesResponse;
import com.VideoGameApp.Domain.User;
import com.VideoGameApp.Domain.VideoGame;
import com.VideoGameApp.Service.UserService;
import com.VideoGameApp.Service.VideoGameService;

@Controller
public class APIController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VideoGameService videoGameService;

	@GetMapping("/get-games/{username}")
	public String getAListOfGamesFromApi(ModelMap model, @PathVariable String username) {
		RAWGVideoAPI api = new RAWGVideoAPI();
		ResponseEntity<RAWGVideoGamesResponse> response = api.callRAWGVideoApi();
		User user = userService.findByUsername(username);
		VideoGame game = new VideoGame();
		model.put("response", response);
		model.put("games", game);
		model.put("user", user);
		return "list-of-games";
	}
	
	@PostMapping("/get-game/{username}/{title}")//redirect to /view/{username}/{title}. SO i want to save the game first and then procede to redirect the user to toe the url
	public String createAGameFromApi(@PathVariable String username, @PathVariable String title) {
		User user = userService.findByUsername(username);
		videoGameService.createGamefromAPi(title, user);
		return "redirect:/home";
	}
}
