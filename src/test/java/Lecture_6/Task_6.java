package Lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_6 {
    WebDriver driver = null;

    @BeforeTest
    public void preCondition() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @AfterTest
    public void postCondition() {
        driver.quit();
    }


    public void click() {
        driver.findElement(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-bike-light')]")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack' and @name='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']//parent::div")).click();
        driver.findElement(By.cssSelector("button[id$='fleece-jacket']")).click();
        WebElement element = driver.findElement(By.xpath("(//div)[60]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        driver.findElement(By.cssSelector("button[id*='-labs-onesie']")).click();
    }


    @Test
    public void test() {
        driver.findElement(By.xpath("//input[@placeholder=\"Username\"]/ancestor::div[contains(@class,\"form_group\")]//input")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header_secondary_container']//following::div")).isDisplayed());
        click();
        driver.findElement(By.cssSelector("a[class^=shopping_cart]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText(), "Sauce Labs Backpack");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='29.99']")).getText(), "$29.99");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText(), "Sauce Labs Backpack");
    }
}

