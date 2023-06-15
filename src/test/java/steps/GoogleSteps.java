package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.GoogleSearchPage;
import utils.Driver;


public class GoogleSteps {
    WebDriver driver; // declaration
    GoogleSearchPage googleSearchPage;

    @Before // instantiation (runs each Scenario)
    public void setDriver() {
        driver = Driver.getDriver();
        googleSearchPage = new GoogleSearchPage();
    }

    @When("user search for {string}")
    public void userSearchFor(String input) {
        googleSearchPage.searchInputBox.sendKeys(input + Keys.ENTER);
    }
}
