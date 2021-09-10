package Lecture_10;

import Driver.BaseTest;
import PageObject.BasketPage;
import PageObject.LoginPage;
import PageObject.ProductCataloguePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvocationCount extends BaseTest {
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
    @Test(invocationCount = 3)
    public void ProductAdd_test(){
        loginPage.verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productcataloguePage
                .AddProductToBasket()
                .OpenBasket();

    }
    @Test(invocationCount = 1)
    public void ProductDelete_test(){
        loginPage.verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productcataloguePage
                .AddProductToBasket()
                .OpenBasket();
        basketPage.verifyBasketPage()
                .ClickRemoveButton();

    }
}
