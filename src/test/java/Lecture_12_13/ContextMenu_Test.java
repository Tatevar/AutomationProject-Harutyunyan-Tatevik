package Lecture_12_13;

import Driver.BaseTest;
import PageObject.herokuapp.ContextMenuObject;
import PageObject.herokuapp.HomePageObject;
import TestNg.Listener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static PageObject.herokuapp.HomePageLinksEnum.CONTEXT_MENU;

@Listeners({Listener.class})
public class ContextMenu_Test extends BaseTest {
    ContextMenuObject contextMenuObject;
    HomePageObject homePageObject;

    @BeforeClass
    public void precondition() {
        contextMenuObject = new ContextMenuObject(driver);
        homePageObject = new HomePageObject(driver);
        homePageObject.openPage();
        homePageObject.clickLink(CONTEXT_MENU);
    }

    @Test
    public void contextMenuObject_Test() {

        contextMenuObject
                .verifyPageTitle()
                .verifyAlertText();
    }

}
