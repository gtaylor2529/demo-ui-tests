package page_objects;

import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Page {

    protected WebDriver driver;
    private WebElement element = null;
    private List<WebElement> elements;
    private int explicitWaitTime = 20;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void tearDownDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/jpeg");
        }
        driver.close();
    }

    public void navigateToRootElement() {
        element = driver.findElement(By.xpath("/html/body"));
    }

    public void navigateToElementById(String id) {
        element = element.findElement(By.id(id));
    }

    public void navigateToElementByClassName(String className) {
        element = element.findElement(By.className(className));
    }

    public void navigateToElementByTagName(String tagName) {
        element = element.findElement(By.tagName(tagName));
    }

    public void click() {
        element.click();
    }

    public void waitForElementToBeVisibleById(String id) {
        new WebDriverWait(driver, (long) explicitWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public boolean checkForElementToBeVisibleById(String id) {
        boolean elementFound = true;
        try {
            new WebDriverWait(driver, (long) 5).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        } catch (Exception e) {
            elementFound = false;
        }
        return elementFound;
    }

    public void buildListByClassName(String className) {
        elements = element.findElements(By.className(className));
    }

    public void buildListByTagName(String tagName) {
        elements = element.findElements(By.tagName(tagName));
    }

    public String getListSize() {
        return String.valueOf(elements.size());
    }

    public void navigateToListElementByText(String text) {
        Iterator elementList = elements.iterator();
        while (elementList.hasNext()) {
            WebElement element = (WebElement) elementList.next();
            if (element.getText().equalsIgnoreCase(text)) {
                this.element = element;
                break;
            }
        }
    }

    public void verifyElementHasText(String text) {
        assertThat(element.getText()).isEqualToIgnoringCase(text);
    }
}
