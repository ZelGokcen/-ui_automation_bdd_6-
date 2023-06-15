package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class GoogleSearchPage { // P O M Page Object Model

    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "q")
    public WebElement searchInputBox;   // Page locate the WebElement

}

