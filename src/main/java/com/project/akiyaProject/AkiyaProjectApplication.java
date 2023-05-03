package com.project.akiyaProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.project.akiyaProject.service.EmailSenderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class AkiyaProjectApplication {

	private final EmailSenderService senderService;
	
	public static void main(String[] args) {
		SpringApplication.run(AkiyaProjectApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendEmail() {
//		senderService.sendEmail("dltkddnl0141@gmail.com", "부동산 매물 소개",
//				"매물 소개 입니다.");
//	}
}
