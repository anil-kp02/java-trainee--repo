package com.watsoo.tms.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="module_master")
public class ModuleMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="module_name")
	private String moduleName;
	
	@Column(name="module_allias")
	private String moduleAllias;
	
	@Column(name="redirect_url")
	private String redirectUrl;
	
	@Column(name="logo")
	private byte[] logo;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@Column(name="is_parent")
	private Boolean isParent;
	
	@Column(name = "created_on")
	//@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="updated_on")
	//@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	
	@Column(name="created_by")
	private Long createdBy;
	
	@Column(name="updated_by")
	private Long updatedBy;

	
	

	public ModuleMaster(Long id, String moduleName, String moduleAllias, String redirectUrl, byte[] logo, Boolean isActive,
			Boolean isParent,Date createdOn, Date updatedOn, Long createdBy, Long updatedBy) {
		super();
		this.id=id;
		this.moduleName = moduleName;
		this.moduleAllias = moduleAllias;
		this.redirectUrl = redirectUrl;
		this.logo = logo;
		this.isActive = isActive;
		this.isParent = isParent;
		this.createdOn=createdOn;
		this.updatedOn=updatedOn;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public ModuleMaster() {
		super();
		
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

//	// entity to dto 
//	
//	public ModuleMasterDto entityToDto() {
//		
//		return new ModuleMasterDto(this.id != null ? this .id:null,this. moduleName != null ?this.moduleName:null,this. moduleAllias!=null ? this.moduleAllias : null,
//				this.redirectUrl != null ? this.redirectUrl : null,this. logo != null ? this.logo : null,this. isActive != null ? this.isActive :true,
//						this.isParent != null ?this.isParent : null, this. createdOn != null? this.createdOn:null,this. updatedOn != null ? this.updatedOn : null,
//								this.createdBy != null ? this.createdBy : null,this. updatedBy != null ? this.updatedBy :null);
//	}

}
