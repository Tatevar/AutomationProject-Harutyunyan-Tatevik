package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;

public class OrderCheckingPage extends BasePage {
    private By summaryPage = By.id("checkout_summary_container");
    private By finishBtn = By.id("finish");


    public OrderCheckingPage verifyOrderCheckingPage() {
        isDisplayed(summaryPage);
        return this;
    }

    public OrderCheckingPage ClickFinishBtn() {
        click(finishBtn);
        return this;
    }
}

