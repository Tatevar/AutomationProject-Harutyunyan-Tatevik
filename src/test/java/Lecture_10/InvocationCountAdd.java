package Lecture_10;

import Driver.BaseTest;
import PageObject.BasketPage;
import PageObject.LoginPage;
import PageObject.ProductCataloguePage;
import TestNg.Listener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import properties.PropertyReader;
@Listeners({Listener.class})
public class InvocationCountAdd extends BaseTest {
    LoginPage loginPage;
    ProductCataloguePage productcataloguePage;
    BasketPage basketPage;

    @BeforeClass
    public void pre() {
        loginPage = new LoginPage(driver);
        productcataloguePage = new ProductCataloguePage(driver);
        basketPage = new BasketPage(driver);

    }

    @BeforeMethod
    public void precondition() {
        loginPage.openPage();
    }

    @Test(invocationCount = 2) // тут во второй раз заходит уже с товаром  в корзине и не может кликнуть, не знаю как избегать
    public void ProductAdd_test() {
        loginPage.verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productcataloguePage
                .AddProductToBasket()
                .productCountIsOne();

    }
}


