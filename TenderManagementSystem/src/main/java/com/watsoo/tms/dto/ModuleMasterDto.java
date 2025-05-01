package com.watsoo.tms.dto;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ModuleMasterDto {

	private Long id;

	private String moduleName;

	private String moduleAllias;

	private String redirectUrl;

	private byte[] logo;

	private Boolean isActive;

	private Boolean isParent;
	
	private Date createdOn;
	
	private Date updatedOn;
	
	private Long createdBy;

	private Long updatedBy;
	
	private Long Sequence;
	
	private List<ModuleMasterDto> child = new ArrayList<>();

	public ModuleMasterDto() {
		super();
		
	}

	public ModuleMasterDto(Long id, String moduleName, String moduleAllias, String redirectUrl, byte[] logo,
			Boolean isActive, Boolean isParent, Date createdOn, Date updatedOn, Long createdBy,
			Long updatedBy) {
		super();
		this.id = id;
		this.moduleName = moduleName;
		this.moduleAllias = moduleAllias;
		this.redirectUrl = redirectUrl;
		this.logo = logo;
		this.isActive = isActive;
		this.isParent = isParent;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleAllias() {
		return moduleAllias;
	}

	public void setModuleAllias(String moduleAllias) {
		this.moduleAllias = moduleAllias;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	public List<ModuleMasterDto> getChild() {
		
		if(child == null) {
			child = new ArrayList<>();
		}
		
		return child;
	}

	public void setChild(List<ModuleMasterDto> child) {
		this.child = child;
	}
	

	public Long getSequence() {
		return Sequence;
	}

	public void setSequence(Long sequence) {
		Sequence = sequence;
	}

//	//dto to entity
//	public ModuleMaster dtoToEntity() {
//		
//		return new ModuleMaster(this.id != null ?this.id:null,this.moduleName != null? this.moduleName: null,this.moduleAllias != null? this.moduleAllias:null,
//				this.redirectUrl != null ? this.redirectUrl : null,this. logo != null ? this.logo: null,this. isActive != null ? this.isActive : true,
//						this. isParent != null ? this.isParent:null, this. createdOn != null? this.createdOn:new Date(),this. updatedOn != null ? this.updatedOn : null,
//								this. createdBy != null ?this.createdBy:null,this. updatedBy != null ?this.updatedBy:null);
//	}

}
