package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Browser.browser;
import Locators.Page1Object;
import Locators.Page2Object;

public class Page2 extends browser{
	public static String UserCheck() throws Exception {
		Thread.sleep(2000);
		return Page2Object.User().getText();
	}
	public static void clickOnMenu() {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Page2 Functionality");
		logger1.log(Status.INFO, "Click on Menu");
		try
		{
			
		//	List<WebElement> list=driver.findElements(By.xpath("//ul[@class='oxd-main-menu']/li"));
			
			List <WebElement>list=Page2Object.select();
			wait = new WebDriverWait(driver, Duration .ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='oxd-main-menu']/li[3]/a")));
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getText().contains("Leave"))
				{
					list.get(i).click();
					logger1.log(Status.PASS, "CLicked on Leave");
					break;
				}
		}
		}
		catch(Exception e)
		{
			System.out.println("page2- -While clicking on menu");
			logger1.log(Status.FAIL, "Failed Clicking on Leave");
		}
		extent.flush();
	}
	public static String LeaveName() throws Exception
	{
		Thread.sleep(3000);
		return Page2Object.Leave().getText();
	}
		


}