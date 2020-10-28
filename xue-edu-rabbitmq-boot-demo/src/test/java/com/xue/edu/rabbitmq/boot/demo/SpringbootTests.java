package com.xue.edu.rabbitmq.boot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xue.edu.rabbitmq.boot.demo.producer.Producer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTests {

	@Autowired
	Producer producer;

	@Test
	public void contextLoads() {
		producer.send();
	}

}
