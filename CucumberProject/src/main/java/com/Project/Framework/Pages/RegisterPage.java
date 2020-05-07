package com.Project.Framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Project.Framework.Factory.BasePage;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.NAME , using = "firstname")
	public WebElement FirstNameTxt;
	@FindBy(how = How.NAME , using = "lastname")
	public WebElement LastNameTxt;
	@FindBy(how = How.NAME , using = "phone")
	public WebElement MobileTxt;
	@FindBy(how = How.NAME, using = "email")
	public WebElement EmailTxt;
	@FindBy(how = How.NAME, using = "password")
	public WebElement PasswordTxt;
	@FindBy(how = How.NAME, using = "confirmpassword")
	public WebElement ConfirmTxt;
	@FindBy(how = How.CSS, using = ".btn.btn-block.btn-lg.btn-success.btn_full.signupbtn")
	public WebElement SignUpBtn;
	
	public void registerUser(String firstname, String lastname, String mobile, String email, String password, String confirm) {
		FirstNameTxt.sendKeys(firstname);
		LastNameTxt.sendKeys(lastname);
		MobileTxt.sendKeys(mobile);
		EmailTxt.sendKeys(email);
		PasswordTxt.sendKeys(password);
		ConfirmTxt.sendKeys(confirm);
	}
	
	public void clickSignUp() {
		SignUpBtn.click();
	}
}
