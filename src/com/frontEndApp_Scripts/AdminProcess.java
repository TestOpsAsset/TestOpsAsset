package com.frontEndApp_Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.frontEndApp_pages.HealthChecksPage;
import com.frontEndApp_pages.HomePage;
import com.frontEndApp_pages.MetricsCheckPage;

public class AdminProcess extends setBrowser {

	@Test (priority = 1)
	public void login(){
		HomePage hp = new HomePage(driver);
		Assert.assertEquals("You are logged in as user \"admin\"." , hp.logIn(data.User, data.pwd));
		System.out.println("-------------------------------------------");
	}
	
	@Test (priority = 2)
	public void HealthChecks(){
		System.out.println("we have entered to Health method");
		HealthChecksPage hc = new HealthChecksPage(driver);
		hc.healtCheck(3);
		//Assertion should be here
		System.out.println("-------------------------------------------");
	}
	
	@Test (priority = 3)
	public void MetricsCheck() throws InterruptedException{
		MetricsCheckPage mc = new MetricsCheckPage(driver);
		mc.checkMemotyStatus(40);
		//Assertion should be here
		System.out.println("-------------------------------------------");
	}
	
	/*
	@Test (priority = 4)
	public void ConfigCheck(){
		ConfigCheckPage cp = new ConfigCheckPage(driver);
		//Assertion should be here
		Assert.assertEquals(cp.checkLocalServerPort(data.portName), true);
		
		System.out.println("-------------------------------------------");
		
	}*/
	
	
	
	
}
