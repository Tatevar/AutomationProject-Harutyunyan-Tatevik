package Lecture_10;

import Driver.BaseTest;
import PageObject.Saucedemo.BasketPage;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductCataloguePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvocationCountAdd extends BaseTest {
    LoginPage loginPage;
    ProductCataloguePage productcataloguePage;
    BasketPage basketPage;

    @BeforeClass
    public void pre() {
        loginPage = new LoginPage();
        productcataloguePage = new ProductCataloguePage();
        basketPage = new BasketPage();

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


