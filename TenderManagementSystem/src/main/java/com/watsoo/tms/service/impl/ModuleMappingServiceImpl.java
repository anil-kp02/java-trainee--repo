package com.watsoo.tms.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.watsoo.tms.dao.ModuleMappingDao;
import com.watsoo.tms.dto.ModuleMappingDto;
import com.watsoo.tms.entity.ModuleMapping;
import com.watsoo.tms.response.Response;
import com.watsoo.tms.service.ModuleMappingService;
import com.watsoo.tms.setter.EntitySetter;

@Service
public class ModuleMappingServiceImpl implements ModuleMappingService {
	
	@Autowired
	private ModuleMappingDao mappingDao;
	@Autowired
	private EntitySetter entitySetter;

	@Override
	public Response addMapping(ModuleMappingDto dto) {
		try{
			ModuleMapping mapping = entitySetter.moduleMappingDtoToEntity(dto);
			Long id = mappingDao.addMapping(mapping);
			return new Response(HttpStatus.OK.value()," Id Of the Mapping :"+id,"Mapping Added ");
			
			
		}catch(Exception e) {
			return new Response(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
			
		}
		
	}

	@Override
	public Response updateMapping(ModuleMappingDto mappingDto) {
		
		try {
			ModuleMapping mapping = mappingDao.findMappingById(mappingDto.getId());
			
			if(mapping != null) {
				
				
				ModuleMapping toBeUpdated= new ModuleMapping(mappingDto.getId(),mappingDto.getParentId() != null ?mappingDto.getParentId(): mapping.getParentId()
						,mappingDto.getModuleId() != null?mappingDto.getModuleId():mapping.getModuleId()
						, mappingDto.getSequence() != null ?mappingDto.getSequence():mapping.getSequence());
				
				ModuleMapping updatedMapping= mappingDao.updateMapping(toBeUpdated);
				ModuleMappingDto updatedMappingDto = entitySetter.moduleMappingEntityToDto(updatedMapping);
				
				return new Response(HttpStatus.OK.value(), updatedMappingDto, "updated Sucessfully");
			}
			
			return new Response(HttpStatus.BAD_REQUEST.value(), null, "There is no Module-mapping in this id ");
			
			
		}catch(Exception e) {
			
			return new Response(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
			
		}
	}

	@Override
	public Response getById(Long id) {
		
		try {
			
			ModuleMapping mapping = mappingDao.findMappingById(id);
			
			if(mapping != null) {
				ModuleMappingDto mappingDto = entitySetter.moduleMappingEntityToDto(mapping);
				return new Response(HttpStatus.OK.value(), mappingDto,"Retrived sucessfully");
			}
			return new Response(HttpStatus.BAD_REQUEST.value(), null, "There is no Module-mapping in this id ");
			
			
		} catch (Exception e) {
			return new Response(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
		}
		
	}

	@Override
	public Response deleteMapping(Long id) {
		
		try {
			
			ModuleMapping mapping = mappingDao.findMappingById(id);
			if(mapping != null) {
				ModuleMapping deleteMapping = mappingDao.deleteMapping(id);
				return new Response(HttpStatus.OK.value(), deleteMapping, "Deleted sucessFully");
			}
			
			return new Response(HttpStatus.BAD_REQUEST.value(), null, "There is no Module-mapping in this id ");
			
		} catch (Exception e) {
			return new Response(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
		}
	}

	@Override
	public Response findAllMapping() {
		List<ModuleMapping> mappingList = mappingDao.findAllMappings();
		if(mappingList != null) {
			List<ModuleMappingDto> mappingDtos= mappingList.stream().filter(m-> m!= null).map(entitySetter::moduleMappingEntityToDto).collect(Collectors.toList());
			return new Response(HttpStatus.OK.value(), mappingDtos, "Retrived ");
			
		}
		
		return new Response(HttpStatus.OK.value(), Collections.EMPTY_LIST , " Mapping List Is Empty");
	}

}
