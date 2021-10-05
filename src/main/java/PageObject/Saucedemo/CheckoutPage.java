package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private By continueButton = By.cssSelector("[data-test=continue]");
    private By firstName = By.cssSelector("[data-test=firstName]");
    private By lastName = By.cssSelector("[data-test=lastName]");
    private By postalCode = By.cssSelector("[data-test=postalCode]");
    private By checkoutInfo = By.id("checkout_info_container");

    public CheckoutPage verifyCheckoutPage() {
        isDisplayed(checkoutInfo);
        return this;
    }

    public CheckoutPage EnterCheckoutData(String firstname, String lastnamame,String postalcode) {
        enter(this.firstName, firstname);
        enter(this.lastName, lastnamame);
        enter(this.postalCode, postalcode);
        click(this.continueButton);
        return this;
    }
}
