package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class TestClass {

    private By duckDuckLogo = By.xpath("(//a[@aria-label='Learn about DuckDuckGo'])[2]");
    private By searchbox = By.xpath("//input[@id='searchbox_input']");
    private By searchSubmitButton = By.xpath("//button[@class='iconButton_button__A_Uiu searchbox_searchButton__LxebD']");
    private By seleniumSearchResult = By.xpath("//a[@class='eVNpHGjtxRBq_gLOfGDr LQNqh2U1kzYxREs65IJu']");


    @Test
    public void test1() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
        driver.quit();
    }


    @Test
    public void test2() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        driver.findElement(duckDuckLogo).isDisplayed();
        driver.quit();
    }

    @Test
    public void test3() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        driver.findElement(searchbox).sendKeys("Selenium WebDriver");
        driver.findElement(searchSubmitButton).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(seleniumSearchResult));
        List<WebElement> elemnts = driver.findElements(seleniumSearchResult);
        String actualLink = elemnts.get(0).getAttribute("href");;
        System.out.println("Actual Link: " + actualLink);
        String expectedLink = "https://www.selenium.dev/documentation/webdriver/";
        Assert.assertEquals(actualLink, expectedLink, "Links do not match!");
        driver.quit();
    }

}
