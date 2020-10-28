package com.xue.edu.rabbitmq.boot.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "MY_FIRST_QUEUE")
public class FirstConsumer {

	@RabbitHandler
	public void process(String message) {
		System.out.println("first queue recevied msg:"+message);
	}
	
}
