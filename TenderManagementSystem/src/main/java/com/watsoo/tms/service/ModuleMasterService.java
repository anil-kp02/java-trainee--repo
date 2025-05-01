package com.watsoo.tms.service;

import com.watsoo.tms.dto.ModuleMasterDto;
import com.watsoo.tms.response.Response;

public interface ModuleMasterService {

	Response addModule(ModuleMasterDto dto);

	Response updateModule(ModuleMasterDto dto);

	Response deleteModule(Long id);

	Response getById(Long id);

	Response getModuleTree();

	Response findAllModules();

}
