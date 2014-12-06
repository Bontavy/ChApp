/* This class is used to keep track of user info such as username, password, postedChallenges, acceptedChallenges, and friends
 *  Add UUID attribute to fields
 */
package com.example.challengeapp;

import java.util.*;

public class User {

	private String username;
	private String password;
	public List<Challenge> postedChallenges;
	public List<Challenge> acceptedChallenges;
	public List<String> friends;
	
	/**
	 * Constructor for no parameters
	 */
	public User() {
		super();
		this.username = null;
		this.password = null;
	}
	
	/**
	 * @param username
	 * @param password
	 * Constructor with username and password parameters
	 */
	public User(String username, String password){
		super();
		this.username = username;
		this.password = password;
	}
	
	/**
	 * @param username
	 * @param password
	 * @param postedChallenges
	 * @param acceptedChallenges
	 * @param friends
	 * Constructor with username, password, postedChallenges, acceptedChallenges, and friends parameters
	 */
	public User(String username, String password, List<Challenge> postedChallenges, List<Challenge> acceptedChallenges, List<String> friends){
		super();
		this.username = username;
		this.password = password;
		this.postedChallenges=postedChallenges;
		this.acceptedChallenges=acceptedChallenges;
		this.friends = friends;
	}
	
	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/*
	 * Sets username 
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return postedChallenges
	 */
	public List<Challenge> getPostedChallenges() {
		return postedChallenges;
	}

	/**
	 * @param postedChallenges
	 */
	public void setPostedChallenges(List<Challenge> postedChallenges) {
		this.postedChallenges = postedChallenges;
	}

	/*
	 * @return acceptedChallenges;
	 */
	public List<Challenge> getAcceptedChallenges() {
		return acceptedChallenges;
	}

	/*
	 * @param acceptedChallenges
	 * set acceptedChallenges
	 */
	public void setAcceptedChallenges(List<Challenge> acceptedChallenges) {
		this.acceptedChallenges = acceptedChallenges;
	}
	
	/*
	 * @return friends
	 */
	public List<String> getFriends() {
		return friends;
	}

	/**
	 * @param friends
	 */
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	
	/**
	 * @param id
	 * @return
	 */
	public User getUser(UUID id){
		return this;
	}

	
}
