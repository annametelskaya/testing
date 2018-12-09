package by.bsu.metelskaya.page;

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

    public void scrollToContent() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", content);
    }

    public void chooseDepartureDate(int numberOfDaysFromNow) {
        departureCalendar.click();
        availableDates.get(numberOfDaysFromNow - 1).click();
    }

    public void chooseReturnDate(int numberOfDaysFromNow) {
        returnCalendar.click();
        availableDates.get(numberOfDaysFromNow - 1).click();
    }

    public void clickToAddNewPassenger() {
        passengersSelector.click();
    }

    public void addInfants(int number) {
        addFewPassengers(number, plusInfant);
    }

    public void clickSearch(int number) {
        for (int i = 0; i < number; i++)
            serchButton.click();
    }

    public String getError() {
        return errors.getText();
    }

    private void addFewPassengers(int number, WebElement element) {
        for (int i = 0; i < number; i++) {
            element.click();
        }
    }
}

