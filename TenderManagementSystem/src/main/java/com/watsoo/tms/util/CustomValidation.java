package com.watsoo.tms.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.watsoo.tms.dto.ModuleMappingDto;
import com.watsoo.tms.dto.ModuleMasterDto;
import com.watsoo.tms.response.Response;

@Component
public class CustomValidation {

	public Response validateModuleMappingDto(ModuleMappingDto dto) {
		
		List<String> errors = new ArrayList<>();
		
		if(dto.getModuleId() == null ) {
			errors.add(" Module Id Required");
		}
		if(dto.getSequence() == null) {
			errors.add("Sequence Required for the mapping");
		}
		if(!errors.isEmpty()) {
			return new Response(HttpStatus.BAD_REQUEST.value(), errors, " Errors ");
		}
		
		return new Response(HttpStatus.OK.value(), "", "validated");
		
	}

	public Response validateModuleMasterDto(ModuleMasterDto dto) {
		
		List<String> errors = new ArrayList<>();
		
		if(dto.getModuleName() == null || dto.getModuleName().isBlank())
			errors.add("Module Name Required");
		if(dto.getModuleAllias() == null || dto.getModuleAllias().isBlank())
			errors.add("Module Alias Required");
		
		if(!errors.isEmpty())
			return new Response(HttpStatus.BAD_REQUEST.value(),errors,"Errors");
		
		return new Response(HttpStatus.OK.value(), null, "Validated ");
	}

}
