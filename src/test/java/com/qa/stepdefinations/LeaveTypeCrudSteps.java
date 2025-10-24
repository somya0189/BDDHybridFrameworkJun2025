package com.qa.stepdefinations;

import org.junit.Assert;

import com.qa.base.Base;
import com.qa.pages.LeavePage;
import com.qa.pages.LoginPage;
import com.qa.util.CaptureScreenshot;
import com.qa.util.ReadProperties;
import com.qa.util.WaitMethods;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LeaveTypeCrudSteps extends Base {
	Scenario scenario;
	LoginPage objLoginPage;
	LeavePage objleavePage;

	@Before
	public void logintoApplication(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("^Navigate to LEave after log in with Admin user$")
	public void navigate_to_LEave_after_log_in_with_Admin_user() throws Throwable {

		scenario.write("Starting the Orange HRM application in browser");
		driver = initializeWebDriver();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		scenario.write("Logging in to Orange HRMS APplication");
		objLoginPage = new LoginPage(driver, scenario);
		String actualHomePageTitle = objLoginPage.logintoApplication(ReadProperties.getAppUserName(),
				ReadProperties.getAppPassword());
		Assert.assertEquals("Dashboard", actualHomePageTitle);
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		objleavePage = new LeavePage(driver, scenario);
		scenario.write("Navigate to LEave after log in with Admin user");
		objleavePage.navigateToLeavePage();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@When("^I navigate config and then select Leave Types$")
	public void i_navigate_config_and_then_select_Leave_Types() throws Throwable {

		scenario.write("I navigate config and then select Leave Types");
		objleavePage.navigateToLeaveTypePage();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^Add the Leave with below field and values and I verify leave is displayed in leave list$")
	public void add_the_Leave_with_below_field_and_values_and_I_verify_leave_is_displayed_in_leave_list(
			DataTable leaveTypeTable) throws Throwable {

		scenario.write("Adding new leaveType");
		objleavePage.addnewLeaveType(leaveTypeTable.raw().get(0).get(1));
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		Assert.assertEquals(leaveTypeTable.raw().get(0).get(1), objleavePage.getnewlyaddedLeaveType());
	}

	@Then("^I Edit the Leave type and change below values and I verify verify the leave name is changed to new name$")
	public void i_Edit_the_Leave_type_and_change_below_values_and_I_verify_verify_the_leave_name_is_changed_to_new_name(
			DataTable editLEavetTypeTable) throws Throwable {

		scenario.write("Editing the leave Type");
		objleavePage.editLeaveType(editLEavetTypeTable.raw().get(0).get(1));
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

	}

	@Then("^Delete the Newly added Leave Type$")
	public void delete_the_Newly_added_Leave_Type() throws Throwable {

		scenario.write("Deleting the leave type");
		objleavePage.deleteLEaveType();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

	}

	@After
	public void closeApplication(Scenario scenario) {
		scenario.write("Closing the application");
		closeBrowser();
	}
}
