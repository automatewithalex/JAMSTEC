package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import selenium.SeleniumDriverManager;

public class HomePageSteps {

    WebDriver driver = SeleniumDriverManager.getInstance().getDriver();

    @Given("I am on the {string} page of AutomateWithAlex.com")
    public void iAmOnThePageOfAutomateWithAlexCom(String page) {
        HomePage homePage = new HomePage(driver);
        switch (page.toLowerCase()) {
            case "home" -> homePage.navigateTo("https://www.automatewithalex.com/");
            default -> throw new IllegalArgumentException("Page '" + page + "' not recognized");
        }
    }

    @When("I fill in the {string} field with {string}")
    public void iFillInTheFieldWith(String field, String value) {
        HomePage homePage = new HomePage(driver);
        switch (field.toLowerCase()) {
            case "first name" -> homePage.typeFirstName(value);
            case "last name" -> homePage.typeLastName(value);
            case "email" -> homePage.typeEmail(value);
            case "message" -> homePage.typeMessage(value);
            default -> throw new IllegalArgumentException("Field '" + field + "' not recognized");
        }
    }

    @And("I click the {string} button")
    public void iClickTheButton(String button) {
        HomePage homePage = new HomePage(driver);
        switch (button.toLowerCase()) {
            case "submit" -> homePage.submitContactForm();
            default -> throw new IllegalArgumentException("Button '" + button + "' not recognized");
        }
    }

    @Then("I should see a confirmation message indicating my message was sent successfully")
    public void iShouldSeeAConfirmationMessageIndicatingMyMessageWasSentSuccessfully() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getFeedbackMessage(), "Thanks for submitting!");
    }

    @And("I leave the {string} field empty")
    public void iLeaveTheFieldEmpty(String field) {
        HomePage homePage = new HomePage(driver);
        switch (field.toLowerCase()) {
            case "first name" -> homePage.clearFirstName();
            case "last name" -> homePage.clearLastName();
            case "email" -> homePage.clearEmail();
            case "message" -> homePage.clearMessage();
            default -> throw new IllegalArgumentException("Field '" + field + "' not recognized");
        }
    }

    @Then("I should see an error message indicating the {string} field is required")
    public void iShouldSeeAnErrorMessageIndicatingTheFieldIsRequired(String field) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        switch (field.toLowerCase()) {
            case "first name" -> Assert.assertEquals(homePage.getFirstNameTooltip(), "Please fill out this field.");
            case "last name" -> Assert.assertEquals(homePage.getLastNameTooltip(), "Please fill out this field.");
            case "email" -> Assert.assertEquals(homePage.getEmailTooltip(), "Please fill out this field.");
            case "message" -> Assert.assertEquals(homePage.getMessageTooltip(), "Please fill out this field.");
            default -> throw new IllegalArgumentException("Field '" + field + "' not recognized");
        }
    }

    @Then("I should see an error message indicating the email address is invalid")
    public void iShouldSeeAnErrorMessageIndicatingTheEmailAddressIsInvalid() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getEmailTooltip(), "Please enter a valid email address.");
    }

}