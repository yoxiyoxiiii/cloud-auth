package cn.kr.authrabbitmq.work;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 工作队列 轮询分发，多个消费者 监听同一个队列
 * Recv1 ，Recv2 处理的消息个数相同。
 */
public class Send {

    @Test
    public void send() throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();

        //创建工作队列
        channel.queueDeclare("work_que",false,false,false,null);

        for (int i = 0;i<50; i++) {
            String msg = "hello work que" + i;
            //消息发布
            channel.basicPublish("","work_que",null,msg.getBytes());
            System.out.println(" [x] Sent '" + msg + "'");

            Thread.sleep(i * 10);

        }

        channel.close();
        connection.close();
    }
}
