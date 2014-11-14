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
	private String createdBy;
	private Date createdDate;
	/*
	 * Constructor for Challenge
	 * 
	 * @param name for the name of the Challenge
	 * @param description for the description of the Challenge
	 * @param category for the category of the Challenge
	 * @param privacy for the privacy of the Challenge
	 */
	public Challenge modify(String category, String title, String description,
			String pictures, String privacy, String createdBy, boolean sponsored,
			boolean completed) {
		Id = UUID.randomUUID();
		this.category = category;
		this.title = title;
		this.description = description;
		this.pictures = pictures;
		this.privacy = privacy;
		this.sponsored = sponsored;
		this.completed = completed;
		this.createdBy = createdBy;
		this.createdDate = Calendar.getInstance().getTime();
		
		return this;
	}
	
	public String getCreatedUser() {
		return createdBy;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public String getName() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public String getPrivacy() {
		return this.privacy;
	}
}
