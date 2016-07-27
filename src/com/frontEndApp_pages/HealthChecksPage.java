package com.frontEndApp_pages;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthChecksPage {
	private WebDriver driver;
	
	
	@FindBy (id="admin-menu")
	@CacheLookup
	private WebElement adminMenu;
	
	@FindBy (xpath ="html/body/div[2]/nav/div/div[2]/ul/li[4]/ul/li[3]/a")
	@CacheLookup
	private WebElement healthMenu;
	
	@FindBy(css  =".btn.btn-primary")
	@CacheLookup
	private WebElement refreshButton;
	
	
	// -- Constructor
	public HealthChecksPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void healtCheck(int rowvalue){
		adminMenu.click();
		healthMenu.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		//refreshButton.click();
		String rowpath=".//*[@id='healthCheck']/tbody/tr[";
		String tvalue, temp="";
		int x=0;
		for (int j=1; j<= rowvalue; j++){
			tvalue= driver.findElement(By.xpath(rowpath + j + "]/td[1]/span")).getText();
				switch (tvalue){
				case "Elasticsearch": 
					if ((temp = driver.findElement(By.xpath(rowpath + j + "]/td[2]/span")).getText()).equals("UP")){x++;}
					break;
				case "DiskSpace" 	: 
					if ((temp = driver.findElement(By.xpath(rowpath + j + "]/td[2]/span")).getText()).equals("UP")){x++;}
					break;			
				case "Db" 			: 
					if ((temp = driver.findElement(By.xpath(rowpath + j + "]/td[2]/span")).getText()).equals("UP")){x++;}
					break;
								
				default: break;
				}
			System.out.println("Row: " + j + " -> Health Checks table: " + tvalue + " -> Status: " + temp);
		}
				
		Assert.assertEquals(3, x);
		System.out.println("Health checks completed, x = " + x);
		System.out.println("----------------------------------------------");
	}
	
	
	
	
}
