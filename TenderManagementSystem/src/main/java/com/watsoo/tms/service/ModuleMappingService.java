package com.watsoo.tms.service;

import com.watsoo.tms.dto.ModuleMappingDto;
import com.watsoo.tms.response.Response;

public interface ModuleMappingService {

	Response addMapping(ModuleMappingDto dto);

	Response updateMapping(ModuleMappingDto mappingDto);

	Response getById(Long id);

	Response deleteMapping(Long id);

	Response findAllMapping();

}
