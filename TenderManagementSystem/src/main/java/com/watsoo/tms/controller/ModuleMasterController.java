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

import com.watsoo.tms.dto.ModuleMasterDto;
import com.watsoo.tms.response.Response;
import com.watsoo.tms.service.ModuleMasterService;
import com.watsoo.tms.util.CustomValidation;

@RestController
@RequestMapping("/master-module")
public class ModuleMasterController {
	
	@Autowired
	private ModuleMasterService masterService;
	@Autowired
	private CustomValidation customValidation;
	
	@PostMapping("/add")
	public ResponseEntity<?> addModule(@RequestBody ModuleMasterDto dto){
		
		if(dto != null) {
			Response validation = customValidation.validateModuleMasterDto(dto);
			if(validation.getStatus() == 400) {
				return ResponseEntity.ok().body(validation);
			}
			
			Response response= masterService.addModule(dto);
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.badRequest().body("cant be Added ");
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateModule(@RequestBody ModuleMasterDto dto){
		
		if(dto!= null && dto.getId() != null) {
			Response response= masterService.updateModule(dto);
			
			return ResponseEntity.ok().body(response);
			
		}
		
		return ResponseEntity.badRequest().body("cant Added, id required ");
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteModule(@RequestParam Long id){
		
		Response deleteModule = masterService.deleteModule(id);
		
		return ResponseEntity.ok().body(deleteModule);
	}
	
	@GetMapping("/by-id")
	public ResponseEntity<?> findById(@RequestParam Long id){
		
		if(id != null) {
			Response module = masterService.getById(id);
			return ResponseEntity.ok().body(module);
		}
		return ResponseEntity.ok().body(" Id Can't be null");
		
	}
	
	@GetMapping("/module-tree")
	public ResponseEntity<?> getModuleTree(){
		
		Response tree= masterService.getModuleTree();
		return ResponseEntity.ok().body(tree);
		
	}
	@GetMapping("/find/all")
	public ResponseEntity<?> getAllModules(){
		
		Response response = masterService.findAllModules();
		return ResponseEntity.ok().body(response);
		
	}
	

}
