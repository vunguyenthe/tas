package com.trade.atoc.service;

import com.trade.atoc.activemq.config.SimpleCommunicationSystem;
import com.trade.atoc.message.base.BaseMessage;

public interface TASService {

	void fowardMessageToQueue(final SimpleCommunicationSystem communicationSystem, BaseMessage message);

}
