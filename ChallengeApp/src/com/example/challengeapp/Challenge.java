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
	
	/*
	 * Constructor for Challenge
	 * 
	 * @param title for the name of the Challenge
	 * @param description for the description of the Challenge
	 * @param category for the category of the Challenge
	 * @param privacy for the privacy of the Challenge
	 */
	public Challenge(String category, String title, String description,
			String pictures, String privacy, boolean sponsored,
			boolean completed) {
		super();
		this.category = category;
		this.title = title;
		this.description = description;
		this.pictures = pictures;
		this.privacy = privacy;
		this.sponsored = sponsored;
		this.completed = completed;
	}

	public Challenge modify(String category, String title, String description,
			String pictures, String privacy, boolean sponsored,
			boolean completed) {
		this.category = category;
		this.title = title;
		this.description = description;
		this.pictures = pictures;
		this.privacy = privacy;
		this.sponsored = sponsored;
		this.completed = completed;
		return this;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public boolean isSponsored() {
		return sponsored;
	}

	public void setSponsored(boolean sponsored) {
		this.sponsored = sponsored;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
