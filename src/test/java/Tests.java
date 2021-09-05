import Driver.BaseTest;
import PageObject.LoginPage;
import PageObject.ProductCataloguePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    ProductCataloguePage productCataloguePage = new ProductCataloguePage(driver);

    @BeforeMethod
    public void precondition() {
        loginPage.openPage();

    }

    @Test
    public void loginToApplicationStandard_Test() {
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productCataloguePage
                .verifyProductPage()
                .AddProductToBasket()
                .OpenBasket();

    }

}
