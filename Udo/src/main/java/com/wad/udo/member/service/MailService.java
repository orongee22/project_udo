package com.wad.udo.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {

	@Autowired
	private JavaMailSender sender;

	public void send(String id, String email, String name, String code) {

		MimeMessage message = sender.createMimeMessage();

		try {
			message.setSubject("[안내] 회원가입 처리를 위해 인증이 필요합니다.", "UTF-8");
			String htmlMsg = "<h1>인증이 필요합니다..</h1>";

			htmlMsg += "<h3>인증을 위해 아래 링크를 클릭해주세요.</h3>";
			htmlMsg += "<h5><a href = \"http://ec2-54-180-121-110.ap-northeast-2.compute.amazonaws.com:8080/udo/member/verify?id=" + id + "&code=" + code
					+ "\">인증하기</a></h5>";

			/*
			 * htmlMsg +=
			 * "<h5><a href = \"http://ec2-54-180-121-110.ap-northeast-2.compute.amazonaws.com:8080/mm/member/verify?id="
			 * + email + "&code=" + code + "\">인증하기 (아마존 서버)</a></h5>";
			 */
			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("udo@gmail.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(email, name, "UTF-8"));

			sender.send(message);

		} catch (MessagingException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendId(String id, String email, String name) {

		MimeMessage message = sender.createMimeMessage();

		try {
			message.setSubject("[안내] " + name + "님께서 요청하신 아이디 정보입니다.", "UTF-8");
			String htmlMsg = "<h1>" + id + "</h1>";

			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("udo@gmail.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(email, name, "UTF-8"));

			sender.send(message);

		} catch (MessagingException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendPw(String id, String email, String name, String pw) {

		MimeMessage message = sender.createMimeMessage();

		try {
			message.setSubject("[안내] " + name + "님께서 요청하신 비밀번호 정보입니다.", "UTF-8");
			String htmlMsg = "<h1>" + pw + "</h1>";
			htmlMsg += "<h3>로그인 후 비밀번호를 반드시 변경해주세요.</h3>";

			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("udo@gmail.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(email, name, "UTF-8"));

			sender.send(message);

		} catch (MessagingException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
