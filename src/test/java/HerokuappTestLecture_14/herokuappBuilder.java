package HerokuappTestLecture_14;
import Driver.BaseTest;
import PageObject.herokuapp.FormAuthenticationObject;
import PageObject.herokuapp.HomePageObject;
import TestNg.Listener;
import herokuappPatterns.LoginBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static Driver.BaseTest.driver;
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
        LoginBuilder loginBuilder = new LoginBuilder
                .Builder()
                .withUsername("")
                .withPassword("")
                .build();
        formAuthenticationObject
                .verifyPageTitle("Login Page")
                .loginToApplication(loginBuilder)
                .checkErrorText("Your username is invalid!\n" +
                        "×");




        }
    }

