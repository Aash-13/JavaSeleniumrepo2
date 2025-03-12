package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browser.browser;

public class Page1Object extends browser{
	static By userNameTextBox=By.name("username");
	static By passwordTextBox=By.name("password");
	static By loginButton=By.xpath("//button[@type='submit']");
    
	
	public static WebElement userNameTextBox() {
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameTextBox));

		WebElement element=driver.findElement(userNameTextBox);
		return element;
	}
	
	public static WebElement passwordTextBox() {
		wait=new WebDriverWait(browser.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBox));

		WebElement element=driver.findElement(passwordTextBox);
		return element;
	}
	
	public static WebElement loginButton() {
		WebElement element=driver.findElement(loginButton);
		return element;
	}
}