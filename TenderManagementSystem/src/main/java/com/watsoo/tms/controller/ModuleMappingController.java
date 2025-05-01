package com.watsoo.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.watsoo.tms.dto.ModuleMappingDto;
import com.watsoo.tms.response.Response;
import com.watsoo.tms.service.ModuleMappingService;
import com.watsoo.tms.util.CustomValidation;

@RestController
@RequestMapping("/module-mapping")
public class ModuleMappingController {
	
	@Autowired
	private ModuleMappingService mappingService;
	@Autowired
	private CustomValidation customValidation;
	
	@PostMapping("/add")
	public ResponseEntity<?> addMapping(@RequestBody ModuleMappingDto dto){
		
		if(dto != null) {
			Response validation = customValidation.validateModuleMappingDto(dto);
			if(validation.getStatus() == 400) {
				return ResponseEntity.ok().body(validation);
			}
			Response response = mappingService.addMapping(dto);
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.badRequest().body("Insufficient Data");
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateMapping(@RequestBody ModuleMappingDto mappingDto){
		
		if(mappingDto != null && mappingDto.getId() != null) {
			Response response =mappingService.updateMapping(mappingDto);
			
			return ResponseEntity.ok().body(response);
			
		}
		return ResponseEntity.badRequest().body("Mapping must have it id And it cant be null");
		
	}
	
	@GetMapping("/find/by-id")
	public ResponseEntity<?> findById(@RequestParam Long id){
		
		if(id != null) {
			Response mapping = mappingService.getById(id);
			return ResponseEntity.ok().body(mapping);
		}
		
		return ResponseEntity.ok().body("Id can't be Null");
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteMapping(@RequestParam Long id){
		
		if(id != null) {
			Response response = mappingService.deleteMapping(id);
			return ResponseEntity.ok().body(response);
		}
		return ResponseEntity.ok().body("Id can't be Null");
		
	}
	
	@GetMapping("find/all")
	public ResponseEntity<?> findAll(){
		Response response = mappingService.findAllMapping();
		
		return ResponseEntity.ok().body(response);
		
	}
	
	

}
