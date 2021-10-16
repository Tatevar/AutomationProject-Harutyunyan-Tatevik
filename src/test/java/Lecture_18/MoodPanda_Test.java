package Lecture_18;

import Driver.BaseTestSelenide;
import PageObject.Moodpanda.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class MoodPanda_Test extends BaseTestSelenide {

    @Test
    public void verifyHomePage_Test() {
        get(HomePage.class)
                .checkBrandNameSubtext()
                .checkImage();
    }

    @Test
    public void verifyTestimonialsPage_Test() {
        get(HomePage.class)
                .clickScrollDownBtn();

        get(TestimonialsPage.class)
                .verifyContentText("FOR MOOD-TRACKING")
                .verifyContentText("MOBILE & WEB APP");
    }
    @Test
    public void checkAboutPAge() {
        get(HomePage.class)
                .clickAboutBtn();
        get(AboutPage.class)
                .verifyAboutPage("ABOUT US");
    }
    @Test
    public void checkFaqPage_Test() {
        get(HomePage.class)
                .clickLoginBtn()
                .clickFaqBtn();
        get(FaqPage.class)
                .CheckPageDisplayed();
    }
    @Test
    public void loginToMyAccount_Test() {
        get(HomePage.class)
                .clickLoginBtn();
        get(Login.class)
                .EnterUserData();
        get(MyAccount.class)
                .verifyPage();
    }

    @AfterMethod
    public void post() {
        closeWebDriver();
    }
}
