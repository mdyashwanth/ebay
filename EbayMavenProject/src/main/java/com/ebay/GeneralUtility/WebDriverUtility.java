package com.ebay.GeneralUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility extends BaseClass {
	/*
	 * this method will supply time for every invocation of search context
	 * @author Yashwanth MD 
	 * @param driver
	 */
public void implicitWait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
public void explicitWait(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
}
}
