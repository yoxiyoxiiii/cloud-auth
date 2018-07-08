package cn.kr.authrabbitmq.confirm;

import cn.kr.authrabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

/**
 * 异步 confirm 模式
 */
public class SendAync {

    private static final String QUEUE_NAME = "QUEUE_simple_confirm_aync";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectUtil.connection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //设置confirm 模式
        channel.confirmSelect();
        final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new
                TreeSet<Long>());


        //设置confirm 监听
        channel.addConfirmListener(new ConfirmListener() {

            //消息投递成功回调
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {

            }

            //RabbitMQ 因为自身内部错误导致消息丢失，
            // 就会发送一条 nack 消息，
            // 生产者应用程序同样可以在回调方法中处理该 nack 消息
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {

            }
        });


    }
}
