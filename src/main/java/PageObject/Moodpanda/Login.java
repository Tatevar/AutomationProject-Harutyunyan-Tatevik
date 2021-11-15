package PageObject.Moodpanda;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class Login {
    SelenideElement email = $(byXpath("//*[@name='ctl00$ContentPlaceHolderContent$TextBoxEmail']"));
    SelenideElement password = $(byXpath("//*[@name='ctl00$ContentPlaceHolderContent$TextBoxPassword']"));
    SelenideElement loginForm = $(byXpath("//*[@id='UpdateMoodWelcome']/div"));

    public Login EnterUserData() {
      loginForm.should(matchText("Login to MoodPanda"));
      email.setValue("tatevar93@gmail.com");
      password.setValue("tatevar55").pressEnter();
        return this;
    }
}

