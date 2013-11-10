package com.test.util;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;
import io.selendroid.device.DeviceTargetPlatform;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;

public class CommonMethods extends TestWaiter {

	public static WebDriver driver;
	final static String pathSeparator = File.separator;
	public static final String NATIVE_APP = "NATIVE_APP";
	public static final String WEBVIEW = "WEBVIEW";
	public static final String appId = "io.selendroid.testapp:0.5.1";

	public static void startApplication() throws Exception {

		SelendroidCapabilities capa = SelendroidCapabilities.device(
				DeviceTargetPlatform.ANDROID17, appId);

		driver = new SelendroidDriver("http://localhost:5555/wd/hub", capa);

	}

	public static void killApp() {

		driver.quit();

	}

	public static void openStartActivity() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String activityClass = "io.selendroid.testapp." + "HomeScreenActivity";

		driver.switchTo().window(NATIVE_APP);
		driver.get("and-activity://" + activityClass);

	}

	public void assertInputField(String objectId) {

		WebElement inputField = driver.findElement(By.id(objectId));
		Assert.assertEquals("true", inputField.getAttribute("enabled"));
	}

	public void clickButton(String objectButtonId) {
		WebElement button = driver.findElement(By.id(objectButtonId));
		button.click();

	}

	public void assertTextPresent(String ID, String element) {
		Assert.assertEquals(element, driver.findElement(By.id(ID)).getText());

	}

	public void assertTextByPartialLink(String text) {
		WebElement toast = waitForElement(By.linkText(text), 4, driver);
		Assert.assertNotNull(toast);
	}

	public void clearField(String id) {

		driver.findElement(By.id(id)).clear();
	}

	public static void takeScreenShot() throws Exception {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File screenshot = ((TakesScreenshot) augmentedDriver)
				.getScreenshotAs(OutputType.FILE);
		String nameScreenshot = UUID.randomUUID().toString() + ".png";
		File directory = new File(".");

		String newFileNamePath = directory.getCanonicalPath() + pathSeparator
				+ "target" + pathSeparator + "jbehave" + pathSeparator
				+ "screenshots" + pathSeparator + nameScreenshot;
		FileUtils.copyFile(screenshot, new File(newFileNamePath));

		// return newFileNamePath;

		/*
		 * Reporter.log(message + "<br/><a href='file:///" + path +
		 * "'> <img src='file:///" + path +
		 * "' height='100' width='100'/> </a>");
		 */
	}

	/*
	 * protected String getPath() throws IOException { File directory = new
	 * File(".");
	 * 
	 * String newFileNamePath = directory.getCanonicalPath() + pathSeparator +
	 * "target" + pathSeparator + "jbehave" + pathSeparator + "screenshots" +
	 * pathSeparator + nameScreenshot; return newFileNamePath; }
	 */

	public void clickByID(String ID) {

		driver.findElement(By.id(ID)).click();
	}

	public void inputByID(String ID, String sendParam) {
		driver.findElement(By.id(ID)).sendKeys(sendParam);
	}

	public void inputByName(String name, String sendParam) {
		driver.findElement(By.name(name)).sendKeys(sendParam);

	}

	public void inputByLinkText(String name, String sendParam) {
		driver.findElement(By.linkText(name)).sendKeys(sendParam);

	}

	public void inputByClassName(String classname, String sendParam) {
		driver.findElement(By.className(classname)).sendKeys(sendParam);
	}

	public void clickByClassName(String classname) {
		driver.findElement(By.className(classname)).click();
	}

	public void clickByLinkText(String name) {
		driver.findElement(By.linkText(name)).click();

	}
	

}
