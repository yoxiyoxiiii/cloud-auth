package cn.kr.authrabbitmq.simple;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv {

    private static final String QUEUE_NAME = "QUEUE_simple";

    @Test
    public void recvold() throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();

        //消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(QUEUE_NAME,true,queueingConsumer);

        while (true) {

            //获取下一个消息到来的对象
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");

        }
    }

//    @Test
    public static void newRecv() throws IOException, TimeoutException {

        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            //处理消息
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {

                String msg = new String(body);
                System.out.printf("msg+==========="+msg);
            }
        };

        //监听队列
        channel.basicConsume(QUEUE_NAME,defaultConsumer);
        channel.close();
        connection.close();
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        newRecv();
    }

}
