package com.trade.atoc.activemq.config;

import java.util.concurrent.BlockingQueue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TopicMessageSubcriber implements MessageListener {
	
    private BlockingQueue<String> blockingQueue;

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
                String mesg = ((TextMessage) message).getText();
                blockingQueue.offer(mesg);
            } catch (JMSException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}


    public void setBlockingQueue(BlockingQueue<String> blockingQueue) {

        this.blockingQueue = blockingQueue;
    }

}
