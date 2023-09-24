package testCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StatringTest {
  @Test
public void openChromeBrowser() {
	  
// Open Chrome Browser	  
	  WebDriverManager.chromedriver().setup();

 }
 
 @Test
 public void gotoURL () throws InterruptedException {

	 
// Setup Login to Profitable Happiness website Login with username  
	WebDriver driver = new ChromeDriver();
	driver.get("https://staging.profitablehappiness.com/signin");
	//driver.get("https://www.amazon.com");
	
	String pageTitle = driver.getTitle();
	System.out.println("Page Title  " +pageTitle);
	
	WebElement emailInput = driver.findElement(By.name("email"));
	emailInput.sendKeys("joy@9voltstudio.com");
	
	// Find the "Sign In" button by its type attribute
	WebElement signInButton = driver.findElement(By.cssSelector("button[type='Submit']"));

    // Click the "Sign In" button
    signInButton.click();
	Thread.sleep(3000);
	  
    //Click the button 'Ok, got it!
    WebElement popupButton = driver.findElement(By.xpath("//button[contains(text(),'Ok, got it!')]"));
    popupButton.click();
    
    // End of enter email to PH-----------------------------------------------------------------
    
 // Open Email and take the latest email and click the link for PH
   
    // Open a new tab	
    
	driver.switchTo().newWindow(WindowType.TAB);

	Thread.sleep(6000);
    // Switch to the new tab
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    Thread.sleep(6000);
    // Navigate to Webmail
    
    driver.get("https://webmail.dreamhost.com"); 
    
    WebElement mailInput = driver.findElement(By.name("_user"));
    mailInput.sendKeys("joy@9voltstudio.com");
    
    WebElement passwordInput = driver.findElement(By.name("_pass"));
    passwordInput.sendKeys("Africa2023!");
    
    WebElement submitButton = driver.findElement(By.id("rcmloginsubmit"));
    submitButton.click();
    
    // Now click on the latest email from PH and click the authentication link
    
    // Search for emails with a specific subject
    WebElement searchBox = driver.findElement(By.name("_q"));
    searchBox.sendKeys("Authenticate and Login!");
    searchBox.submit();
    Thread.sleep(6000); // Adding a small delay for search results to load
    
    // Get the list of search results
    // Get a list of emails matching the subject
    List<WebElement> emailList = driver.findElements(By.xpath("//span[contains(text(),'Authenticate and Login!')]/parent::a"));
    Thread.sleep(3000);
    // Click on the latest email
    if (!emailList.isEmpty()) {
        emailList.get(0).click();
        emailList.get(0).click();
      
        Thread.sleep(3000);
        
        WebElement authenticateLink = driver.findElement(By.xpath("//a[contains(text(),'Authenticate & Login')]"));
        authenticateLink.click();
    }
  }
}	
