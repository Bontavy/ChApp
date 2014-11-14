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

import java.util.Calendar;
import java.util.UUID;
import java.util.Date;

public class Challenge {
	private UUID Id;
	private String category;
	private String title;
	private String description;
	private String pictures;	
	// Add picture handling functionality.
	// A picture must be resized and used as part of
	// the description for a challenge.
	private String privacy;
	private boolean sponsored;
	private boolean completed;
	private String CreatedBy;
	private Date CreatedDate;
	/*
	 * Constructor for Challenge
	 * 
	 * @param name for the name of the Challenge
	 * @param description for the description of the Challenge
	 * @param category for the category of the Challenge
	 * @param privacy for the privacy of the Challenge
	 */
	public Challenge (String name, String description, String category, String privacy, String username) {
		Id = UUID.randomUUID();
		challengeName = name;
		challengeDescription = description;
		challengeCategory = category;
		challengePrivacy = privacy;
		CreatedBy = username;
		CreatedDate = Calendar.getInstance().getTime();
	}
	
	public String getCreatedUser() {
		return CreatedBy;
	}
	
	public Date getCreatedDate() {
		return CreatedDate;
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
