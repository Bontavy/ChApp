/*
 * Class for the challenge info
 * Has a constructor method that takes in these parameters and sets them to their corresponding data fields
 * Has get and set methods for each data field
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
	
	/**
	 * @param id
	 * @param category
	 * @param title
	 * @param description
	 * @param pictures
	 * @param privacy
	 * @param sponsored
	 * @param completed
	 * @param createdBy
	 * @param createdDate
	 */
	
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
	
	/**
	 * @param category
	 * @param title
	 * @param description
	 * @param pictures
	 * @param privacy
	 * @param sponsored
	 * @param completed
	 * @return
	 */
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
	
	/**
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return pictures
	 */
	public String getPictures() {
		return pictures;
	}

	/**
	 * @param pictures
	 */
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	/**
	 * @return privacy
	 */
	public String getPrivacy() {
		return privacy;
	}

	/**
	 * @param privacy
	 */
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	/**
	 * @return sponsored
	 */
	public boolean isSponsored() {
		return sponsored;
	}

	/**
	 * @param sponsored
	 */
	public void setSponsored(boolean sponsored) {
		this.sponsored = sponsored;
	}

	/**
	 * @return completed
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * @param completed
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	/**
	 * @return id
	 */
	public UUID getId() {
		return id;
	}
	
	/**
	 * @param id
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	
	/**
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * @return createdDate;
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	
	/**
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}