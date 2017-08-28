package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.Config;
import org.openqa.selenium.WebDriver;
import page_objects.Page;

public class SetupStepDef {

    Scenario scenario;
    WebDriver driver;
    Page page;

    @Before
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
        driver = Config.setDriver();
    }

    @After
    public void tearDownBrowser() {
        page = new Page(driver);
        page.tearDownDriver(scenario);
    }
}
