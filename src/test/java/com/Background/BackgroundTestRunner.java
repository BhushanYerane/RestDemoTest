package com.Background;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/com/BackgroundFF"},
		glue={"com.Background"},
		plugin={"pretty",
				"html:target/cucumber-htmlreport.html",
				"json:target/cucumber-report200.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/ExtentReport.html"
		}
		)

public class BackgroundTestRunner {

}
