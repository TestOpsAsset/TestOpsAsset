package com.frontEndNGO_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CatalogSearchPage {
	public WebDriver driver;
	
	 @FindBy (xpath ="//*[@id=\'wcm-left180\']/div[3]/div[1]/form/p/input")
	 @CacheLookup 
	 private WebElement searchBox;
	 
	 @FindBy (xpath = "//*[@id=\'wcm-left180\']/div[3]/div[1]/form/p/a/img")
	 @CacheLookup 
	 private WebElement passwordUser;
	 
	

}
