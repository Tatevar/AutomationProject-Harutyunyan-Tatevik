package Lecture_8;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_8 {

        @Test
        public void test() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.get("file:///Users/tatevar/Documents/NewProject/AutomationProject-Harutyunyan-Tatevik/src/test/java/Lecture_8/index.html");
            driver.findElement(By.id("firstInput")).sendKeys("Armenia");;
            driver.findElement(By.id("secondInput")).sendKeys("Belarus");
            driver.findElement(By.id("firstButton")).click();
            driver.findElement(By.id("secondButton")).click();
            driver.findElement(By.className("image")).isDisplayed();
            WebElement selector = driver.findElement(By.name("cars"));
            Select select = new Select(selector);
            select.selectByIndex(1);
            WebElement selector1 = driver.findElement(By.name("cars1"));
            Select select1 = new Select(selector1);
            select1.selectByIndex(2);
            driver.findElement(By.xpath("//input[@Id='css']")).click();
            Thread.sleep(5000);
            driver.findElement(By.name("textForYou")).isDisplayed();
            driver.findElement(By.xpath("//a[@target=\"_blank\"]")).click();
             //тут не поняла как проверить , что в новой вкладке открылась страница
            driver.quit();
        }
    }

