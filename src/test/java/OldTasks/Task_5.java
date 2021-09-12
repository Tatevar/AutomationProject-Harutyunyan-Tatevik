package OldTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_5 {
    WebDriver driver = null;

    @BeforeTest
    public void preCondition() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @AfterTest
    public void postCondition() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//input[@Name = \"calc_roomwidth\"]")).clear();
        WebElement roomWidth = driver.findElement(By.xpath("//input[@Name = \"calc_roomwidth\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_roomheight\"]")).clear();
        WebElement roomHeight = driver.findElement(By.xpath("//input[@Name = \"calc_roomheight\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_lamwidth\"]")).clear();
        WebElement laminatWidth = driver.findElement(By.xpath("//input[@Name = \"calc_lamwidth\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_lamheight\"]")).clear();
        WebElement laminatHeight = driver.findElement(By.xpath("//input[@Name = \"calc_lamheight\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_inpack\"]")).clear();
        WebElement calcPack = driver.findElement(By.xpath("//input[@Name = \"calc_inpack\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_price\"]")).clear();
        WebElement laminatePrice = driver.findElement(By.xpath("//input[@Name = \"calc_price\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_bias\"]")).clear();
        WebElement rows = driver.findElement(By.xpath("//input[@Name = \"calc_bias\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_walldist\"]")).clear();
        WebElement wallDistance = driver.findElement(By.xpath("//input[@Name = \"calc_walldist\"]"));
        WebElement button = driver.findElement(By.xpath("//input[@Value = \"Рассчитать\"]"));
        WebElement selector = driver.findElement(By.xpath("//select[@Name = \"calc_direct\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selector).build().perform();
        Select select = new Select(selector);
        select.selectByIndex(0);
        roomWidth.sendKeys("12000");
        roomHeight.sendKeys("9000");
        laminatWidth.sendKeys("200");
        laminatHeight.sendKeys("100");
        calcPack.sendKeys("50");
        laminatePrice.sendKeys("6000");
        rows.sendKeys("60");
        wallDistance.sendKeys("40");
        button.click();
        Thread.sleep(5000);
        driver.findElements(By.xpath("//*[@Class=\"col-xs-12 col-sm-12 whiteback\"]")).forEach(data -> System.out.println(data.getText()));
    }

    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.xpath("//input[@Name = \"calc_roomwidth\"]")).clear();
        WebElement roomWidth = driver.findElement(By.xpath("//input[@Name = \"calc_roomwidth\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_roomheight\"]")).clear();
        WebElement roomHeight = driver.findElement(By.xpath("//input[@Name = \"calc_roomheight\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_lamwidth\"]")).clear();
        WebElement laminatWidth = driver.findElement(By.xpath("//input[@Name = \"calc_lamwidth\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_lamheight\"]")).clear();
        WebElement laminatHeight = driver.findElement(By.xpath("//input[@Name = \"calc_lamheight\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_inpack\"]")).clear();
        WebElement calcPack = driver.findElement(By.xpath("//input[@Name = \"calc_inpack\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_price\"]")).clear();
        WebElement laminatePrice = driver.findElement(By.xpath("//input[@Name = \"calc_price\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_bias\"]")).clear();
        WebElement rows = driver.findElement(By.xpath("//input[@Name = \"calc_bias\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_walldist\"]")).clear();
        WebElement wallDistance = driver.findElement(By.xpath("//input[@Name = \"calc_walldist\"]"));
        WebElement button = driver.findElement(By.xpath("//input[@Value = \"Рассчитать\"]"));
        WebElement selector = driver.findElement(By.xpath("//select[@Name = \"calc_direct\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selector).build().perform();
        Select select = new Select(selector);
        select.selectByIndex(1);
        roomWidth.sendKeys("15,000");
        roomHeight.sendKeys("10,000");
        laminatWidth.sendKeys("300");
        laminatHeight.sendKeys("400");
        calcPack.sendKeys("60");
        laminatePrice.sendKeys("5000");
        rows.sendKeys("70");
        wallDistance.sendKeys("50");
        button.click();
        Thread.sleep(5000);
        driver.findElements(By.xpath("//*[@Class=\"col-xs-12 col-sm-12 whiteback\"]")).forEach(data -> System.out.println(data.getText()));

    }

    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.xpath("//input[@Name = \"calc_roomwidth\"]")).clear();
        WebElement roomWidth = driver.findElement(By.xpath("//input[@Name = \"calc_roomwidth\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_roomheight\"]")).clear();
        WebElement roomHeight = driver.findElement(By.xpath("//input[@Name = \"calc_roomheight\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_lamwidth\"]")).clear();
        WebElement laminatWidth = driver.findElement(By.xpath("//input[@Name = \"calc_lamwidth\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_lamheight\"]")).clear();
        WebElement laminatHeight = driver.findElement(By.xpath("//input[@Name = \"calc_lamheight\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_inpack\"]")).clear();
        WebElement calcPack = driver.findElement(By.xpath("//input[@Name = \"calc_inpack\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_price\"]")).clear();
        WebElement laminatePrice = driver.findElement(By.xpath("//input[@Name = \"calc_price\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_bias\"]")).clear();
        WebElement rows = driver.findElement(By.xpath("//input[@Name = \"calc_bias\"]"));
        driver.findElement(By.xpath("//input[@Name = \"calc_walldist\"]")).clear();
        WebElement wallDistance = driver.findElement(By.xpath("//input[@Name = \"calc_walldist\"]"));
        WebElement button = driver.findElement(By.xpath("//input[@Value = \"Рассчитать\"]"));
        WebElement selector = driver.findElement(By.xpath("//select[@Name = \"calc_direct\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selector).build().perform();
        Select select = new Select(selector);
        select.selectByIndex(1);
        roomWidth.sendKeys("1000");
        roomHeight.sendKeys("1000");
        laminatWidth.sendKeys("1000");
        laminatHeight.sendKeys("1000");
        calcPack.sendKeys("6");
        laminatePrice.sendKeys("9000");
        rows.sendKeys("30");
        wallDistance.sendKeys("20");
        button.click();
        Thread.sleep(5000);
        driver.findElements(By.xpath("//*[@Class=\"col-xs-12 col-sm-12 whiteback\"]")).forEach(data -> System.out.println(data.getText()));
    }
}





/*Открыть сайт https://masterskayapola.ru/kalkulyator/laminata.html
Ввести параметры для расчета.
Нажать на кнопку ‘Рассчитать’.
Проверить полученные значения.
Закрыть окно браузера

 */