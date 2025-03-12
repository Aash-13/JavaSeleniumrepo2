package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Browser.browser;
import Locators.Page1Object;
import ScreenShot.Capture;

public class Page1 extends browser{
	public static String title() throws Exception {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Title");
		logger1.log(Status.INFO, "Screenshot");
		Thread.sleep(5000);
		logger1.addScreenCaptureFromPath(Capture.screenShot("title"));
		extent.flush();
		return driver.getTitle();
	}
	public static void userNameEnter(String data) throws Exception{
		extent.attachReporter(reporter);
		logger1=extent.createTest("UserName");
		logger1.log(Status.INFO, "Enter Username");
		try
		{
		//	driver.findElement(By.name("username")).sendKeys("Admin");
			wait = new WebDriverWait(driver, Duration .ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
			Page1Object.userNameTextBox().sendKeys(data);
			logger1.log(Status.PASS, "Username Entered SUccessfully");
		}
		catch(Exception e)
		{
			System.out.println("Page1 - While entering Username");
			logger1.log(Status.FAIL, "Failed Entering Username");
		}
		extent.flush();
	}
	
	public static void userPasswordEnter(String data) throws Exception{
		extent.attachReporter(reporter);
		logger1=extent.createTest("Password");
		logger1.log(Status.INFO, "Enter Password");
		try
		{
		//	driver.findElement(By.name("password")).sendKeys("admin123");
			wait = new WebDriverWait(driver, Duration .ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
			Page1Object.passwordTextBox().sendKeys(data);
			logger1.log(Status.PASS, "Entered Password Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Page1- While entering Password");
			logger1.log(Status.FAIL, "Failed Entering password");
		}
		extent.flush();
	}
	public static void clickLogin() throws Exception{
		extent.attachReporter(reporter);
		logger1=extent.createTest("LoginButton");
		logger1.log(Status.INFO, "Click Login");
		try
		{
		//	driver.findElement(By.xpath("//button[@type='submit']")).click();
			wait = new WebDriverWait(driver, Duration .ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
			Page1Object.loginButton().click();
			logger1.log(Status.PASS, "Logged in successfully");
		}
		catch(Exception e)
		{
			System.out.println("Page1- While clicking Login Button");
			logger1.log(Status.FAIL, "Failed logging in");
		}
		extent.flush();
	}

}