package com.frontEndApp_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListofUsersPage {
	WebDriver driver;


	@FindBy(id="admin-menu")
	@CacheLookup
	private WebElement adminMenu;
	
	@FindBy (xpath="html/body/div[2]/nav/div/div[2]/ul/li[4]/ul/li[1]/a/span[2]")
	@CacheLookup
	private WebElement usersMenu;
	
	
	// -- CONSTRUCTOR ----------------------------------
	public ListofUsersPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// -- Execution Method, this will be called by MainProcess class
	public Boolean createListofUsers(){
		Boolean actual = false;
		
		adminMenu.click();
		usersMenu.click();
		
		System.out.println("-- List of users process has started");
		System.out.println("");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		int i=1;
		String userStatus= null, login="", email="";
		String spanpath = "/html/body/div[3]/div[1]/div/div[2]/table/tbody/tr[";
		String loginpath ="/html/body/div[3]/div[1]/div/div[2]/table/tbody/tr[";
		String emailpath = "/html/body/div[3]/div[1]/div/div[2]/table/tbody/tr[";
		
		System.out.println(" This is the list of User and their information");
		try{				 
			do{	
				userStatus = driver.findElement(By.xpath(spanpath + i + "]/td[4]/span[1]")).getAttribute("aria-hidden");// Getting the user status (Activated/Deactivated)
				login = driver.findElement(By.xpath(loginpath + i +"]/td[2]")).getText();								// Getting login value from table
				email = driver.findElement(By.xpath(emailpath + i +"]/td[3]")).getText();								// Getting email value from table
				if (userStatus.equals("true")){ 																		//Validating userStatus value
					System.out.println("User: " + login + " is Acvitated -> email: " + email);
				}else{
					System.out.println("User: " + login + " is Deactivated -> email: "+email);
				}
				i++;
			}while (userStatus != "");
		}
		catch (Exception e){
			 actual = true;
		}
		
		return actual;
		
	}
	
	
}
