package com.mybites.demo.controller.mqController;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 类 名: Consumer
 * 描 述: mq消费者
 * 作 者: zhuchenshu
 * 创 建: 2018/12/31 16:49
 * 邮 箱: zhuchenshu@foxmail.com
 */
@Component
public class Consumer {
    @JmsListener(destination = "my_msg")
    public void readMsg(String text) {
        System.out.println("接收到消息：" + text);
    }

    @JmsListener(destination = "my_map")
    public void readMap(Map map) {
        System.out.println(map);
    }
}
