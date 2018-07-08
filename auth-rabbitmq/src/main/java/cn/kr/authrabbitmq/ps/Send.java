package cn.kr.authrabbitmq.ps;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 发布订阅
 * 生产者：将消息投递到 交换机
 * 交换机 ：交换机 将消息投递到 绑定到交换机的队列
 * 队列 ： 绑定到 交换机
 * 消费者：监听队列，消费消息
 *
 * 交换机类型：
 * 匿名："";
 * fanout :不处理路由键，routingKey 为空。也就是说只要和交换机绑定的队列都能收到消息
 */
public class Send {

    @Test
    public void send() throws IOException, TimeoutException {

        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();

        //声明交换机,并指定交换机的类型
        //fanout分发类型
        channel.exchangeDeclare("exchange_test","fanout");

        String msg = "hello exchange";

        //消息发送到交换机，由交换机发送至绑定的队列。不直接发送到队列。
        channel.basicPublish("exchange_test","",null,msg.getBytes());

        channel.close();
        connection.close();
    }
}
