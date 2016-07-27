package com.frontEndApp_pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MetricsCheckPage {
	private WebDriver driver;
	
	@FindBy (id="admin-menu")
	@CacheLookup
	private WebElement adminMenu;
	
	@FindBy (xpath="html/body/div[2]/nav/div/div[2]/ul/li[4]/ul/li[2]/a/span[2]")
	@CacheLookup
	private WebElement metricsMenu;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/p[1]/button")
	@CacheLookup
	private WebElement refreshButton;
	
	@FindBy (xpath="html/body/div[3]/div[1]/div/div[1]/div[1]/div[1]/div/span")
	@CacheLookup
	private WebElement totalMemory;
	
	@FindBy (xpath="html/body/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/span")
	@CacheLookup
	private WebElement heapMemory;
	
	
	// --- Constructor -----------
	public MetricsCheckPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public void checkMemotyStatus(int topPercentage){
		adminMenu.click();
		metricsMenu.click();
		//refreshButton.click();
		driver.manage().timeouts().implicitlyWait(1,  TimeUnit.MINUTES);
		///----
		boolean actual = true;
		if (getNumber(totalMemory.getText()) > topPercentage){
			actual = false;
		}else if (getNumber(heapMemory.getText()) > topPercentage){
				actual = false;
		}
		System.out.println("Total Memory: " + totalMemory.getText());
		System.out.println("Heap Memory: " + heapMemory.getText());
		System.out.println("Flag: " + actual);
		Assert.assertEquals(true, actual);
	}
	
	public int getNumber(String sValue){
		int vInteger = 0;
		if (sValue.length() < 3) {
			vInteger = Integer.parseInt(sValue.substring(0,3));
		}else{
			vInteger = Integer.parseInt(sValue.substring(0,2));
		}		
		return vInteger;	
	}
	
	
}
