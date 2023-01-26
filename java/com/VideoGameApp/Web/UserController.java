package com.VideoGameApp.Web;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.VideoGameApp.Domain.User;
import com.VideoGameApp.Domain.UserDTO;
import com.VideoGameApp.Domain.VideoGame;
import com.VideoGameApp.Service.UserService;
import com.VideoGameApp.Service.VideoGameService;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private VideoGameService videoGameService;
	
	@GetMapping("/register")
	public String getRegisterPage(ModelMap model) {
		UserDTO user = new UserDTO();
		model.put("user", user);
		return "register";
	}
	
	@PostMapping("/register")
	public String saveUser(UserDTO user) {
		User userSave = new User();
		userSave.setUsername(user.getUsername());
		userSave.setPassword(user.getPassword());
		userService.createUser(user);
		return "redirect:/login";
	}
	
	@GetMapping("/Create/Videogame/{username}")
	public String getCreateGamePage(@PathVariable String username, ModelMap model) {
		VideoGame game = new VideoGame();
		User currentUser = userService.findByUsername(username);
		model.put("game", game);
		model.put("user", currentUser);
		return "register-videogame";
	}
	
	@PostMapping("/Create/Videogame/{username}")
	public String postGame(VideoGame game, @PathVariable String username) {
		User user = userService.findByUsername(username);
		videoGameService.save(game, user);
		return "redirect:/home";
	}
	
	@GetMapping("/View/{username}/{title}")
	public String viewGamePage(ModelMap model, @PathVariable String username, @PathVariable String title) {
		User user = userService.findByUsername(username);
		VideoGame game = videoGameService.findByTitleAndUser(title, user);
		model.put("game", game);
		return "/videogame";
	}
	
	@PostMapping("/update")
	public String updateGame(VideoGame game) {
		videoGameService.save(game);
		return"redirect:/home";
	}
	
	@PostMapping("/delete/videogame/{gameId}")
	public String deleteGame(@PathVariable Long gameId) {
		Optional<VideoGame> gameFound = videoGameService.findById(gameId);
		VideoGame game = gameFound.get();
		videoGameService.delete(game);
		return"redirect:/home";
	}

	@PostMapping("/delete/account/{username}")
	public String deleteAccount(@PathVariable String username, HttpServletRequest request, HttpServletResponse response) {
		User user = userService.findByUsername(username);
		userService.deleteByUser(user);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		return "redirect:/login?logout";
	}
	@PostMapping("/update-name/{username}")
	public String updateUsername(User user, @PathVariable String username) {
		User userFound = userService.findByUsername(username);
		userFound.setUsername(user.getUsername());
		userService.save(userFound);
		return "redirect:/home";
	}
	
//	@PostMapping("/users/exists")		future update
//	@ResponseBody
//	public Boolean checkExists(@RequestBody UserDTO user) {
//		User userCheck = new User();
//		userCheck.setUsername(user.getUsername());
//		userCheck = userService.findByUsername(user.getUsername());
//		return (userCheck != null);
//	}
}
