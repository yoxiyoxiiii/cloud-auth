package cn.kr.authrabbitmq.tx;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {

    private static final String QUEUE_NAME = "QUEUE_simple";
    public static void main(String [] args) throws Exception {
        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            //获取到达的消息
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
       //监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
