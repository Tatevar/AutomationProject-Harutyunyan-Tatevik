package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {
    private By header = By.xpath("//div[@class='header_secondary_container']//following::div");
    private By checkoutButton = By.id("checkout");
    private By removeButton = By.id("remove-sauce-labs-backpack");
    private By removedCartItem =By.className("removed_cart_item");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage verifyBasketPage() {
        isDisplayed(header);
        return this;
    }

    public BasketPage ClickCheckoutButton() {
        click(checkoutButton);
        return this;
    }

    public BasketPage ClickRemoveButton() {
        click(removeButton);
        return this;
    }

    public BasketPage basketPageAfterProductRemoving() {
        isDisplayed(removedCartItem);
        return this;
    }
}

