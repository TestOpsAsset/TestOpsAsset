package com.frontEndApp_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.frontEndApp_Scripts.data;

public class NewPwdPage {
	private WebDriver driver;
	
	@FindBy (id = "account-menu")
	@CacheLookup
	private WebElement accountMenu;
	
	@FindBy (linkText = "Password")
	@CacheLookup
	private WebElement pwdMenu;
	
	@FindBy (id="password")
	@CacheLookup
	private WebElement newPwd;
	
	@FindBy (id="confirmPassword")
	@CacheLookup
	private WebElement confirmPwd;
	
	@FindBy (xpath ="html/body/div[3]/div[1]/div/div/div/form/button")
	@CacheLookup
	private WebElement savebutton;	
	
	
	// Constructor
	public NewPwdPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,  this);
	}

	public void changePassword(){
		accountMenu.click();
		pwdMenu.click();
		System.out.println("--> This is change password method");
		newPwd.sendKeys(data.newpwd);
		confirmPwd.sendKeys(data.newpwd);
		savebutton.click();
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		String actual = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div/div/div[1]/strong")).getText();
		System.out.println("Actual message: " + actual);
		System.out.println("-------------------------------------");
		Assert.assertEquals(actual, "Password changed!");
		}


}
