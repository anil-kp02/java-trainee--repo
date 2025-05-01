package com.watsoo.tms.dao;

import java.util.List;

import com.watsoo.tms.entity.ModuleMapping;

public interface ModuleMappingDao {

	Long addMapping(ModuleMapping dtoToEntity);

	ModuleMapping updateMapping(ModuleMapping dtoToEntity);

	ModuleMapping findMappingById(Long id);
	
	List<ModuleMapping> findAllMappings();
	
	ModuleMapping deleteMapping(Long id);


	
}
