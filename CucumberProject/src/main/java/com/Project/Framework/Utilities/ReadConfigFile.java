package com.Project.Framework.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile implements IReader{
	
	private Properties properties;
	
	 public ReadConfigFile() {
		readPropertiesFile("");
	 }
	 
	 public ReadConfigFile(String filename) {
		readPropertiesFile(filename);
	}
	
	private void readPropertiesFile(String filename) {
		if(isDefaultPropertiesFile(filename)) {
			properties = getDataFromProperties("config.properties");
		} else {
			properties = getDataFromProperties(filename);
		}
	}

	private boolean isDefaultPropertiesFile(String filename) {
		if("".equals(filename))
			return true;
		return false;
	}

	private Properties getDataFromProperties(String filename) {
		Properties prop = new Properties();
		String path = ResourceUtility.getResourcePath(filename);
		try {
			InputStream stream = new FileInputStream (new File(path ));
			prop.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	@Override
	public String getBrowserType() {
		return properties.getProperty("BrowserType");
	}

	@Override
	public String getUrl() {
		return properties.getProperty("Url");
	}

	@Override
	public String getUsername() {
		return properties.getProperty("Username");
	}

	@Override
	public String getPassword() {
		return properties.getProperty("Password");
	}

	@Override
	public int getExplicitWait() {
		return Integer.parseInt(properties.getProperty("ExplicitWait"));
	}

	@Override
	public void setBrowserType() {
		// create the user-defined system property
		String browserName = System.getProperty("BrowserType");
		properties.setProperty("BrowserName", browserName);	
	}

}
