package cn.kr.authrabbitmq.ps;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv2 {

    private final static String EXCHANGE_NAME = "exchange_test";
    public static void main(String[] args) throws IOException, TimeoutException {
        revc();
    }

    public static void revc() throws IOException, TimeoutException {
        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare("Recv2",false,false,false,null);

        //声明交换机。并指定交换机的类型
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        //将队列绑定到交换机
        channel.queueBind("Recv2",EXCHANGE_NAME,"");

        //同一时间队列只将一条消息发送给消费者
        channel.basicQos(1);
        //消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("[1] Recv msg:" + msg);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("[2] done ");
                    // 手动回执
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }

            }

        };

        //消费者监听队列，关闭自动应答
        channel.basicConsume("Recv2",false,consumer);
    }
}
