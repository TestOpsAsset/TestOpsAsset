package com.frontEndApp_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class NewUserPage {
	private  WebDriver driver;
	
	@FindBy(id="admin-menu")
	@CacheLookup
	private WebElement mainMenu;
	
	@FindBy(xpath="html/body/div[2]/nav/div/div[2]/ul/li[4]/ul/li[1]/a/span[2]")
	@CacheLookup
	private WebElement userMenu;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div[1]/div/button")
	@CacheLookup
	private WebElement createUser;
	
	@FindBy(name="login")
	@CacheLookup
	private WebElement txtlogin;
	
	@FindBy(name="firstName")
	@CacheLookup
	private WebElement txtFname;
	
	@FindBy(name="lastName")
	@CacheLookup
	private WebElement txtLname;
	
	@FindBy(name="email")
	@CacheLookup
	private WebElement txtemail;
	
	@FindBy(xpath="html/body/div[1]/div/div/form/div[2]/div[7]/select")
	@CacheLookup
	private WebElement profiles;
	
	@FindBy(xpath="html/body/div[1]/div/div/form/div[3]/button[2]")
	@CacheLookup
	private WebElement savebutton;
		
		
	 // --- Constructor declaration
	public NewUserPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("this is the contructor of NewUserPage");
	}
	
	public void insertData(String login, String Fname, String Lname, String tempEmail, int role){
			mainMenu.click();
			userMenu.click();
			createUser.click();
			txtlogin.sendKeys(login);
			txtFname.sendKeys(Fname);
			txtLname.sendKeys(Lname);
			txtemail.sendKeys(tempEmail);
			// UserRole will be assigned based on the below calculation
			
			Select auth = new Select(profiles);
			if (role%2 != 0){
				// Selecting USER ROLE
				auth.selectByVisibleText("ROLE_USER");
				//driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/div[7]/select/option[1]")).click(); 
			}else{
				// Selecting ADMIN ROLE
				auth.selectByVisibleText("ROLE_USER");
				//driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/div[7]/select/option[2]")).click(); 
			}	
			savebutton.click();
					
			String actual= driver.findElement(By.xpath("html/body/div[3]/div[1]/div/jhi-alert/div/div/div/div/pre")).getText();
			System.out.println("actual result: " + actual);
			String expected = "A user is created with identifier " + login;
			System.out.println("expected result: " + expected);
			Assert.assertEquals(expected, actual);
					
		}
}


