package Lecture_9;

import Driver.BaseTest;
import PageFactory.BasketPageFact;
import PageFactory.LoginPageFact;
import PageObject.Saucedemo.CheckoutPage;
import PageObject.Saucedemo.OrderCheckingPage;
import PageObject.Saucedemo.OrderCompletedPage;
import PageObject.Saucedemo.ProductCataloguePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    ProductCataloguePage productCataloguePage;
    BasketPageFact basketPageFact;
    CheckoutPage checkoutPage;
    OrderCheckingPage orderCheckingPage;
    OrderCompletedPage orderCompletedPage;
    LoginPageFact loginPageFact;

    @BeforeClass
    public void initialization() {
        productCataloguePage = new ProductCataloguePage();
        basketPageFact = new BasketPageFact();
        checkoutPage = new CheckoutPage();
        orderCheckingPage = new OrderCheckingPage();
        orderCompletedPage = new OrderCompletedPage();
        loginPageFact = new LoginPageFact();
    }
    @BeforeMethod
    public void precondition() {
        loginPageFact.openPage();
    }

    @Test(priority = 1)
    public void loginToAppWithStandard_Test() {
        loginPageFact
                .fillLoginFields("standard_user","secret_sauce");
    }
    @Test(priority = 2)
    public void loginToAppWithProblemUser_Test() {
        loginPageFact
                .fillLoginFields("problem_user", "secret_sauce");
        productCataloguePage
                .verifyPageAfterProblemUser();
    }

        @Test(priority = 3)
        public void loginToAppWithLockedUser_Test() {
            loginPageFact
                    .fillLoginFields("locked_out_user", "secret_sauce")
                    .checkErrorText("Epic sadface: Sorry, this user has been locked out.");
        }
    @Test(priority = 4 )
    public void AddProductToBasket_Test() {
        loginPageFact
                .fillLoginFields("standard_user", "secret_sauce");
        productCataloguePage
                .AddProductToBasket()
                .OpenBasket();
        basketPageFact
                .verifyBasketPage();
    }
    @Test(priority = 5 )
    public void RemoveProductFromBasket_Test() throws InterruptedException {
        loginPageFact
                .fillLoginFields("standard_user", "secret_sauce");
        Thread.sleep(5000);
        productCataloguePage
                .AddProductToBasket()
                .OpenBasket();
        basketPageFact
                .verifyBasketPage()
                .ClickRemoveButton();
    }
        @Test(priority = 6 )
        public void PlaceAnOrder_Test() throws InterruptedException {
            loginPageFact
                    .fillLoginFields("standard_user", "secret_sauce");
            Thread.sleep(5000);
            productCataloguePage
                    .AddProductToBasket()
                    .OpenBasket();
            basketPageFact
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
