package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import static PageObject.herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;

public class DynamicControlsObject extends BasePage {
    private By removeBtn = By.cssSelector("#checkbox-example>button");
    private By textBack = By.cssSelector("#checkbox-example>p");
    private By title = By.tagName("h4");
    private By input = By.cssSelector("#input-example>input");
    private By enableBtn = By.cssSelector(" #input-example>button");

    public DynamicControlsObject verifyPageTitle() {
        Assert.assertEquals(getElementText(title), DYNAMIC_CONTROLS.getLinkText());
        return this;
    }

    public DynamicControlsObject clickRemoveBtn() {
        click(removeBtn);
        return this;
    }

    public DynamicControlsObject verifyElementText(String text) {
        wait.until(ExpectedConditions.textToBe(textBack, text));
        return this;
    }

    public DynamicControlsObject clickEnableBtn() {
        click(enableBtn);
        return this;
    }

    public DynamicControlsObject checkTheFieldEnabled() {
        driver.findElement(input).click();
        return this;
    }

    public DynamicControlsObject checkTheFieldDisabled() {
        if (driver.findElement(input).isEnabled())
            System.out.println("The field is enabled");
        else
            System.out.println("The field is Disabled");
        return this;
    }
}