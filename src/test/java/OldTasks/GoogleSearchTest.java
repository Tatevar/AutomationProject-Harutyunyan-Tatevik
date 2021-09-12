package OldTasks;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("Hello world", Keys.ENTER);
        driver.quit();
    }

    @Test
    public void test2() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("//", Keys.ENTER);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        driver.quit();
    }

    @Test
    public void test3() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("Hello world", Keys.ENTER);
        driver.findElement(By.xpath("(//h3)[1]")).click();
        Assert.assertEquals(driver.findElement(By.tagName("span")).getText(), "History");
        driver.quit();
    }

    @Test
    public void test4() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("hello world", Keys.ENTER);
        WebElement element = driver.findElement(By.xpath("(//h3)[10]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        element.click();
        driver.quit();
    }
}
