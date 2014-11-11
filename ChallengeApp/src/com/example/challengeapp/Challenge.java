/*
 * Class for the challenge info including name, description, category, and privacy
 * Has a constructor method that takes in these parameters and sets them to their corresponding data fields
 * Has get methods for each data field
 * 
 * @author: Bontavy Vorng
 * @version: v1
 * @since: v1
 * 
 */

package com.example.challengeapp;

public class Challenge {
	private String challengeName, challengeDescription, challengeCategory, challengePrivacy;
	
	/*
	 * Constructor for Challenge
	 * 
	 * @param name for the name of the Challenge
	 * @param description for the description of the Challenge
	 * @param category for the category of the Challenge
	 * @param privacy for the privacy of the Challenge
	 */
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
