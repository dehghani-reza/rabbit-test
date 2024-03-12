package com.test.rabbitTest;

public enum RabbitMqQue {
	DEFAULT_QUE("DEFAULT_QUE");

	public final String queName;

	private RabbitMqQue(String queName) {
		this.queName = queName;
	}
}
