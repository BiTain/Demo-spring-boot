package com.demospringboot.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demospringboot.dto.NewDTO;
import com.demospringboot.entity.NewEntity;

@Component
public class NewConverter {
	
	@Autowired
	private ModelMapper modelMapper;

	public NewEntity toEntity(NewDTO dto) {
		return modelMapper.map(dto, NewEntity.class);
	}
	
	public NewDTO toDTO(NewEntity entity) {
		return modelMapper.map(entity, NewDTO.class);
	}
	
	public NewEntity toEntity(NewDTO dto,NewEntity entity) {
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		return entity;
	}
	
}
