package com.VideoGameApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.VideoGameApp.Domain.Authorities;
import com.VideoGameApp.Domain.User;
import com.VideoGameApp.Domain.UserDTO;
import com.VideoGameApp.Domain.VideoGame;
import com.VideoGameApp.Domain.Enum.Status;
import com.VideoGameApp.Repositories.AuthoritiesRepository;
import com.VideoGameApp.Repositories.UserRepoistory;



@Service
public class UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepoistory userRepo;
	@Autowired
	private AuthoritiesRepository authorRepo;
	@Autowired
	private VideoGameService videoGameService;

	public User createUser(UserDTO user) {
		User userCreating = new User();
		userCreating.setUsername(user.getUsername());
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		userCreating.setPassword(encryptedPassword);
		Status status = Status.OFFLINE;
		userCreating.setStatus(status);
		
		Authorities author = new Authorities();
		author.setUser(userCreating);
		author.setAuthority("ROLE_USER");
		userRepo.save(userCreating);
		authorRepo.save(author);
		return userCreating;
	}

	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public Optional<User> findbyId(Long userId) {
		return userRepo.findById(userId);
	}

	public void deleteByUser(User user) {
		for(VideoGame game: user.getVideoGame()) {
			videoGameService.delete(game);
		}
		userRepo.delete(user);
	}

	public void save(User userFound) {
		userRepo.save(userFound);
	}
}
