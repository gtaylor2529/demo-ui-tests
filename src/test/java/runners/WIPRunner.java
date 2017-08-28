package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepdefs"},
        features = {"src/test/resources/features/"},
        format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
        tags = "@WIP"
)

public class WIPRunner {
}
