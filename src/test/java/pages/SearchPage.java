package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private static final By SEARCH_INPUT = By.xpath("//input[@name = 'ss']");
    private static final By SEARCH_BUTTON = By.cssSelector("button[type=submit]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }

    public void searchFor(String keyword) throws InterruptedException {
        driver.findElement(SEARCH_INPUT).sendKeys(keyword);
        waitForPageLoaded();
        driver.findElement(SEARCH_BUTTON).click();
        waitForPageLoaded();
    }

}
