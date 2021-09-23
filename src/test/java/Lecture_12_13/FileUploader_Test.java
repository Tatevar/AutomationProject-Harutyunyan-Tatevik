package Lecture_12_13;

import Driver.BaseTest;
import PageObject.herokuapp.FileUploaderObject;
import PageObject.herokuapp.HomePageLinksEnum;
import PageObject.herokuapp.HomePageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploader_Test extends BaseTest {
    HomePageObject homePageObject;
    FileUploaderObject fileUploaderObject;

    @BeforeClass
    public void precondition() {

        fileUploaderObject = new FileUploaderObject();
        homePageObject = new HomePageObject();
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
