package cn.kr.authrabbitmq;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqTest {

    private final static String QUEUE_NAME = "hello";

    public  static void main(String [] args) throws java.io.IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        String message = "Hello World!";

        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        channel.close();
        connection.close();
    }


    @Test
    public void recv() throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        Thread.sleep(1000);
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("recv >>>>"+ message);
                super.handleDelivery(consumerTag, envelope, properties, body);
            }
        };

        channel.basicConsume(QUEUE_NAME, consumer);
    }

}
