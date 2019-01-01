package com.mybites.demo;

import com.mybites.demo.controller.mqController.HelloReceive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类 名:
 * 描 述:
 * 作 者: zhuchenshu
 * 创 建: 2019/1/1 20:01
 * 邮 箱: zhuchenshu@foxmail.com
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRabbitMQ {

    @Autowired
    private HelloReceive amqpComponent;

    @Test
    public void send() {
        amqpComponent.send("hello world2");
    }
}