package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPageObjectModel;
import pageObject.LoginpageObjectsModel;
import resources.base;

public class ValidationTest extends base{ //here by writing extends and calling base.java file we can use all methods under base.java file

	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	driver=initializebrowser(); //we are writing driver=ini.. bcz initializebrowser basically returns a driver
	driver.manage().window().maximize();
	log.info("Open new brower");
	}
	
		
	
	@Test
	public void pageNavigation() throws IOException
	{ 
		
	LandingPageObjectModel lg=new LandingPageObjectModel(driver); //passing driver as argument cz we need to initiate chrome here
	Assert.assertEquals(lg.getTitle().getText(), "FEATURED COURSES");
	Assert.assertTrue(lg.getNav().isDisplayed());
		
	}
	
	@AfterTest
	public void closebrowser()
	{
		
		driver.close();
	}
	
}
