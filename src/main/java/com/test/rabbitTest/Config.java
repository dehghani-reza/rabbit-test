package com.test.rabbitTest;

public class Config {

	private Config() {
	}
	//first create network in docker and set name of rabbit container in RABBIT_ADDRESS value
	public static final String RABBIT_ADDRESS = "rabbitmq";
}
