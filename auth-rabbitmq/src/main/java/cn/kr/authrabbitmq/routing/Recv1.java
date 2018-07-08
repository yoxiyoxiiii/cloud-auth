package cn.kr.authrabbitmq.routing;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv1 {


    private final static String QUEUE_NAME = "test_queue_direct_1";
    private final static String EXCHANGE_NAME = "test_exchange_direct";
    public static void main(String[] args) throws IOException, TimeoutException {

        recv();
    }

    public static void recv() throws IOException, TimeoutException {
        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();


        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        // 绑定队列到交换机,并设置routingkey
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "update");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "delete");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);
        Consumer consumer = new DefaultConsumer(channel) {
            // 消息到达 触发这个方法
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("[2] Recv msg:" + msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("[2] done ");
                    // 手动回执
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);

    }
}
