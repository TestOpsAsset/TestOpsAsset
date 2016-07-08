package com.frontEndApp_pages;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	private  WebDriver driver;
	
	
	@FindBy(id="account-menu")
	@CacheLookup
	private WebElement accountMenu;
	
	@FindBy(id="login")
	@CacheLookup
	private WebElement signIn;
	
	@FindBy(id="username")
	@CacheLookup
	private WebElement username;
	
	@FindBy(id="password")
	@CacheLookup
	private WebElement password;
	
	@FindBy(xpath="html/body/div[1]/div/div/div[2]/div/div[3]/form/button")
	@CacheLookup
	private WebElement signInButton;
	
	
	//---- Constructor declaration
	public HomePage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	// Actions that will be executed using above values
	public void logIn(String user, String pwd){
		accountMenu.click();
		signIn.click();
		username.sendKeys(user);
		password.sendKeys(pwd);
		signInButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actual = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div/div[2]/div/div")).getText();
		System.out.println(actual);
		System.out.println("--------------------------------------------");
		Assert.assertEquals("You are logged in as user \"admin\"." , actual);
	}
	
	
}
