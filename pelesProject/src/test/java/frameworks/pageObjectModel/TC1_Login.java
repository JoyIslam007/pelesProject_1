package frameworks.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC1_Login {
	// global
	static WebDriver driver;
	static Page_Login login;
	
  @Test
  public void verifySDLogin() throws InterruptedException {
	  // TC:1 Launch Chrome Browser
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
	  // TC:2 GoTo TestURL: https://www.saucedemo.com/
	  driver.get("https://www.saucedemo.com/");
	  Thread.sleep(5000);
	  login =new Page_Login(driver);
	  
	  // Fill the username text box with input
	  login.type_UserName("standard_user");
	  // Fill the password
	  login.type_Password("secret_sauce");
	  // Click the login button
	  login.click_Login();
	  
	  // TC:3 Verify the Selenium Page
	  String actualURL= driver.getCurrentUrl();
	  String expectedURL = "https//www.saucedemo.com/inventory.html";
	  
	  Assert.assertEquals(actualURL, expectedURL);
	  
	  Thread.sleep(5000);
	  
	  // Close Browser
	  driver.close();
	  
  }
}