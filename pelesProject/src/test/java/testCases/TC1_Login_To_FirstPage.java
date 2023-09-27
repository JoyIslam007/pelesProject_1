package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.pageObjectModel.Page_Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.PH_FirstPage_Login;

public class TC1_Login_To_FirstPage {
	// global
	static WebDriver driver;
	static PH_FirstPage_Login login;
	
  @Test
  public void verify_FirstPage_Login () throws InterruptedException {
	  // Launch Chrome Browser
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
	  // GoTo TestURL: https://www.saucedemo.com/
	  driver.get("https://staging.profitablehappiness.com/signin");
	  Thread.sleep(5000);
	  login =new PH_FirstPage_Login(driver);
	  
	  // Fill the username text box with input
	  login.type_UserName("joy@9voltstudio.com");
	  
	  // Click the SignIn
	  // login.click_SignIn();
	  Thread.sleep(5000);
	  boolean isSuccess = login.click_SignIn();

      // Assert if the sign-in was successful
      Assert.assertTrue(isSuccess, "Sign-in was not successful");
	  Thread.sleep(5000);
      
      //login.click_popUpButton();

	  // Close Browser
	  driver.close();
	  
  }
}
