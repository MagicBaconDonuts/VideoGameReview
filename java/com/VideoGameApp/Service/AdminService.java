package com.VideoGameApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.VideoGameApp.Domain.User;
import com.VideoGameApp.Repositories.UserRepoistory;

@Service
public class AdminService {

	@Autowired
	private UserRepoistory userRepo;
	@Secured({"ROLE_ADMIN"})//future update
	public List<User> getAllUserAccounts () {
		return userRepo.findAll();
	}
}
