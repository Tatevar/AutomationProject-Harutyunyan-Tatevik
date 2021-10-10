package PageObject.Moodpanda;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class FaqPage {
    SelenideElement FaqPageElement = $(byXpath("//*[@id='main']/div")).shouldHave(text("FAQS"));

    public FaqPage CheckPageDisplayed() {
        Assert.assertEquals( FaqPageElement.getText(),"FAQS\n" +
                "Some of our frequently asked questions");
        return this;
    }
}