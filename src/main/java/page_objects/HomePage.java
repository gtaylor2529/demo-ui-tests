package page_objects;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void assertHomePageIsDisplayed() {
        waitForElementToBeVisibleById("wrapper");
    }

    public void assertSectionIsDisplayed(String sectionName) {
        navigateToRootElement();
        buildListByClassName("block-header__heading");
        navigateToListElementByText(sectionName);
        verifyElementHasText(sectionName);
    }
}
