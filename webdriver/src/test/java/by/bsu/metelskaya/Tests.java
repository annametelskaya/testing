package by.bsu.metelskaya;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {
    WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.airbaltic.com/en-BY/index");
    }

    @Test
    public void findTicketWhenThereAreBlankFields() {
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='btn btn-blue btn-search']/button"));
        submitButton(2, searchButton);
        String realError = driver.findElement(By.xpath("//ul[@class='form-errors']")).getText();
        String expectedError = "Please select the departure date.\n" +
                "Please select the return date.\n" +
                "Please select the destination of your journey.\n" +
                "Please select the origin of your journey.";
        Assert.assertEquals(realError, expectedError);
    }

    @After
    public void close() {
        driver.close();
    }

    private void submitButton(int numberOfClick, WebElement button) {
        for (int i = 0; i < numberOfClick; i++) {
            button.submit();
        }
    }
}
