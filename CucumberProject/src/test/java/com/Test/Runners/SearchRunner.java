package com.Test.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features = {"src/test/java/com/Test/Features"},
		glue = {"com.Test.Steps" , "com.Test.Hooks"},
		tags = {"@Search"},
		//plugin = {"pretty" , "html:target/SearchReport"},
		plugin = {"pretty" , "json:target/search.json"},
		dryRun = false,
		monochrome = true,
		strict = true
		)

public class SearchRunner extends AbstractTestNGCucumberTests {

}
