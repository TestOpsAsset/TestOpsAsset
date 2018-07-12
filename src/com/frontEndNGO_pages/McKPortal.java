package com.frontEndNGO_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class McKPortal {
	
	public WebDriver driver;
	
	 @FindBy (id="username")
	 @CacheLookup 
	 private WebElement userID;
	 
	 @FindBy (id="password")
	 @CacheLookup 
	 private WebElement passwordUser;
	 
		//--- Constructor Declaration -> this will be used by ngoMainProcess
		public McKPortal (WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		//-- Actions that will be executed using above WebElements
		
	
	 
}
