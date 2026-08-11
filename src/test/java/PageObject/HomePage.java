package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage (WebDriver driver) {
		super(driver);
	}
   
	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement msgHeading;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement clickMenu;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement lnkLougout;
	
	public boolean isHomePageExists() {
		try {
			return (msgHeading.isDisplayed());
		}catch(Exception e){
			return false;
		}
	}
	
	public void clickSidebar() {
		clickMenu.click();
	}
	
	
	public void clickLogout()
	{
		lnkLougout.click();
	}
	
}
