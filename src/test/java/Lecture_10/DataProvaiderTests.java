package Lecture_10;
import Driver.BaseTest;
import Driver.DriverCreation;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductCataloguePage;
import TestNg.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(Listener.class)
public class DataProvaiderTests extends BaseTest {
    String emptyField = "";
    String username = "standard_user";
    String password = "secret_sauce";
    String incorrectData = "yeah";
    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPasswordError = "Epic sadface: Password is required";
    String incorrectDataError = "Epic sadface: Username and password do not match any user in this service";

    @DataProvider(name = "Authorization", parallel = true)
    public Object[][] signInInputData() {

        return new Object[][]{
                {username, password, ""}, //positive sign-in
                {username, incorrectData, incorrectDataError},
                {emptyField, password, emptyUsernameError},
                {username, emptyField, emptyPasswordError},
                {emptyField, emptyField, emptyUsernameError},
                {incorrectData, incorrectData, incorrectDataError},
        };
    }

    @Test(dataProvider = "Authorization")
    public void SignIn_Tests(String username, String password, String errorText) {
        WebDriver driver = DriverCreation.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        ProductCataloguePage productCataloguePage = new ProductCataloguePage(driver);
        loginPage
                .openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);
        if (errorText.isEmpty()) {
            productCataloguePage.verifyProductPage();
        } else {
            loginPage.checkErrorText(errorText);
        }
    }

    @AfterMethod
    public void post(){
        DriverCreation.quitDriver();
    }
}