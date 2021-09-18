package Lecture_9;

import Driver.BaseTest;
import PageFactory.LoginPageFact;
import PageObject.Saucedemo.*;
import TestNg.Listener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({Listener.class})
public class Tests extends BaseTest {
    ProductCataloguePage productCataloguePage;
    BasketPage basketPage;
    CheckoutPage checkoutPage;
    OrderCheckingPage orderCheckingPage;
    OrderCompletedPage orderCompletedPage;
    LoginPageFact loginPageFact = new LoginPageFact(driver);
    LoginPage loginPage = new LoginPage(driver);

    @BeforeClass
    public void initialization() {
        productCataloguePage = new ProductCataloguePage(driver);
        basketPage = new BasketPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderCheckingPage = new OrderCheckingPage(driver);
        orderCompletedPage = new OrderCompletedPage(driver);

    }

    @Test(priority = 1)
    public void loginToAppWithStandard_Test() {
        loginPageFact
                .openPage()
                .verifyLoginPage()
                .fillLoginFields("standard_user","secret_sauce");
    }
    @Test(priority = 2)
    public void loginToAppWithProblemUser_Test() {
        loginPage
                .openPage()
                .loginToApplication("problem_user", "secret_sauce");
        productCataloguePage
                .verifyPageAfterProblemUser();
    }

        @Test(priority = 3)
        public void loginToAppWithLockedUser_Test() {
            loginPage
                    .openPage()
                    .loginToApplication("locked_out_user", "secret_sauce")
                    .checkErrorText("Epic sadface: Sorry, this user has been locked out.");
        }
    @Test(priority = 4 )
    public void AddProductToBasket_Test() {
        loginPage
                .openPage()
                .loginToApplication("standard_user", "secret_sauce");
        productCataloguePage
                .AddProductToBasket()
                .OpenBasket();
        basketPage
                .verifyBasketPage();
    }
    @Test(priority = 5 )
    public void RemoveProductFromBasket_Test() throws InterruptedException {
        loginPage
                .openPage()
                .loginToApplication("standard_user", "secret_sauce");
        Thread.sleep(5000);
        productCataloguePage
                .AddProductToBasket()
                .OpenBasket();
        basketPage
                .verifyBasketPage()
                .ClickRemoveButton();
    }
        @Test(priority = 6 )
        public void PlaceAnOrder_Test() throws InterruptedException {
            loginPage
                    .openPage()
                    .loginToApplication("standard_user", "secret_sauce");
            Thread.sleep(5000);
            productCataloguePage
                    .AddProductToBasket()
                    .OpenBasket();
            basketPage
                    .verifyBasketPage()
                    .ClickCheckoutButton();
        checkoutPage
                .verifyCheckoutPage()
                .EnterCheckoutData("tata","har","m14bt");
        orderCheckingPage
                .verifyOrderCheckingPage()
                .ClickFinishBtn();
        orderCompletedPage
                .VerifyOrderCompletedPage();
    }
}
