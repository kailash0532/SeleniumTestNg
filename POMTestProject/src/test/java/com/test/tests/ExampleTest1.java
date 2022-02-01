package com.test.tests;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.pageObject.PagesObject;
import com.test.utils.ExcelReader;
@Test(groups = "Regression")
public class ExampleTest1 {
	public  static WebDriver driver;
	PagesObject pageobject;	
	 Logger LOGGER = LogManager.getLogger(ExampleTest1.class.getName());
	 
	public static SoftAssert sft=new  SoftAssert();
	 @BeforeSuite
	 public void beforeSuite() {
		 System.out.println("beforeSuite will be executed Every Suite");
	 }
	 
	 @BeforeMethod
	 public void beforeMethod() {
		 System.out.println("before method will be executed before every @Test method");
	 }
	 
	 
	 @BeforeClass
	 public void beforeClass() {
		 System.out.println("before class will be executed before every class");
	 }
	 @BeforeGroups
	 public void beforeGroup() {
		 driver=new ChromeDriver();
	 }
	 
	 
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browser) {
		
		
		LOGGER.info("browser Name  *******"+browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
		 ChromeOptions option=new ChromeOptions();
		  option.addArguments("--start-maximized");
		  driver=new ChromeDriver(option);
		
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("Fire fox browser");
			FirefoxOptions option=new FirefoxOptions();
			  option.addArguments("start-maximized");
			driver=new FirefoxDriver();
		}
		
		pageobject=new PagesObject(driver,LOGGER);
	}
	
	
	@DataProvider(name="getDetails")
	  public static Object[][] getData() throws Exception {
		 
				 return ExcelReader.getTableArray("F:\\SeleniumandJavaProjects\\POMTestProject\\src\\test\\java\\com\\test\\TestData\\TestData.xlsx", "LandingPage");		

	  }
	
	
	
  @Test
  public void sampletesting1() throws InterruptedException {
	  
	  String url="https://www.utmn.ru/en/study-with-us/admission/apply-now/";	 
	  
	    LOGGER.info("Started the Test");  	  
		
	   
	  		driver.navigate().to(url);	  		
	  		pageobject.landpagepf.enterFormvalues("Name1","Name2");	
	  //		pageobject.landpage.clickOnContacts();	
	  		By contactsLink =By.xpath("//*[text()='CONTACTS']");
	  		pageobject.landpagepf.clickElement(contactsLink);
	  		
	  		pageobject.contactPage.enterFormvalues();	
	  		
	  		LOGGER.info("Ended the Test"); 
	  		sft.assertAll();
	  		
	  
  }
  
	
	  @Test(dataProvider = "getDetails") 
	  public void sampletesting2(String
	  firstName,String lastName) throws InterruptedException {
	  
	  String url="https://www.utmn.ru/en/study-with-us/admission/apply-now/";
	  
	  LOGGER.info("Started the Test");
	  
	  System.out.println("**********"+firstName);
	  System.out.println("**********"+lastName);
	  
	  driver.navigate().to(url);
	  pageobject.landpagepf.enterFormvalues(firstName,lastName); //
	  pageobject.landpage.clickOnContacts(); By contactsLink
	  =By.xpath("//*[text()='CONTACTS']");
	  pageobject.landpagepf.clickElement(contactsLink);
	  
	  pageobject.contactPage.enterFormvalues();
	  
	  LOGGER.info("Ended the Test");
	  
	  
	  
	  }
		
		 
	 @AfterTest
	public void quitBrowser() {
		 driver.quit();
	 }
	
  
  
}
