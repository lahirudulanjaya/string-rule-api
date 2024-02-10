package com.beta.replyservice.response;

/**
 * Represents a message for the response of a reply.
 */
public class ReplyMessage {

	private final String data;

	public ReplyMessage(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}
}