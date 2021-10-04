package HerokuappTestLecture_14;
import Driver.BaseTest;
import PageObject.herokuapp.FormAuthenticationObject;
import PageObject.herokuapp.HomePageObject;
import TestNg.Listener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Patterns.UserBuilder;

import static PageObject.herokuapp.HomePageLinksEnum.FORMAUTHENTICATION;

@Listeners({Listener.class})
public class herokuappBuilder extends BaseTest {
    HomePageObject homePageObject;
    FormAuthenticationObject formAuthenticationObject;

    @BeforeClass
    public void precondition() {
        homePageObject = new HomePageObject(driver);
        homePageObject.openPage();
        homePageObject.clickLink(FORMAUTHENTICATION);
        formAuthenticationObject = new FormAuthenticationObject(driver);
    }

    @Test
    public void formAuthenticationObject_Test() {
        UserBuilder userBuilder = new UserBuilder
                .Builder()
                .withUsername("hgjh")
                .withPassword("   ")
                .build();
        formAuthenticationObject
                .verifyPageTitle("Login Page")
                .loginToApplication(userBuilder)
                .checkErrorText("Your username is invalid!\n" +
                        "×");
        }
    }

