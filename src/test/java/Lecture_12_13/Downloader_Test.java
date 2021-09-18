package Lecture_12_13;
import PageObject.herokuapp.FileDownloaderObject;
import org.testng.annotations.Test;

public class Downloader_Test {
    FileDownloaderObject fileDownloaderObject = new FileDownloaderObject();

    @Test
    public void Test() throws InterruptedException {
        fileDownloaderObject.setUpAndclick();
        fileDownloaderObject.checkFile();

    }
}
