package com.ApplicationUP;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/test/resources/com/ApplicationUP/ApplicationStatus.feature"},
			glue = {"com.ApplicationUP"},
			dryRun = false,
			monochrome = true,
			plugin={"pretty","html:target/cucumber-htmlreport",	"json:target/cucumber-report1.json"}
		)
public class checkgoogleRunnerTest {

}
