package com.VideoGameApp.Security;

import org.springframework.security.core.userdetails.UserDetails;

import com.VideoGameApp.Domain.User;

public class CustomSecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = -7518119124789659551L;

	public CustomSecurityUser() {}
	
	public CustomSecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setPassword(user.getPassword());
		this.setUsername(user.getPassword());
		this.setStatus(user.getStatus());
		this.setVideoGame(user.getVideoGame());
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
