package PageObject.Booking;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ResultPage {
    SelenideElement SearchRate = $(byXpath("//*[@id=\"search_results_table\"]"));

     public ResultPage FindHotelRate(){
         SearchRate.shouldBe(matchText("Exceptional"));
         return this;
     }
    public ResultPage CheckHotelIsDisplayed() {
        $(byText("Cozy House"));
        return this;
    }

}
