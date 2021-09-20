package Lecture_12_13;

import Driver.BaseTest;
import PageObject.herokuapp.FileUploaderObject;
import PageObject.herokuapp.HomePageLinksEnum;
import PageObject.herokuapp.HomePageObject;
import TestNg.Listener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})
public class FileUploader_Test extends BaseTest {
    HomePageObject homePageObject;
    FileUploaderObject fileUploaderObject;

    @BeforeClass
    public void precondition() {

        fileUploaderObject = new FileUploaderObject(driver);
        homePageObject = new HomePageObject(driver);
        homePageObject.openPage();
        homePageObject.clickLink(HomePageLinksEnum.FILE_UPLOADER);

    }

    @Test
    public void fileUploader_Test() {
        fileUploaderObject
                .verifyPageTitle("File Uploader")
                .uploadFile()
                .clickFileSubmit()
                .verifyPageTitle("File Uploaded!")
                .verifyThatFileUploaded("img.png");
    }
}
