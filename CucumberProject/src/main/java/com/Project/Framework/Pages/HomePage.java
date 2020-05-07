package com.Project.Framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Project.Framework.Factory.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//li/div[@class='dropdown dropdown-login dropdown-tab']/a[@id='dropdownCurrency']")
	public WebElement MyAccountLnk;
	@FindBy(how = How.LINK_TEXT, using = "Login")
	public WebElement LoginLnk;
	@FindBy(how = How.LINK_TEXT, using = "Sign Up")
	public WebElement SignUpLnk;
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen1\"]/a")
	public WebElement DestinationTxt;
	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div")
	public WebElement DestinationLnk;
	@FindBy(how = How.ID, using = "checkin")
	public WebElement CheckinTxt;
	@FindBy(how = How.ID, using = "checkout")
	public WebElement CheckoutTxt;
	@FindBy(how = How.XPATH, using = "//*[@id=\"airDatepickerRange-hotel\"]/div[2]/div/div[2]/span/i")
	public WebElement DatePicker;
	@FindBy(how = How.XPATH, using = "//*[@id=\"hotels\"]/div/div/form/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div[2]/div/span/button[1]")
	public WebElement ChildIncreaseBtn;
	@FindBy(how = How.CSS, using = "[name='HOTELS'] .btn-primary")
	public WebElement SearchBtn;

	public void clickMyAccount() {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(MyAccountLnk));
		MyAccountLnk.click();
	}

	public void clickLogin() {
		LoginLnk.click();
	}

	public void clickSignUp() {
		SignUpLnk.click();
	}
	
	public void enterHotelDetails(String dest, String checkin, String checkout) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(DestinationTxt));
		DestinationTxt.click();
		DestinationTxt.sendKeys(dest);
		WebDriverWait waits = getWait();
		waits.until(ExpectedConditions.elementToBeClickable(DestinationLnk));
		DestinationLnk.click();
		ChildIncreaseBtn.click();
		CheckinTxt.clear();
		CheckinTxt.sendKeys(checkin);
		CheckoutTxt.clear();
		CheckoutTxt.sendKeys(checkout);
		DatePicker.click();
	}
	
	public void clickSearch() {
		SearchBtn.click();
	}

}
