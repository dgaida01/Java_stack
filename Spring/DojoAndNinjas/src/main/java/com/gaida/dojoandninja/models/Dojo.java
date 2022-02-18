package com.gaida.dojoandninja.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
	
	//****************************************
	//Member Variables 
	//****************************************

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank (message="Dojo must have a name")
	private String name;
	
	
	//****************************************
	//Auto Generate Date time stamps
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
	// blank and loaded constructors 
	//****************************************
		
		public Dojo () {}
		
		public Dojo(String name) {			
			this.name = name;
		}
		//****************************************
		// create One to Many Relationship here
		//****************************************
		@OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
		private List<Ninja> ninjas;
		
		//****************************************
		//Generate getters and setters below
		//****************************************

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
		public List<Ninja> getNinjas() {
			return ninjas;
		}
		public void setNinjas(List<Ninja> ninjas) {
			this.ninjas = ninjas;
		}
		
		
		

}
