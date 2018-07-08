package cn.kr.authrabbitmq.ps;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv1 {

    private final static String QUEUE_NAME = "test_queue_fanout_email";
    private final static String EXCHANGE_NAME = "exchange_test";

    public static void main(String[] args) throws IOException, TimeoutException {
        recv();
    }

    public static void recv() throws IOException, TimeoutException {
        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);


        //将队列绑定到 交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");

        //同一时间队列只将一条消息发送给消费者
        channel.basicQos(1);

        //创建消费者
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("[1] Recv msg:" + msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("[1] done ");
                    // 手动回执,告诉mq 服务器成功消费消息
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }

            }
        };

        //监听队列,关闭自动应答
        channel.basicConsume(QUEUE_NAME,false,consumer);
    }
}
