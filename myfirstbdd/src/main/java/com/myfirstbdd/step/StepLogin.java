package com.myfirstbdd.step;

import org.junit.Assert;

import com.myfirstbdd.utility.Driver;
import com.myfirstbdd.utility.MyConfiguration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepLogin {
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		String url=MyConfiguration.get("url");
		Driver.getDriver().get(url);
	}
	
	@Then("user logs in as Developer")
	public void user_logs_in_as_Developer() {
		String abc=Driver.getDriver().getTitle();
		Assert.assertEquals("Dashboard", abc);
	}
	
}
