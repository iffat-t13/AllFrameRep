package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.surefire.shade.common.org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public static WebDriver driver; //we are declaring public driver object so that it can be reused inside any method in the entire tc. we dont need to write it again and again. Also so it can be accessed from other tc class files
	public Properties prop;
	public WebDriver initializebrowser () throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\iffat\\AllFrameProject\\src\\main\\java\\resources\\datadriven.properties");
	
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);
	
	
	if (browserName.equals("chrome")) //(browserName=="chrome") this code initially failed because you cant use == when you are extracting values from properties file
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumstuff\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumstuff\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
	String urlpath=prop.getProperty("url");
	driver.get(urlpath);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver; //we initialize timer object and then returning it to driver object so that everytime driver object is used timeout is used too 
	}
	//take screenshot
	public void getScreenshot(String result) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\iffat\\AllFrameProject\\"+result+ "System.currentTimeMillis()+.png")); //result isnt in "" cz thts a variable
	
	}
	
	}


