package com.xue.edu.rabbitmq.boot.demo.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send() {

		amqpTemplate.convertAndSend("","MY_FIRST_QUEUE","-------- a direct msg");
		amqpTemplate.convertAndSend("TOPIC_EXCHANGE","SECOND_QUEUE.xuexi" , "-------- a topic msg");
		amqpTemplate.convertAndSend("FANOUT_EXCHANGE","THIRD_QUEUE" , "-------- a fanout msg");
	}

}
