package com.Test.Steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Project.Framework.Factory.PageName;
import com.Project.Framework.Pages.AccountPage;
import com.Project.Framework.Pages.HomePage;
import com.Project.Framework.Pages.RegisterPage;
import com.Project.Framework.Services.DriverService;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {

	private WebDriver driver;
	private DriverService service;
	private HomePage homePage;
	private RegisterPage registerPage;
	private AccountPage accountPage;

	public RegisterSteps(DriverService service) {
		this.service = service;
		this.driver = service.getDriver();
	}

	@When("click on the Signup link")
	public void click_on_the_Signup_link() {
		homePage = new HomePage(driver);
		homePage.clickSignUp();
		registerPage = (RegisterPage) homePage.navigateTo(PageName.RegisterPage, driver, "Register");
	}

	@When("I enter the following details in Register page")
	public void i_enter_the_following_details_in_Register_page(DataTable table) {
		List<Map<String, String>> rows = table.asMaps(String.class, String.class);

		for (Map<String, String> columns : rows) {
			registerPage.registerUser(columns.get("Firstname"), columns.get("Lastname"), columns.get("Mobile"),
					columns.get("Email"), columns.get("Password"), columns.get("ConfirmPassword"));
		}
		service.getScreenshotHelper().takeScreenshot("target\\Screenshots", "RegistrationDetails.png");
	}
	
	@When("I enter the {string} {string} {string} {string} {string} {string} in Register page")
	public void i_enter_the_in_Register_page(String firstname, String lastname, String mobile, String email, String password, String confirm) {
		registerPage.registerUser(firstname, lastname, mobile, email, password, confirm);
	}

	@When("click on the Signup button")
	public void click_on_the_Signup_button() {
		registerPage.clickSignUp();
		accountPage = (AccountPage) registerPage.navigateTo(PageName.AccountPage, driver, "Account");
	}
	
	@Then("I land in the account page")
	public void i_land_in_the_account_page() {
		Assert.assertEquals(accountPage.fetchTitle(), "My Account");
	}
	
	@When("click on Signup button")
	public void click_on_Signup_button() {
		registerPage.clickSignUp();
	}
	
	@Then("I receive an error that user is already registered")
	public void i_receive_an_error_that_user_is_already_registered() {
		Assert.assertEquals(registerPage.fetcherror(), "Email Already Exists.");
		service.getScreenshotHelper().takeScreenshot("target\\Screenshots", "InvalidRegister.png");
	}

}
