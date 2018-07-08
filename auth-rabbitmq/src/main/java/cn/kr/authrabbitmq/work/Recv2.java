package cn.kr.authrabbitmq.work;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        revc();
    }

    public static void revc() throws IOException, TimeoutException {
        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare("work_que",false,false,false,null);

        DefaultConsumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");
                System.out.println(" [2] Received '" + message + "'");
                try {
                    Thread.sleep(2*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //监听队列
        channel.basicConsume("work_que",true,consumer);

    }
}
