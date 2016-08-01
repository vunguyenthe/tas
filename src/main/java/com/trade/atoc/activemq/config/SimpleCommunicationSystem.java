package com.trade.atoc.activemq.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.trade.atoc.message.base.BaseMessage;
import com.trade.atoc.system.config.SystemConfiguration;

public class SimpleCommunicationSystem {

	private String messageSend;
	private static final Logger logger = LoggerFactory
			.getLogger(SimpleCommunicationSystem.class);
	private TopicMessageSubcriber listener = null;
	private static TopicMessagePublisher publisher = null;
	private DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
	private ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(SystemConfiguration.user, SystemConfiguration.password, SystemConfiguration.broker_url);

	private static final int SIZE_QUEUE = 10000;
	private BlockingQueue<String> atocMessageQueue = null;
	public static BlockingQueue<BaseMessage> mobileMessageQueue = null;
	JmsTemplate jmsTemplate = new JmsTemplate();

	public SimpleCommunicationSystem() throws JMSException {
		atocMessageQueue = new LinkedBlockingQueue<String>(SIZE_QUEUE);
		mobileMessageQueue = new LinkedBlockingQueue<BaseMessage>(
				SIZE_QUEUE);
		initialize();
		listener.setBlockingQueue(atocMessageQueue);

	}

	public void registerMessageListener(String destinationName) {
		if (listener == null) {
			listener = new TopicMessageSubcriber();
			container.setConnectionFactory(connectionFactory);
			Destination destination = new ActiveMQTopic(destinationName);
			container.setDestination(destination);
			container.setMessageListener(listener);
			container.afterPropertiesSet();
			container.start();
			System.out.println("registerMessageListener is ok -> "
					+ destinationName);
		}

	}

	public void registerPublisher(String destinationName) {
		if (publisher == null) {
			publisher = new TopicMessagePublisher();
			DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
			defaultMessageListenerContainer
					.setConnectionFactory(connectionFactory);
			Destination destination = new ActiveMQTopic(destinationName);
			defaultMessageListenerContainer.setDestination(destination);
			jmsTemplate.setConnectionFactory(connectionFactory);
			jmsTemplate.setDefaultDestination(destination);
			publisher.setJmsTemplate(jmsTemplate);
			System.out.println("registerPublisher is ok -> " + destinationName);
		}
	}

	public void initialize() throws JMSException {
		registerMessageListener(SystemConfiguration.atoc_tas);
		registerPublisher(SystemConfiguration.tas_atoc);
	}

	public String getReceivedAtocMessage() throws JMSException {

		String msg = null;
		try {
			System.out.println("Take a message from ATOC");
			msg = atocMessageQueue.take();
		} catch (InterruptedException e) {
			logger.error("Message receive failed : " + e.getMessage(), e);
		}
		return msg;
	}

	public void sendMessage(String message, String atocId) throws JMSException {

		this.getPublisher().sendMessages(message, atocId);
	}

	public void setMessageSend(String messageSend) {

		this.messageSend = messageSend;
	}

	public TopicMessagePublisher getPublisher() {

		return publisher;
	}
	public BlockingQueue<BaseMessage> getMobileMessageQueue(){
		return mobileMessageQueue;
	}
	public int getSizeAtocMessagesQueue() {

		return this.atocMessageQueue.size();
	}
	public int getSizeMobilesMessagesQueue() {

		return SimpleCommunicationSystem.mobileMessageQueue.size();
	}
	public BaseMessage getReceivedMobileMessage() throws JMSException {

		BaseMessage msg = null;
		try {
			System.out.println("Take a message from Mobile");
			msg = mobileMessageQueue.take();
		} catch (InterruptedException e) {
			logger.error("Message receive failed : " + e.getMessage(), e);
		}
		return msg;
	}
}
