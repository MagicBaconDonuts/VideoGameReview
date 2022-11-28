package com.VideoGameApp.Domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.VideoGameApp.Domain.Enum.Status;

@Entity
public class User {
	private Long id;
	private String username;
	private String password;
	private List<VideoGame> videoGame = new ArrayList<>();
	private Status status;
	private Set<Authorities> authorities = new HashSet<>();
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(nullable = false, length = 100, unique = true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(mappedBy = "user")
	public List<VideoGame> getVideoGame() {
		return videoGame;
	}
	public void setVideoGame(List<VideoGame> videoGame) {
		this.videoGame = videoGame;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	public Set<Authorities> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	
}
