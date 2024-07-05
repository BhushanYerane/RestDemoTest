package com.jsonRefData;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com/jsonRefData/UserApiTests.feature"},
        glue = {"com.jsonRefData"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        dryRun = false,
        monochrome = true
		)
public class UserTestRunner {
}
