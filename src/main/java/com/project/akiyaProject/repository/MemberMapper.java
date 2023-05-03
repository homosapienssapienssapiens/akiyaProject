package com.project.akiyaProject.repository;

import org.apache.ibatis.annotations.Mapper;

import com.project.akiyaProject.model.Member;

@Mapper
public interface MemberMapper {
	void saveMember(Member member);
}
