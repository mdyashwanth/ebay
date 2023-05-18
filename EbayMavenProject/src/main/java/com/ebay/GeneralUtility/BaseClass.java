package com.ebay.GeneralUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseClass {
public WebDriver driver;
public FileUtility fileutility = new FileUtility();
public WebDriverUtility webdriverutility = new WebDriverUtility();

@BeforeMethod
//Launch the browser(Pre-condition)
	public void configBeforeMethod()throws IOException {
		String browserName = fileutility.readDataFromPropertyFile("browser");
		if(browserName.equals("chrome")) {
		driver=new ChromeDriver();
		}else if(browserName.equals("firefox")){
			driver=new FirefoxDriver();
		}else if(browserName.equals("edge")){
		driver=new EdgeDriver();
		}	
		driver.manage().window().maximize();
		driver.get(fileutility.readDataFromPropertyFile("url"));
	}
	
@AfterMethod
//Close the browser(Post-condition)
public void configAfterMethod() {
	driver.manage().window().minimize();
  driver.quit();	
}
}
