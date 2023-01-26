package com.VideoGameApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VideoGameApp.Domain.User;
import com.VideoGameApp.Domain.VideoGame;
import com.VideoGameApp.Repositories.VideoGameRepository;



@Service
public class VideoGameService {
	@Autowired
	private VideoGameRepository videoGameRepo;
//	@Autowired
//	private UserRepo userRepo;


	public void save(VideoGame game, User user) {
		game.setUser(user);
		videoGameRepo.save(game);
	}


	public VideoGame findByTitleAndUser(String title, User user) {
		return videoGameRepo.findByUserIdAndGameTitle(title, user);
	}


	public void save(VideoGame game) {
		videoGameRepo.save(game);
	}


	public Optional<VideoGame> findById(Long gameId) {
		return videoGameRepo.findById(gameId);
	}


	public void delete(VideoGame game) {
		videoGameRepo.delete(game);
	}


	public void createGamefromAPi(String title, User user) {
		VideoGame game = new VideoGame();
		game.setUser(user);
		game.setRating(0);
		game.setTitle(title);
		game.setDescription("");
		game.setCompleted(false);
		videoGameRepo.save(game);
	}

	
}
