package Lecture_14;

import Driver.BaseTest;
import PageFactory.BasketPageFact;
import PageFactory.LoginPageFact;
import PageObject.Saucedemo.*;
import TestNg.Listener;
import UserLoginData.UserLogin;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})
public class Lecture_14 extends BaseTest {
        ProductCataloguePage productCataloguePage;
        LoginPageFact loginPageFact;
        UserLogin userLogin = new UserLogin();

        @BeforeClass
        public void preCondition() {
            productCataloguePage = new ProductCataloguePage(driver);
            loginPageFact = new LoginPageFact(driver);
            loginPageFact.openPage();
        }
    // value object pattern
        @Test
        public void loginToAppWithStandard_Test() {
            loginPageFact.loginToApp(userLogin);
            productCataloguePage.verifyProductPage();

        }
    }

