package com.gaida.bookclub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {

	//*********************************************************************
	//Member Variables
	//*********************************************************************
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	@Column(unique=true)
	@NotBlank (message="cannot be blank")
	@Size(min=3, message="must be at least 3 char long")
	private String title;
	
	@NotBlank (message="cannot be blank")
	@Size(min=3, message="must be at least 3 char long")
	private String author;
	
	@NotBlank (message="cannot be blank")
	private String comments;
	
	
	//*********************************************************************
	//Create Many to Many relationship between Book Owner (user) and Book placed on shelf
	//*********************************************************************
		
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="book_owners",
			joinColumns = @JoinColumn(name="book_id"),
			inverseJoinColumns  = @JoinColumn(name="user_id")
			)
	
	private List <User> owners; 
	
	@OneToMany(mappedBy="aBook",fetch=FetchType.LAZY)
	private List<Rating> bookRating;
	
	//*********************************************************************
	// Constructors for Book
	//*********************************************************************
		public Book() {}

		public Book(String title,String author,String comments) {
			super();
			this.title = title;
			this.author = author;
			this.comments = comments;
		}
	
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
//custom methods 
//*********************************************************************	    
	    
	    public double averageRating() {
	    	double sum=0;
	    	for(int i = 0 ; i<bookRating.size(); i++) {
	    		sum +=bookRating.get(i).getScore();
	    	}
	    	 double result = sum/bookRating.size();
	    	 return result;
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

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public List<User> getOwners() {
			return owners;
		}

		public void setOwners(List<User> owners) {
			this.owners = owners;
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

		public List<Rating> getBookRating() {
			return bookRating;
		}

		public void setBookRating(List<Rating> bookRating) {
			this.bookRating = bookRating;
		}

		
	
	

	
	    
	
	
	
	
	
}
