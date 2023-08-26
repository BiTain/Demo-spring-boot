package com.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demospringboot.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity,Long>{
	NewEntity findOneById(Long id);
}
