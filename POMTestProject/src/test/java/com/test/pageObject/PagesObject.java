package com.test.pageObject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.test.pages.ContactPage;
import com.test.pages.LandingPage;
import com.test.pages.LandingPagePF;

public class PagesObject {
	
public	LandingPage landpage;
public	LandingPagePF landpagepf;
public	ContactPage contactPage;


public PagesObject(WebDriver driver,Logger log){
	landpage=new LandingPage(driver,log);
	contactPage=new ContactPage(driver);
	landpagepf=new LandingPagePF(driver,log);
}

}
