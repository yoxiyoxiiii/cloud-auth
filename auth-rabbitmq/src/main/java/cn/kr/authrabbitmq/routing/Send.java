package cn.kr.authrabbitmq.routing;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 交换机的 路由模式
 *
 */
public class Send {


    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws IOException, TimeoutException {

        send();
    }

    public static void send() throws IOException, TimeoutException {

        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();

        //声明路由对列
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");

        // 消息内容
        String message = "id=1001的商品删除了";

        //将消息投递到指定的 routingkey
        channel.basicPublish(EXCHANGE_NAME, "delete", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();

    }
}
