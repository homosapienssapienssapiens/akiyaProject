package com.project.akiyaProject.model.Enum;

public enum CityEnum {
	TouKyou("도쿄","東京","東京"),
	Oosaka("오사카","大阪","大阪"),
	Nagoya("나고야","名古屋","名古屋"),
	Fukuoka("후쿠오카","福岡","福岡"),
	Sapporo("삿포로","札幌","札幌");
	
	private String cname_ko;
	private String cname_jp;
	private String cname_cn;
	
	private CityEnum(String cname_ko, String cname_jp, String cname_cn) {
		this.cname_ko = cname_ko;
		this.cname_jp = cname_jp;
		this.cname_cn = cname_cn;
	}
	
	public String getCityko() {
		return cname_ko;
	}
	public String getCityjp() {
		return cname_jp;
	}
	public String getCitycn() {
		return cname_cn;
	}
}
