package com.xue.edu.rabbitmq.boot.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "THIRD_QUEUE")
public class ThirdConsumer {

	@RabbitHandler
	public void process(String message) {
		System.out.println("third queue recevied message :"+message);
	}
}
