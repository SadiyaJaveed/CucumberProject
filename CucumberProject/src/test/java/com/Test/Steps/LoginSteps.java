package com.Test.Steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Project.Framework.Factory.PageName;
import com.Project.Framework.Pages.AccountPage;
import com.Project.Framework.Pages.HomePage;
import com.Project.Framework.Pages.LoginPage;
import com.Project.Framework.Services.DriverService;
import com.Project.Framework.Utilities.IReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private WebDriver driver;
	private DriverService service;
	private IReader reader;
	private HomePage homePage;
	private LoginPage loginPage;
	private AccountPage accountPage;

	public LoginSteps(DriverService service) {
		this.service = service;
		this.driver = service.getDriver();
		this.reader = service.getReader();
	}

	@Given("I navigate to the PHP travels website")
	public void i_navigate_to_the_PHP_travels_website() {
		driver.get(reader.getUrl());
	}

	@When("I click on the My Account link")
	public void i_click_on_the_My_Account_link() {
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
	}

	@When("click on the Login link")
	public void click_on_the_login_link() {
		homePage.clickLogin();
		loginPage = (LoginPage) homePage.navigateTo(PageName.LoginPage, driver, "Login");
	}

	@Then("I must land in the login page")
	public void i_must_land_in_the_login_page() {
		Assert.assertEquals(loginPage.fetchTitle(), "Login");
		service.getScreenshotHelper().takeScreenshot("target\\Screenshots", "SuccessLoginPage.png");
	}

	@When("I enter the login details")
	public void i_enter_the_login_details() {
		loginPage.enterLoginDetails(reader.getUsername(), reader.getPassword());
		service.getScreenshotHelper().takeScreenshot("target\\Screenshots", "LoginDetails.png");
	}

	@When("click on the Login button")
	public void click_on_the_Login_button() {
		loginPage.clickLogin();
		accountPage = (AccountPage) loginPage.navigateTo(PageName.AccountPage, driver, "Account");
	}

	@Then("I must land in the account page")
	public void i_must_land_in_the_account_page() {
		Assert.assertEquals(accountPage.fetchTitle(), "My Account");
		service.getScreenshotHelper().takeScreenshot("target\\Screenshots", "SuccessAccountPage.png");
	}

	@When("I enter the incorrect login details")
	public void i_enter_the_incorrect_login_details() {
		loginPage.enterLoginDetails("test@test.com", "user");
	}

	@When("click on Login button")
	public void click_on_Login_button() {
		loginPage.clickLogin();
	}

	@Then("I must receive an error")
	public void i_must_receive_an_error() {
		Assert.assertEquals(loginPage.fetcherror(), "Invalid Email or Password");
		service.getScreenshotHelper().takeScreenshot("target\\Screenshots", "InvalidLogin.png");
	}

}
