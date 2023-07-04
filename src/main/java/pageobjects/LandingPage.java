package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class = \"hidden-xs hidden-sm hidden-md\"][contains(text(), \"My Account\")]")
	WebElement myAccountDropdown;
	
	@FindBy(linkText = "Login")
	WebElement loginOption;
	
	public WebElement myAccountDropdown() {
		
		return myAccountDropdown;
	}
	
	public WebElement loginOption() {
		
		return loginOption;
	}

}
