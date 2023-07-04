package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	
	
	Logger log;
	public WebDriver driver;
	
	@Test(dataProvider="getLoginData")
	public void login(String email, String password, String expectedResult) throws IOException, InterruptedException { 
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on my account dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		log.debug("Email address got entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on login button");
		
		AccountPage accountPage = new AccountPage(driver);
		
		String actualResult = null;
		
		try {
			if(accountPage.editAccountInformationOption().isDisplayed()) {
			actualResult = "Successful";
			log.debug("User got logged in");
			}
		}catch(Exception e) {
		
		actualResult = "Failure";
		log.debug("User didn't logged in");
		}

	Assert.assertEquals(actualResult,expectedResult);
	log.debug("Login test got passed");
	}		
	
	@BeforeMethod
	public void openApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = intializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}
	
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
	}
	@DataProvider
	public Object[][] getLoginData() {
		
	Object[][] data = {{"sask7887@yahoo.com","Baba@123*","Successful"},{"dummy@test.com","Nast78","Failure"}};
	
	return data;
	}

}
