package com.trade.atoc.util;
import javax.jms.JMSException;

import org.junit.Test;

import com.trade.atoc.activemq.config.SimpleCommunicationSystem;
public class SimpleCommunicationSystemTest {
	SimpleCommunicationSystem  communicationSystem = null;
	
	@Test
	public void sendMessage() throws JMSException{
		communicationSystem = new SimpleCommunicationSystem();
		communicationSystem.sendMessage("Hello ATOC1", "8C705A856AEC_Debug_rsi");
		System.out.println("Sent Hello ATOC1");
	}
	
}
