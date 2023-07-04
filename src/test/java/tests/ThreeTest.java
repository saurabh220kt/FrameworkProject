package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {
	
	@Test
	public void testThree () throws InterruptedException, IOException {
		
		System.out.println("TestThree");
		
		WebDriver driver = intializeDriver();
		driver.get("http://www.tutorialsninja.com/demo/");
		Thread.sleep(2000);
		driver.close();

}
}
