package com.example.challengeapp;

import java.util.*;

public class User {

	private String username;
	private String password;
	public List<Challenge> postedChallenges;
	public List<Challenge> acceptedChallenges;
	public List<String> friends;

	public User() {
		super();
		this.username = null;
		this.password = null;
	}
	
	public User(String username, String password){
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, List<Challenge> postedChallenges, List<Challenge> acceptedChallenges, List<String> friends){
		super();
		this.username = username;
		this.password = password;
		this.postedChallenges=postedChallenges;
		this.acceptedChallenges=acceptedChallenges;
		this.friends = friends;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Challenge> getPostedChallenges() {
		return postedChallenges;
	}

	public void setPostedChallenges(List<Challenge> postedChallenges) {
		this.postedChallenges = postedChallenges;
	}

	public List<Challenge> getAcceptedChallenges() {
		return acceptedChallenges;
	}

	public void setAcceptedChallenges(List<Challenge> acceptedChallenges) {
		this.acceptedChallenges = acceptedChallenges;
	}
	
	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	
	public User getUser(UUID id){
		return this;
	}

	
}
