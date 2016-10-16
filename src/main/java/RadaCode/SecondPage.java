package RadaCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondPage {
    private WebDriver driver;

    public SecondPage() {
        this.driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public SecondPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//span[contains(.,\"Все подряд\")]/..")
    private WebElement linkAllTopics;

    @FindBy(xpath = ".//ul[@id=\"nav-pages\"]//a[.=\"2\"]")
    private WebElement secondPage;

    public void clickSecondPage(){
        secondPage.click();
    }

    public void clickAllTopicsLink() {
        linkAllTopics.click();
    }
}