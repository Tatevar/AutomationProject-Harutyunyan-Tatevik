package PageObject.herokuapp;

import Driver.BaseTest;
import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FileDownloader extends BasePage {

    private By downloadFile = By.xpath("//*[@id='content']/div/a[1]");

    public FileDownloader(WebDriver driver) {
        super(driver);
    }

    public FileDownloader fileClick() {
        click(downloadFile);
        return this;
    }

    public void setUp() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        pause(3);

    }

    public void checkFile() {
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("testUpload.json")) {
                    f = new File(fileName);
                    found = true;
                }
                pause(3);
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
    }
}









