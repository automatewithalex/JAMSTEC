package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='first-name']")
    private WebElement firstNameInput;
    @FindBy(css = "[name='last-name']")
    private WebElement lastNameInput;
    @FindBy(css = "[name='email']")
    private WebElement emailInput;
    @FindBy(css = "form textarea")
    private WebElement messageInput;
    @FindBy(css = "form button")
    private WebElement submitButton;
    @FindBy(css = "form p>span")
    private WebElement feedbackMessage;

    public void fillContactForm(String firstname, String lastName, String email, String message) {
        typeFirstName(firstname);
        typeLastName(lastName);
        typeEmail(email);
        typeMessage(message);
    }

    public void typeFirstName(String firstname) {
        type(firstNameInput, firstname);
    }

    public void typeLastName(String lastName) {
        type(lastNameInput, lastName);
    }

    public void typeEmail(String email) {
        type(emailInput, email);
    }

    public void typeMessage(String message) {
        type(messageInput, message);
    }

    public void clearFirstName() {
        firstNameInput.clear();
    }

    public void clearLastName() {
        lastNameInput.clear();
    }

    public void clearEmail() {
        emailInput.clear();
    }

    public void clearMessage() {
        messageInput.clear();
    }

    public String getFirstNameTooltip() {
        return firstNameInput.getAttribute("title");
    }

    public String getLastNameTooltip() {
        return lastNameInput.getAttribute("title");
    }

    public String getEmailTooltip() {
        return emailInput.getAttribute("title");
    }

    public String getMessageTooltip() {
        return messageInput.getAttribute("title");
    }

    public String getFeedbackMessage() {
        wait.until(ExpectedConditions.visibilityOf(feedbackMessage));
        return feedbackMessage.getText();
    }

    public void submitContactForm() {
        click(submitButton);
    }

}