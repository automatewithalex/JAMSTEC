package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Dimension;
import org.testng.Reporter;
import selenium.BrowserTypes;
import selenium.SeleniumDriverManager;

import java.time.Duration;

public class Hooks {

    public String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");
    public String WAIT = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT");
    public String WIDTH = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WIDTH");
    public String HEIGHT = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("HEIGHT");

    @Before
    public void setup() {
        SeleniumDriverManager.getInstance().createDriver(BrowserTypes.valueOf(BROWSER.toUpperCase()), new Dimension(Integer.parseInt(WIDTH), Integer.parseInt(HEIGHT)));
        SeleniumDriverManager.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(WAIT)));
    }

    @After
    public void tearDown() {
        SeleniumDriverManager.getInstance().quitDriver();
    }

}