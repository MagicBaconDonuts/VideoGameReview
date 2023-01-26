package com.VideoGameApp.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginConntroller {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}
