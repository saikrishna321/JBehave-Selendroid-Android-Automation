package com.selendroid.jbehave.pages;

import com.test.util.CommonMethods;
import com.test.util.ObjectRepo;

public class HomePage extends CommonMethods {

	public void assertInputFieldExists() {

		assertInputField(ObjectRepo.assertInputText);

	}

	public void inputSearchText(String element) {

		inputByID(ObjectRepo.searchField, element);
	}

	public void assertTextEntered(String element) {
		assertTextPresent(ObjectRepo.searchField, element);
		clearField(ObjectRepo.searchField);
	}
	
	public void assertToastMessage(){
		
		assertTextByPartialLink("Hello selendroid toast!");
	}
	
	public void clickToastButton(){
		
		clickButton(ObjectRepo.toastButton);
	}
}
