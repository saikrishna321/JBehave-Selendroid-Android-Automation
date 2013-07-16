package com.selendroid.jbehave.steps;

import io.selendroid.SelendroidCapabilities;

import java.net.MalformedURLException;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterScenario.Outcome;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import com.test.util.CommonMethods;

public class MySteps extends CommonMethods {
	SelendroidCapabilities capa;
	WebDriver driver;

	@BeforeScenario
	public void startServer() throws Exception {
		System.out.println("********Start the Selendroid Server**********");
		startApplication();

	}


	@AfterScenario
	public void killApplication() {

		killApp();
	}

	@AfterScenario(uponOutcome = Outcome.FAILURE)
	public void onFailureTakeScreenShot() throws Exception {

		takeScreenShot();

	}

	@Given("A user must be able to view search field")
	public void homepage() throws MalformedURLException {
		openStartActivity();
		assertInputField();

	}

	@When("A user performs a search with <element>")
	public void searchRange(@Named("element") String element) throws Exception {
		inputByID("my_text_field", element);

	}

	@Then("verify the text enter is <element>")
	public void verifySearchResults(@Named("element") String element) {
		assertTextPresent("my_text_field", element);
	}

}
