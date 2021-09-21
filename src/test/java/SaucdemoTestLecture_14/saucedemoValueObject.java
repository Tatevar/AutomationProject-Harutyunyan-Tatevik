package SaucdemoTestLecture_14;

import Driver.BaseTest;
import PageFactory.LoginPageFact;
import PageObject.Saucedemo.*;
import TestNg.Listener;
import saucedemoPatterns.UserLogin;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})
public class saucedemoValueObject extends BaseTest {
        ProductCataloguePage productCataloguePage;
        LoginPageFact loginPageFact;
        UserLogin userLogin = new UserLogin();

        @BeforeClass
        public void preCondition() {
            productCataloguePage = new ProductCataloguePage(driver);
            loginPageFact = new LoginPageFact(driver);
            loginPageFact.openPage();
        }
   // Chain Of Invocations
        @Test
        public void loginToAppWithStandard_Test() {
            loginPageFact
                    .verifyLoginPage()
                    .loginToApp(userLogin);
            productCataloguePage
                    .verifyProductPage();

        }
    }

