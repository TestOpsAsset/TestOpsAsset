package com.frontEndApp_pages;

import java.util.concurrent.TimeUnit;

//HELLOW THIS IS A COMMENT ENTERED FROM GITHUB UPDATES
//This line will replace my previous comment

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private  WebDriver driver;
	
	 @FindBy (id="username")
	 @CacheLookup 
	 private WebElement userID;
	 
	 @FindBy (id="password")
	 @CacheLookup 
	 private WebElement passwordUser;
	
	 @FindBy (xpath="//*[@id='wcm-login-container']/tbody/tr/td[1]/div/fieldset/a/img")
	// @FindBy(xpath="html/body/div[1]/div/div/div[2]/div/div[3]/form/button")
	 @CacheLookup
	 private WebElement signInButton;
	 
	 @FindBy (xpath="//*[@id=\'frm_logout\']/div[2]/div/a[2]")
	 @CacheLookup
	 private WebElement logout;
	 
	 //---Pagination
	 @FindBy (xpath="//*[@id=\"wcm-left180\"]/div[4]/ul[1]/li[1]/a")
	 @CacheLookup
	 private WebElement opordering;
	
	 @FindBy (xpath="//*[@id=\"menu-link-catalog-search\"]")
	 @CacheLookup
	 private WebElement opcatalog;
	 
	 @FindBy (xpath="/html/body")
	 @CacheLookup
	 private WebElement container;
	 

	
	//---- Constructor declaration
	public HomePage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
		
	/*
	 * Actions that will be executed using above values
	 */
	
	public String logIn(String user, String pwd){
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		
		userID.sendKeys(user);
		passwordUser.sendKeys(pwd);
		signInButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actual = "Successfully logged in";
		return actual;  
	}
	public String paginationNGO(){
		opordering.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("/html/body"));
		WebElement mainMenu2 = driver.findElement(By.xpath("/html/body/main"));
		actions.moveToElement(mainMenu).moveToElement(mainMenu2).perform();
		mainMenu2.findElement(By.linkText("//a[text()='Catalog']")).click();
		System.out.println("\"-----Passed--------------");

		
		opcatalog.click();
		System.out.println("opcatalog");
		String actual = "ordering";
		System.out.println(actual);
		return actual;
		
	}
	
	public String logOutApp(){
		logout.click();
		String actual = driver.findElement(By.xpath("//*[@id=\'messageArea\']/table/tbody/tr/td[1]/div/p")).getText();
		return actual;
		
	}
}
