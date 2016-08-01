package com.trade.atoc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trade.atoc.activemq.config.SimpleCommunicationSystem;
import com.trade.atoc.message.base.BaseMessage;

@Service("tasService")
@Transactional
public class TASServiceImpl implements TASService {

	@Override
	public void fowardMessageToQueue(
			final SimpleCommunicationSystem communicationSystem,
			BaseMessage message) {
		try {
			communicationSystem.getMobileMessageQueue().offer(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
