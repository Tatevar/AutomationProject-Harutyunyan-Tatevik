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
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.cssSelector("button[id$='fleece-jacket']")).click();
        WebElement element = driver.findElement(By.xpath("(//div)[60]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        driver.findElement(By.cssSelector("button[id*='-labs-onesie']")).click();
    }
    public String getText(String element){
        WebElement webElement = driver.findElement(By.xpath("//div[text() = '" + element + "']"));
        webElement.getText();

        return element;
    }

    @Test
    public void test() throws InterruptedException {

        driver.findElement(By.xpath("//input[@Placeholder='Username']/ancestor::div[contains(@Class,'form_group')]//input")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header_secondary_container']//following::div")).isDisplayed());
        click();
        driver.findElement(By.cssSelector("a[class^=shopping_cart]")).click();

        Assert.assertEquals(getText("Sauce Labs Backpack"), "Sauce Labs Backpack");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='29.99']")).getText(), "$29.99");

        Assert.assertEquals(getText("Sauce Labs Bike Light"), "Sauce Labs Bike Light");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='9.99']")).getText(), "$9.99");

        Assert.assertEquals(getText("Sauce Labs Fleece Jacket"), "Sauce Labs Fleece Jacket");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='49.99']")).getText(), "$49.99");

        WebElement element = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Labs Bolt T-Shirt')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='15.99']")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Onesie')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='7.99']")).isDisplayed());

    }
}

