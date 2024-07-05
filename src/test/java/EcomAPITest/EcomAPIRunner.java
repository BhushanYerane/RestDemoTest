package EcomAPITest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.core.cli.Main;

@SuppressWarnings("unused")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/EcomAPITestFF/",
        glue = {"EcomAPITest"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class EcomAPIRunner  
{

}
