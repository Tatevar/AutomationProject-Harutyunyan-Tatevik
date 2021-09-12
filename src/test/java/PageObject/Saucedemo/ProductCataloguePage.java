package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductCataloguePage extends BasePage {
    private By title = By.cssSelector("[class=title]");
    private By logo = By.cssSelector("[class=app_logo]");
    private By filter = By.tagName("select");
    private By addToBasket = By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-backpack')]");
    private By basketLink = By.className("shopping_cart_link");
    private By lockedUserCheckImg = By.xpath("//a[@id='item_4_img_link']");
    private By productCount = By.xpath("//span[@class='shopping_cart_badge']");

    public  ProductCataloguePage(WebDriver driver) {
        super(driver);
    }

    public ProductCataloguePage verifyProductPage() {
        isDisplayed(title, logo, filter);
        return this;
    }
    public ProductCataloguePage verifyPageAfterProblemUser() {
        isDisplayed(lockedUserCheckImg);
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
    public ProductCataloguePage productCountIsOne() {

        String actualResult = getElementText(productCount);
        Assert.assertEquals(actualResult, "1");
        System.out.println(actualResult);
        pause(5);
        return this;

    }
}


