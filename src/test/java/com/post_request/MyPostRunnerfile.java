package com.post_request;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/test/resources/com/post_requestFF/"},
			glue = {"com.post_request"},
			dryRun = false,
			monochrome = true,
			plugin={"pretty","html:target/cucumber-htmlreport","json:target/cucumber-report1.json"}
		)
public class MyPostRunnerfile {

}
