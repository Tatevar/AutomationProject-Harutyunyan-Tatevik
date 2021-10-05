package Lecture_12_13;

import Driver.BaseTest;
import PageObject.herokuapp.ContextMenuObject;
import PageObject.herokuapp.HomePageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.herokuapp.HomePageLinksEnum.CONTEXT_MENU;

public class ContextMenu_Test extends BaseTest {
    ContextMenuObject contextMenuObject;
    HomePageObject homePageObject;

    @BeforeClass
    public void precondition() {
        contextMenuObject = new ContextMenuObject();
        homePageObject = new HomePageObject();
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
