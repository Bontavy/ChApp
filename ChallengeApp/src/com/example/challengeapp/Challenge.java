/*
 * Class for the challenge info
 * Has a constructor method that takes in these parameters and sets them to their corresponding data fields
 * Has get methods for each data field
 * 
 */

package com.example.challengeapp;

import java.util.Calendar;
import java.util.UUID;
import java.util.Date;

public class Challenge {
	
	private UUID id;
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
	public Challenge(UUID is, String category, String title,
			String description, String privacy, 
			boolean sponsored, boolean completed, String createdBy) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.description = description;
		this.pictures = pictures;
		this.privacy = privacy;
		this.sponsored = sponsored;
		this.completed = completed;
		this.createdBy = createdBy;
	}
	
	public Challenge(UUID id, String category, String title,
			String description, String pictures, String privacy,
			boolean sponsored, boolean completed, String createdBy,
			Date createdDate) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.description = description;
		this.pictures = pictures;
		this.privacy = privacy;
		this.sponsored = sponsored;
		this.completed = completed;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
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
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}