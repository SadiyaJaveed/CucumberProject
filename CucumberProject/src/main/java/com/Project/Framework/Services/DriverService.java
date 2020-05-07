package com.Project.Framework.Services;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import com.Project.Framework.Browsers.CustomChromeDriver;
import com.Project.Framework.Browsers.CustomEdgeDriver;
import com.Project.Framework.Browsers.CustomFirefoxDriver;
import com.Project.Framework.Helpers.ScreenshotHelper;
import com.Project.Framework.Utilities.IReader;
import com.Project.Framework.Utilities.ReadConfigFile;

public class DriverService {
	
	private WebDriver driver;
	private IReader reader;
	private CustomChromeDriver customChromeDriver;
	private CustomFirefoxDriver customFirefoxDriver;
	private CustomEdgeDriver customEdgeDriver;
	private ScreenshotHelper screenshotHelper;
	
	public WebDriver getDriver() {
		return driver;
	}
	public IReader getReader() {
		return reader;
	}
	public CustomChromeDriver getCustomChromeDriver() {
		return customChromeDriver;
	}
	public CustomFirefoxDriver getCustomFirefoxDriver() {
		return customFirefoxDriver;
	}
	public CustomEdgeDriver getCustomEdgeDriver() {
		return customEdgeDriver;
	}
	public ScreenshotHelper getScreenshotHelper() {
		return screenshotHelper;
	}
	
	public DriverService() {
		launchBrowser();
	}
	
	private void launchBrowser() {
		reader = new ReadConfigFile();
		
		driver = getBrowserDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(reader.getExplicitWait(), TimeUnit.SECONDS);	
		//driver.manage().timeouts().implicitlyWait(reader.getExplicitWait(), TimeUnit.SECONDS);
		
		screenshotHelper = ScreenshotHelper.getInstance(driver);
	}
	
	private WebDriver getBrowserDriver() {
		switch (reader.getBrowserType()) {
		case BrowserType.CHROME:
			customChromeDriver = new CustomChromeDriver();
			return customChromeDriver.getChromeDriver();
		case BrowserType.FIREFOX:
			customFirefoxDriver = new CustomFirefoxDriver();
			return customFirefoxDriver.getFirefoxDriver();
		case BrowserType.EDGE:
			customEdgeDriver = new CustomEdgeDriver();
			return customEdgeDriver.getEdgeDriver();
		default:
			throw new RuntimeException("Invalid browser type: " +reader.getBrowserType());
		}
	}

}
