package com.watsoo.tms.dto;

public class ModuleMappingDto {

	private Long id;

	private Long parentId;

	private Long moduleId;

	private Long sequence;

	public ModuleMappingDto(Long id, Long parentId, Long moduleId, Long sequence) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.moduleId = moduleId;
		this.sequence = sequence;
	}

	public ModuleMappingDto() {
		super();
		// TODO Auto-generated constructor stub
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
	
//	// dto to entity 
//	public ModuleMapping dtoToEntity() {
//		return new ModuleMapping(this.id != null ? this.id: null,this. parentId != null ?this.parentId: null, 
//				this. moduleId != null ? this.moduleId: null,this. sequence !=null? this.sequence : null);
//	}

}
