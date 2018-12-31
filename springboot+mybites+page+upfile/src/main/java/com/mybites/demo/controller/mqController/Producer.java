package com.mybites.demo.controller.mqController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 类 名: Producer
 * 描 述: mq生产者
 * 作 者: zhuchenshu
 * 创 建: 2018/12/31 16:44
 * 邮 箱: zhuchenshu@foxmail.com
 */
@RestController
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/sendMessage")
    public void sendMessage(String msg) {
        jmsMessagingTemplate.convertAndSend("my_msg", msg);
    }

    @RequestMapping("/sendMap")
    public void sendMap() {
        Map map = new HashMap();
        map.put("name", "zhuchenshu");
        map.put("phone", "123123123");
        jmsMessagingTemplate.convertAndSend("my_map", map);
    }
}
