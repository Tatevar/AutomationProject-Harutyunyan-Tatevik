package Lecture_10;

import Driver.BaseTest;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductCataloguePage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static PageObject.Saucedemo.ProductPageFilter.*;

public class SortingTests extends BaseTest {
    LoginPage loginPage;
    ProductCataloguePage productCataloguePage;

    @BeforeClass
    public void initialization() {
        loginPage = new LoginPage();
        productCataloguePage = new ProductCataloguePage();
    }

    @BeforeMethod
    public void precondition() {
        loginPage.openPage();

    }

    @Test()
    public void sortFromZToA_Test() throws InterruptedException {
        loginPage
                .loginToApplication("standard_user", "secret_sauce");
       Thread.sleep(2000);
        productCataloguePage.selectOption(NAME_Z_A)
                .sortByNameZA();
    }

    @Test()
    public void sortFromAToZ_Test() {
        loginPage
                .loginToApplication("standard_user", "secret_sauce");
        productCataloguePage
                .selectOption(NAME_A_Z)
                .sortByNameAZ();

    }
    @Description("Sort the products from high to low")
    @Step("Login and go to the products page,change filter")
    @Link("https://www.saucedemo.com/inventory.html")
    @Issue("Jira-230")
    @TmsLink("jira-346")
    @Test
    public void sortPriceHigh_Test() {
        loginPage
                .loginToApplication("standard_user", "secret_sauce");
        productCataloguePage.selectOption(PRICE_H_L)
                .sortByPriceHL();
    }

    @Test()
    public void sortPriceLow_Test() {
        loginPage
                .loginToApplication("standard_user", "secret_sauce");
        productCataloguePage.selectOption(PRICE_L_H)
                .sortByPriceLH();
    }
}
