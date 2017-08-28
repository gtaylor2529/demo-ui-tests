package stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.Config;
import org.openqa.selenium.WebDriver;
import page_objects.Page;
import page_objects.GenericPage;
import page_objects.HomePage;

public class GenericStepDefs {

    WebDriver driver = Config.getDriver();
    Page page;
    GenericPage genericPage;
    HomePage homePage;

    @When("^I go to (.*)$")
    public void iGoTo(String url) throws Throwable {
        page = new Page(driver);
        page.navigateToUrl(url);
        homePage = new HomePage(driver);
        homePage.assertHomePageIsDisplayed();
    }

    @Then("^the (.*) header is displayed$")
    public void thePageNameHeaderIsDisplayed(String pageName) throws Throwable {
        genericPage = new GenericPage(driver);
        genericPage.assertPageIsDisplayed("adasdas");
    }

    @When("^I navigate to the (.*) page$")
    public void iNavigateToThePageNamePage(String pageName) throws Throwable {
        genericPage = new GenericPage(driver);
        genericPage.navigateToPage(pageName);
    }

    @When("^I open the contact page$")
    public void iOpenTheContactPage() throws Throwable {
        genericPage = new GenericPage(driver);
        genericPage.navigateToContactPage();
    }
}
