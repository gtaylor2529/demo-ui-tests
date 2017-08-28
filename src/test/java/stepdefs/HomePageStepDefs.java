package stepdefs;

import cucumber.api.java.en.Then;
import driver.Config;
import org.openqa.selenium.WebDriver;
import page_objects.HomePage;

public class HomePageStepDefs {

    WebDriver driver = Config.getDriver();
    HomePage homePage;

    @Then("^the (.*) section is displayed$")
    public void theSectionIsDisplayed(String sectionName) throws Throwable {
        homePage = new HomePage(driver);
        homePage.assertSectionIsDisplayed(sectionName);
    }
}
