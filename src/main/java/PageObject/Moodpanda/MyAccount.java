package PageObject.Moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MyAccount {
    SelenideElement myAccount = $(By.cssSelector(".container .navbar-header"));

    public  MyAccount verifyPage(){
        myAccount.shouldBe(Condition.matchText("Me\n" +
                " Account"));
        return this;
    }
}
