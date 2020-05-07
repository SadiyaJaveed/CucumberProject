package com.Project.Framework.Helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {
	
	private WebDriver Driver;
	private static ScreenshotHelper screenshotHelper;
	
	private ScreenshotHelper(WebDriver driver) {
		this.Driver = driver;
	}
	
	public static ScreenshotHelper getInstance(WebDriver driver) {
		screenshotHelper = new ScreenshotHelper(driver);
		return screenshotHelper;
	}
	
	public void takeScreenshot(String taretDirectory, String targetFilename) {
		File screenshot = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(taretDirectory + File.separator+ targetFilename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public byte[] takeScreenshot() {
		byte[] screenshot = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}

}
