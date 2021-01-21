package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Book 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int bookId;
	@NotEmpty(message = "Title is required")
	private String title;
	@NotEmpty(message = "First name is required")
	private String authorFirstName;
	@NotEmpty(message = "Last name is required")
	private String authorLastName;
    @NotEmpty(message = "Rating is required")
	private String rating;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", authorFirstName=" + authorFirstName
				+ ", authorLastName=" + authorLastName + ", rating=" + rating + "]";
	}
}
