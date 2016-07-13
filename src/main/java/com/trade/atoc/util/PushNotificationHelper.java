package com.trade.atoc.util;

import org.jboss.aerogear.unifiedpush.DefaultPushSender;
import org.jboss.aerogear.unifiedpush.PushSender;
import org.jboss.aerogear.unifiedpush.message.MessageResponseCallback;
import org.jboss.aerogear.unifiedpush.message.UnifiedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trade.atoc.json.JSONParser;
import com.trade.atoc.message.base.BaseMessage;
import com.trade.atoc.system.config.SystemConfiguration;
public class PushNotificationHelper {
	private static final Logger logger = LoggerFactory
			.getLogger(PushNotificationHelper.class);

	private static final PushSender defaultPushSender = DefaultPushSender
			.withRootServerURL(SystemConfiguration.push_server)
			.pushApplicationId(SystemConfiguration.app_id)
			.masterSecret(SystemConfiguration.master_secret).build();	
	
	public static void requestPushNotificationWithAlias(
			String message) {
		BaseMessage baseMessage = (BaseMessage) JSONParser.fromJsonToObject(message);
		String deviceAlias = baseMessage.getDeviceAlias();
		System.out.println("deviceAlias: " + deviceAlias);
		UnifiedMessage unifiedMessage = UnifiedMessage.withCriteria()
				.aliases(deviceAlias).message().alert(message).build();
		defaultPushSender.send(unifiedMessage, new MessageResponseCallback() {

			@Override
			public void onComplete() {

			}
		});
	}

	public static void requestPushNotification(String message) {
		final UnifiedMessage unifiedMessage = UnifiedMessage.withMessage()
				.alert(message).build();

		defaultPushSender.send(unifiedMessage, new MessageResponseCallback() { // [5]

					@Override
					public void onComplete() {

					}

				});

	}
}
