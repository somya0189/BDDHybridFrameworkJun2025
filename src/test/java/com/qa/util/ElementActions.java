package com.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;

public class ElementActions {
	
	WebDriver driver;

	 

	public static String ELEMENT_TO_BE_CLICKABLE = "elementTobeClickable";

	public static String ELEMENT_TO_BE_VISIBLE = "visibilityOf";

	public static String STALENESS_OF_ELEMENT = "stalenessof";
	public static void sendKeys(WebDriver driver, WebElement elem, Scenario scenario, String texttoType) {
		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
			} 
		catch (Exception E) {
			scenario.write(" Error while waiting for clicking on Emmenet ");
			}
		try {
			elem.sendKeys(texttoType);
			} 
		catch (Exception E) {
			scenario.write(" Error on typeing the text in element after wating !");
			}
		}
	
	public static String getText(WebDriver driver, WebElement elem, Scenario scenario) {
		String texttoReturn = null;
		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_VISIBLE, scenario);
			} 
		catch (Exception E) {
			scenario.write(" Error while waiting for Element visibility  ");
			}
		try {
			texttoReturn = elem.getText();
			} 
		catch (Exception E){
			scenario.write(" Error on fetching  the text in element after wating !");
			}
		return texttoReturn;
		}
	
	public static void selectOptionFromDropDown(WebDriver driver, WebElement elem, Scenario scenario, String option) {
		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
			}
		catch (Exception E) {
             scenario.write(" Error while waiting for Element to be clickable   ");
             }
		Select objselect = new Select(elem);
		try {
			objselect.selectByValue(option);
			} 
		catch (Exception E) {
			scenario.write(" Error while selecting the option from Dropdown! ");
			}
		}
}
