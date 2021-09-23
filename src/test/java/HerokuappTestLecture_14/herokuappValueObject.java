package HerokuappTestLecture_14;
import Driver.BaseTest;
import PageObject.herokuapp.FormAuthenticationObject;
import PageObject.herokuapp.HomePageObject;
import TestNg.Listener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Patterns.UserLogin;

import static PageObject.herokuapp.HomePageLinksEnum.FORMAUTHENTICATION;


public class herokuappValueObject extends BaseTest {
    HomePageObject homePageObject;
    FormAuthenticationObject formAuthenticationObject;
    UserLogin userLogin = new UserLogin();

    @BeforeClass
    public void precondition() {
        homePageObject = new HomePageObject();
        homePageObject.openPage();
        homePageObject.clickLink(FORMAUTHENTICATION);
        formAuthenticationObject = new FormAuthenticationObject();

    }
    @Test
    public void valueObject_Test() {

        formAuthenticationObject
                .verifyPageTitle("Login Page")
                .loginToApp(userLogin)
                .checkErrorText("Your password is invalid!\n" +
                        "×");
    }
}

