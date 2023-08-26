package com.demospringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demospringboot.converter.NewConverter;
import com.demospringboot.dto.NewDTO;
import com.demospringboot.entity.CategoryEntity;
import com.demospringboot.entity.NewEntity;
import com.demospringboot.repository.CategoryRepository;
import com.demospringboot.repository.NewRepository;
import com.demospringboot.service.INewService;

@Service
public class NewService implements INewService{

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private NewConverter newConverter;
	
	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId()!=null) {
			NewEntity oldNewEntity = newRepository.findOneById(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);
		}else {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for (long item : ids) {
			newRepository.deleteById(item);
		}
	}
}
