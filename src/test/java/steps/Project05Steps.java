package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.Project05Page;
import utils.Driver;

public class Project05Steps {
    WebDriver driver;
    Project05Page project05Page;

    @Before
    public void setDriver(){
        driver = Driver.getDriver();
        project05Page = new Project05Page();
    }

    @Then("the user should see {string} heading")
    public void theUserShouldSeeThePaginationHeading(String heading) {
        switch (heading){
            case "Pagination":
                Assert.assertTrue(project05Page.mainHeading.isDisplayed());
                Assert.assertEquals(heading, project05Page.mainHeading.getText());
                break;
            case "World City Populations 2022":
                Assert.assertTrue(project05Page.subHeading.isDisplayed());
                Assert.assertEquals(heading, project05Page.subHeading.getText());
                break;
            default:
                throw new NotFoundException("Invalid heading!");

        }
    }

    @And("the user should see the {string} paragraph")
    public void theUserShouldSeeTheParagraph(String paragraph) {
        Assert.assertTrue(project05Page.paragraphText.isDisplayed());
        Assert.assertEquals(paragraph, project05Page.paragraphText.getText());
    }

    @Then("the user should see the {string} button is disabled")
    public void theUserShouldSeeTheButtonIsDisabled(String button) {
        switch (button){
            case "Previous":
                Assert.assertTrue(project05Page.previousButton.isDisplayed());
                Assert.assertFalse(project05Page.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(project05Page.nextButton.isDisplayed());
                Assert.assertFalse(project05Page.nextButton.isEnabled());
                break;
            default:
                throw new NotFoundException("Button is not found!");
        }
    }

    @When("the user clicks on the {string} button till it becomes disabled")
    public void theUserClicksOnTheButtonTillItBecomesDisabled(String button) {
        while (project05Page.nextButton.isEnabled()) {
            project05Page.nextButton.click();
        }
        Assert.assertFalse(project05Page.nextButton.isEnabled());
    }

    @Then("the user should see City with the info below and an image")
    public void theUserShouldSeeCityWithTheInfoBelowAndAnImage(DataTable dataTable) {
        for (int i = 0; i < dataTable.asList().size(); i++) {
            String expected = dataTable.asList().get(i);
            String actual = project05Page.pageData.get(i).getText();

            Assert.assertEquals(expected, actual);
            Assert.assertTrue(project05Page.image.isDisplayed());
        }
        project05Page.nextButton.click();
    }

}
