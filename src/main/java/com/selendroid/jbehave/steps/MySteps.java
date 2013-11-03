package com.selendroid.jbehave.steps;

import java.net.MalformedURLException;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterScenario.Outcome;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.annotations.AfterClass;

import com.selendroid.jbehave.pages.HomePage;
import com.test.util.CommonMethods;

public class MySteps {

	HomePage home = new HomePage();

	@BeforeScenario
	public void startServer() throws Exception {
		System.out.println("********Start the Selendroid Server**********");
		CommonMethods.startApplication();

	}

	@AfterScenario
	public void killApplication() {
		System.out.println("********Closing the Selendroid Server**********");
		CommonMethods.killApp();
	}

	@AfterScenario(uponOutcome = Outcome.FAILURE)
	public void onFailureTakeScreenShot() throws Exception {

		CommonMethods.takeScreenShot();

	}

	@Given("A user must be able to view search field")
	public void homepage() throws MalformedURLException {
		CommonMethods.openStartActivity();
		home.assertInputFieldExists();
	}

	@When("A user performs a search with <element>")
	public void searchRange(@Named("element") String element) throws Exception {

		home.inputSearchText(element);
	}

	@Then("verify the text enter is <element>")
	public void verifySearchResults(@Named("element") String element) {
		home.assertTextEntered(element);
	}

}
