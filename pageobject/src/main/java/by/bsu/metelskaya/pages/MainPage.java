package by.bsu.metelskaya.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    @FindBy(xpath = "//div[@class='el-tabs__content']")
    private WebElement content;
    @FindBy(xpath = "//div[@class='departure']/div/input")
    private WebElement departureCalendar;
    @FindBy(xpath = "//div[@class='return']/div/input")
    private WebElement returnCalendar;
    @FindBy(xpath = "//td[@class='available']")
    private List<WebElement> availableDates;
    @FindBy(xpath = "//div[@focusoutforceopen='openPaxSelector']")
    private WebElement passengersSelector;
    @FindBy(xpath = "//div[@class='pax-count-input'][last()]/span[last()]")
    private WebElement plusInfant;
    @FindBy(xpath = "//ul[@class='form-errors']")
    WebElement errors;
    @FindBy(xpath = "//div[@class='btn btn-blue btn-search']")
    WebElement serchButton;

    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String tryToFindTicketWhenDepartureDateIsLaterThanReturnDate() {
        scrollToContent();
        clickSearch(1);
        chooseReturnDate(1);
        chooseDepartureDate(3);
        return errors.getText();
    }

    public String tryToFindTicketWhenNumberOfInfantsIsMoreThanAdults() {
        scrollToContent();
        clickSearch(1);
        clickToAddNewPassenger();
        addInfants(2);
        return errors.getText();
    }

    public String tryToFindWhenAllFieldsAreEmpty() {
        scrollToContent();
        clickSearch(2);
        return errors.getText();
    }

    private MainPage scrollToContent() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", content);
        return this;
    }


    private MainPage chooseDepartureDate(int numberOfDaysFromNow) {
        departureCalendar.click();
        availableDates.get(numberOfDaysFromNow - 1).click();
        return this;
    }

    private MainPage chooseReturnDate(int numberOfDaysFromNow) {
        returnCalendar.click();
        availableDates.get(numberOfDaysFromNow - 1).click();
        return this;
    }

    private MainPage clickToAddNewPassenger() {
        passengersSelector.click();
        return this;
    }

    private MainPage addInfants(int number) {
        addFewPassengers(number, plusInfant);
        return this;
    }

    private MainPage clickSearch(int number) {
        for (int i = 0; i < number; i++)
            serchButton.click();
        return this;
    }

    private void addFewPassengers(int number, WebElement element) {
        for (int i = 0; i < number; i++) {
            element.click();
        }
    }
}
