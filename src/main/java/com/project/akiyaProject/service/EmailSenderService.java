package com.project.akiyaProject.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailSenderService {
	// @Autowired, @RequiredArgsConstructor 두개 모두 의존성 주입 어노테이션.
	// @Autowired는 필드, 메서드, 생성자 등에서 사용되어 해당 클래스의 인스턴스에 자동으로 의존성 주입.
	// @RequiredArgsConstructor는 final이나 @NonNull이 붙은 필드에만 생성자 주입.
	
	private final JavaMailSender mailSender;
	
	public void sendEmail(String toEmail,
							String subject,
							String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("akiyapro5@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		
		System.out.println("발송 성공");
	}
}
