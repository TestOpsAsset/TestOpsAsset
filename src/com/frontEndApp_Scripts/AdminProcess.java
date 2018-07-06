package com.frontEndApp_Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.frontEndApp_pages.HomePage;

public class AdminProcess extends setBrowser {

	@Test 
	public void login(){
		HomePage hp = new HomePage(driver);
		Assert.assertEquals("Log Out", hp.logIn(data.User, data.pwd));
		System.out.println("-------------------------------------------");
	}
	
}
