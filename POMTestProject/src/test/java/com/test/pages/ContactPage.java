package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {
WebDriver driver;
	
	By name =By.xpath("//input[@name='user_name']");
	
	By email =By.xpath("//input[@name='user_email']");
	
	
	public ContactPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void enterFormvalues() {
		
		driver.findElement(name).sendKeys("Test");
		driver.findElement(email).sendKeys("Test2");
	}
	
}
