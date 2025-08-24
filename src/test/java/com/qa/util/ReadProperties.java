package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author sony
 *
 */
/**
 * @author sony
 *
 */
public class ReadProperties {
	
	/**
	 * @return This method is used to read and load properties from config.Properties file
	 */
	public static Properties loadProperties() {

		// Open the File

		File objfile = new File("AppConfig/config.properties");

		// Read the File

 

		FileInputStream objfis = null;

		try {

			objfis = new FileInputStream(objfile);

		} catch (FileNotFoundException e1) {

 

			e1.printStackTrace();

		}

 

		Properties objprop = new Properties();

		try {

			objprop.load(objfis);

		} catch (IOException e) {

 

			e.printStackTrace();

		}

		return objprop;

 

	}

	/**
	 * @return This method is used to read AppURL
	 */
	public static String getappURL() {

		 

		return loadProperties().getProperty("appURL");

	}

	
	/**
	 * @return This method is to read implicit time form config.Properties
	 */
	public static long implicitWaitTime() {

		 

		return Long.parseLong(loadProperties().getProperty("implicitWaitTime"));

	}

	/**
	 * @return This method is to read username from config.Properties
	 */
	public static String getAppUserName() {

		return loadProperties().getProperty("userName");

	}
	
	/**
	 * @return This method is to read password from config.Properties
	 */
	public static String getAppPassword() {

		return loadProperties().getProperty("password");

	}
	/**
	 * @return This method is for FluentWaitTime
	 */
	public static long getFluentWaitTime() {

		 

		return Long.parseLong(loadProperties().getProperty("fluentWaitTime"));

	}

}
