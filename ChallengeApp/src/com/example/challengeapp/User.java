package com.example.challengeapp;

import java.util.*;

public class User {

	private String username;
	private String password;
	private UUID id;
	public String [] postedChallenges;
	public String [] acceptedChallenges;
	public UUID [] friends;

	public User() {
		super();
		this.username = null;
		this.password = null;
	}
	
	public User(String username, String password, UUID id){
		super();
		this.username = username;
		this.password = password;
		this.id=id;
	}
	
	public User(String username, String password, UUID id, String [] postedChallenges, String [] acceptedChallenges){
		super();
		this.username = username;
		this.password = password;
		this.id=id;
		this.postedChallenges=postedChallenges;
		this.acceptedChallenges=acceptedChallenges;
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
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public String[] getPostedChallenges() {
		return postedChallenges;
	}

	public void setPostedChallenges(String[] postedChallenges) {
		this.postedChallenges = postedChallenges;
	}

	public String[] getAcceptedChallenges() {
		return acceptedChallenges;
	}

	public void setAcceptedChallenges(String[] acceptedChallenges) {
		this.acceptedChallenges = acceptedChallenges;
	}
	
	public UUID[] getFriends() {
		return friends;
	}

	public void setFriends(UUID[] friends) {
		this.friends = friends;
	}
	
	public User getUser(UUID id){
		return this;
	}

	
}
