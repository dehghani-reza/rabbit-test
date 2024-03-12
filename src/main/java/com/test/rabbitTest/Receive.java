package com.test.rabbitTest;

import java.nio.charset.StandardCharsets;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Receive {

	public static void getMessageFromQue(RabbitMqQue que) {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(que.queName, false, false, false, null);
			channel.basicConsume(que.queName, true, deliverCallback, consumerTag -> {
			});
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	static DeliverCallback deliverCallback = (consumerTag, delivery) -> {
		String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
		System.out.printf("read message from rabbit and it is: %1$s %n", message);
	};
}
