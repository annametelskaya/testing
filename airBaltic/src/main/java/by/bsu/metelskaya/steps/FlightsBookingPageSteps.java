package by.bsu.metelskaya.steps;

import by.bsu.metelskaya.page.FlightsBookingPage;
import org.openqa.selenium.WebDriver;

public class FlightsBookingPageSteps {
    FlightsBookingPage flightsBookingPage;

    public FlightsBookingPageSteps(WebDriver driver) {
        flightsBookingPage = new FlightsBookingPage(driver);
    }

    public void clickContinue() {
        flightsBookingPage.clickContinueButton();
    }

    public boolean checksIsErrorExist(){
        return flightsBookingPage.checkError();
    }
}
