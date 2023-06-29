package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class Project05Page {
    public Project05Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".mb-5")
    public WebElement mainHeading;

    @FindBy(id = "sub_heading")
    public WebElement subHeading;

    @FindBy(id = "content")
    public WebElement paragraphText;

    @FindBy(id = "previous")
    public WebElement previousButton;

    @FindBy(id = "next")
    public WebElement nextButton;

    @FindBy(css = "div[class*=pagBodyData]>p")
    public List<WebElement> pageData;

    @FindBy(css = ".city_image")
    public WebElement image;
}