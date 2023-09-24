package frameworks.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Page_Login {
	WebDriver driver;
	
	//Segrigate Elements are objects are same
	//Specify the object/element Locators
	
	By UsernameField = By.xpath ("//input [@id='user-name']");//input [@id='user-name']
	By PasswordField = By.xpath("//input [@id='password']");;
	By LoginButton = By.xpath("//input [@id='login-button']");
	
	// Create Constructor
	public Page_Login(WebDriver driver) {
		this.driver =driver;
	}
	
	public void type_UserName(String uname) throws InterruptedException {
		// Fill Username textbox with input
		driver.findElement(UsernameField).sendKeys(uname);
		Thread.sleep(5000);
	}
	
	public void type_Password (String pwd) throws InterruptedException {
		// Fill Password textbox with input
		driver.findElement(PasswordField).sendKeys(pwd);
		Thread.sleep(5000);
	}
	
	public void click_Login() throws InterruptedException {
		// Click the login button
		driver.findElement(LoginButton).click();
		Thread.sleep(5000);
	}
}
