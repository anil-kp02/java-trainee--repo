package com.spring.radis.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.radis.dto.StudyMaterialDto;
import com.spring.radis.entity.StudyMaterials;
import com.spring.radis.repository.StudyMaterialRepository;

@Service
public class StudyMaterialService {
	
	@Autowired
	private StudyMaterialRepository materialRepository;
	
	
	public List<StudyMaterialDto> getAll(){
		return materialRepository.findAll()
				.stream().map(m->m.entityToDto())
				.collect(Collectors.toList());
	}
	
	
	public void addMaterials(StudyMaterialDto materialDto) {
		materialRepository.save(materialDto.dtoToEntity());
	}
	
	
	@Cacheable(value="materials" ,key = "#id" )
	public StudyMaterialDto getById(Long id) {
		Optional<StudyMaterials> materials = materialRepository.findById(id);
		return materials.get().entityToDto();
	}
	
	
	@CachePut(value = "update",key="dto")
	public StudyMaterialDto updateMaterial(StudyMaterialDto dto) {
		
		Optional<StudyMaterials> materials = materialRepository.findById(dto.getId());
		
		materials.get().setTitle(dto.getTitle());
		materials.get().setContent(dto.getContent());
		materials.get().setAddedDate(dto.getAddedDate());
		materials.get().setIsActive(dto.getIsActive());
		
		return materialRepository.save(materials.get()).entityToDto();
	}
	
	@CacheEvict(value = "delete",key="#id")
	public void deleteMaterial(Long id) {
		
		StudyMaterials materials = materialRepository.findById(id)
				.orElseThrow( ()-> new RuntimeException("Materials Not Found in this id "));
		
		materialRepository.delete(materials);
		
	}

}
