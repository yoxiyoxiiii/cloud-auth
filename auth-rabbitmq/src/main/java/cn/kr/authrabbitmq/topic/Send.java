package cn.kr.authrabbitmq.topic;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * topic 模型（路由的模糊匹配）
 * 接收者 声明 队列 并指定 routingKey
 * 发送者 将 消息投递到 交换机，并指定 routingKey
 * 交换机 将 消息投递 到 两者匹配的 routingKey
 * 匹配规则 ：
 *  # 一个或多个(所有)
 *  * 一个
 */
public class Send {


    private final static String EXCHANGE_NAME = "test_exchange_topic";

    @Test
    public void send() throws IOException, TimeoutException {
        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();

        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");

        String msg = "goods......";

        //发送goods.add 消费者1和消费者2都可以收到消息
        //发送goods.delete 消费者2收到消息
        //消息接收者 设置 的 routingKey 为 good.# 则 goods.delete 可以投递过去。
        String routingKey = "goods.delete";
        channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());

        System.out.println("Send msg"+msg);

        channel.close();
        connection.close();
    }
}
