package PageObject.Moodpanda;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AboutPage {
    SelenideElement AboutContainer = $(byXpath("//*[@id=\"main\"]/div"));

    public AboutPage verifyAboutPage(String text) {
        AboutContainer.shouldBe(matchText(text));
        return this;
    }
}

