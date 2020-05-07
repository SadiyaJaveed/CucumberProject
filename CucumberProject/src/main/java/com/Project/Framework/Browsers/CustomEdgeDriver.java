package com.Project.Framework.Browsers;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomEdgeDriver {
	
	private void setWebDriverManager() {
		WebDriverManager.edgedriver().setup();
	}
	
	private EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		return options;
	}
	
	public EdgeDriver getEdgeDriver() {
		setWebDriverManager();
		EdgeOptions options = getEdgeOptions();
		EdgeDriver driver = new EdgeDriver(options);
		return driver;
	}

}
