package com.spring.radis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.radis.dto.StudyMaterialDto;
import com.spring.radis.service.StudyMaterialService;

@RestController
@RequestMapping("/materials")
public class MaterialsController {
	
	@Autowired
	private StudyMaterialService materialService;
	
	@GetMapping("/get/by/id")
	public ResponseEntity<?> getById(@RequestParam Long id){
		
		StudyMaterialDto dto = materialService.getById(id);
		
		if(dto !=null) {
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Not Found",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/find/all")
	public ResponseEntity<?> findAll(){
		
		List<StudyMaterialDto> dtos= materialService.getAll();
		
		if(dtos !=null) {
			return new ResponseEntity<>(dtos,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Not Found",HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody StudyMaterialDto dto){
			materialService.addMaterials(dto);
		return new ResponseEntity<>("ok",HttpStatus.OK);
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> updateMaterial(@RequestBody StudyMaterialDto dto){
		
		StudyMaterialDto materialDto = materialService.updateMaterial(dto);
		
		if(materialDto !=null) {
			return new ResponseEntity<>(materialDto,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Not Found",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteMaterial(@RequestParam Long id ){
		
		materialService.deleteMaterial(id);
		
		return new ResponseEntity<>("ok",HttpStatus.OK);
	}

}
