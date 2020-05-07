package com.Project.Framework.Factory;

import org.openqa.selenium.WebDriver;

import com.Project.Framework.Pages.AccountPage;
import com.Project.Framework.Pages.HomePage;
import com.Project.Framework.Pages.HotelResultPage;
import com.Project.Framework.Pages.LoginPage;
import com.Project.Framework.Pages.RegisterPage;

public class CustomFactory {
	
	public static BasePage getInstance(PageName name, WebDriver driver) {
		
		switch (name) {
		case HomePage:
			return new HomePage(driver);
		case LoginPage:
			return new LoginPage(driver);
		case RegisterPage:
			return new RegisterPage(driver);
		case AccountPage:
			return new AccountPage(driver);
		case HotelResultPage:
			return new HotelResultPage(driver);

		default:
			throw new RuntimeException("Invalid page name");
		}
		
	}
}
