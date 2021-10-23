package Lecture_22.steps;

import Driver.BaseTestSelenide;
import PageObject.Booking.BookingPage;
import PageObject.Booking.ResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingHomePage_Steps extends BaseTestSelenide {
    @Given("The booking page is loaded")
    public void openPage(){
        get(BookingPage.class)
                .CheckPageDisplayed();
    }
    @When("Enter Hotel Name And Click the Search Button")
    public void searchTheHotel() {
        get(BookingPage.class)
                .enterHotelNameAndSubmit();
    }
    @Then("The Hotel is displayed with the Rating Exceptional")
    public void hotelResults(){
        get(ResultPage.class)
                .CheckHotelIsDisplayed()
                .FindHotelRate();


    }
}
