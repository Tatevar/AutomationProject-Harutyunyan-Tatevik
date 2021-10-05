package Lecture_10;

import Driver.BaseTest;
import PageObject.Saucedemo.BasketPage;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductCataloguePage;
import TestNg.Listener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
public class InvocationCountRemove extends BaseTest {
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

    @Test(invocationCount = 3)
    public void ProductDelete_test(){
        loginPage.verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productcataloguePage
                .AddProductToBasket()
                .OpenBasket();
        basketPage.verifyBasketPage()
                .ClickRemoveButton()
                .basketPageAfterProductRemoving();

    }
}
