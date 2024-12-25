package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.SearchPage;

import java.time.Duration;

public class SearchStep {
    WebDriver driver;
    SearchPage searchPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchPage = new SearchPage(driver);
    }

    @Given("booking search page is opened")
    public void bookingSearchPageIsOpened() {
        searchPage.open();
    }

    @When("user performs search by {string}")
    public void userPerformsSearchBy(String hotel) throws InterruptedException {
        searchPage.search(hotel);
    }

    @Then("{string} hotel is shown")
    public void hotelIsShown(String hotelName) throws InterruptedException {
        boolean result = searchPage.isHotelShown(hotelName);
        Assert.assertTrue(result, "There is no hotel with such title in the list");
    }

    @And("hotel has rating {string}")
    public void hotelHasRating(String hotelRating) throws InterruptedException {
        boolean result = searchPage.isRatingCorrect(hotelRating);
        Assert.assertTrue(result, "The rating is incorrect");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
