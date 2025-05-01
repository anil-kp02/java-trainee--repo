package com.watsoo.tms.setter;

import org.springframework.stereotype.Component;

import com.watsoo.tms.dto.ModuleMappingDto;
import com.watsoo.tms.dto.ModuleMasterDto;
import com.watsoo.tms.entity.ModuleMapping;
import com.watsoo.tms.entity.ModuleMaster;

@Component
public class EntitySetter {
	
	public ModuleMapping moduleMappingDtoToEntity(ModuleMappingDto mappingDto) {
		
		if(mappingDto != null) {
			return new ModuleMapping(mappingDto.getId(), mappingDto.getParentId(), mappingDto.getModuleId(), mappingDto.getSequence());
		}
		return null;
		
	}
	
	public ModuleMappingDto moduleMappingEntityToDto(ModuleMapping mapping) {
		if(mapping != null) {
			return new ModuleMappingDto(mapping.getId(),mapping.getParentId(),mapping.getModuleId(),mapping.getSequence());
		}
		return null;
		
	}
	
	public ModuleMaster moduleMasterDtoToEntity(ModuleMasterDto moduleMasterDto) {
		if(moduleMasterDto != null) {
			return new ModuleMaster(moduleMasterDto.getId(),moduleMasterDto.getModuleName(),
					moduleMasterDto.getModuleAllias(),moduleMasterDto.getRedirectUrl(),moduleMasterDto.getLogo(),
					moduleMasterDto.getIsActive(),moduleMasterDto.getIsParent(),
					moduleMasterDto.getCreatedOn(),moduleMasterDto.getUpdatedOn()
					,moduleMasterDto.getCreatedBy(),moduleMasterDto.getUpdatedBy());
			
		}
		return null;
	}
	
	public ModuleMasterDto moduleMasterEntityToDto(ModuleMaster moduleMaster) {
		if(moduleMaster != null) {
			return new ModuleMasterDto(moduleMaster.getId(),moduleMaster.getModuleName(),
					moduleMaster.getModuleAllias(),moduleMaster.getRedirectUrl(),moduleMaster.getLogo(),
					moduleMaster.getIsActive(),moduleMaster.getIsParent(),
					moduleMaster.getCreatedOn(),moduleMaster.getUpdatedOn()
					,moduleMaster.getCreatedBy(),moduleMaster.getUpdatedBy());
		}
		return null;
	}

}