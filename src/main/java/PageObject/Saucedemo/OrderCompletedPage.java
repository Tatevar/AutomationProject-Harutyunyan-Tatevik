package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;

public class OrderCompletedPage extends BasePage {
    private By orderCompleted= org.openqa.selenium.By.id("checkout_complete_container");

    public OrderCompletedPage VerifyOrderCompletedPage(){
        isDisplayed(orderCompleted);
        return this;
    }
}
