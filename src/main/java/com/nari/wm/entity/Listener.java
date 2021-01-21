package com.nari.wm.entity;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @RabbitListener(queues = {"${rabbitmq.queue.msg}"})
    public void receiveMsg(String msg){
        System.out.println("接收消息:  "+msg);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.user}"})
    public void receiveScMsg(Sc sc){
        System.out.println("接受Sc消息：  "+sc.toString());
    }

}
