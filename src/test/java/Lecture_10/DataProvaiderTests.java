package Lecture_10;

import Driver.BaseTest;
import PageObject.LoginPage;
import PageObject.ProductCataloguePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Driver.DriverCreation.quitDriver;

public class DataProvaiderTests extends BaseTest {
    LoginPage loginPage;
    ProductCataloguePage productCataloguePage ;
    String emptyField = "";
    String username = "standard_user";
    String password = "secret_sauce";
    String incorrectData = "yeah";
    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPasswordError = "Epic sadface: Password is required";
    String incorrectDataError = "Epic sadface: Username and password do not match any user in this service";

    @BeforeClass
    public void pre() {
        loginPage = new LoginPage(driver);
        productCataloguePage = new ProductCataloguePage(driver);
    }

@DataProvider(name = "Authorization",parallel = true)
public Object [][] signInInputData() {

    return new Object[][]{
            {username,password}, //positive sign-in
            {username,incorrectData,incorrectDataError},
            {emptyField,password,emptyUsernameError},
            {username,emptyField,emptyPasswordError},
            {emptyField,emptyField,emptyUsernameError},
            {incorrectData,incorrectData,incorrectDataError},
    };
    }
    @Test(dataProvider = "Authorization")
    public void SignIn_Tests(String username, String password,String errorText) {
        loginPage
                .openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);
        if (errorText.isEmpty()) {
            productCataloguePage.verifyProductPage();
        } else {
            loginPage.checkErrorText(errorText);
        }
        quitDriver();
    }
}
