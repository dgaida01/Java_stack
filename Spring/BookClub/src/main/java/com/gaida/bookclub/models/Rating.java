package com.gaida.bookclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ratings")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Min(value=1 , message = "rating must be at least 1")
	@Max(value=10, message ="rating cannot be greater than 10")
	private double score;
	
	//*********************************************************************
	//Database created and updated date time stamps
	//*********************************************************************
			
			@Column(updatable=false)
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    
		    private Date createdAt;
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date updatedAt;
			
    //*********************************************************************
	//Auto complete Date time stamps upon creation and update
	//*********************************************************************
		   @PrePersist
		    protected void onCreate(){
		        this.createdAt = new Date();
		    }
		    @PreUpdate
		    protected void onUpdate(){
		        this.updatedAt = new Date();
		    }

	//*********************************************************************
	//Create one to many relation ship between ratings and Owners and Books and Users
	//*********************************************************************
		    @ManyToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name="user_id")
		    private User owner;
		    
		    @ManyToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name="book_id")
		    private Book aBook;

		    public Rating () {};
			public Rating(double score,	User owner, Book aBook) {
				this.score = score;
				this.owner = owner;
				this.aBook = aBook;
			}
	
	//*********************************************************************
	//Getters and Setters
	//*********************************************************************
			public long getId() {
				return id;
			}
			public void setId(long id) {
				this.id = id;
			}
			public double getScore() {
				return score;
			}
			public void setScore(double score) {
				this.score = score;
			}
			public Date getCreatedAt() {
				return createdAt;
			}
			public void setCreatedAt(Date createdAt) {
				this.createdAt = createdAt;
			}
			public Date getUpdatedAt() {
				return updatedAt;
			}
			public void setUpdatedAt(Date updatedAt) {
				this.updatedAt = updatedAt;
			}
			public User getOwner() {
				return owner;
			}
			public void setOwner(User owner) {
				this.owner = owner;
			}
			public Book getaBook() {
				return aBook;
			}
			public void setaBook(Book aBook) {
				this.aBook = aBook;
			}


			    

	 
			    

}