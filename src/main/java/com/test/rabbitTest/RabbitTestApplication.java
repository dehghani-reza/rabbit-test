package com.test.rabbitTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RabbitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitTestApplication.class, args);
		log.info("start messaging que");
		for (int i = 0; i < 100; i++) {
			Send.sendMessage("message at %1$s".formatted(LocalDateTime.now()), RabbitMqQue.DEFAULT_QUE);
		}
		Receive.getMessageFromQue(RabbitMqQue.DEFAULT_QUE);
	}

}
