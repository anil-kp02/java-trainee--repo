package com.watsoo.tms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="module_mapping")
public class ModuleMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="parent_id")
	private Long parentId;
	
	@Column(name="module_id")
	private Long moduleId;
	
	@Column(name="sequence")
	private Long sequence;

	public ModuleMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModuleMapping(Long id, Long parentId, Long moduleId, Long sequence) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.moduleId = moduleId;
		this.sequence = sequence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	
	// entity To dto
//	
//	public ModuleMappingDto entityToDto() {
//		
//		return new ModuleMappingDto(this.id != null ? this.id: null,this. parentId != null ?this.parentId: null, 
//				this. moduleId != null ? this.moduleId: null,this. sequence !=null? this.sequence : null);
//		
//	}
	
	

}
