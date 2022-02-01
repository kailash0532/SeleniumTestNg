package com.test.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.test.tests.ExampleTest1;

public class LandingPagePF {
	
	WebDriver driver;
	Logger LOGGER;
	
	@FindBy(xpath="//input[@name='FIRST_NAME']")
	WebElement firstName; 
	
	@FindBy(xpath="//input[@name='LAST_NAME']")
	WebElement LastName; 
	
	@FindBy(xpath="//*[text()='CONTACTS']")
	WebElement contactsLink; 
	
	@FindBy(xpath="//div[text()='General information']")
	WebElement generalInformationTitle; 
	
	
	
	public LandingPagePF(WebDriver driver,Logger log){
		this.driver=driver;
		LOGGER=log;		
		PageFactory.initElements(driver, this);
	}
	
	public void enterFormvalues(String firstName1,String lastName) {
		LOGGER.info("entered first name"+firstName1 );
		firstName.sendKeys(firstName1);			
		LOGGER.info("entered last name"+lastName);
		LastName.sendKeys(lastName);
	//	Assert.assertEquals("General informatioXX", generalInformationTitle.getText(), "Verifyig the title of the page");
		Assert.assertTrue(generalInformationTitle.getText().contains("General"));
		
		ExampleTest1.sft.assertEquals("General informatioXX", generalInformationTitle.getText(), "Verifyig the title of the page");
		
		ExampleTest1.sft.assertTrue(generalInformationTitle.getText().contains("General"), "Verifying text contains expected text or not");
		
		
		
	}
	
	public void clickOnContacts() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", contactsLink);
		contactsLink.click();
		
	}
	
	public void clickwithJavaScriptExecutor() {
		JavascriptExecutor js=(JavascriptExecutor)driver;		
		js.executeScript("arguments[0].click();", contactsLink);
	}
	
	
	public void clickElement(By by) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", contactsLink);
		driver.findElement(by).click();
	}
	

}
