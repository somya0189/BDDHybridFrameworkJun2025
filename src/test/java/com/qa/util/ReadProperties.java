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
	 * @return This method is used to read and load properties from config properties file
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
	 * @return This method is used to read App URL
	 */
	public static String getappURL() {

		 

		return loadProperties().getProperty("appURL");

	}

	
	/**
	 * @return
	 */
	public static long implicitWaitTime() {

		 

		return Long.parseLong(loadProperties().getProperty("implicitWaitTime"));

	}

	/**
	 * @return
	 */
	public static String getAppUserName() {

		return loadProperties().getProperty("userName");

	}
	
	/**
	 * @return
	 */
	public static String getAppPassword() {

		return loadProperties().getProperty("password");

	}
	/**
	 * @return
	 */
	public static long getFluentWaitTime() {

		 

		return Long.parseLong(loadProperties().getProperty("fluentWaitTime"));

	}

}
