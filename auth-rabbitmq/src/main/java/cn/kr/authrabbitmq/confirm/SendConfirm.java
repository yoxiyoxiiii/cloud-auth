package cn.kr.authrabbitmq.confirm;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者 消息确认机制
 * 已经在 transaction 事务模式的 channel 是不能再设置成 confirm 模式的，即这两种模式是不能共存的。
 */
public class SendConfirm {

    private static final String QUEUE_NAME = "QUEUE_simple_confirm";
    @Test
    public void sendMsg() throws IOException, TimeoutException, InterruptedException {
        /* 获取一个连接 */
        Connection connection = ConnectUtil.connection();
        /* 从连接中创建通道 */
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //生产者通过调用channel的confirmSelect方法将channel设置为confirm模式
        channel.confirmSelect();
        String msg = "Hello QUEUE !";

        channel.basicPublish("", QUEUE_NAME, null,msg.getBytes());

        //消息成功投递到 mq 服务器后 执行，这种方式是同步的，如果服务器很久不响应的话，会影响正常的业务流程。
        //可以采用异步 confirm 模式
        if(!channel.waitForConfirms()){
            System.out.println("send message failed.");
        }else{
            System.out.println(" send messgae ok ...");
        }
        channel.close();
        connection.close();
    }
}
