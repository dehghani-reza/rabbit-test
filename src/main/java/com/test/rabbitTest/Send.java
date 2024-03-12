package com.test.rabbitTest;

import java.nio.charset.StandardCharsets;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Send {

	public static void sendMessage(String message, RabbitMqQue que) {
		log.trace("initializing sending message to que in rabbit");
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		//The connection abstracts the socket connection, and takes care of protocol version negotiation and authentication and so on for us
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			log.debug("after getting connection from {} and before creating channel", factory.getHost());
			log.trace("try to create if not exit que");
			channel.queueDeclare(que.queName, false, false, false, null);
			log.trace("try to publish message {} to que {}", message, que.queName);
			channel.basicPublish("", que.queName, null, message.getBytes(StandardCharsets.UTF_8));

			log.debug("message has been sent to rabbit with address {} and message {}", factory.getHost(), message);
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}
}
