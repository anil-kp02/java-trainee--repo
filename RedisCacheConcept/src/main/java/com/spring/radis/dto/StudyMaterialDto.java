package com.spring.radis.dto;

import java.util.Date;

import com.spring.radis.entity.StudyMaterials;

public class StudyMaterialDto {
	
	private Long id;
	
	private String title;

	private String content;

	private Date addedDate;

	private Boolean isActive;

	public StudyMaterialDto(Long id,String title, String content, Date addedDate, Boolean isActive) {
		super();
		this.id=id;
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
		this.isActive = isActive;
	}

	public StudyMaterialDto() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "StudyMaterialDto [title=" + title + ", content=" + content + ", addedDate=" + addedDate + ", isActive="
				+ isActive + "]";
	}
	
	public StudyMaterials dtoToEntity() {
		return new StudyMaterials(this.id != null ?this.id:null,this.title != null?this.title:null,this. content != null ?this.content:null
				,this. addedDate != null ?this.addedDate:null, this.isActive != null?this.isActive:null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
