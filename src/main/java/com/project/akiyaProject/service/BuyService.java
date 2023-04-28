package com.project.akiyaProject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.akiyaProject.model.HouseInfo;
import com.project.akiyaProject.repository.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BuyService {

    private final BoardMapper boardMapper;
	
	public HouseInfo getHouseById(String house_id) {
		
		return boardMapper.getHouseById(house_id);

	}
}
