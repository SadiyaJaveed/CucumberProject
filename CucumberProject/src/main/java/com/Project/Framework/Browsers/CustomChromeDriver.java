package com.Project.Framework.Browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomChromeDriver {
	
	private void setWebDriverManager() {
		WebDriverManager.chromedriver().setup();
	}
	
	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		return options;
	}
	
	public ChromeDriver getChromeDriver() {
		setWebDriverManager();
		ChromeOptions options = getChromeOptions();
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}
}
