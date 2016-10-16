package RadaCode;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Run {
    WebDriver driver;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "D:\\Job\\Testing\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void googlePageTesting() {
        RadaСode.FirstPage google = new RadaСode.FirstPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("hplogo")));
        Assert.assertEquals("Google", google.getLogo());

        google.setSearchBar("habrahabr");

        ThirdPage results = new ThirdPage(driver);
        results.clickOnLink();

        SecondPage habr = new SecondPage(driver);
        Assert.assertEquals("Хабрахабр", results.getTextToAssert());
        habr.clickAllTopicsLink();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//ul[@id=\"nav-pages\"]//a[.=\"2\"]")));
        habr.clickSecondPage();
    }
}