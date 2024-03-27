package com.multi.chatting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//챗봇에서 응답 메시지로 전송될 객체
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {

	
	
	public ResponseMessage(String from2, String text2, Object object, String time2) {
		// TODO Auto-generated constructor stub
	}
	private String from;
	private String text;
	private String menu;
	private String time;
	
	
}
