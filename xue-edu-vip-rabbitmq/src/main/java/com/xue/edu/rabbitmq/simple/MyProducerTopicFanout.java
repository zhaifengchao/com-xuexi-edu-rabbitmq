package com.xue.edu.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MyProducerTopicFanout {

	private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE_FANTOUT";
	
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.1");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("guest");
		factory.setVirtualHost("/");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		String mq = "Hello world, Rabbit MQ FANOUT";
		
		channel.basicPublish(EXCHANGE_NAME, "xuexi.best.fanout", null, mq.getBytes());
		channel.close();
		connection.close();
		

	}

}
