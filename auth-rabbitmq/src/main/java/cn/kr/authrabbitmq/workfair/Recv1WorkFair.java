package cn.kr.authrabbitmq.workfair;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv1WorkFair {

    public static void main(String[] args) throws IOException, TimeoutException {
        revc();
    }

    public static void revc() throws IOException, TimeoutException {
        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare("work_que_fair",false,false,false,null);

        //设置消费者 每次只 消费一条消息
        int  prefetchCount =1;
        channel.basicQos(prefetchCount);
        DefaultConsumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");
                System.out.println(" [1] Received '" + message + "'");
                try {
                    Thread.sleep(1*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //手动设置 回执消息
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };

        //关闭自动确认
        boolean autoAck = false;
        //监听队列
        channel.basicConsume("work_que_fair",autoAck,consumer);

    }
}
