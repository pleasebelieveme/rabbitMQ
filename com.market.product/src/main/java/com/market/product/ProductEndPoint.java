package com.market.product;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// 사용자에게 요청을 받아 동작하지 않는 경우는 이름을 Controller대신 EndPoint로 사용
@Slf4j
@Component
public class ProductEndPoint {

	@Value("${spring.application.name}")
	private String appName;

	@RabbitListener(queues = "${message.queue.product}")
	public void receiveMessage(String orderId) {
		log.info("Received orderId : {}, appName : {}", orderId, appName);
	}
}
