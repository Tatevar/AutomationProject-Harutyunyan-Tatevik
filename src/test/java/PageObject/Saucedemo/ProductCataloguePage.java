package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.nio.channels.Selector;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static Driver.DriverCreation.getDriver;

public class ProductCataloguePage extends BasePage {
    private By title = By.cssSelector("[class=title]");
    private By logo = By.cssSelector("[class=app_logo]");
    private By filter = By.tagName("select");
    private By addToBasket = By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-backpack')]");
    private By basketLink = By.className("shopping_cart_link");
    private By lockedUserCheckImg = By.xpath("//a[@id='item_4_img_link']");
    private By productCount = By.xpath("//span[@class='shopping_cart_badge']");
    private By selectOption = By.cssSelector(".product_sort_container");
    private By productNames = By.cssSelector(".inventory_item_name");
    private By productPrices = By.cssSelector(".inventory_item_price");


    public ProductCataloguePage(WebDriver driver) {
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

    public ProductCataloguePage selectOption(ProductPageFilter productPageFilter) {
        Select selector = new Select(getDriver().findElement(selectOption));
        selector.selectByValue(productPageFilter.getElement());
        return this;
    }

    public ProductCataloguePage sortByNameAZ() {

        List<String> expectedData = getDriver()
                .findElements(productNames)
                .stream()
                .map(data -> data.getText())
                .sorted().collect(Collectors.toList());
        List<String> actualData = getDriver().findElements(productNames)
                .stream()
                .map(data -> data.getText())
                .collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        System.out.println(actualData);
        System.out.println(expectedData);
        return this;

    }

    public ProductCataloguePage sortByNameZA() {

        List<String> expectedData = getDriver()
                .findElements(productNames)
                .stream()
                .map(data -> data.getText())
                .sorted()
                .collect(Collectors.toList());
        List<String> actualData = getDriver()
                .findElements(productNames)
                .stream()
                .map(data -> data.getText()).collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        System.out.println(actualData);
        System.out.println(expectedData);
        return this;
    }
    public ProductCataloguePage sortByPriceLH() {


        List<String> actualData = getDriver()
                .findElements(productPrices)
                .stream()
                .map(data -> data.getText()
                .replace("$", " ")
                .trim()).collect(Collectors.toList());
        String [] expectedDataArray = {"7.99", "9.99", "15.99", "15.99", "29.99", "49.99"};
        List<String> expectedData = Arrays.asList(expectedDataArray);
        Assert.assertEquals(expectedData, actualData);
        System.out.println(expectedData);
        System.out.println(actualData);
        return this;

    }

    public ProductCataloguePage sortByPriceHL() {


        List<String> actualData = getDriver().findElements(productPrices)
                .stream()
                .map(data -> data.getText()
                .replace("$", " ")
                .trim()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        String [] expectedDataArray = {"49.99", "9.99", "15.99", "15.99", "29.99", "7.99"};
        List<String> expectedData = Arrays.asList(expectedDataArray);
        Assert.assertEquals(expectedData, actualData);
        System.out.println(expectedData);
        System.out.println(actualData);
        return this;

    }

}


