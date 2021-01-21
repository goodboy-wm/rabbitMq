package com.nari.rabbitmq.brl;

import java.util.List;

public interface RabbitMqSendService {

    void sendMsg(String msg);

    void sendSc();

}
