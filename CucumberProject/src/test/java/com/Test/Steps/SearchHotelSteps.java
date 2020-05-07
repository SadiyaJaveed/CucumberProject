package com.Test.Steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Project.Framework.Factory.PageName;
import com.Project.Framework.Pages.HomePage;
import com.Project.Framework.Pages.HotelResultPage;
import com.Project.Framework.Services.DriverService;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchHotelSteps {
	
	private WebDriver driver;
	private DriverService service;
	private HomePage homePage;
	private HotelResultPage resultPage;

	public SearchHotelSteps(DriverService service) {
		this.service = service;
		this.driver = service.getDriver();
	}
	
	@When("I enter the following details for hotel search")
	public void i_enter_the_following_details_for_hotel_search(DataTable table) {
		homePage = new HomePage(driver);
		
		List<Map<String, String>> rows = table.asMaps(String.class, String.class);

		for (Map<String, String> columns : rows) {
			homePage.enterHotelDetails(columns.get("Destination"), columns.get("Checkin"), columns.get("Checkout"));
		}
		service.getScreenshotHelper().takeScreenshot("target\\Screenshots", "HotelDetails.png");
	}

	@When("click on the search button")
	public void click_on_the_search_button() {
		homePage.clickSearch();
		resultPage = (HotelResultPage) homePage.navigateTo(PageName.HotelResultPage, driver, "Hotels");
	}

	@Then("I must be displayed with the search results")
	public void i_must_be_displayed_with_the_search_results() {
		Assert.assertEquals(resultPage.fetchTitle(), "Hotels Results");
		service.getScreenshotHelper().takeScreenshot("target\\Screenshots", "HotelResults.png");
	}

}
