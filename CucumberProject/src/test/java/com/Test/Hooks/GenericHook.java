package com.Test.Hooks;

import org.openqa.selenium.WebDriver;

import com.Project.Framework.Services.DriverService;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class GenericHook {
	
	private WebDriver driver;
	private DriverService service;
	
	public GenericHook(DriverService service) {
		this.service = service;
		this.driver = service.getDriver();
	}
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown(Scenario runtimeInfo) {
		int random = (int) (Math.random() * 1000);
		if (runtimeInfo.isFailed()) {
			service.getScreenshotHelper().takeScreenshot("target\\Screenshots", "FailedScreen " + random + ".png"); 
			runtimeInfo.embed(service.getScreenshotHelper().takeScreenshot(), "image/png", "Failed Screen"); 
		}
		
		driver.quit();
	}

}
