package page_objects;

import org.openqa.selenium.WebDriver;

public class ContactPage extends Page {

    public ContactPage(WebDriver driver) {
        super(driver);
        waitForElementToBeVisibleById("contactbox");
    }

    public void verifyAmountOfValtechOffices() {
        navigateToRootElement();
        navigateToElementById("contactbox");
        buildListByTagName("li");
        System.out.println("Total number of Valtech offices: " + getListSize());
    }
}
