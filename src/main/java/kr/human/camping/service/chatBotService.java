package kr.human.camping.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import javax.websocket.Session;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class chatBotService {
	
	
	
	JSONObject chatbotobj = new JSONObject();
	
	// 초기 생성자 메서드 처음에만 실행된다.
	public JSONObject chatBotService() {
		log.info("chatBotService 생성자 메서드 실행!!!");
		chatbotobj.put("type", "message");
		chatbotobj.put("sessionId", "getId");
		chatbotobj.put("userName", "캠핑봇");
		chatbotobj.put("msg", "무엇을 도와드릴까요?");
		return chatbotobj;
	}
	
	
	// 챗봇 로직
	public void chatBot(JSONObject obj, WebSocketSession session) {
		log.info("chatBotService AI로직 실행!!!");
		String usermsg = obj.toString();
		System.out.println("user메시지 정보 : "+usermsg);
		WebSocketSession wss = session;
		try {
			wss.sendMessage(new TextMessage(usermsg));
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		String msg = (String)obj.get("msg");
		
		
		// 파일 읽기
		/*JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			Reader reader = new FileReader("C:\\CampingProject\\src\\main\\resources\\static\\brain.json");
			jsonObject = (JSONObject) parser.parse(reader);
		} catch (IOException | ParseException e1) {
			e1.printStackTrace();
		}
		
		String key = (String)jsonObject.get("로그인");
		*/
		if(msg.contains("로그인")) {
			chatbotobj.put("msg", "로그인 페이지는 <a href='local:8080/login'>로그인</a> 으로 접속해주세요.");
		} 
		
		
		
		try {
			TextMessage sendMsg = new TextMessage(chatbotobj.toJSONString());
			session.sendMessage(sendMsg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
