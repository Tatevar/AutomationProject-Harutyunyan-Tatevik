package Lecture_12_13;

import Driver.BaseTest;
import PageObject.herokuapp.DynamicControlsObject;
import PageObject.herokuapp.HomePageObject;
import TestNg.Listener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static PageObject.herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;


@Listeners({Listener.class})
public class DynamicControls_Test extends BaseTest {
    DynamicControlsObject dynamicControlsObject;
    HomePageObject homePageObject;


    @BeforeClass
    public void precondition() {
        dynamicControlsObject = new DynamicControlsObject(driver);
        homePageObject = new HomePageObject(driver);
        homePageObject.openPage();
        homePageObject.clickLink(DYNAMIC_CONTROLS);
    }

   @Test
    public void clickCheckbox_Test() {
        dynamicControlsObject
                .verifyPageTitle()
                .clickRemoveBtn()
                .verifyElementText("It's gone!");
    }
    @Test
    public void findInput_Test() {

        dynamicControlsObject
                .verifyPageTitle()
                .checkTheFieldDisabled()
                .clickEnableBtn()
                .checkTheFieldEnabled();
    }

}
