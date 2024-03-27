package com.multi.chatting;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //webSocekt ���� ������ �۵��ȴ�
// implements WebSocketMessageBrokerConfigurer �ؾ� ��
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer  {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {

		//������: ws://localhost:9090/myapp(���ý�Ʈ)/chat => socketjs���� ������ �� ��� (sockjs ���� �ּ�)
		//���� �� ä��
		registry.addEndpoint("/chat")
		.withSockJS();//���� ���� ������������ ������ �� �ְ� �� �ش�
		
		//ê�� ������ ��������Ʈ ���� => ���߿�
		registry.addEndpoint("/chatbot")
		//queue ��� �� ���� ���� Ŭ���̾�Ʈ�� �ĺ��� HandshakeHandler ����
		.withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// �ش� �ּҸ� �����ϴ� ������ Ŭ���̾�Ʈ���� �޽����� �����Ѵ�
		registry.enableSimpleBroker("/topic","/queue");
		//Ŭ���̾�Ʈ�� ������ ���� �޽����� �޴� prefix(���λ�)
		registry.setApplicationDestinationPrefixes("/app");
		// /app/chat
	}

}
