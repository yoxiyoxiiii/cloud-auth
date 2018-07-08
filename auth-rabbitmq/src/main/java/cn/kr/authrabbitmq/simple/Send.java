package cn.kr.authrabbitmq.simple;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单队列:
 * 耦合性高
 * 生产者，消费者 一一对应
 * 队列名变更，需要同时更该
 * 解决 方案 ： work queues 工作队列
 * 一个生产者 可以对应多个消费者
 * 消费者处理消息可能会花费很长时间，这是简单队列就会照成消息挤压。
 */

public class Send {

    private static final String QUEUE_NAME="QUEUE_simple";


    @Test
    public void sendMg() throws IOException, TimeoutException {

        //获取链接
        Connection connection = ConnectUtil.connection();
        //从连接中获取通道
        Channel channel = connection.createChannel();
        //创建对列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        String msg="Hello Simple QUEUE !";

        //发布消息
      channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        System.out.println("---------send ms :"+msg);
        channel.close();
        connection.close();
    }

//    public static void main(String[] args) throws IOException, TimeoutException {
//        sendMg();
//    }
}
