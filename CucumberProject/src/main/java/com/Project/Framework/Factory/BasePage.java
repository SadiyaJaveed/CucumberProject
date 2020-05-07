package com.Project.Framework.Factory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected WebDriverWait getWait() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
	
	public BasePage navigateTo(PageName name, WebDriver driver, String text) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.titleContains(text));
		return CustomFactory.getInstance(name, driver);
	}
	
	
	public String fetchTitle() {
		return driver.getTitle();
	}
	
	@FindBy(how = How.CSS, using = ".alert.alert-danger")
	public WebElement ErrorMessage;
	
	public String fetcherror() {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(ErrorMessage));
		return ErrorMessage.getText();
	}

}
