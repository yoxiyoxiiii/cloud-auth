package cn.kr.authrabbitmq.workfair;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 公平分发 能者多劳
 */
public class Send {

    @Test
    public void send() throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();

        //创建工作队列
        channel.queueDeclare("work_que_fair",false,false,false,null);

        //设置生产者在每次只 发送一条消息给消费者，在 消费者 没有处理完 当前消息时，不会分发消息给消费者。
        int  prefetchCount =1;
        channel.basicQos(prefetchCount);


        for (int i = 0;i<50; i++) {
            String msg = "hello work que" + i;
            //消息发布
            channel.basicPublish("","work_que_fair",null,msg.getBytes());
            System.out.println(" [x] Sent '" + msg + "'");

            Thread.sleep(i * 10);

        }

        channel.close();
        connection.close();
    }
}
