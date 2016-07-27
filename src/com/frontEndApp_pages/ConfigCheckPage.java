package com.frontEndApp_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ConfigCheckPage {
private WebDriver driver;

@FindBy (id = "admin-menu")
@CacheLookup
private WebElement adminMenu;

@FindBy (css = ".active>a>span")
@CacheLookup
private WebElement configMenu;

@FindBy (css=".break.ng-binding")
@CacheLookup
private WebElement localserver;

@FindBy (css=".pull-right.label.label-default.break.ng-binding")
@CacheLookup
private WebElement localserverport;

//  Constructor
public ConfigCheckPage(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver,  this);
}

public boolean checkLocalServerPort(String sValue){
	boolean flag;
	adminMenu.click();
	configMenu.click();
	WebElement filter = driver.findElement(By.cssSelector(".form-control.ng-pristine.ng-untouched.ng-valid.ng-empty"));
	filter.sendKeys(sValue); //it doesn't require click event, search begins as you enter values
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	if ((localserverport.getText().equals("8080")) && (localserver.getText().equals("local.server.port"))){
		flag=true;
	}else{
		flag=false;
	}
	
	return flag;	
}











}