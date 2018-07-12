package com.frontEndApp_Scripts;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.frontEndApp_pages.HomePage;

public class setBrowser {
	WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void settingBrowser(String browser) throws IOException, InterruptedException{
		// Since version 2.50, firefox will require WebDriver (Geckodriver) from Marionette
		if (browser.equalsIgnoreCase("Firefox")){
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			//capabilities.setCapability("marionette", true);
			//driver = new FirefoxDriver(capabilities);
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty(data.Chrome1, data.Chrome2);
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Internet Explorer")){
			System.setProperty(data.IE1, data.IE2 );
			DesiredCapabilities capabilities =new DesiredCapabilities();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(capabilities);
			driver = new InternetExplorerDriver();
		}
		
			
			driver.get(data.appURL);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			
			System.out.println("BeforeTest annotation has been completed - Setting up browser complete");
			System.out.println("We are using: "+ browser + " browser");
			System.out.println("-----------------------------------------------------------------------");
	
	}
	
	@AfterClass
		public void outofclass(){
		driver.findElement(By.xpath("html/body/div[2]/nav/div/div[2]/ul/li[1]/a/span[2]")).click();
		HomePage hpOut = new HomePage(driver);
		String actual = hpOut.logOutApp();
		System.out.println(actual);
		Assert.assertEquals(actual, "Register a new account");
		System.out.println("Closing browser instance.");
		System.out.println("_________________________________________________________________");
		driver.quit();		
		
	}
	
	/*@AfterTest
	public void quitBrowser(){	
		driver.findElement(By.xpath("html/body/div[2]/nav/div/div[2]/ul/li[1]/a"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterSuite
	public void close(){
		System.out.println("Closing browser instance.");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
	}*/
}
