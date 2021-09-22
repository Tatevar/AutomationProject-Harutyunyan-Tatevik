package PageObject.herokuapp;
import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FileUploaderObject extends BasePage {
    private By uploadBtn = By.id("file-upload");
    private By title = By.tagName("h3");
    private By fileSubmit = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");
    private String userDir = System.getProperty("user.dir");

    public FileUploaderObject(WebDriver driver) {
        super(driver);
    }

    public FileUploaderObject verifyPageTitle(String title) {
        Assert.assertEquals(getElementText(this.title), title);
        return this;
    }

    public FileUploaderObject uploadFile() {
        driver.findElement(uploadBtn).sendKeys(userDir + properties.getProperty("filePath"));
        return this;
    }

    public FileUploaderObject clickFileSubmit() {
        click(fileSubmit);
        return this;
    }

    public FileUploaderObject verifyThatFileUploaded(String name) {
        Assert.assertEquals(getElementText(uploadedFiles), name);
        return this;
    }
}
