package stepdefs;

import cucumber.api.java.en.Then;
import driver.Config;
import org.openqa.selenium.WebDriver;
import page_objects.ContactPage;

public class ContactPageStepDef {

    WebDriver driver = Config.getDriver();
    ContactPage contactPage;

    @Then("^all of the Valtech offices will be displayed$")
    public void allOfTheValtechOfficesWillBeDisplayed() throws Throwable {
        contactPage = new ContactPage(driver);
        contactPage.verifyAmountOfValtechOffices();
    }
}
