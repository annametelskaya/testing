package by.bsu.metelskaya.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsBookingPage {
    @FindBy(xpath = "//div[@class='login login-guest clearfix']/div[@class='bottom-nav']/button")
    private WebElement continueButton;

    private WebDriver driver;
    private WebDriverWait wait;


    public FlightsBookingPage(WebDriver driver) {
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
