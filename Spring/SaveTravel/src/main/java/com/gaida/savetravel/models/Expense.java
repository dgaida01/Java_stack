package com.gaida.savetravel.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expense")
public class Expense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	@NotNull
	@Size(min=3, max=40 , message="Expense name must be at 3-40 characters in lenght") 
	private String expenseName;
	
	@NotNull
	@Size(min=3, max=40 , message="Vendor name must be at 3-40 characters in lenght")
	private String vendor;
	
	@NotNull
	@Min(value=(long)1.0, message="Amount must be at least $1")
	private double amount;
	
	@NotNull
	@Size(min=4, message="Description must be at least 4 characters in lenght")
	private String description;
	
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
	
	 
	 
	public Expense() {
		
	}
	 
	

	public Expense(String expenseName,String vendor, double amount,String description) {
		this.expenseName = expenseName;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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