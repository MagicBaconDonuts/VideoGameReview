package com.VideoGameApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.VideoGameApp.Domain.User;

@Repository
public interface UserRepoistory extends JpaRepository<User, Long> {
	
	@Query("select u from User u"
			+ " left join fetch u.authorities"
			+ " where u.username = :username")
	User findByUsername(String username);
	
}
