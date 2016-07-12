package com.frontEndApp_Scripts;

import org.testng.annotations.Test;

import com.frontEndApp_pages.HealthChecksPage;
import com.frontEndApp_pages.HomePage;

public class AdminProcess extends setBrowser {

	@Test (priority=1)
	public void login(){
		HomePage hp = new HomePage(driver);
		hp.logIn(data.User, data.pwd);
			
	}
	
	public void HealthChecks(){
		HealthChecksPage hc = new HealthChecksPage(driver);
		hc.healtCheck(3);
		System.out.println("-------------------------------------------");
	}
	
	
	
}
