package com.mybites.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类 名:
 * 描 述:
 * 作 者: zhuchenshu
 * 创 建: 2018/12/31 19:30
 * 邮 箱: zhuchenshu@foxmail.com
 */
@Configuration
public class MqConfig {
    @Bean
    public Queue queue() {
        return new Queue("ctoedu.queue");
    }
}
