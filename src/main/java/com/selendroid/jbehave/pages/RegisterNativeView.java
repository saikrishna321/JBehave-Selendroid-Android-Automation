package com.selendroid.jbehave.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.test.util.CommonMethods;

public class RegisterNativeView extends CommonMethods {

	String userName = "Selendroid_Tests";
	String email = "saikrishna321@yahoo.com";
	String password = "selendroid";

	public void registerUserWithDetails() {

		inputByID("inputUsername", userName);
	}

	public void enterEmailByName() {

		inputByID("inputEmail", email);
	}

	public void enterPassword() {

		inputByID("inputPassword", password);
	}

	public void acceptAdds() {

		clickByClassName("android.widget.CheckBox");
	}

	public void clickRegisterUserButton() {
		// TODO Auto-generated method stub
		clickByLinkText("Register User (verify)");
	}

	public void assertUserRegister() {

		assertTextPresent("label_username_data", userName);
		assertTextPresent("label_email_data", email);
		assertTextPresent("label_password_data", password);
		assertTextPresent("label_preferedProgrammingLanguage_data", "Ruby");

	}
}
