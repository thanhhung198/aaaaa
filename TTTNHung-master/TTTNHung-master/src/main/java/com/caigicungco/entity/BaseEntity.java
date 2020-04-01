package com.caigicungco.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "createdby")
	//@CreatedBy
	private String createdBy;
	
	@Column(name = "modifiedby")
	//@ModifiedBy
	private String modifiedBy;
	
	@Column(name = "createddate")
	//@CreatedDate
	private Date createdDate;
	
	@Column(name = "modifieddate")
	//@ModifiedDate
	private Date modifiedDate;



	public Long getId() {
		return id;
	}
	public void setId(Long id){this.id=id;}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
