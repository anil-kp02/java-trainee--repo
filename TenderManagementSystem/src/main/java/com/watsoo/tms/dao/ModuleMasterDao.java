package com.watsoo.tms.dao;

import java.util.List;

import com.watsoo.tms.entity.ModuleMaster;

public interface ModuleMasterDao {

	Long addModule(ModuleMaster module);

	ModuleMaster updateModule(ModuleMaster dtoToEntity);

	ModuleMaster deleteModule(Long id);

	ModuleMaster findModuleById(Long id);
	
	List<ModuleMaster> findAllModules();


}
