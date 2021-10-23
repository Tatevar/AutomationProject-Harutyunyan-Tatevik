package PageObject.Booking;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BookingPage {
    SelenideElement HeaderElement = $(byCssSelector(".bui-header bui-header--logo-large bui-u-hidden-print bui-header--rounded-tabs"));
    SelenideElement SearchFieldElement = $(byXpath("//input[@id='ss']"));
    SelenideElement SearchButtonElement = $(byCssSelector(".sb-searchbox__button"));
    SelenideElement FoundElement = $(byXpath("//li[@data-label='Cozy House, Dilijan, Armenia']"));

    public BookingPage CheckPageDisplayed() {
       HeaderElement.isDisplayed();
        return this;
    }
        public BookingPage enterHotelNameAndSubmit() {
            SearchFieldElement.setValue("Cozy House");
            FoundElement.click();
            SearchButtonElement.click();
            return this;
        }
    }
