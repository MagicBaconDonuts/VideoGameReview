package com.VideoGameApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.VideoGameApp.Domain.User;
import com.VideoGameApp.Domain.VideoGame;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {

	@Query("select v from VideoGame v where title = :title AND user = :user")
	VideoGame findByUserIdAndGameTitle(String title, User user);
	
	@Query("select v from VideoGame v where title = :title")
	VideoGame findByTitle(String title);


}
