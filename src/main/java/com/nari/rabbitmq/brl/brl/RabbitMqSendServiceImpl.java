package com.nari.rabbitmq.brl.brl;

import com.nari.rabbitmq.brl.RabbitMqSendService;
import com.nari.rabbitmq.brl.UserService;
import com.nari.wm.entity.Sc;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMqSendServiceImpl implements RabbitMqSendService, RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.queue.msg}")
    private String quequName;
    @Value("${rabbitmq.queue.user}")
    private String userQueueName;
    @Autowired
    private UserService userService;

    @Override
    public void sendMsg(String msg) {
        System.out.println("发送消息：  "+msg);
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(quequName,msg);
    }

    @Override
    public void sendSc() {
        List<Sc> allSc = userService.getAllSc();
        Sc sc = allSc.get(0);

        System.out.println("发送用户消息：  "+sc.toString());

        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(userQueueName,sc);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if(b){
            System.out.println("消费成功");
        }else{
            System.out.println("消费失败：  "+s);
        }
    }
}
