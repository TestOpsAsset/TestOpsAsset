package com.frontEndApp_Scripts;

import org.testng.annotations.Test;

import com.frontEndApp_pages.HealthChecksPage;
import com.frontEndApp_pages.HomePage;

public class AdminProcess extends setBrowser {

	@Test (priority = 1)
	public void login(){
		HomePage hp = new HomePage(driver);
		hp.logIn(data.User, data.pwd);			
	}
	
	@Test (priority = 2)
	public void HealthChecks(){
		System.out.println("we have entered to Health method");
		HealthChecksPage hc = new HealthChecksPage(driver);
		hc.healtCheck(3);
		System.out.println("-------------------------------------------");
	}
	
	
	
}
