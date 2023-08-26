package com.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demospringboot.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long>{
	CategoryEntity findOneByCode(String code);
}
