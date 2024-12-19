package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchResultsPage extends BasePage {

    private static final By HOTEL_TITLE = By.xpath("//*[@data-testid='title']");
    private static final By HOTEL_RATING = By.xpath("//*[@data-testid='review-score']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHotelShown(String hotelTitle) throws InterruptedException {
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

    public boolean isRatingCorrect(String hotelRating) {
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
