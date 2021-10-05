package SaucdemoTestLecture_14;

import Driver.BaseTest;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductCataloguePage;
import Patterns.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class saucedemoBuilder extends BaseTest {
    ProductCataloguePage productCataloguePage;
    LoginPage loginPage;


    @BeforeClass
    public void preCondition() {
        productCataloguePage = new ProductCataloguePage();
        loginPage = new LoginPage();
        loginPage.openPage();
    }

    @Test
    public void loginToAppWithStandard_Test() {
        User user =  User
                .builder()
                .username("problem_user")
                .password("secret_sauce")
                .build();
        loginPage.loginToAppWithBuilder(user);
        productCataloguePage.verifyProductPage();

    }
}
