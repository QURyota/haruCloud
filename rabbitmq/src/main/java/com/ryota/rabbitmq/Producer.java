package com.ryota.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Ryota
 * @description 生产者 发消息
 * @date 2022/8/18 23:04
 */
public class Producer {

    /**
     * 队列名称
     */
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //工厂ip 连接rabbitmq的队列
        factory.setHost("1.117.156.46");
        //用户名
        factory.setUsername("admin");
        //密码
        factory.setPassword("123");
        
        //创建连接
        Connection connection = factory.newConnection();
    }
    
}
