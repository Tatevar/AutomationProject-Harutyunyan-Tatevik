package Lecture_12_13;

import Driver.BaseTest;
import PageObject.herokuapp.HomePageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage_Test extends BaseTest {
    HomePageObject homePageObject;

    @BeforeClass
    public void precondition() {
        homePageObject = new HomePageObject();
    }


    @Test
    public void verifyHomePageObject_Test() {
        homePageObject.openPage().verifyHomePage();
    }
}
