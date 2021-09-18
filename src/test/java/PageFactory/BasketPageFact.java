package PageFactory;

import PageObject.BasePage;
import PageObject.Saucedemo.BasketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPageFact extends BasePage {

    @FindBy(xpath="//div[@class='header_secondary_container']//following::div")
    WebElement header;

    @FindBy(id="checkout")
    WebElement checkoutButton;

    @FindBy(id="remove-sauce-labs-backpack")
    WebElement removeButton;

    @FindBy(id="removed_cart_item")
    WebElement removedCartItem;

    public BasketPageFact(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public BasketPageFact verifyBasketPage() {
        this.header.isDisplayed();
        return this;
    }

    public BasketPageFact ClickCheckoutButton() {
        this.checkoutButton.click();
        return this;
    }

    public BasketPageFact ClickRemoveButton() {
        this.removeButton.click();
        return this;
    }

    public BasketPageFact basketPageAfterProductRemoving() {
        this.removedCartItem.isDisplayed();
        return this;
    }
}

