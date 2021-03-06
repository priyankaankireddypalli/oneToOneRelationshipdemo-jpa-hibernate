package com.priya.jpa.hibernate.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	
	private String rating;
	
	private String description;
	
	
	protected Review() {}
	//Constructor


	public Review(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}


	public Long getId() {
		return id;
	}



	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return String.format("Review [rating=%s, description=%s]", rating, description);
	}

	
}
