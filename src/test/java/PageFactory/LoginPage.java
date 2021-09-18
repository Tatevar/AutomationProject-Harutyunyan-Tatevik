package PageFactory;

import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    @FindBy(css = "[data-test=username]")
    WebElement userName;

    @FindBy(css = "[data-test=password]")
    WebElement password;

    @FindBy(css = "[data-test=login-button]")
    WebElement loginBtn;

    @FindBy(how = How.ID, using = "test")
    WebElement webElement;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, LoginPage.class);
    }

    public LoginPage openPage() {
        loginBtn.click();
        open("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage fillAuthFields(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginBtn.click();
        return this;
    }
}


