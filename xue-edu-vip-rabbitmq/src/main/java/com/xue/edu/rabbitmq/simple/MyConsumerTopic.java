package com.xue.edu.rabbitmq.simple;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.Basic.Consume;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class MyConsumerTopic {
	
	private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE_TOPIC";
    private final static String QUEUE_NAME = "SIMPLE_QUEUE_TOPIC";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();

		// MQ的连接地址
		factory.setHost("127.0.0.1");
		
		// MQ的端口
		factory.setPort(5672);
		
		// MQ的虚拟机
		factory.setVirtualHost("/");
		
		// MQ的用户
		factory.setUsername("guest");
		factory.setPassword("guest");
		
		Connection conn = factory.newConnection();
		Channel channel = conn.createChannel();
	//	channel.exchangeDeclare(EXCHANGE_NAME, "direct", false , false , null);
		channel.exchangeDeclare(EXCHANGE_NAME, "topic", false , false , null);
//		channel.exchangeDeclare(EXCHANGE_NAME, "direct", false , false , null);
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "xuexi.best.topic");
		Consumer consumer = new DefaultConsumer(channel) {

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String msg = new String(body, "UTF-8");
				System.out.println(msg);
			}
			
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);

	}

}
