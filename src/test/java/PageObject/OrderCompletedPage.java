package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletedPage extends BasePage{
    private By orderCompleted= org.openqa.selenium.By.id("checkout_complete_container");

    public OrderCompletedPage(WebDriver driver) {
        super(driver);
    }
    public OrderCompletedPage VerifyOrderCompletedPage(){
        isDisplayed(orderCompleted);
        return this;
    }
}
