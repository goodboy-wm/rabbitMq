package com.nari.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Config {

    @Value("${rabbitmq.queue.msg}")
    private String queueName;
    @Value("${rabbitmq.queue.user}")
    private String userQueueName;

    @Bean
    public Queue createQueue(){
        return new Queue(queueName,true);
    }
    @Bean
    public Queue createUserQueue(){
        return new Queue(userQueueName,true);
    }

}
