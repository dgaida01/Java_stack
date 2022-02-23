package com.gaida.bookclub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	//*********************************************************************
	//Member Variables
	//*********************************************************************
			
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotEmpty(message="is required!")
	    @Size(min=3, max=30, message="must be between 3 and 30 characters")
	    private String userName;
	    
	    @NotEmpty(message="is required!")
	    @Email(message="Please enter a valid email!")
	    private String email;
	    
	    @NotEmpty(message="is required!")
	    @Size(min=8, max=128, message="must be between 8 and 128 characters")
	    private String password;
	    
	    @Transient
	    @NotEmpty(message="is required!")
	    @Size(min=8, max=128, message="must be between 8 and 128 characters")
	    private String confirm;
	  
	
	    
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
		
    
	//*********************************************************************
	//Create Many to Many relationship between Book Owner (user) and Book placed on shelf
	//*********************************************************************
		
		@ManyToMany(fetch=FetchType.LAZY)
		@JoinTable(
				name="book_owners",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns  = @JoinColumn(name="book_id")
				)
		
		private List <Book> books; 
		
		
	//*********************************************************************
	// Constructors for Book
	//*********************************************************************
	    public User() {
	    }
	    
		public User(String userName,String email,String password, String confirm) {
			this.userName = userName;
			this.email = email;
			this.password = password;
			this.confirm = confirm;
		}
	
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
	  //Getters and Setters
	  //*********************************************************************
	
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public String getUserName() {
				return userName;
			}
			public void setUserName(String userName) {
				this.userName = userName;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public String getConfirm() {
				return confirm;
			}
			public void setConfirm(String confirm) {
				this.confirm = confirm;
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
			
			
    
}