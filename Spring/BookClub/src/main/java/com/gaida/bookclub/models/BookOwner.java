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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="book_owners")
public class BookOwner {

	//*********************************************************************
	//Member Variables
	//*********************************************************************
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	
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
	//Create one to many relation ship between Book Owners and Books and Users
	//*********************************************************************
	
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User owner;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="book_id")
	    private Book aBook;

	    
	//*********************************************************************
	// Constructors for Join Table BOOK Owners
	//*********************************************************************
	    public BookOwner () {};
	    
	    
	    
    public BookOwner(User owner, Book aBook) {
			super();
			this.owner = owner;
			this.aBook = aBook;
		}
	//*********************************************************************
	//Getters and Setters
	//*********************************************************************
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
