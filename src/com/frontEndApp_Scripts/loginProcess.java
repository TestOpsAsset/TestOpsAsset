package com.frontEndApp_Scripts;

import org.testng.annotations.Test;
import com.frontEndApp_pages.HomePage;

public class loginProcess extends setBrowser{

	@Test
	public void signIn(){
		HomePage hp =  new HomePage(driver);
		
		hp.logIn(data.User, data.pwd);
	}
}
