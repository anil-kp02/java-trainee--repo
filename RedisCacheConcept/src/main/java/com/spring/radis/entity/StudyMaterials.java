package com.spring.radis.entity;

import java.util.Date;

import com.spring.radis.dto.StudyMaterialDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name ="study_materials")
public class StudyMaterials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String content;
	
	private Date addedDate;
	
	private Boolean isActive;

	public StudyMaterials() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudyMaterials(Long id,String title, String content, Date addedDate, Boolean isActive) {
		super();
		this.id=id;
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public StudyMaterialDto entityToDto() {
		return new StudyMaterialDto(this.id != null ?this.id:null, this.title != null?this.title:null,this. content != null ?this.content:null
				,this. addedDate != null ?this.addedDate:null, this.isActive != null?this.isActive:null);
	}
	
	
	
	

}
