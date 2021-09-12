package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {
    private WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void enter(By element, CharSequence... charSequences) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(charSequences);
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected void open(String url) {
        driver.get(url);
    }

    protected String getElementText(By element) {
        return driver.findElement(element).getText();
    }


    protected void isDisplayed(By... elements) {
        for (By element : elements) {
            Assert.assertTrue(driver.findElement(element).isDisplayed(), "Element :: " + elements + " is not exist.");
        }
    }

}