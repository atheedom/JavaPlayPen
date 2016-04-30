package com.alextheedom.rabbitmq;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
/**
 * Created by atheedom on 21/11/15.
 */
public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws java.io.IOException, InterruptedException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        boolean TRUE = true;
        while(TRUE){
            Thread.sleep(1000);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }

        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
