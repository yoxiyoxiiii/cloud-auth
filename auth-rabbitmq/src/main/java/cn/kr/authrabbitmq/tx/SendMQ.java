package cn.kr.authrabbitmq.tx;


import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * mq 的事务机制：保证 生产者 产生的消息能 准确的 投递到 Rabbitmq 服务器
 * 所有的 mq 消费者和 生产者都无法通信，都只能靠 mq 服务器传递消息。
 * 也就是说 某条消息 是否被 消费者 成功消费 生产者是不知道的。
 * 即：生产者将消息投递给mq 服务器 ，服务器可以由回执信息；
 * 消息者 成功消费了 消息 有消息应答机制，
 * 将结果 返回给 mq服务器，服务器将成功消费的消息从内存中删除。
 *
 在 Rabbitmq 中我们可以通过持久化来解决因为服务器异常而导致丢失的问题,
 除此之外我们还会遇到一个问题:
 生产者将消息发送出去之后,消息到底有没有正确到达 Rabbit 服务器呢?
 如果不错
 得数处理,我们是不知道的,(即 Rabbit 服务器不会反馈任何消息给生产者),也就是默认的情况下是不知道消息有没有
 正确到达;
 *
 */
public class SendMQ {

    private static final String QUEUE_NAME = "QUEUE_simple";

    @Test
    public void sendMsg() throws IOException, TimeoutException {

        Connection connection = ConnectUtil.connection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String msg = "Hello Simple QUEUE222 !";

        try{
        //AMQP 协议下的事务管理
        //下面这句话等同于 开启事务，如果没有异常消息是肯定能够到达的。缺点：此种模式还是很耗时的,采用这种方式 降低了 Rabbitmq 的消息吞吐量
        channel.txSelect();

        //将消息投递给 mq 服务器
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());

        //异常，事务会回滚
        int i = 1/0;
        //提交事务
        channel.txCommit();
        }catch (Exception e) {
            //事务回滚，消息会投递失败
            channel.txRollback();
            System.out.println("----msg rollabck ");
        }finally {
            System.out.println("---------send msg over:" + msg);
        }

        channel.close();
        connection.close();
    }
}
