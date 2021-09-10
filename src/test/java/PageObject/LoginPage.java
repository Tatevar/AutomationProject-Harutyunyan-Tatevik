package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private By username = By.cssSelector("[data-test=username]");
    private By password = By.cssSelector("[data-test=password]");
    private By loginBtn = By.cssSelector("[data-test=login-button]");
    private By errorTxt = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage openPage() {
        open();
        return this;
    }

    public LoginPage verifyLoginPage() {
        isDisplayed(username, password, loginBtn);
        return this;
    }

    public LoginPage loginToApplication(String username, String password) {
        enter(this.username, username);
        enter(this.password, password);
        click(this.loginBtn);
        return this;
    }

    public LoginPage checkErrorText(String expectedText) {
        Assert.assertEquals(getElementText(errorTxt), expectedText);
        return this;
    }
}