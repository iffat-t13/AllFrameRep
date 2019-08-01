package academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPageObjectModel;
import pageObject.LoginpageObjectsModel;
import resources.base;

public class FullframeHomePage extends base{ //here by writing extends and calling base.java file we can use all methods under base.java file

	@Test(dataProvider="getData")
	public void pageNavigation(String Username, String Password, String test) throws IOException, InterruptedException
	{
		driver=initializebrowser(); //we are writing driver=ini.. bcz initializebrowser basically returns a driver
	driver.manage().window().maximize();
	Thread.sleep(2000);
	Actions act = new Actions(driver);

	Thread.sleep(5000);

	WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")); 

	ele.click();
	//two ways to invoke method 1. inheritance through extends 2. creating object to that class and invoke method of it
	LandingPageObjectModel lg=new LandingPageObjectModel(driver); //passing driver as argument cz we need to initiate chrome here
	lg.getLogin().click(); //we are using this method from Landingobject file.
	LoginpageObjectsModel lp= new LoginpageObjectsModel(driver);
	lp.getEmail().sendKeys(Username);
	lp.getPassword().sendKeys(Password);
	lp.Submit().click();
	System.out.println(test);
	System.out.println(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText());
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many diff data types test should run
		//columns stands for how many values for each test
		Object [][] data=new Object[2][3];  //you have to defien as Object[1][2] for one 1 row and 2 columns. Object takes total counts ; Object[total row][total column], not index.
	     data [0][0]= "iffat@gmail.com";
	     data[0][1]="test";
	     data[0][2]="write permission user";
	     
	     data[1][0]="readpermission@gmail.com";
	    data[1][1]="test";
	    data[1][2]="REad permission only";
	return data;
	}
	
	@AfterTest
	public void closebrowser()
	{
		
		driver.close();
		driver=null;  //to save or clear memory for next tests 
	}
}
