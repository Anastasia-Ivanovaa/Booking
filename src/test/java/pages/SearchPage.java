package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchPage extends BasePage {

    private static final By SEARCH_INPUT = By.xpath("//input[@name = 'ss']");
    private static final By SEARCH_BUTTON = By.cssSelector("button[type=submit]");
    private static final By HOTEL_TITLE = By.xpath("//*[@data-testid='title']");
    private static final By HOTEL_RATING = By.xpath("//div[@data-testid='review-score']/div[1]/div");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }

    public void search(String hotel) throws InterruptedException {
        sleep(5000);
        driver.findElement(SEARCH_INPUT).sendKeys(hotel);
        sleep(5000);
        driver.findElement(SEARCH_BUTTON).click();
    }

    public boolean isHotelShown(String hotelTitle) throws InterruptedException {
        sleep(5000);
        waitForPageLoaded();
        List<WebElement> hotelTitles = driver.findElements(HOTEL_TITLE);
        boolean isHotelFound = false;
        for (WebElement title : hotelTitles) {
            if (title.getText().equals(hotelTitle)) {
                isHotelFound = true;
                break;
            }
        }
        return isHotelFound;
    }

    public boolean isRatingCorrect(String hotelRating) throws InterruptedException {
        sleep(5000);
        waitForPageLoaded();
        List<WebElement> hotelRatings = driver.findElements(HOTEL_RATING);
        boolean isRatingMatched = false;
        for (WebElement rating : hotelRatings) {
            if (rating.getText().equals(hotelRating)) {
                isRatingMatched = true;
                break;
            }
        }
        return isRatingMatched;
    }
}
