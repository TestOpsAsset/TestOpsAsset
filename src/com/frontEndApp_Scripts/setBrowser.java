package com.frontEndApp_Scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class setBrowser {
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void settingBrowser(String browser) throws IOException{
		// Since version 2.50, firefox will require WebDriver (Geckodriver) from Marionette
		if (browser.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty(data.Chrome1, data.Chrome2);
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Internet Explorer")){
			System.setProperty(data.IE1, data.IE2 );
			driver = new InternetExplorerDriver();
		}
		 
		/*  Process to read objRepo.properties
		File src = new File("objRepo.properties");
		FileInputStream f = new FileInputStream(src);
		Properties prop = new Properties();
		prop.load(f);
		
		driver.findElement();
		*/
		
		
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(data.appURL);
			
			System.out.println("BeforeTest annotation has been completed - Setting up browser complete");
			System.out.println("We are using: "+ browser + " browser");
			System.out.println("-----------------------------------------------------------------------");
	
	}
	
	
	@AfterMethod
	public void back(){
		//System.out.println("AfterMethod method");
		/*driver.findElement(By.xpath("html/body/div[2]/nav/div/div[2]/ul/li[1]/a/span[2]")).click();
		String actual = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div/div[2]/div/div")).getText();
		Assert.assertEquals("You are logged in as user \"admin\"." , actual);
		System.out.println(actual);*/
		
	}
	
	@AfterTest
	public void quitBrowser(){
		//System.out.println("AfterTest method");
		/*
		driver.quit();*/	
		driver.findElement(By.xpath("html/body/div[2]/nav/div/div[2]/ul/li[1]/a"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterSuite
	public void close(){
		System.out.println("Closing browser instance.");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
	}
}
