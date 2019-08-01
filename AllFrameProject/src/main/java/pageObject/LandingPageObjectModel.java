package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObjectModel {
	
	public WebDriver driver; //declared driver object here
	
	By signin=By.cssSelector("a[href*='sign_in']"); //in POM object should be defined on top and method at bottom
	By title=By.xpath("//*[text()='Featured Courses']");
	By navbar=By.cssSelector("[class='nav navbar-nav navbar-right']");
	
	
	public LandingPageObjectModel(WebDriver driver) {
		
	this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNav()
	{
		return driver.findElement(navbar);
	}
}
