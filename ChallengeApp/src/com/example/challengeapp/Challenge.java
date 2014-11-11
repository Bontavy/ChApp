package com.example.challengeapp;

public class Challenge {
	private String challengeName, challengeDescription, challengeCategory, challengePrivacy;
	
	public Challenge (String name, String description, String category, String privacy) {
		challengeName = name;
		challengeDescription = description;
		challengeCategory = category;
		challengePrivacy = privacy;
	}
	
	public String getName() {
		return challengeName;
	}
	
	public String getDescription() {
		return challengeDescription;
	}
	
	public String getCategory() {
		return challengeCategory;
	}
	
	public String getPrivacy() {
		return challengePrivacy;
	}
}
