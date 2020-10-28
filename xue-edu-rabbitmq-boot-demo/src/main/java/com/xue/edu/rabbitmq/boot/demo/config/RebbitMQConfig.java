package com.xue.edu.rabbitmq.boot.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RebbitMQConfig {
	
//	@Bean("DirectExchange")
//	public DirectExchange getDirectExchange() {
//		return new DirectExchange("DIRECT_EXCHANGE");
//	}
	
	@Bean("topicExchange")
	public TopicExchange getTopicExchange() {
		return new TopicExchange("TOPIC_EXCHANGE");
	}
	
	@Bean("fanoutExchange")
	public FanoutExchange getFanoutExchange() {
		return new FanoutExchange("FANOUT_EXCHANGE");
	}
	
//	@Bean("FirstQueue")
//	public Queue getFirstQueue() {
//		return new Queue("FIRST_QUEUE");
//	}
	
	@Bean("secondQueue")
	public Queue getSecondQueue() {
		return new Queue("SECOND_QUEUE");
	}
	
	@Bean("thirdQueue")
	public Queue getThirdQueue() {
		return new Queue("THIRD_QUEUE");
	}
	
//	@Bean
//	public Binding bindFirst(@Qualifier("FirstQueue") Queue queue, @Qualifier("DIRECT_EXCHANGE") DirectExchange exchange ) {
//		return BindingBuilder.bind(queue).to(exchange).with("xuexi.direct");
//	}
	
    @Bean
    public Binding bindSecond(@Qualifier("secondQueue") Queue queue,@Qualifier("topicExchange") TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("#.xuexi.#");
    }

    @Bean
    public Binding bindThird(@Qualifier("thirdQueue") Queue queue,@Qualifier("fanoutExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

}
