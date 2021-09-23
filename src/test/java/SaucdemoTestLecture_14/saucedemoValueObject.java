package SaucdemoTestLecture_14;

import Driver.BaseTest;
import PageFactory.LoginPageFact;
import PageObject.Saucedemo.ProductCataloguePage;
import Patterns.UserLogin;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class saucedemoValueObject extends BaseTest {
        ProductCataloguePage productCataloguePage;
        LoginPageFact loginPageFact;
        UserLogin userLogin = new UserLogin();

        @BeforeClass
        public void preCondition() {
            productCataloguePage = new ProductCataloguePage();
            loginPageFact = new LoginPageFact();
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

