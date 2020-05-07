package com.Test.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features = {"src/test/java/com/Test/Features"},
		glue = {"com.Test.Steps" , "com.Test.Hooks"},
		tags = {"@Smoke or @Login"},
		//plugin = {"pretty" , "html:target/LoginReport"},
		plugin = {"pretty" , "json:target/login.json"},
		dryRun = false,
		monochrome = true,
		strict = true
		)

public class LoginRunner extends AbstractTestNGCucumberTests {

}
