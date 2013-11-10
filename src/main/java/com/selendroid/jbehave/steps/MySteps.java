package com.selendroid.jbehave.steps;

import java.net.MalformedURLException;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterScenario.Outcome;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.annotations.AfterClass;

import com.selendroid.jbehave.pages.HomePage;
import com.selendroid.jbehave.pages.RegisterNativeView;
import com.test.util.CommonMethods;

public class MySteps {

	HomePage home = new HomePage();
	RegisterNativeView register= new RegisterNativeView();

	@BeforeStories
	public void startServer() throws Exception {
		System.out.println("********Start the Selendroid Server**********");
		CommonMethods.startApplication();

	}

	@AfterStories
	public void killApplication() {
		System.out.println("********Closing the Selendroid Server**********");
		CommonMethods.killApp();
	}

	@AfterScenario(uponOutcome = Outcome.FAILURE)
	public void onFailureTakeScreenShot() throws Exception {

		CommonMethods.takeScreenShot();

	}

	@Given("A user must be able to view search field")
	@Alias("A user must be able to lauch the application")
	public void homepage() throws MalformedURLException {
		CommonMethods.openStartActivity();
		home.assertInputFieldExists();
	}

	@When("A user performs a search with <element>")
	public void searchRange(@Named("element") String element) throws Exception {

		home.inputSearchText(element);
	}

	@When("A user click's on the Register page")
	public void registerUser() {
    
		 home.clickRegisterPage();
	}

	@When("register with valid details")
	public void registerWithValidDetails() {
          
		register.registerUserWithDetails();
		register.enterEmailByName();
		register.enterPassword();
		register.acceptAdds();
		register.clickRegisterUserButton();
		//Add details as the per the selendroid example
		
	}

	@When("A user click's the Toast Button")
	public void clickToastButton() {

		home.clickToastButton();

	}

	@Then("verify the toast message is displayed")
	public void verifyToastMessage() {

		home.assertToastMessage();
	}
	
	@Then("verify the user registered")
	public void verifyUserRegistered(){
		
		register.assertUserRegister();
	}

	@Then("verify the text enter is <element>")
	public void verifySearchResults(@Named("element") String element) {
		home.assertTextEntered(element);
	}

}
