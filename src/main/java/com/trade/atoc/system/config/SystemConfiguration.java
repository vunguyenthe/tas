package com.trade.atoc.system.config;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;
public class SystemConfiguration {
	private static final Logger logger = LoggerFactory
			.getLogger(SystemConfiguration.class);
	
	public static String broker_url = "tcp://amqbroker.openshift.hughestech.space:61616";
	public static String user = "admin";
	public static String password = "admin";
	public static String atoc_tas = "atoc.tas.topic";
	public static String tas_atoc = "tas.atoc.topic";	
	public static String keycloak_url = "http://keycloak-manualoverride-dev.openshift.hughestech.space";
	public static String push_server = "https://aerogear-sevenvu.rhcloud.com/ag-push/";
	public static String app_id = "c967a477-a823-41d8-8f00-e08377d62084";
	public static String master_secret = "3fa36e51-4ba3-4c86-a60a-3e36bcc2f9a3";	
	public static String keycloak_user = "admin";	
	public static String keycloak_pass = "admin123";	
	
	private static Properties prop = new Properties();
	public static void loadPropertieseConfiguration()
	{
		try
		{
			if(validateEnv("TASPROFILE"))
			{
				if(System.getenv("TASPROFILE").equals("DEV"))
				{
					System.out.println("->DEV");
					try(InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("tas_DEV.properties")) {
						prop.load(resourceStream);
					}
					
				}
				else if(System.getenv("TASPROFILE").equals("PROD"))
				{
					System.out.println("->PROD");
					try(InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("tas_STAGING.properties")) {
						prop.load(resourceStream);
					}
				}
				else if(System.getenv("TASPROFILE").equals("STAGING"))
				{
					System.out.println("->STAGING");
					try(InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("tas_STAGING.properties")) {
						prop.load(resourceStream);
					}
				}				
				else
				{
					System.out.println("->DEFAULT");
					try(InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("tas.properties")) {
						prop.load(resourceStream);
					}
				}				
			}
			else
			{
				System.out.println("->DEFAULT");
				try(InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("tas.properties")) {
					prop.load(resourceStream);
				}
			}
			
			broker_url = prop.getProperty("MO_BROKER");
			keycloak_url = prop.getProperty("MO_KC");
			push_server = prop.getProperty("MO_UPS");
			app_id = prop.getProperty("MO_UPS_APP_ID");
			master_secret = prop.getProperty("MO_UPS_MASTER_SECRET");	
			keycloak_user = prop.getProperty("MO_KC_USER");
			keycloak_pass = prop.getProperty("MO_KC_PASS");
			
			atoc_tas = prop.getProperty("ATOC_TAS");
			tas_atoc = prop.getProperty("TAS_ATOC");
			user = prop.getProperty("ACTIVEMQ_USER");
			password = prop.getProperty("ACTIVEMQ_PASS");
			
			System.out.println("Push Server env: " + SystemConfiguration.push_server);
			System.out.println("keycloak_url env: " + SystemConfiguration.keycloak_url);
			System.out.println("app_id env: " + SystemConfiguration.app_id);
			System.out.println("master_secret env: " + SystemConfiguration.master_secret);
			System.out.println("keycloak_user env: " + SystemConfiguration.keycloak_user);
			System.out.println("keycloak_pass env: " + SystemConfiguration.keycloak_pass);
			
			System.out.println("atoc_tas env: " + SystemConfiguration.atoc_tas);
			System.out.println("tas_atoc env: " + SystemConfiguration.tas_atoc);
			System.out.println("user env: " + SystemConfiguration.user);
			System.out.println("password env: " + SystemConfiguration.password);
			
		}
		catch(Exception e)
		{
			logger.error("LoadSystemConfiguration failed: " + e.toString());
			e.printStackTrace();
		}
	}
	private static boolean validateEnv(String env)
	{
		String tmp = System.getenv(env);
		if( tmp != null && tmp.length() > 0)
		{
			return true;
		}
		return false;
	}
	public static void loadEnvironmentConfiguration()
	{
		try
		{
			if( validateEnv("MO_BROKER"))
			{
				broker_url =  System.getenv("MO_BROKER");
			}
			if( validateEnv("MO_KC"))
			{
				keycloak_url = System.getenv("MO_KC");
			}
			if( validateEnv("MO_UPS"))
			{
				push_server = System.getenv("MO_UPS");
			}
			if( validateEnv("MO_UPS_APP_ID"))
			{
				app_id = System.getenv("MO_UPS_APP_ID");
			}
			if( validateEnv("MOP_UPS_MASTER_SECRET"))
			{
				master_secret =  System.getenv("MOP_UPS_MASTER_SECRET");
			}
			if( validateEnv("MO_KC_USER"))
			{
				keycloak_user =  System.getenv("MO_KC_USER");
			}
			if( validateEnv("MO_KC_PASS"))
			{
				keycloak_pass =  System.getenv("MO_KC_PASS");
			}	
			if( validateEnv("ATOC_TAS"))
			{
				atoc_tas =  System.getenv("ATOC_TAS");
			}		
			if( validateEnv("TAS_ATOC"))
			{
				tas_atoc=  System.getenv("TAS_ATOC");
			}		
			if( validateEnv("ACTIVEMQ_USER"))
			{
				user =  System.getenv("ACTIVEMQ_USER");
			}		
			if( validateEnv("ACTIVEMQ_PASS"))
			{
				password =  System.getenv("ACTIVEMQ_PASS");
			}		
		}
		catch(Exception e)
		{
			logger.error("loadEnvironmentConfiguration failed: " + e.toString());
		}
	}	
}
