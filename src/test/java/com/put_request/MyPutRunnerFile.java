package com.put_request;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/com/put_requestFF/"},
		glue={"com.put_request"},
		plugin={"pretty",
				"html:target/cucumber-reports",
				"json:target/cucumber-reports/Cucumber.json"},
		dryRun= true,
		monochrome = true
		)

public class MyPutRunnerFile {

}
