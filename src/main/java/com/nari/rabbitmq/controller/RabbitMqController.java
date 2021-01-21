package com.nari.rabbitmq.controller;

import com.nari.rabbitmq.brl.RabbitMqSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqController {
    @Autowired
    RabbitMqSendService rabbitMqSendService;

    @GetMapping(value = "/sendMsg")
    public void sendMsg(){
        rabbitMqSendService.sendMsg("我真棒");
    }

    @GetMapping(value = "/sendScMsg")
    public void sendScMsg(){
        rabbitMqSendService.sendSc();
    }

}
