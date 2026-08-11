package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//locator
	
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement txtUsername;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement btnLogin;
	
	
	//Action
	
	public void enterUsername(String username) {
		txtUsername.sendKeys(username);
	}
	
    public void enterPassword(String pass) {
    	txtPassword.sendKeys(pass);
	}
    
    public void clickLogin() {
		btnLogin.click();
	}

}
