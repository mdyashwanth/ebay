package com.ebay.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ebay.GeneralUtility.BaseClass;

public class searchProducts extends BaseClass {
	@Test
	 public void searchByFilter() {
		   webdriverutility.implicitWait(driver);
		   webdriverutility.explicitWait(driver);
		   driver.findElement(By.id("gh-ac")).sendKeys("cell phones and accessories");
		   driver.findElement(By.id("gh-btn")).click();
		   driver.findElement(By.xpath("//span[text()='Cell Phones & Smartphones']")).click();
		   driver.findElement(By.xpath("//button[@aria-label='see all - Network - opens dialog']")).click();
		   driver.findElement(By.xpath("(//span[normalize-space()='Screen Size'])[1]")).click();
		   driver.findElement(By.xpath("(//span[text()='4.0 - 4.4 in'])[2]")).click();
		   driver.findElement(By.id("c3-mainPanel-price")).click();
		   driver.findElement(By.id("c3-subPanel-_x-price-0-textrange-beginParamValue-textbox")).sendKeys("20");
		   driver.findElement(By.id("c3-subPanel-_x-price-0-textrange-endParamValue-textbox")).sendKeys("1000");
		   driver.findElement(By.xpath("//span[normalize-space()='Item Location']")).click();
		   driver.findElement(By.id("c3-subPanel-location_US%20Only-0_rbx")).click();
		   driver.findElement(By.cssSelector("button[aria-label='Apply']")).click();
		   //Filter by size Verification
		   List <WebElement> filtersApplied = driver.findElements(By.xpath("//a[@class='srp-carousel-list__item-link']"));
		   for(WebElement item : filtersApplied  ) {
			   String FilterBy = item.getText();
			   System.out.println("FilterBy :"+FilterBy);
		   }
	   }
 
	 @Test
	 public void searchProduct() {
			webdriverutility.implicitWait(driver);
			webdriverutility.explicitWait(driver);
			driver.findElement(By.id("gh-ac")).sendKeys("MackBook");
			WebElement selectOption = driver.findElement(By.id("gh-cat"));
			Select select = new Select(selectOption);
			select.selectByVisibleText("Computers/Tablets & Networking");
			driver.findElement(By.id("gh-btn")).click();
			driver.findElement(By.xpath("//span[@class='BOLD'][normalize-space()='Apple MacBook Pro 13\" | 1TB SSD 16GB RAM | YEAR WARRANTY | OSX-2019 | Excellent']"));
			if(driver.getTitle().contains("MackBook")){
				System.out.println("First result is matching with the serch result :" + driver.getTitle());
			}
			else {
				System.out.println("First result is not matching with the serch result" + driver.getTitle());
			}
		}
	}


