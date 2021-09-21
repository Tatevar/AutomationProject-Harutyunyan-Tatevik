package PageObject.herokuapp;
import PageObject.BasePage;
import PageObject.Saucedemo.LoginPage;
import herokuappPatterns.LoginBuilder;
import herokuappPatterns.ValueObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FormAuthenticationObject extends BasePage {
    private By title = By.tagName("h2");
    private By username = By.id("username");
    private By password = By.id("password");
    private By logintBtn = By.xpath("//button[@type='submit']");
    private By errorTxt = By.id("flash-messages");

    public FormAuthenticationObject(WebDriver driver) {
        super(driver);
    }
    public FormAuthenticationObject verifyPageTitle(String title) {
        Assert.assertEquals(getElementText(this.title), title);
        return this;
    }

    public FormAuthenticationObject loginToApplication(LoginBuilder user) {
        enter(this.username, user.username);
        enter(this.password, user.password);
        click(this.logintBtn);
        return this;
    }

    public FormAuthenticationObject loginToApp(ValueObject userLogin) {
        userLogin.setUsername("tomsmith");
        userLogin.setPassword("SuperSecretPassword");
        enter(this.username, userLogin.getUsername());
        enter(this.password, userLogin.getPassword());
        click(this.logintBtn);
        return this;

    }

    public FormAuthenticationObject checkErrorText(String expectedText) {
        Assert.assertEquals(getElementText(errorTxt), expectedText);
        return this;
    }
}
