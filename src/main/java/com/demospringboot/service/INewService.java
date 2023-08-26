package com.demospringboot.service;

import com.demospringboot.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO);
	void delete(long[] ids);
}
