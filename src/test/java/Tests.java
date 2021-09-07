import Driver.BaseTest;
import PageObject.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    ProductCataloguePage productCataloguePage = new ProductCataloguePage(driver);
    BasketPage basketPage = new BasketPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    OrderCheckingPage orderCheckingPage = new OrderCheckingPage(driver);
    OrderCompletedPage orderCompletedPage = new OrderCompletedPage(driver);

    @BeforeClass
    public void initialization() {
        loginPage = new LoginPage(driver);
        productCataloguePage = new ProductCataloguePage(driver);
        basketPage = new BasketPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderCheckingPage = new OrderCheckingPage(driver);
        orderCompletedPage = new OrderCompletedPage(driver);
    }

    @BeforeMethod
    public void precondition() {
        loginPage.openPage();

    }

    @Test(priority = 1)
    public void loginToAppWithStandard_Test() throws InterruptedException {
        loginPage
                .verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
    }
    @Test(priority = 2)
    public void loginToAppWithProblemUser_Test() {
        loginPage
                .loginToApplication("problem_user", "secret_sauce");
        productCataloguePage
                .verifyPageAfterProblemUser();
    }

        @Test(priority = 3)
        public void loginToAppWithLockedUser_Test() {
            loginPage
                    .loginToApplication("locked_out_user", "secret_sauce")
                    .checkErrorText("Epic sadface: Sorry, this user has been locked out.");
        }
    @Test(priority = 4 )
    public void AddProductToBasket_Test() {
        loginPage
                .loginToApplication("standard_user", "secret_sauce");
        productCataloguePage
                .AddProductToBasket()
                .OpenBasket();
        basketPage
                .verifyBasketPage();
    }
    @Test(priority = 5 )
    public void RemoveProductFromBasket_Test() {
        loginPage
                .loginToApplication("standard_user", "secret_sauce");
        productCataloguePage
                .AddProductToBasket()
                .OpenBasket();
        basketPage
                .verifyBasketPage()
                .ClickRemoveButton();
    }
        @Test(priority = 6 )
        public void PlaceAnOrder_Test() {
            loginPage
                    .loginToApplication("standard_user", "secret_sauce");
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
