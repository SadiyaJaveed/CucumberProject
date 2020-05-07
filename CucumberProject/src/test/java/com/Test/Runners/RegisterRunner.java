package com.Test.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features = {"src/test/java/com/Test/Features"},
		glue = {"com.Test.Steps" , "com.Test.Hooks"},
		tags = {"@Register"},
		//plugin = {"pretty" , "html:target/RegisterReport"},
		plugin = {"pretty" , "json:target/register.json"},
		dryRun = false,
		monochrome = true, 
		strict = true
		)

public class RegisterRunner extends AbstractTestNGCucumberTests {

}
