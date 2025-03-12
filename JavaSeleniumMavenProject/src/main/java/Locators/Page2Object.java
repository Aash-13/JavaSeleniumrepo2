package Locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browser.browser;

public class Page2Object extends browser{
	static By user=By.className("oxd-userdropdown-name") ;
	static By leave=By.xpath("//ul[@class='oxd-main-menu']/li[3]/a");
	public static WebElement User() {
		WebElement element=driver.findElement(user);
		return element;
	}
	static By listMenu=By.xpath("//ul[@class='oxd-main-menu']/li");
	
	public static List<WebElement> select() throws Exception{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(leave));
		

		List <WebElement> list=driver.findElements(listMenu);
		return list;
		
	}
	public static WebElement Leave() {
		return driver.findElement(leave);
		
	}

}