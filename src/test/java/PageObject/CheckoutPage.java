package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    // Constructor
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(className = "title")
    WebElement summaryTitle;

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(className = "complete-header")
    WebElement confirmationMessage;


    // Enter First Name
    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }


    // Enter Last Name
    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }


    // Enter Postal Code
    public void enterPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
    }


    // Enter Customer Details
    public void enterCustomerDetails(
            String firstName,
            String lastName,
            String postalCode) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }


    // Click Continue
    public void clickContinue() {
        continueButton.click();
    }


    // Get Order Summary Title
    public String getSummaryTitle() {
        return summaryTitle.getText();
    }


    // Click Finish
    public void clickFinish() {
        finishButton.click();
    }


    // Get Confirmation Message
    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}