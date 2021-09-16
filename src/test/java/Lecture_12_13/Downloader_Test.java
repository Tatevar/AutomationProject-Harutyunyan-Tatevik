package Lecture_12_13;

import Driver.BaseTest;
import PageObject.herokuapp.ContextMenuObject;
import PageObject.herokuapp.FileDownloader;
import PageObject.herokuapp.HomePageObject;
import TestNg.Listener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static PageObject.herokuapp.HomePageLinksEnum.FILEDOWNLOAD;

@Listeners({Listener.class})
public class Downloader_Test extends BaseTest {
    FileDownloader fileDownloader;
    HomePageObject homePageObject;

    @BeforeClass
    public void precondition() {
        fileDownloader = new FileDownloader(driver);
        homePageObject = new HomePageObject(driver);
        homePageObject.openPage();
        homePageObject.clickLink(FILEDOWNLOAD);
    }
    @Test
    public void Test(){
        fileDownloader.setUp();
        fileDownloader.fileClick();
        fileDownloader.checkFile();

    }
}
