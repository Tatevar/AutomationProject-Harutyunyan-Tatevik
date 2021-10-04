package SaucdemoTestLecture_14;

import Driver.BaseTest;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductCataloguePage;
import TestNg.Listener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Patterns.UserBuilder;

@Listeners({Listener.class})
public class saucedemoBuilder extends BaseTest {
    ProductCataloguePage productCataloguePage;
    LoginPage loginPage;


    @BeforeClass
    public void preCondition() {
        productCataloguePage = new ProductCataloguePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openPage();
    }

    @Test
    public void loginToAppWithStandard_Test() {
        UserBuilder userBuilder = new UserBuilder
                .Builder()
                .withUsername("problem_user")
                .withPassword("secret_sauce")
                .build();
        loginPage.loginToAppWithBuilder(userBuilder);
        productCataloguePage.verifyProductPage();

    }
}
