package com.example.model;

import java.sql.Date;

public class Document {

	private long id;
	private String name;
	private Date createdOn;

	public Document() {
	}
	
	public Document(String name, Date createdOn) {
		this.name = name;
		this.createdOn = createdOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
