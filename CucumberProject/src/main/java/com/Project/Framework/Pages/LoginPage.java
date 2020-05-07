package com.Project.Framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Project.Framework.Factory.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.NAME, using = "username")
	public WebElement EmailTxt;
	@FindBy(how = How.NAME, using = "password")
	public WebElement PasswordTxt;
	@FindBy(how = How.CSS, using = ".custom-control-label")
	public WebElement RememberMe;
	@FindBy(how = How.CSS, using = "form#loginfrm > .btn.btn-block.btn-lg.btn-primary.loginbtn")
	public WebElement LoginBtn;
	

	public void enterLoginDetails(String username, String password) {
		EmailTxt.sendKeys(username);
		PasswordTxt.sendKeys(password);
		RememberMe.click();
	}

	public void clickLogin() {
		LoginBtn.click();
	}
	
}
