package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCataloguePage extends BasePage {
    private By title = By.cssSelector("[class=title]");
    private By logo = By.cssSelector("[class=app_logo]");
    private By filter = By.tagName("select");
    private By addToBasket = By.id("add-to-cart-sauce-labs-backpack");
    private By basketLink = By.className("shopping_cart_link");


    public  ProductCataloguePage(WebDriver driver) {
        super(driver);
    }

    public ProductCataloguePage verifyProductPage() {
        isDisplayed(title, logo, filter);
        return this;
    }

    public ProductCataloguePage AddProductToBasket() {
        click(addToBasket);
        return this;
    }

    public ProductCataloguePage OpenBasket() {
        click(basketLink);
        return this;
    }
}


