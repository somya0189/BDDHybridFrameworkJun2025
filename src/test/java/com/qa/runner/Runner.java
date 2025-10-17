package com.qa.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features", glue = { "com.qa.stepdefinations" }, tags = {

		"@BuzzCRUDTest" }, plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" }, monochrome = true)
//json:target/cucumber-reports/Cucumber.json : this is for generating reports from jenkins
//html:target/cucumber-reports : 
public class Runner {

}
