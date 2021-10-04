package PageFactory;

import PageObject.BasePage;
import Patterns.UserLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageFact extends BasePage {

    @FindBy(css = "[data-test=username]")
    WebElement userName;

    @FindBy(css = "[data-test=error]")
    WebElement errorTxt;

    @FindBy(css = "[data-test=password]")
    WebElement password;

    @FindBy(css = "[data-test=login-button]")
    WebElement loginBtn;

    public LoginPageFact(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPageFact openPage() {
        open("https://www.saucedemo.com/");
        return this;
    }

    public LoginPageFact fillLoginFields(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginBtn.click();
        return this;
    }

    public LoginPageFact verifyLoginPage() {
        this.userName.isDisplayed();
        return this;
    }

    public LoginPageFact checkErrorText(String expectedText) {
        Assert.assertEquals(this.errorTxt.getText(), expectedText);
        return this;

    }
// value object pattern
//Chain Of Invocations
    public LoginPageFact loginToApp(UserLogin userLogin) {
        userLogin.setLogin("standard_user");
        userLogin.setPassword("secret_sauce");
        this.userName.sendKeys(userLogin.getLogin());
        this.password.sendKeys(userLogin.getPassword());
        this.loginBtn.click();
        return this;

    }
}


