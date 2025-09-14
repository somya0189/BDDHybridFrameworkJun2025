package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;

import cucumber.api.Scenario;

/**
 * @author sony This class has page factory code for OrangeHRM Login page
 */
public class LoginPage {

	WebDriver driver;
	Scenario scenario;

	// Page Object Repository: Elements are find by @FindBy annotation
	// Page Class Constructor
	// Page Operation Methods

	// Page Object Repository: Elements are find by @FindBy annotation

	@FindBy(xpath = "//input[@name='username']")

	WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")

	WebElement passwordField;

	@FindBy(xpath = "//button[text()=' Login ']")

	WebElement loginButton;

	@FindBy(xpath = "//h6[text()='Dashboard']")

	WebElement homepageTitle;

	// Page Class Constructor
	public LoginPage(WebDriver driver, Scenario scenario) {

		this.driver = driver;
		this.scenario = scenario;

		PageFactory.initElements(driver, this);

	}

	// Page Operation Methods

	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * This method will accept username password parameters and return homepage title
	 */
	public String logintoApplication(String userName, String userPassword) {

		ElementActions.sendKeys(driver, userNameField, scenario, userName);

		ElementActions.sendKeys(driver, passwordField, scenario, userPassword);

		ElementActions.clickElement(driver, loginButton, scenario);

		return ElementActions.getText(driver, homepageTitle, scenario);

	}

}
