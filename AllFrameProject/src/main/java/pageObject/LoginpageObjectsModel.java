package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginpageObjectsModel {
	
	public WebDriver driver; //declared driver object here
	
	By email=By.cssSelector("[id='user_email']"); //in POM object should be defined on top and method at bottom
	By password=By.xpath("//input[@id='user_password']");
	By loging=By.cssSelector("[type='submit']");
	public LoginpageObjectsModel(WebDriver driver) {
		
	this.driver=driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}

	 public WebElement Submit()
	 {
		return driver.findElement(loging);
		 
	 }
}
