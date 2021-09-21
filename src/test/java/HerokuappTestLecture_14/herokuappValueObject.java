package HerokuappTestLecture_14;
import Driver.BaseTest;
import PageObject.herokuapp.FormAuthenticationObject;
import PageObject.herokuapp.HomePageObject;
import TestNg.Listener;
import herokuappPatterns.ValueObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static Driver.BaseTest.driver;
import static PageObject.herokuapp.HomePageLinksEnum.FORMAUTHENTICATION;

@Listeners({Listener.class})
public class herokuappValueObject extends BaseTest {
    HomePageObject homePageObject;
    FormAuthenticationObject formAuthenticationObject;
    ValueObject valueObject = new ValueObject();

    @BeforeClass
    public void precondition() {
        homePageObject = new HomePageObject(driver);
        homePageObject.openPage();
        homePageObject.clickLink(FORMAUTHENTICATION);
        formAuthenticationObject = new FormAuthenticationObject(driver);
    }
    @Test
    public void valueObject_Test() {

        formAuthenticationObject
                .verifyPageTitle("Login Page")
                .loginToApp(valueObject)
                .checkErrorText("Your username is invalid!\n" +
                "×");
    }
}

