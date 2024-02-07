package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.sql.DriverManager;
import java.util.Arrays;

public class SeleniumDriverManager {
    private static final ThreadLocal<SeleniumDriverManager> instance = ThreadLocal.withInitial(SeleniumDriverManager::new);
    private WebDriver driver;

    public static SeleniumDriverManager getInstance() {
        return instance.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void createDriver(BrowserTypes browserType, Dimension screenSize) {
        switch (browserType) {
            case CHROME: {
                createChromeDriver(screenSize);
            }
            break;
            case CHROME_H: {
                createChromeHeadlessDriver(screenSize);
            }
            break;
            case FIREFOX: {
                createFirefoxDriver(screenSize);
            }
            break;
            default: {
                throw new IllegalArgumentException("Unsupported browser type: " + browserType + ". Supported browsers are: " + Arrays.toString(BrowserTypes.values()));
            }
        }
    }

    public void createChromeDriver(Dimension screenSize) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (screenSize != null) {
            chromeOptions.addArguments("window-size=" + screenSize.width + "," + screenSize.height);
        }
        driver = new ChromeDriver(chromeOptions);
    }

    public void createChromeHeadlessDriver(Dimension screenSize) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (screenSize != null) {
            chromeOptions.addArguments("window-size=" + screenSize.width + "," + screenSize.height);
        }
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
    }

    public void createFirefoxDriver(Dimension screenSize) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (screenSize != null) {
            firefoxOptions.addArguments("window-size=" + screenSize.width + "," + screenSize.height);
        }
        driver = new FirefoxDriver(firefoxOptions);
    }

}