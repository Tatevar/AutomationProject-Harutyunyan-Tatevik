package PageObject.herokuapp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.testng.Assert;
public class FileDownloaderObject {

    private By downloadFile = By.xpath("//*[@id='content']/div/a[1]");
    static WebDriver driver;
    String downloadPath ="/Users/tatevar/Documents/NewProject/AutomationProject-Harutyunyan-Tatevik/DownloadFile";

    public void setUpAndclick() throws InterruptedException {

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory",downloadPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.get("http://the-internet.herokuapp.com/download");
        driver.findElement(downloadFile).click();
        Thread.sleep(2000);
    }
    public void checkFile() {
        File folder = new File(downloadPath);
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("ex03.png")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
        driver.quit();
    }
}









