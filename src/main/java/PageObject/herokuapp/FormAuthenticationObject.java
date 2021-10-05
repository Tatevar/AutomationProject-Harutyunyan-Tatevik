package PageObject.herokuapp;
import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import Patterns.User;
import Patterns.UserLogin;

public class FormAuthenticationObject extends BasePage {
    private By title = By.tagName("h2");
    private By username = By.id("username");
    private By password = By.id("password");
    private By logintBtn = By.xpath("//button[@type='submit']");
    private By errorTxt = By.id("flash-messages");

    public FormAuthenticationObject verifyPageTitle(String title) {
        Assert.assertEquals(getElementText(this.title), title);
        return this;
    }

    public FormAuthenticationObject loginToApplication(User user) {
        enter(this.username, user.username);
        enter(this.password, user.password);
        click(this.logintBtn);
        return this;
    }

    public FormAuthenticationObject loginToApp(UserLogin userLogin) {
        userLogin.setLogin("tomsmith");
        userLogin.setPassword("SuperSecretPassword");
        enter(this.username, userLogin.getLogin());
        enter(this.password, userLogin.getPassword());
        click(this.logintBtn);
        return this;

    }

    public FormAuthenticationObject checkErrorText(String expectedText) {
        Assert.assertEquals(getElementText(errorTxt), expectedText);
        return this;
    }
}
