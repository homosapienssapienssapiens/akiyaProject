package com.project.akiyaProject.model;

import java.util.List;

import lombok.Data;
@Data
public class Member {
	private String member_id;
	private String password;
	private String email;
	private String country;
	private String revised;
	private List<String> favorites;
}
