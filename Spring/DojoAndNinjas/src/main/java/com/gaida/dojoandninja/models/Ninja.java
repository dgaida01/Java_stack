package com.gaida.dojoandninja.models;

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
@Table(name="ninjas")
public class Ninja {
	
	//******************************
	// Member Variables
	//******************************
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank (message="First Name is required")
	private String firstName;
	
	@NotBlank (message="Last Name is required")
	private String lastName;
	
	@Min(value=15, message="Student must be at least 15 years old")
	@Max(value=99, message="over 99 years old...maybe you should spend your time on having fun, but if you really want to join give us a call")
	private int age;
	//****************************************
	// Auto update and create Date Time stamps
	//****************************************
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	 @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	 @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	 
	
	//****************************************
	//establish many to one relationships
	//****************************************
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dojo_id")
	private Dojo dojo;

	//****************************************
	//Empty Constructor and Loaded Constructor
	//****************************************
	public Ninja() {}

	public Ninja( String firstName, String lastName, int age) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	//****************************************
	//generate below getters and setters for all
	//****************************************

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public Dojo getDojo() {
		return dojo;
	}
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	
	
	
	
	
	
}

	



