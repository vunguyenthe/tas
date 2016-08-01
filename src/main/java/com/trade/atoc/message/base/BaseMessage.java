package com.trade.atoc.message.base;

import java.util.UUID;

import com.trade.atoc.annotation.JsonSerializeType;

@JsonSerializeType
public abstract class BaseMessage {
	protected UUID messageId;
	protected String deviceAlias;
	protected Long createdDate;
	protected String atocId;
	public UUID getMessageId() {
		return messageId;
	}

	public void setMessageId(UUID messageId) {
		this.messageId = messageId;
	}

	public String getDeviceAlias() {
		return deviceAlias;
	}

	public void setDeviceAlias(String deviceAlias) {
		this.deviceAlias = deviceAlias;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public String getAtocId() {
		return atocId;
	}

	public void setAtocId(String atocId) {
		this.atocId = atocId;
	}

	@Override
	public String toString() {
		return "BaseMessage [messageId=" + messageId + ", deviceAlias=" + deviceAlias + ", createdDate=" + createdDate
				+ ", atocId=" + atocId + "]";
	}


}