package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    } // constructor

    public static WebDriver getDriver() { // method that set up the driver and returns
        if (driver == null) { // this is when we do this >> if driver is null

            //  WebDriverManager.chromedriver().setup(); // Set up Chrome driver

            String browser = ConfigurationReader.getProperty("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup(); // Set up driver
                    driver = new FirefoxDriver(); // Launch a driver
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver = new SafariDriver();
                    break;
                case "edge":
                    // TODO implement Microsoft Edge driver instantiation
                    break;
                default:
                    throw new IllegalStateException(browser + " browser does not match any case!!!");
            }

            driver.manage().window().maximize(); // Maximizes the window
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigurationReader.getProperty("implicit_wait")), TimeUnit.SECONDS); // implicit wait
        }
        return driver;
    }


    public static void quitDriver() {
        if (driver != null) { // if not null, return existing object and quit the driver.
            driver.manage().deleteAllCookies(); // to not get issues for next execution.
            driver.quit();
            driver = null; // make sure driver is null(nothing)
        }

    }
}