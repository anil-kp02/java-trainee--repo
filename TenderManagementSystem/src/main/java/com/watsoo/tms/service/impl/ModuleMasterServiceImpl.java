package com.watsoo.tms.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.watsoo.tms.dao.ModuleMappingDao;
import com.watsoo.tms.dao.ModuleMasterDao;
import com.watsoo.tms.dto.ModuleMappingDto;
import com.watsoo.tms.dto.ModuleMasterDto;
import com.watsoo.tms.entity.ModuleMapping;
import com.watsoo.tms.entity.ModuleMaster;
import com.watsoo.tms.response.Response;
import com.watsoo.tms.service.ModuleMasterService;
import com.watsoo.tms.setter.EntitySetter;

@Service
public class ModuleMasterServiceImpl implements ModuleMasterService {

	@Autowired
	private ModuleMasterDao masterDao;
	@Autowired
	private ModuleMappingDao mappingDao;
	@Autowired
	private EntitySetter entitySetter;

	@Override
	public Response addModule(ModuleMasterDto dto) {
		try {
			
			ModuleMaster module = entitySetter.moduleMasterDtoToEntity(dto);
			module.setCreatedOn(new Date());
			
			Long id = masterDao.addModule(module);
			return new Response(HttpStatus.OK.value(), "Id of the Module :" +id, "Module Added");

		} catch (Exception e) {
			return new Response(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
		}
	}

	@Override
	public Response updateModule(ModuleMasterDto dto) {

		try {
			ModuleMaster moduleMaster = masterDao.findModuleById(dto.getId());

			if (moduleMaster != null) {

				dto.setUpdatedOn(new Date());
				
//				moduleMaster.setModuleName("jdehghd");
				
				  ModuleMaster tobeUpated = new ModuleMaster(dto.getId(), dto.getModuleName()
				  != null ? dto.getModuleName() : moduleMaster.getModuleName(),
				  dto.getModuleAllias() != null ? dto.getModuleAllias() :
				  moduleMaster.getModuleAllias(), dto.getRedirectUrl() != null ?
				  dto.getRedirectUrl() : moduleMaster.getRedirectUrl(), dto.getLogo() != null ?
				  dto.getLogo() : moduleMaster.getLogo(), dto.getIsActive() != null ?
				  dto.getIsActive() : moduleMaster.getIsActive(), dto.getIsParent() != null ?
				  dto.getIsParent() : moduleMaster.getIsParent(), moduleMaster.getCreatedOn(),
				  dto.getUpdatedOn(), dto.getCreatedBy() != null ? dto.getCreatedBy() :
				  moduleMaster.getCreatedBy(), dto.getUpdatedBy() != null ? dto.getUpdatedBy()
				  : moduleMaster.getUpdatedBy());
				 

				ModuleMaster module = masterDao.updateModule(tobeUpated);
				ModuleMasterDto moduleDto = entitySetter.moduleMasterEntityToDto(module);
				
				return new Response(HttpStatus.OK.value(), moduleDto, "Module Modified");
			}
			return new Response(HttpStatus.BAD_REQUEST.value(), null, " Provide Valid Module id!! ");

		} catch (Exception e) {
			return new Response(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
		}
	}

	@Override
	public Response deleteModule(Long id) {

		try {
			ModuleMaster module = masterDao.deleteModule(id);
			if (module != null) {
				ModuleMasterDto moduleDto= entitySetter.moduleMasterEntityToDto(module);
				return new Response(HttpStatus.OK.value(), moduleDto, "deleted Sucess fully");
			}
			return new Response(HttpStatus.BAD_REQUEST.value(), null, "No Module In this id ");

		} catch (Exception e) {

			return new Response(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
		}

	}

	@Override
	public Response getById(Long id) {

		try {
			ModuleMaster module = masterDao.findModuleById(id);


			if (module != null) {
				ModuleMasterDto moduleDto= entitySetter.moduleMasterEntityToDto(module);
				return new Response(HttpStatus.OK.value(), moduleDto, "Retrival SucessFull");
			}
			return new Response(HttpStatus.BAD_REQUEST.value(), null, "No module In this id ");

		} catch (Exception e) {
			return new Response(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
		}

	}

	@Override
	public Response getModuleTree() {

		try {

			// Mapping Hierarchy

			// get All active modules
			
			List<ModuleMaster> moduleList = masterDao.findAllModules();
			if (moduleList == null || moduleList.isEmpty()) {
				return new Response(HttpStatus.BAD_REQUEST.value(), null, "There is No Module Listed ");
				
			}
//			List<ModuleMasterDto> modules = masterDao.findAll().stream().filter(m -> m.getIsActive() == true)
//					.map(m -> entitySetter.moduleMasterEntityToDto(m)).collect(Collectors.toList());
			
			List<ModuleMasterDto> modules = moduleList.stream().filter(m -> m.getIsActive() == true)
					.map(m -> entitySetter.moduleMasterEntityToDto(m)).collect(Collectors.toList());
			
			// get All mappings
			List<ModuleMapping> mappingList= mappingDao.findAllMappings();
			if ( mappingList == null || mappingList.isEmpty()) {
				return new Response(HttpStatus.BAD_REQUEST.value(), null, "There is No Mapping till  Now  ");
			}
			
			List<ModuleMappingDto> mappings = mappingList.stream().filter(m -> m != null)
					.map(m -> entitySetter.moduleMappingEntityToDto(m)).collect(Collectors.toList());

		

			// Map all the module-mapping with its sequence
			Map<Long, ModuleMasterDto> validMap = new HashMap<>();
			for (ModuleMasterDto module : modules) {

				Long sequence = mappings.stream().filter(m -> m.getModuleId().equals(module.getId()))
						.map(ModuleMappingDto::getSequence).findFirst().orElse(1L);
				module.setSequence(sequence);
				validMap.put(module.getId(), module);
			}

			// Retrieve the Parent
			List<ModuleMasterDto> parent = new ArrayList<>();
			for (ModuleMappingDto mapping : mappings) {

				ModuleMasterDto current = validMap.get(mapping.getModuleId());
				if (mapping.getParentId() == null && mapping != null) {
					parent.add(current);
				} else {
					ModuleMasterDto parentDto = validMap.get(mapping.getParentId());
					if (parentDto != null) {
						parentDto.getChild().add(current);
					}
				}

			}

			// Sort the Root Module And its child module

//			for (ModuleMasterDto module : parent) {
//				if (module != null && module.getChild() != null) {
////					List<ModuleMasterDto> childModule = module.getChild();
////					if (childModule != null && !childModule.isEmpty())
////						childModule.sort(Comparator.comparing(ModuleMasterDto::getSequence));
//				List<ModuleMasterDto> sortedChild = module.getChild().stream().filter(m-> m != null)
//				.sorted(Comparator.comparing(ModuleMasterDto::getSequence))
//				.collect(Collectors.toList());
//				
//				module.setChild(sortedChild);
//				}
//			}
			/////// This is for One one Parent child relationship 
//			parent.sort(Comparator.comparing(ModuleMasterDto::getSequence));
			
			
			List<ModuleMasterDto> resultList = parent.stream().filter(p-> p != null)
			.collect(Collectors.toList());
			
			sortTree(resultList);

			return new Response(HttpStatus.OK.value(), resultList, "Module Hierarchy Retrived ");

		} catch (Exception e) {

			e.printStackTrace();		
			return new Response(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
		}

	}
	
	private void sortTree(List<ModuleMasterDto> modules) {
	    modules.sort(Comparator.comparingLong(ModuleMasterDto::getSequence));
	    for (ModuleMasterDto module : modules) {
	        if(module.getChild() !=null) {
	        	module.getChild().removeIf(Objects::isNull); // remove null values from the list
	        	sortTree(module.getChild()); //  recursively sort children
	        }
	        
	    }
	}

	@Override
	public Response findAllModules() {
		List<ModuleMaster> moduleMasters = masterDao.findAllModules();
		if( moduleMasters != null && !moduleMasters.isEmpty()) {
			
			List<ModuleMasterDto> moduleMasterDtos = moduleMasters.stream().filter(m-> m!= null)
					.map(entitySetter::moduleMasterEntityToDto)
					.collect(Collectors.toList());
			
			return new Response(HttpStatus.OK.value(), moduleMasterDtos, "Retrived");
		}
		return new Response(HttpStatus.OK.value(),Collections.EMPTY_LIST," Module List is Empty");
	}

}
