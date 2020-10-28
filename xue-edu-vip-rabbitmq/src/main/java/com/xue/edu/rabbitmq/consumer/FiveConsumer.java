package com.xue.edu.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class FiveConsumer implements MessageListener {
	
	private Logger logger = LoggerFactory.getLogger(FiveConsumer.class);

	public void onMessage(Message message) {

		logger.info("this five consumer received message:"+message);

	}

}
