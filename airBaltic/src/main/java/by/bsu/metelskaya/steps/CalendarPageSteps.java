package by.bsu.metelskaya.steps;

import by.bsu.metelskaya.page.CalendarPage;
import org.openqa.selenium.WebDriver;

public class CalendarPageSteps {
    CalendarPage calendarPage;

    public CalendarPageSteps(WebDriver driver) {
        calendarPage = new CalendarPage(driver);
    }

    public void clickContinue(){
        calendarPage.clickContinueButton();
    }
}
