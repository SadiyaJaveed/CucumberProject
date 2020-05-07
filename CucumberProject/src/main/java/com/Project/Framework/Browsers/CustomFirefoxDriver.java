package com.Project.Framework.Browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomFirefoxDriver {

	private void setWebDriverManager() {
		WebDriverManager.firefoxdriver().setup();
	}

	private FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("marionette", true);
		options.setAcceptInsecureCerts(true);
		return options;
	}

	public FirefoxDriver getFirefoxDriver() {
		setWebDriverManager();
		FirefoxOptions options = getFirefoxOptions();
		FirefoxDriver driver = new FirefoxDriver(options);
		return driver;
	}

}
