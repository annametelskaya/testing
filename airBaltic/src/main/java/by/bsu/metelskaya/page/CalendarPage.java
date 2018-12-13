package by.bsu.metelskaya.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarPage {
    @FindBy(xpath = "//div[@class='item']/button[@class='btn btn-next button-green btn-continue-booking']")
    private WebElement continueButton;

    private WebDriver driver;
    private WebDriverWait wait;


    public CalendarPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickContinueButton() {
        checkVisibility(continueButton).click();
    }

    private WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
