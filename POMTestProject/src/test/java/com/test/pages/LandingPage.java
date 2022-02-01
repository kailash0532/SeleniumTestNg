package com.test.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	WebDriver driver;
	Logger LOGGER;
	By firstName =By.xpath("//input[@name='FIRST_NAME']");
	
	By LastName =By.xpath("//input[@name='LAST_NAME']");
	
	By contactsLink =By.xpath("//*[text()='CONTACTS']");
	
	
	public LandingPage(WebDriver driver,Logger log){
		this.driver=driver;
		LOGGER=log;
	}
	
	public void enterFormvalues(String firstName1,String lastName) {
		LOGGER.info("entered first name"+firstName1 );
		driver.findElement(firstName).sendKeys(firstName1);
		LOGGER.info("entered last name"+lastName);
		driver.findElement(LastName).sendKeys(lastName);
		
	}
	
	public void clickOnContacts() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(contactsLink));
		driver.findElement(contactsLink).click();
		
	}
	
	public void clickwithJavaScriptExecutor() {
		JavascriptExecutor js=(JavascriptExecutor)driver;		
		js.executeScript("arguments[0].click();", driver.findElement(contactsLink));
	}
	
	
	public void clickElement(By by) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(contactsLink));
		driver.findElement(by).click();
	}
	

}
