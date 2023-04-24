package com.project.akiyaProject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.akiyaProject.model.HouseRegForm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RentService {
	
	public static HouseRegForm getHouseById(String house_id) {
		
		return null;
	}

}
