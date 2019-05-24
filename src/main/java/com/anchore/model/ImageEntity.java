package com.anchore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="sys.anchore_demo")
public class ImageEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="digest",nullable = false)
	private String digest;
	@Column(name="tag", nullable = false)
	private String tag;
	@CreatedDate
	@Column(name="created_date",nullable = false)
	private String created_at;
	 
   public Long getId()  
    {  
        return id;  
    }  
   public void setId(Long id)  
	    {  
	        this.id = id;  
	    }  
	
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

}
