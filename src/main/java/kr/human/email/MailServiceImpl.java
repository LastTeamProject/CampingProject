package kr.human.email;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService{

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String toAddress, String subject, String content) {
		MailHandler mailHandler=null;
		try {
			mailHandler = new MailHandler(javaMailSender);
			mailHandler.setFrom("hyunwoungkim@naver.com", "힐링캠핑");
			mailHandler.setTo(toAddress); // 받는사람
			mailHandler.setSubject(subject + " 님 가입 축하드립니다. 인증 메일입니다."); // 제목
			mailHandler.setText("<h1>하하하하하 정말 갈까?</h1>"); // 내용
			mailHandler.send(); // 메일 보내기
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
