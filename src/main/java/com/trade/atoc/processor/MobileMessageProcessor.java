package com.trade.atoc.processor;

import javax.jms.JMSException;

import com.trade.atoc.activemq.config.SimpleCommunicationSystem;
import com.trade.atoc.json.JSONParser;
import com.trade.atoc.message.base.BaseMessage;

public class MobileMessageProcessor implements Runnable {

    private Thread thread;
    private String threadName;
    private SimpleCommunicationSystem simpleCommunicationSystem = null;

    public MobileMessageProcessor(SimpleCommunicationSystem communicationSystem) throws JMSException {
        simpleCommunicationSystem = communicationSystem;
        threadName = MobileMessageProcessor.class.getSimpleName();
        System.out.println("Creating " + threadName);
    }

    public void processMessage(String message, String atocId) {

        System.out.println("->send message to atoc " + message);
        try {
            simpleCommunicationSystem.getPublisher().sendMessages(message, atocId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {

        while (true) {
            BaseMessage message = null;
            try {
                message = simpleCommunicationSystem.getReceivedMobileMessage();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            if (message != null) {
                JSONParser.registerType(message.getClass());
                String json = JSONParser.toJson(message);
                processMessage(json, message.getAtocId());
            }
        }
    }

    public void start() {

        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
