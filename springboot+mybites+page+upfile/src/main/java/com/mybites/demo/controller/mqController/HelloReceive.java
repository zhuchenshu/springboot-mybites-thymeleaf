package com.mybites.demo.controller.mqController;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 类 名:
 * 描 述:
 * 作 者: zhuchenshu
 * 创 建: 2019/1/1 20:03
 * 邮 箱: zhuchenshu@foxmail.com
 */
@Component
public class HelloReceive {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
        this.amqpTemplate.convertAndSend("ctoedu.queue", msg);
        this.amqpTemplate.convertAndSend("exchange", "topic.massages","hello topic rabbit");
        this.amqpTemplate.convertAndSend("fanoutExchange", "", "广播广播");
    }

    @RabbitListener(queues = "ctoedu.queue")
    public void receiveQueue(String text) {
        System.out.println("接受到：" + text);
    }

    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:"+str);
    }
    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("messages:"+str);
    }

    @RabbitListener(queues="fanout.A")
    public void processA(String str1) {
        System.out.println("ReceiveA:"+str1);
    }
    @RabbitListener(queues="fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:"+str);
    }
    @RabbitListener(queues="fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC:"+str);
    }
}
