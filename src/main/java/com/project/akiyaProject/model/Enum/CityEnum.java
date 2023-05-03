package com.project.akiyaProject.model.Enum;

public enum CityEnum {
	TouKyou("도쿄","東京","東京"),
	Oosaka("오사카","大阪","大阪"),
	Nagoya("나고야","名古屋","名古屋"),
	Fukuoka("후쿠오카","福岡","福岡"),
	Sapporo("삿포로","札幌","札幌");
	
	private String cname_ko;
	private String cname_jp;
	private String cname_zh;
	
	private CityEnum(String cname_ko, String cname_jp, String cname_zh) {
		this.cname_ko = cname_ko;
		this.cname_jp = cname_jp;
		this.cname_zh = cname_zh;
	}
	
	public String getCname_ko() {
		return cname_ko;
	}
	public String getCname_jp() {
		return cname_jp;
	}
	public String getCname_zh() {
		return cname_zh;
	}
}
