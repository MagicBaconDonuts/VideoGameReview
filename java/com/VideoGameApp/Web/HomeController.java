package com.VideoGameApp.Web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.VideoGameApp.Domain.User;
import com.VideoGameApp.Service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String getHomePage(@AuthenticationPrincipal User user, ModelMap model) {
		List<User> allUsers = userService.findAll();
		model.put("users", allUsers);
		Optional<User> currentUser = userService.findbyId(user.getId());
		User cUser = currentUser.get();
		model.put("user", cUser);
		return "home";
	}
}
