package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {
    private By header = By.xpath("//div[@class='header_secondary_container']//following::div");
    private By button = By.id("checkout");

    protected BasketPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage verifyBasketPage() {
        isDisplayed(header);
        return this;
    }

    public BasketPage ClickCheckoutButton() {
        click(header);
        return this;
    }
}

