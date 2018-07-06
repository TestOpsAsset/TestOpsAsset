package com.frontEndApp_pages;

import java.util.concurrent.TimeUnit;

//HELLOW THIS IS A COMMENT ENTERED FROM GITHUB UPDATES
//This line will replace my previous comment

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
//---- Constructor declaration
	public HomePage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}	
	private  WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"headerLinks\"]/div[1]/a")
	@CacheLookup
	private WebElement signIn;
	
	@FindBy(id="username")
	@CacheLookup
	private WebElement username;
	
	@FindBy(id="password")
	@CacheLookup
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"wcm-login-container\"]/tbody/tr/td[1]/div/fieldset/a/img")
	@CacheLookup
	private WebElement signInButton;
	
	@FindBy (id="logout")
	@CacheLookup
	private WebElement logOut;
	
	
	public String logIn(String user, String pwd){
		
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		//accountMenu.click();
		signIn.click();
		username.sendKeys(user);
		password.sendKeys(pwd);
		signInButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actual = driver.findElement(By.xpath("//*[@id=\"usrlogoutcurrent\"]")).getText();
		System.out.println(actual);
		return actual; 
	}
	
	public String logOutApp(){
		//accountMenu.click();
		logOut.click();
		String actual = driver.findElement(By.xpath("//*[@id=\"frm_logout\"]/div[1]/a[2]")).getText();
		return actual;
		
	}
}
