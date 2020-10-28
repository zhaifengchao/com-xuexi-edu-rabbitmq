package com.xue.edu.rabbitmq.boot.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "SECOND_QUEUE")
public class SecondConsumer {
	
	@RabbitHandler
	public void process(String message) {
		System.out.println("second Queue recevied message:"+message);
	}

}
