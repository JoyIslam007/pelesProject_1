package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PH_FirstPage_Login {
	WebDriver driver;
	
	// Define the elements in FirstPage of Login
	By UsernameField = By.name("email"); // Email field
	By SignInButton = By.cssSelector("button[type='Submit']"); // Sign in Field
	By PopupButton = By.className("swal2-confirm"); // Popup Ok I got it! button
	By SuccessRing = By.xpath("//div[@class='swal2-success-ring']"); // Success ring
	By UnsuccessRing = By.xpath("//span[@class='swal2-x-mark']");
	
	// Create Constructor
	public PH_FirstPage_Login(WebDriver driver) {
		this.driver =driver;
	}
	
	public void type_UserName(String uname) throws InterruptedException {
		// Fill Username textbox with input
		driver.findElement(UsernameField).sendKeys(uname);
		Thread.sleep(6000);
	}
	
//	public void click_SignIn() throws InterruptedException {
//		// Click the login button
//		driver.findElement(SignInButton).click();
//		Thread.sleep(5000);
//	}
	
	public boolean click_SignIn() throws InterruptedException {
	    driver.findElement(SignInButton).click();
	    Thread.sleep(3000);
	    
	    // Check if the success ring is present
	    return driver.findElements(SuccessRing).size() > 0;
	}
	
	//public void click_popUpButton() {
	  // if  driver.findElement(PopupButton).click();

	//}
}
